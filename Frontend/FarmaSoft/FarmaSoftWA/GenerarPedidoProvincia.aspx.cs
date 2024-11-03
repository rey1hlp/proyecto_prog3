using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections.Generic;
using System.Web.UI.WebControls;


namespace FarmaSoft
{
    public partial class GenerarPedidoProvincia : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if(!IsPostBack)
            {
                gvFarmacias.DataSource = Application["listaFarmacias"];
                gvFarmacias.DataBind();

                ddlDepartamento.DataSource = Application["listaDepartamentos"] as departamento[];
                ddlDepartamento.DataBind();

                if (Session["direccion"] != null)
                {
                    ddlDepartamento.SelectedValue = ((direccion)Session["direccion"]).departamento.ToString();
                }
            }
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CompletarDireccionEnvio.aspx");
        }
    }
}