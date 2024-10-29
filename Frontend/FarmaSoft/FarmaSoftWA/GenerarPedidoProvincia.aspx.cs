using FarmaSoftWA.FarmaSoftWS;
using System;


namespace FarmaSoft
{
    public partial class GenerarPedidoProvincia : System.Web.UI.Page
    {
        private DepartamentoWSClient departamentoWS = new DepartamentoWSClient();
        private FarmaciaAsociadaWSClient farmaciaAsociadaWS = new FarmaciaAsociadaWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            var farm = farmaciaAsociadaWS.listarTodasFarmaciasAsociadas();
            gvFarmacias.DataSource = farm;
            gvFarmacias.DataBind();

            ddlDepartamento.DataSource = departamentoWS.listarTodosDepartamentos();
            ddlDepartamento.DataBind();
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CompletarDireccionEnvio.aspx");
        }
    }
}