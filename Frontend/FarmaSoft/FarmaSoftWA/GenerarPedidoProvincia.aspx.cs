using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections.Generic;


namespace FarmaSoft
{
    public partial class GenerarPedidoProvincia : System.Web.UI.Page
    {
        private FarmaciaAsociadaWSClient farmaciaAsociadaWS = new FarmaciaAsociadaWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            var farm = farmaciaAsociadaWS.listarTodasFarmaciasAsociadas();
            gvFarmacias.DataSource = farm;
            gvFarmacias.DataBind();

            ddlDepartamento.DataSource = Application["listaDepartamentos"] as departamento[];
            ddlDepartamento.DataBind();
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CompletarDireccionEnvio.aspx");
        }
    }
}