using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.EnterpriseServices;
using System.Linq;
using System.Text;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FarmaSoftWA
{
    public partial class AgregarMedicinasPropias : System.Web.UI.Page
    {
        private static pedidoPropio pedido;
        private static poliza poliza = null;
        private PedidoPropioWSClient pedidoPropioWSClient;
        private MedicinaPropiaWSClient medicinaPropiaWSClient;
        private DetalleSolicitudWSClient detalleSolicitudWSClient;
        private static double total;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                poliza = (poliza)Session["poliza"];
                medicinaPropiaWSClient = new MedicinaPropiaWSClient();
                medicinaPropia[] medicinasPropias = medicinaPropiaWSClient.listarTodasMedicinasPropias();   //Para el modal y agregar medicinas
                ViewState["listaMedicinasPropias"] = medicinasPropias;
                
                ddlMedicina.DataSource = medicinasPropias;
                ddlMedicina.DataTextField = "nombre";
                ddlMedicina.DataValueField = "IDP";
                ddlMedicina.DataBind();
                ddlMedicina.Items.Insert(0, new ListItem("-- Selecciona una opción --", ""));

                cargarDatosContacto();
                cargarMedicinasPropias();
                //gvMedicinas_DataBound(sender, e);
                cargarDatosPagar();
            }
            //gvMedicinas_DataBound(sender,e);   //Va calculando la suma de los rows
            
        }
        private void cargarMedicinasPropias()
        {
            if (Session["detallesPedido"] == null) 
            {
                pedido = (pedidoPropio)Session["pedidoAtendido"];
                //Transformar medicinas generales a propias -> tranformar pedidoPropio
                pedidoPropioWSClient = new PedidoPropioWSClient();
                detalleSolicitudWSClient = new DetalleSolicitudWSClient();
                int idSoli = pedido.solicitudAsociada.ID;
                pedido.solicitudAsociada.detallesSolicitud = detalleSolicitudWSClient.listarDetallesSolicitudPorIDSolicitud(idSoli);
                pedido = pedidoPropioWSClient.transformar(pedido);
                //detallePedido detalle = new detallePedido();
                //detalle.medicina.nombre = "";
                //detalle.medicina.ID = "";
                //detalle.medicina.precio = 2;

                //Asignamos el precio y el stock de la medicina
                for (int i = 0; i < pedido.detallesPedido.Length; i++)
                {
                    medicinaPropiaWSClient = new MedicinaPropiaWSClient();
                    medicinaPropia medicina = medicinaPropiaWSClient.obtenerPorId(pedido.detallesPedido[i].medicina.IDP);
                    pedido.detallesPedido[i].precioUnitario = medicina.precio;
                    pedido.detallesPedido[i].medicina.precio = medicina.precio;
                    pedido.detallesPedido[i].medicina.stock = medicina.stock;
                    pedido.detallesPedido[i].medicina.id = medicina.id;
                }
                Session["detallesPedido"] = pedido.detallesPedido;
                Session["pedidoAtendido"] = pedido;
            }
            
            calcularTotal();
            actualizarGvMedicinas();
            //Cargar los datos en el grid view
        }
        private void calcularTotal()
        {
            total = 0;
            detallePedido[] detalles = (detallePedido[])Session["detallesPedido"];
            foreach (detallePedido detalle in detalles)
            {
                total += detalle.cantidadPedida * detalle.medicina.precio;
            }
            txtTotal.Text = total.ToString();
        }
        private void actualizarGvMedicinas()
        {
            detallePedido[] detallesPedido = Session["detallesPedido"] as detallePedido[];
            gvMedicinas.DataSource = detallesPedido;
            gvMedicinas.DataBind();
        }
        private void cargarDatosContacto()
        {
            //Depende de como lo manejaron en las primeras pantallas
            if (Session["PedidoPropio"] != null)
            {
                pedido = (pedidoPropio)Session["PedidoPropio"];
                txtNombre.Text = pedido.solicitudAsociada.cliente.nombre + " " + pedido.solicitudAsociada.cliente.apellidoPaterno;
                txtTelefono.Text = pedido.solicitudAsociada.cliente.telefonoContacto.ToString();
            }
        }
        private void cargarDatosPagar()
        {
            if (poliza != null)
            {
                //Asigna el monto cubierto
                total = double.Parse(txtTotal.Text);
                double cubre = (poliza.porcentajeCobertura * total);
                if (poliza.coberturaMaxima >= cubre)
                {
                    txtMontoCubierto.Text = cubre.ToString();
                    txtTotalAPagar.Text = (total - cubre).ToString();
                    //pedidoPropio.montoCubierto = cubre;
                    //pedidoPropio.montoTotal -= cubre;
                }
                //else
                //{
                //pedidoPropio.montoCubierto = pedidoPropio.solicitudAsociada.cliente.poliza.coberturaMaxima;
                //pedidoPropio.montoTotal -= pedidoPropio.montoCubierto;
                //}
            }
        }
        protected void gvMedicinas_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvMedicinas.PageIndex = e.NewPageIndex;
            actualizarGvMedicinas();
        }
        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CompletarDatosPedido.aspx");
        }
        protected void lbContinuar_Click(object sender, EventArgs e)
        {
            pedidoPropio pedido = (pedidoPropio)Session["pedidoAtendido"];
            pedido.montoTotal = (txtTotalAPagar.Text == "") ? 0 : double.Parse(txtTotalAPagar.Text);
            pedido.montoCubierto = (txtMontoCubierto.Text == "") ? 0 : double.Parse(txtMontoCubierto.Text);
            Session["total"] = (txtTotal.Text == "") ? 0 : double.Parse(txtTotal.Text);
            Session["montoCubierto"] = (txtMontoCubierto.Text == "") ? 0 : double.Parse(txtMontoCubierto.Text);
            Session["totalAPagar"] = (txtTotalAPagar.Text == "") ? 0 : double.Parse(txtTotalAPagar.Text);
            Response.Redirect("ProcesamientoPago.aspx");
        }

        protected void bGuardado_Click(object sender, EventArgs e)
        {
            string codMedicina = ddlMedicina.SelectedValue;
            string cantidadIngresada = txtCantidad.Text;
            int cantMedicina = int.Parse(string.IsNullOrEmpty(cantidadIngresada) ? "0" : cantidadIngresada);
            detallePedido[] listaDetallesArray = Session["detallesPedido"] as detallePedido[];
            BindingList<detallePedido> listaDetalles = new BindingList<detallePedido>(listaDetallesArray.ToList());
            bool agregado = false;
            foreach (detallePedido detalle in listaDetalles) 
            {
                if (detalle.medicina.IDP == codMedicina)
                {
                    detalle.cantidadPedida = cantMedicina;
                    //Ya fue agregado entonces actualiza
                    agregado = true;
                }
            }
            if (ddlMedicina.Enabled == false)
                ddlMedicina.Enabled = true;
            if (!agregado)
            {
                medicinaPropia[] medicinasPropias = ViewState["listaMedicinasPropias"] as medicinaPropia[];

                foreach (medicinaPropia medicinaPropia in medicinasPropias)
                {
                    if (medicinaPropia.IDP == codMedicina)
                    {
                        medicinaPropiaWSClient = new MedicinaPropiaWSClient();
                        medicinaPropia medicina = medicinaPropiaWSClient.obtenerPorId(medicinaPropia.IDP);        //Esta es la llamada a la bd
                                                                                                                  //Obtuvimos datos de la nueva medicina para añadirlo al detalle de pedido
                        listaDetalles.Add(new detallePedido()
                        {
                            medicina = new medicinaPropia()
                            {
                                IDP = codMedicina,
                                nombre = medicinaPropia.nombre,
                                tipoMedicamento = medicinaPropia.tipoMedicamento,
                                tipoMedicamentoSpecified = true,
                                precio = medicina.precio,                  //Obtenido del llamado a la bd de arriba
                                stock = medicina.stock                     //Obtenido del llamado a la bd de arriba
                            },
                            cantidadPedida = cantMedicina,
                            precioUnitario = medicina.precio               //Obtenido del llamado a la bd de arriba
                        });
                        break;
                    }
                }
            }

            //Actualización del pedido en las variables session

            detallePedido[] listaDetallesArrayG = listaDetalles.ToArray();
            Session["detallesPedido"] = listaDetallesArrayG;

            pedido = (pedidoPropio)Session["pedidoAtendido"];
            pedido.detallesPedido = Session["detallesPedido"] as detallePedido[];
            Session["pedidoAtendido"] = pedido;
            calcularTotal();
            cargarDatosPagar();
            actualizarGvMedicinas();
        }

        protected void lbAgregarMedicina_Click(object sender, EventArgs e)
        {
            lblMedTitulo.Text = "Agregar medicina";
            string script = "window.onload = function() { openModal() };";
            ScriptManager.RegisterStartupScript(this, GetType(), "", script, true);
        }

        protected void btnEdit_Click(object sender, EventArgs e)
        {
            lblMedTitulo.Text = "Editar medicina";
            LinkButton btnEdit = (LinkButton)sender; 
            string idP = btnEdit.CommandArgument;
            ddlMedicina.SelectedValue = idP;
            ddlMedicina.Enabled = false;
            string script = "window.onload = function() { openModal() };";
            ScriptManager.RegisterStartupScript(this, GetType(), "", script, true);
        }

        protected void btnDelete_Click(object sender, EventArgs e)
        {
            LinkButton btnDelete = (LinkButton)sender;
            string idP = btnDelete.CommandArgument;            //medicina a eliminar
            detallePedido[] listaDetallesArray = Session["detallesPedido"] as detallePedido[];
            BindingList<detallePedido> listaDetalles = new BindingList<detallePedido>(listaDetallesArray.ToList());
            int i=0;   //Siempre encontrará una medicina para eliminar
            foreach (detallePedido detalle in listaDetalles)
            {
                if (detalle.medicina.IDP == idP)
                {
                    for (i = listaDetalles.Count - 1; i >= 0; i--) 
                    {
                        if (listaDetalles[i].medicina.IDP == idP)
                            break;
                    }
                }
            }
            listaDetalles.RemoveAt(i);
            detallePedido[] listaDetallesArrayG = listaDetalles.ToArray();
            Session["detallesPedido"] = listaDetallesArrayG;

            pedido = (pedidoPropio)Session["pedidoAtendido"];
            pedido.detallesPedido = Session["detallesPedido"] as detallePedido[];
            Session["pedidoAtendido"] = pedido;
            calcularTotal();
            cargarDatosPagar();
            actualizarGvMedicinas();
        }
    }
}