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
    public partial class ResumenSolicitud : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                solicitud solicitud = Session["solicitudAtendida"] as solicitud;
                if (solicitud != null)
                {
                    // Mostrar datos de la solicitud
                    lblIdSolicitud.Text = solicitud.ID.ToString();
                    lblFecha.Text = solicitud.fechayhoraCreacion.ToString("dd/MM/yyyy HH:mm");
                    lblCliente.Text = solicitud.cliente.nombre + " " + solicitud.cliente.apellidoPaterno;

                    // Mostrar los medicamentos agregados
                    var detalles = Session["detallesSolicitud"] as BindingList<detalleSolicitud>;
                    gvMedicinas.DataSource = detalles;
                    gvMedicinas.DataBind();


                    // Mostrar los datos de dirección
                    direccion dir = (direccion)Session["direccion"];
                    lblDepartamento.Text = dir.departamento.ToString();
                    lblProvincia.Text = dir.provincia;
                    lblDistrito.Text = dir.distrito;
                    lblCalle.Text = dir.calle;
                    lblReferencia.Text = dir.referencia;

                    //Si no es Lima, mostrar la farmacia asignada
                    if (dir.departamento!= departamento.LIMA_Y_CALLAO)
                    {
                        farmaciaAsociada farma = Session["FarmaciaSeleccionada"] as farmaciaAsociada;
                        lblFarmacia.Text = farma.nombre;
                        divFarmacia.Style["display"] = "block";
                    }
                }
                else
                {
                    // Si no se encontró la solicitud
                    //Response.Redirect("~/ErrorPage.aspx");
                }
            }
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            if (Request.UrlReferrer != null)
            {
                // Redirigimos a la página anterior
                Response.Redirect(Request.UrlReferrer.ToString());
            }
            else
            {
                // Si no hay una URL de referencia, se redirige a una página predeterminada
                Response.Redirect("~/CompletarDireccionEnvio.aspx");
            }
        }

        protected void lbTerminar_Click(object sender, EventArgs e)
        {
            solicitud solicitudProcesada = Session["solicitudAtendida"] as solicitud;
            solicitudProcesada.farmaciaAsociada = Session["FarmaciaSeleccionada"] as farmaciaAsociada;
            solicitudProcesada.estado = estadoSolicitud.A_ASOCIADA;
            solicitudProcesada.detallesSolicitud = (Session["detallesSolicitud"] as BindingList<detalleSolicitud>).ToArray();
            SolicitudWSClient solicitud = new SolicitudWSClient();
            solicitud.insertarSolicitud(solicitudProcesada);

            Response.Redirect("~/Home.aspx");
        }
        
    }
}

