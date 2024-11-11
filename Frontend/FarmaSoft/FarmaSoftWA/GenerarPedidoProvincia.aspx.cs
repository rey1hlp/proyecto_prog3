using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections.Generic;
using System.Linq;
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

        protected void lbGuardar_Click(object sender, EventArgs e)
        {
            // Buscar el radio button seleccionado en el GridView

            foreach (GridViewRow row in gvFarmacias.Rows)
            {
                RadioButton rbSeleccionado = (RadioButton)row.FindControl("rbSeleccionado");
                if (rbSeleccionado != null && rbSeleccionado.Checked)
                {
                    // Obtener el ID de la farmacia seleccionada(de tipo int)
                    int farmaciaID = Convert.ToInt32(gvFarmacias.DataKeys[row.RowIndex].Value);

                    farmaciaAsociada[] listaFarmacias= ViewState["listaFarmacias"] as farmaciaAsociada[];
                    farmaciaAsociada farmaciaSeleccionada = listaFarmacias.FirstOrDefault(f => f.ID == farmaciaID);
                    Session["FarmaciaSeleccionada"] = farmaciaSeleccionada;
                    
                    Response.Redirect("ResumenSolicitud.aspx");
                    return;
                }
            }

            // Si no se seleccionó ninguna farmacia, muestra un mensaje de error
            ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Por favor seleccione una farmacia.');", true);
            
        }
    }
}