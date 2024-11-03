using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FarmaSoftWA
{
    public partial class ListarSolicitudes : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lblTitulo.Text = "Listado de solicitudes pendientes";

            if (!IsPostBack)
            {
                CargarSolicitudesPendientes();
            }
        }

        private void CargarSolicitudesPendientes()
        {
            try
            {
                SolicitudWSClient solicitudWS = new SolicitudWSClient();
                var solicitudes = solicitudWS.listarTodasSolicitudes();

                //var solicitudesPendientes = solicitudes.Where(s => s.estado== estadoSolicitud.PENDIENTE && !s.completado).ToArray()
                var solicitudesPendientes = solicitudes
                .Where(s => s.estado == estadoSolicitud.PENDIENTE)
                .Select(s => new
                {
                    ID = s.ID,
                    Nombre = s.cliente.nombre,
                    Apellido = (s.cliente.apellidoPaterno + " " + s.cliente.apellidoMaterno),
                    Telefono = s.cliente.telefonoContacto,
                    Fecha = s.fechayhoraCreacion
                }).ToArray();
                // Enlaza el GridView con las solicitudes pendientes
                gvSolicitudes.DataSource = solicitudesPendientes;
                gvSolicitudes.DataBind();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }


        protected void lbAtender_Click(object sender, EventArgs e)
        {
            // Obtiene la fila seleccionada
            foreach (GridViewRow row in gvSolicitudes.Rows)
            {
                RadioButton rbSeleccionado = (RadioButton)row.FindControl("rbSeleccionado");
                if (rbSeleccionado != null && rbSeleccionado.Checked)
                {
                    int idSolicitud = Convert.ToInt32(gvSolicitudes.DataKeys[row.RowIndex].Value);

                    // Cambia el estado de la solicitud a "Atendiendo"
                    try
                    {
                        SolicitudWSClient solicitudWS = new SolicitudWSClient();

                        //Falta esta parte, porque debo pasarle un objeto solicitud, pero al colocar
                        solicitud soli = solicitudWS.obtenerSolicitudPorId(idSolicitud);
                        soli.estado = estadoSolicitud.EN_ATENCION;
                        solicitudWS.actualizarSolicitud(soli);
                    }
                    catch (Exception ex)
                    {
                        // Manejo de errores
                        Console.WriteLine(ex.Message);
                    }
                    // Redirige a SubirArchivo.aspx
                    Response.Redirect("SubirArchivo.aspx");
                    break; // Sal del bucle una vez que hayas encontrado la solicitud seleccionada
                }
            }
        }
    }
}