using FarmaSoftWA.FarmaSoftWS;
using Microsoft.SqlServer.Server;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FarmaSoftWA
{
    public partial class AgregarMedicinasGenericas : System.Web.UI.Page
    {
        private MedicinaGeneralWSClient medicinaGeneralWS = new MedicinaGeneralWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            solicitud solicitudEnProgreso = Session["solicitudAtendida"] as solicitud;
            if (solicitudEnProgreso != null)
            {
                // Asignar los valores a los TextBox en lugar de los Labels
                txtIdCliente.Text = solicitudEnProgreso.cliente.ID.ToString();
                txtNombre.Text = solicitudEnProgreso.cliente.nombre + " " + solicitudEnProgreso.cliente.apellidoPaterno;
                txtTelefono.Text = solicitudEnProgreso.cliente.telefonoContacto.ToString();
                txtDni.Text = solicitudEnProgreso.cliente.numDocumento.ToString(); // Si tienes un TextBox para DNI
                txtApellidos.Text = solicitudEnProgreso.cliente.apellidoPaterno; // Si tienes un TextBox para Apellidos
                txtCorreo.Text = solicitudEnProgreso.cliente.correoContacto; // Si tienes un TextBox para Correo
            }
            if (!IsPostBack)
            {
                ViewState["listaMedicinas"] = medicinaGeneralWS.listarTodasMedicinasGenerales();
                ddlMedicina.DataSource = ViewState["listaMedicinas"] as medicinaGeneral[];
                ddlMedicina.DataTextField = "nombre";
                ddlMedicina.DataValueField = "ID";
                ddlMedicina.DataBind();

                ddlMedicina.Items.Insert(0, new ListItem("-- Selecciona una opción --", ""));

                if (Session["detallesSolicitud"] == null)
                    Session["detallesSolicitud"] = new BindingList<detalleSolicitud>();
                else
                {
                    actualizarGvMedicinas();
                }
            }
        }

        private void actualizarGvMedicinas()
        {
            gvMedicinas.DataSource = Session["detallesSolicitud"] as BindingList<detalleSolicitud>;
            gvMedicinas.DataBind();
        }

        protected void bGuardado_Click(object sender, EventArgs e)
        {
            string codMedicina = ddlMedicina.SelectedValue;
            string cantidadIngresada = txtCantidad.Text;
            int cantMedicina = int.Parse(string.IsNullOrEmpty(cantidadIngresada) ? "0" : cantidadIngresada);

            medicinaGeneral[] medicinasGenerales = ViewState["listaMedicinas"] as medicinaGeneral[];
            BindingList<detalleSolicitud> listaDetalles = Session["detallesSolicitud"] as BindingList<detalleSolicitud>;

            foreach (medicinaGeneral medicinaGen in medicinasGenerales)
            {
                if (medicinaGen.IDP == codMedicina)
                {
                    listaDetalles.Add(new detalleSolicitud()
                    {
                        medicina = new medicinaGeneral()
                        {
                            IDP = codMedicina,
                            nombre = medicinaGen.nombre,
                            tipoMedicamento = medicinaGen.tipoMedicamento,
                            tipoMedicamentoSpecified = true
                        },
                        cantidadPedida = cantMedicina
                    });
                    break;
                }
            }

            Session["detallesSolicitud"] = listaDetalles;

            actualizarGvMedicinas();
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("SubirArchivo.aspx");
        }

        protected void lbGuardar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CompletarDireccionEnvio.aspx");
        }

        private tipoMedicamento1 transformarTipoMedicamento(tipoMedicamento tipoATransformar)
        {
            string valorStr = tipoATransformar.ToString();
            return (tipoMedicamento1)Enum.Parse(typeof(tipoMedicamento1), valorStr);
        }

        protected void gvMedicinas_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvMedicinas.PageIndex = e.NewPageIndex;
            actualizarGvMedicinas();
        }

        protected void btnEliminarMedicina_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            string codigoSelec = (string)btn.CommandArgument;

            BindingList<detalleSolicitud> listaDetalles = Session["detallesSolicitud"] as BindingList<detalleSolicitud>;
            for (int i = 0; i < listaDetalles.Count; i++)
            {
                if (listaDetalles[i].medicina.IDP.Equals(codigoSelec))
                {
                    listaDetalles.RemoveAt(i);
                    break;
                }
            }

            Session["detallesSolicitud"] = listaDetalles;

            actualizarGvMedicinas();
        }
    }
}