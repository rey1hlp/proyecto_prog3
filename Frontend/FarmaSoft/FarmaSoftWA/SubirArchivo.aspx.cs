using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Services.Protocols;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml.Linq;

namespace FarmaSoftWA
{
    public partial class SubirArchivo : System.Web.UI.Page
    {
        private byte[] fotoPoliza;
        private byte[] fotoReceta;
        private SolicitudWSClient solicitudWS = new SolicitudWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                //Mostrar la solicitud que se esta atendiendo
                solicitud solicitudEnProgreso = Session["solicitudAtendida"] as solicitud;
                if (solicitudEnProgreso != null)
                {
                    lblId.Text = "ID: " + solicitudEnProgreso.ID;
                    lblNombre.Text = "Nombre: " + solicitudEnProgreso.cliente.nombre;
                    lblFecha.Text = "Fecha: " + solicitudEnProgreso.fechayhoraCreacion.ToString("dd/MM/yyyy");
                } 
            }

            Cargar_Foto_Receta_Medica(sender, e);
            Cargar_Foto_Poliza(sender, e);
                
            
            
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            solicitud solSeleccionada = (solicitud) Session["solicitudAtendida"];

            if(solSeleccionada != null)
            {
                Application.Lock();
                
                BindingList<int> solicitudesEnAtencion = Application["solicitudesEnAtencion"] as BindingList<int>;
                solicitudesEnAtencion.Remove(solSeleccionada.ID);

                Application.UnLock();

                solicitudWS.actualizarSolicitud(solSeleccionada);
            }

            Session["solicitudAtendida"] = null;
            Session["direccion"] = null;
            Session["recetaMedicaFoto"] = null;
            Session["polizaFoto"] = null;
            Session["detallesSolicitud"] = null;

            Response.Redirect("ListarSolicitudes.aspx");
        }

        protected void lbContinuar_Click(object sender, EventArgs e)
        {
            int valid = Guardar_Foto_Receta() + Guardar_Foto_Poliza();
            if (valid == 0)
            {
                Response.Redirect("AgregarMedicinasGenericas.aspx");
            }
            //temporalmente dejo esto
        }

        protected void Cargar_Foto_Receta_Medica(object sender, EventArgs e)
        {
                string extension = System.IO.Path.GetExtension(fileUploadReceta.FileName);
                if (fileUploadReceta.HasFile && (extension.ToLower() == ".jpg" || extension.ToLower() == ".jpeg" || extension.ToLower() == ".png" || extension.ToLower() == ".gif"))
                {
                    string filename = Guid.NewGuid().ToString() + extension;
                    string filePath = Server.MapPath("~/Uploads/") + filename;
                    fileUploadReceta.SaveAs(Server.MapPath("~/Uploads/") + filename);
                    imgReceta.ImageUrl = "~/Uploads/" + filename;
                }
        }
        

        protected void Cargar_Foto_Poliza(object sender, EventArgs e)
        {
            string extension = System.IO.Path.GetExtension(fileUploadPoliza.FileName);
            if (fileUploadPoliza.HasFile && (extension.ToLower() == ".jpg" || extension.ToLower() == ".jpeg" || extension.ToLower() == ".png" || extension.ToLower() == ".gif"))
            {

                string filename = Guid.NewGuid().ToString() + extension;
                string filePath = Server.MapPath("~/Uploads/") + filename;
                fileUploadPoliza.SaveAs(Server.MapPath("~/Uploads/") + filename);
                imgPoliza.ImageUrl = "~/Uploads/" + filename;
            }
        }
        protected int Guardar_Foto_Receta()
        {
                string extension = System.IO.Path.GetExtension(fileUploadReceta.FileName);
                if (fileUploadReceta.HasFile && (extension.ToLower() == ".jpg" || extension.ToLower() == ".jpeg" || extension.ToLower() == ".png" || extension.ToLower() == ".gif"))
                {
                    string filename = Guid.NewGuid().ToString() + extension;
                    string filePath = Server.MapPath("~/Uploads/") + filename;
                    fileUploadReceta.SaveAs(filePath);

                    // Leer el archivo directamente como bytes
                    byte[] fileBytes = System.IO.File.ReadAllBytes(filePath);

                    // Guardar el archivo en la sesión
                    Session["recetaMedicaFoto"] = fileBytes;
                }
                else
                {
                    Response.Write("Por favor, selecciona un archivo de imagen válido.");
                return 1;
            }
                return 0;
        }

        protected int Guardar_Foto_Poliza()
        {
            string extension = System.IO.Path.GetExtension(fileUploadPoliza.FileName);
            if (fileUploadPoliza.HasFile && (extension.ToLower() == ".jpg" || extension.ToLower() == ".jpeg" || extension.ToLower() == ".png" || extension.ToLower() == ".gif"))
            {
                string filename = Guid.NewGuid().ToString() + extension;
                string filePath = Server.MapPath("~/Uploads/") + filename;
                fileUploadPoliza.SaveAs(filePath);

                // Leer el archivo directamente como bytes
                byte[] fileBytes = System.IO.File.ReadAllBytes(filePath);

                // Guardar el archivo en la sesión
                Session["recetaMedicaFoto"] = fileBytes;
            }
            else
            {
                Response.Write("Por favor, selecciona un archivo de imagen válido.");
                return 1;
            }
            return 0;
        }
    }
}