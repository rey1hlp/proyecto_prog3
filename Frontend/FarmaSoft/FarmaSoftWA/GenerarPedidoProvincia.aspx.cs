using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections.Generic;
using System.Web.UI.WebControls;


namespace FarmaSoft
{
    public partial class GenerarPedidoProvincia : System.Web.UI.Page
    {
        private FarmaciaAsociadaWSClient farmaciaWS = new FarmaciaAsociadaWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if(!IsPostBack)
            {
                ViewState["listaFarmacias"] = farmaciaWS.listarTodasFarmaciasAsociadas();
                actualizarGvFarmacias();

                ddlDepartamento.DataSource = Application["listaDepartamentos"] as departamento[];
                ddlDepartamento.DataBind();

                if (Session["direccion"] != null)
                {
                    ddlDepartamento.SelectedValue = ((direccion)Session["direccion"]).departamento.ToString();
                }
            }
        }

        private void actualizarGvFarmacias()
        {
            gvFarmacias.DataSource = ViewState["listaFarmacias"] as farmaciaAsociada[];
            gvFarmacias.DataBind();
        }
        protected void gvFarmacias_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvFarmacias.PageIndex = e.NewPageIndex;
            actualizarGvFarmacias();
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CompletarDireccionEnvio.aspx");
        }

        
    }
}