using FarmaSoftWA.FarmaSoftWS;
using System;


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

            //var departamentos = departamentoWS.listarTodosDepartamentos();
            //ddlDepartamento.DataSource = departamentos;
            //ddlDepartamento.DataBind();
        }
    }
}