using System;
using FarmaSoftWA.FarmaSoftWS;

namespace FarmaSoft
{
    public partial class CompletarDireccionEnvio : System.Web.UI.Page
    {
        private DepartamentoWSClient departamentoWS = new DepartamentoWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            lblTitulo.Text = "Completar direccion de envío";
            
            ddlDepartamento.DataSource = departamentoWS.listarTodosDepartamentos();
            ddlDepartamento.DataBind();
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("SubirArchivo.aspx");
        }

        protected void lbGuardar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GenerarPedidoProvincia.aspx");
        }
    }
}