using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FarmaSoftWA
{
    public partial class ResumenPedido : System.Web.UI.Page
    {
        private PagoWSClient daoPago = null;
        private PedidoPropioWSClient daoPedidoPropio = null;
        private DetallePedidoWSClient daoDetallePedido = null;
        private static pago pago = null;
        private static pedidoPropio pedido;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                cargarDatosContacto();
                cargarMedicinasPropias();
                cargarDatosPago();
                cargarDetallesPago();
            }
        }
        private void cargarMedicinasPropias()
        {
            detallePedido[] detallesPedido = Session["detallesPedido"] as detallePedido[];
            gvMedicinas.DataSource = detallesPedido;
            gvMedicinas.DataBind();
        }
        protected void gvMedicinas_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvMedicinas.PageIndex = e.NewPageIndex;
            cargarMedicinasPropias();
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
        private void cargarDatosPago()
        {
            txtTotal.Text = ((double)Session["total"]).ToString();
            txtMontoCubierto.Text = ((double)Session["montoCubierto"]).ToString();
            txtTotalAPagar.Text = ((double)Session["totalAPagar"]).ToString();
        }
        private void cargarDetallesPago()
        {
            pago = (pago)Session["pago"];
            txtNumeroOperacion.Text = pago.numOperaciones.ToString();
            txtMetodoPago.Text = pago.metodoPago;
            txtMontoPagado.Text = pago.montoPagado.ToString();
        }
        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ProcesamientoPago.aspx");
        }
        protected void lbFinalizar_Click(object sender, EventArgs e)
        {
            pago = (pago)Session["pago"];
            pago.pedidoPropio.completado = true;
            daoDetallePedido = new DetallePedidoWSClient();
            foreach (detallePedido detalle in pago.pedidoPropio.detallesPedido)
            {
                daoDetallePedido.insertarDetallePedido(detalle, pago.pedidoPropio.ID);
            }
            daoPedidoPropio = new PedidoPropioWSClient();
            daoPedidoPropio.actualizarPedido(pago.pedidoPropio);
            daoPago = new PagoWSClient();
            daoPago.insertarPago(pago);
        }
    }
}