using System;
using FarmaSoftWA.FarmaSoftWS;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.ComponentModel;

namespace FarmaSoftWA
{
    public partial class ListarPedidos : System.Web.UI.Page
    {
        private PedidoPropioWSClient pedidoPropioWS = new PedidoPropioWSClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            lblTitulo.Text = "Listado de pedidos pendientes";

            if (!IsPostBack)
            {
                ViewState["listaPedidosPropiosPendientes"] = pedidoPropioWS.listarTodosPedidosPropios().Where(p => p.estadoPedido ==estadoPedido.PENDIENTE).ToArray();

                actualizarGvPedidos();
            }
        }
        private void actualizarGvPedidos()
        {
            gvPedidos.DataSource = ViewState["listaPedidosPropiosPendientes"] as pedidoPropio[];
            gvPedidos.DataBind();
        }
        protected void lbAtender_Click(object sender, EventArgs e)
        {
            // Obtiene la solicitud seleccionada
            foreach (GridViewRow row in gvPedidos.Rows)
            {
                RadioButton rbSeleccionado = (RadioButton)row.FindControl("rbSeleccionado");
                if (rbSeleccionado != null && rbSeleccionado.Checked)
                {
                    int idPedidoSelec = Convert.ToInt32(gvPedidos.DataKeys[row.RowIndex].Value);

                    // verificar si la solicitud seleccionada no ha sido seleccionada antes
                    // como es una var. compartida, se debe utilizar lock para manejar la race condition
                    Application.Lock();
                    BindingList<int> pedEnAtencion = Application["pedidosPropiosEnAtencion"] as BindingList<int>; //revisar si "pedidosPropiosEnAtencion" es correcto
                    if (pedEnAtencion.Contains(idPedidoSelec))
                    {
                        Application.UnLock();
                        // Script de alerta de JavaScript
                        string script = "alert('Pedido seleccionado en atención. Haz click en Aceptar para mostrar nuevos pedidos pendientes.');";
                        ClientScript.RegisterStartupScript(this.GetType(), "alertScript", script, true);
                        Response.Redirect(Request.RawUrl, true);
                    }
                    // si no está en atención, se añade a la lista y se libera la variable
                    pedEnAtencion.Add(idPedidoSelec);
                    Application.UnLock();

                    // Buscamos en la lista de solicitudes pendientes a la seleccionada, para obtener
                    // sus datos y actualizar el estado en la base de datos
                    pedidoPropio[] listaPedidos = ViewState["listaPedidosPropiosPendientes"] as pedidoPropio[];

                    foreach (pedidoPropio ped in listaPedidos)
                    {
                        if (ped.ID == idPedidoSelec)
                        {
                            ped.estadoPedido = estadoPedido.EN_ATENCION;
                            Session["solicitudAtendida"] = ped;
                            pedidoPropioWS.actualizarPedido(ped);
                            break;
                        }
                    }

                    // Finalmente, nos redirigimos a la siguiente pagina
                    Response.Redirect("AgregarMedicinasPropias.aspx", true); //Enlazar con las paginas que faltan
                    break; // no debería llegar a ejecutarse ...
                }
            }
        }

        protected void gvSolicitudes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvPedidos.PageIndex = e.NewPageIndex;
            actualizarGvPedidos();
        }

        protected void rbSeleccionado_CheckedChanged(object sender, EventArgs e)
        {
            // desmarcar todos los radio buttons que se pueden haber seleccionado antes
            foreach (GridViewRow row in gvPedidos.Rows)
            {
                RadioButton rb = (RadioButton)row.FindControl("rbSeleccionado");
                rb.Checked = false;
            }

            // Marcar el nuevo radio button seleccionado
            RadioButton rbSelec = (RadioButton)sender;
            rbSelec.Checked = true;
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Home.aspx");
        }
    }

}
