using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FarmaSoftWA
{
    public partial class AgregarMedicinasPropias : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                cargarDatosContacto();
                cargarDatosPagar();
            }
            actualizarGvMedicinas();
        }
        private void actualizarGvMedicinas()
        {
            gvMedicinas.DataSource = Session["detallesPedido"] as BindingList<detallePedido>;
            gvMedicinas.DataBind();
        }
        private void cargarDatosContacto()
        {
            //Depende de como lo manejaron en las primeras pantallas
            txtNombre.Text = (Session["nombre"] == null) ? "" : (string)Session["nombre"];
            txtTelefono.Text = (Session["telefono"] == null) ? "" : (string)Session["nombre"];
        }
        private void cargarDatosPagar()
        {
            //Depende de como lo manejaron en las primeras pantallas
            txtTotal.Text = (Session["nombre"] == null) ? "" : ((double)Session["total"]).ToString();
            txtMontoCubierto.Text = (Session["telefono"] == null) ? "" : ((double)Session["montoCubierto"]).ToString();
            txtTotalAPagar.Text = (Session["telefono"] == null) ? "" : ((double)Session["totalAPagar"]).ToString();
        }
        protected void gvMedicinas_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvMedicinas.PageIndex = e.NewPageIndex;
            actualizarGvMedicinas();
        }
        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarPedidos.aspx");
        }
        protected void lbContinuar_Click(object sender, EventArgs e)
        {
            Session["total"] = (txtTotal.Text == "") ? 0 : double.Parse(txtTotal.Text);
            Session["montoCubierto"] = (txtMontoCubierto.Text == "") ? 0 : double.Parse(txtMontoCubierto.Text);
            Session["totalAPagar"] = (txtTotalAPagar.Text == "") ? 0 : double.Parse(txtTotalAPagar.Text);
            Response.Redirect("ProcesamientoPago.aspx");
        }
    }
}