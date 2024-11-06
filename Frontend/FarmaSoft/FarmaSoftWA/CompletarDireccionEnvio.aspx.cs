using System;
using System.Collections.Generic;
using System.Web.UI.WebControls;
using FarmaSoftWA.FarmaSoftWS;

namespace FarmaSoft
{
    public partial class CompletarDireccionEnvio : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if(!IsPostBack)
            {
                ddlDepartamento.DataSource = Application["listaDepartamentos"] as departamento[];
                ddlDepartamento.DataBind();

                ddlDepartamento.Items.Insert(0, new ListItem("-- Selecciona una opción --", ""));

                if (Session["direccion"] != null)
                {
                    direccion dirPrevia = (direccion) Session["direccion"];
                    ddlDepartamento.SelectedValue = dirPrevia.departamento.ToString();
                    txtProvincia.Text = dirPrevia.provincia;
                    txtDistrito.Text = dirPrevia.distrito;
                    txtCalle.Text = dirPrevia.calle;
                    txtReferencia.Text = dirPrevia.referencia;
                }
            }
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("AgregarMedicinasGenericas.aspx");
        }

        protected void lbContinuar_Click(object sender, EventArgs e)
        {
            string selectedValue = ddlDepartamento.SelectedValue;
            // Verificar que se haya seleccionado una opción válida
            if (!string.IsNullOrEmpty(selectedValue))
            {
                direccion direccionCliente = new direccion();
                direccionCliente.departamento = (departamento) Enum.Parse(typeof(departamento), selectedValue);
                direccionCliente.provincia = txtProvincia.Text;
                direccionCliente.distrito = txtDistrito.Text;
                direccionCliente.calle = txtCalle.Text;
                direccionCliente.referencia = txtReferencia.Text;
                direccionCliente.departamentoSpecified = true;

                Session["direccion"] = direccionCliente;
                
                // Redirigir a la página correspondiente
                if (selectedValue.Equals("LIMA_Y_CALLAO"))
                {
                    Response.Redirect("GenerarPedidoLima.aspx");
                }
                else
                {
                    Response.Redirect("GenerarPedidoProvincia.aspx");
                }
            }
        }
    }
}