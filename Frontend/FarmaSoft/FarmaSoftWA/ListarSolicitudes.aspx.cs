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
    public partial class ListarSolicitudes : System.Web.UI.Page
    {
        private SolicitudWSClient solicitudWS = new SolicitudWSClient();
        
        protected void Page_Load(object sender, EventArgs e)
        {
            lblTitulo.Text = "Listado de solicitudes pendientes";

            if (!IsPostBack)
            {
                ViewState["listaSolicitudesPendientes"] = solicitudWS
                    .listarTodasSolicitudes()
                    .Where(s => s.estado == estadoSolicitud.PENDIENTE)
                    .ToArray();

                actualizarGvSolicitudes();
            }
        }

        private void actualizarGvSolicitudes()
        {
            gvSolicitudes.DataSource = ViewState["listaSolicitudesPendientes"] as solicitud[];
            gvSolicitudes.DataBind();
        }

        protected void lbAtender_Click(object sender, EventArgs e)
        {
            // Obtiene la solicitud seleccionada
            foreach (GridViewRow row in gvSolicitudes.Rows)
            {
                RadioButton rbSeleccionado = (RadioButton) row.FindControl("rbSeleccionado");
                if (rbSeleccionado != null && rbSeleccionado.Checked)
                {
                    int idSolicitudSelec = Convert.ToInt32(gvSolicitudes.DataKeys[row.RowIndex].Value);

                    // verificar si la solicitud seleccionada no ha sido seleccionada antes
                    // como es una var. compartida, se debe utilizar lock para manejar la race condition
                    Application.Lock();
                    BindingList<int> solEnAtencion = Application["solicitudesEnAtencion"] as BindingList<int>;
                    if (solEnAtencion.Contains(idSolicitudSelec))
                    {
                        Application.UnLock();
                        // Script de alerta de JavaScript
                        string script = "alert('Solicitud seleccionada en atención. Haz click en Aceptar para mostrar nuevas solicitudes pendientes.');";
                        ClientScript.RegisterStartupScript(this.GetType(), "alertScript", script, true);
                        Response.Redirect(Request.RawUrl, true);
                    }
                    // si no está en atención, se añade a la lista y se libera la variable
                    solEnAtencion.Add(idSolicitudSelec);
                    Application.UnLock();
                    
                    // Buscamos en la lista de solicitudes pendientes a la seleccionada, para obtener
                    // sus datos y actualizar el estado en la base de datos
                    solicitud[] listaSolicitudes = ViewState["listaSolicitudesPendientes"] as solicitud[];
                    
                    foreach(solicitud sol in listaSolicitudes)
                    {
                        if(sol.ID == idSolicitudSelec)
                        {
                            sol.estado = estadoSolicitud.EN_ATENCION;
                            Session["solicitudAtendida"] = sol;
                            solicitudWS.actualizarSolicitud(sol);
                            break;
                        }
                    }

                    // Finalmente, nos redirigimos a SubirArchivo.aspx
                    Response.Redirect("SubirArchivo.aspx", true);
                    break; // no debería llegar a ejecutarse ...
                }
            }
        }

        protected void gvSolicitudes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvSolicitudes.PageIndex = e.NewPageIndex;
            actualizarGvSolicitudes();
        }

        protected void rbSeleccionado_CheckedChanged(object sender, EventArgs e)
        {
            // desmarcar todos los radio buttons que se pueden haber seleccionado antes
            foreach (GridViewRow row in gvSolicitudes.Rows)
            {
                RadioButton rb = (RadioButton) row.FindControl("rbSeleccionado");
                rb.Checked = false;
            }

            // Marcar el nuevo radio button seleccionado
            RadioButton rbSelec = (RadioButton) sender;
            rbSelec.Checked = true;
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Home.aspx");
        }
    }
}