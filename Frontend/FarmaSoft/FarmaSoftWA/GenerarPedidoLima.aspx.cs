using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FarmaSoftWA
{
    public partial class GenerarPedidoLima : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if(!IsPostBack)
            {
                ddlDepartamento.DataSource = Application["listaDepartamentos"] as departamento[];
                ddlDepartamento.DataBind();

                ddlDepartamento.SelectedValue = "LIMA_Y_CALLAO";
                if (Session["direccion"] != null)
                {
                    direccion dirPrevia = (direccion)Session["direccion"];
                    txtProvincia.Text = dirPrevia.provincia;
                    txtDistrito.Text = dirPrevia.distrito;
                    txtCalle.Text = dirPrevia.calle;
                    txtReferencia.Text = dirPrevia.referencia;
                }
            }
            
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CompletarDireccionEnvio.aspx");
        }
    }
}