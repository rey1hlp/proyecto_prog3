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

namespace FarmaSoftWA
{
    public partial class SubirArchivo : System.Web.UI.Page
    {
        private byte[] fotoPoliza;
        private byte[] fotoReceta;
        private SolicitudWSClient solicitudWS = new SolicitudWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["recetaMedicaFoto"] != null)
                fotoReceta = (byte[]) Session["recetaMedicaFoto"];
            if (Session["polizaFoto"] != null)
                fotoPoliza = (byte[]) Session["polizaFoto"];
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
            Response.Redirect("AgregarMedicinasGenericas.aspx");
        }

        protected void Cargar_Foto_Receta_Medica(object sender, EventArgs e)
        {
            if (IsPostBack && fileUploadReceta.PostedFile != null && fileUploadReceta.HasFile)
            {
                string extension = System.IO.Path.GetExtension(fileUploadReceta.FileName);
                if (extension.ToLower() == ".jpg" || extension.ToLower() == ".jpeg" || extension.ToLower() == ".png" || extension.ToLower() == ".gif")
                {
                    string filename = Guid.NewGuid().ToString() + extension;
                    string filePath = Server.MapPath("~/Uploads/") + filename;
                    fileUploadReceta.SaveAs(Server.MapPath("~/Uploads/") + filename);
                    imgReceta.ImageUrl = "~/Uploads/" + filename;
                    imgReceta.Visible = true;
                    FileStream fs = new FileStream(filePath, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    Session["recetaMedicaFoto"] = br.ReadBytes((int)fs.Length);
                    fs.Close();
                }
                else
                {
                    Response.Write("Por favor, selecciona un archivo de imagen válido.");
                }
            }
        }

        protected void Cargar_Foto_Poliza(object sender, EventArgs e)
        {
            if (IsPostBack && fileUploadPoliza.PostedFile != null && fileUploadPoliza.HasFile)
            {
                string extension = System.IO.Path.GetExtension(fileUploadPoliza.FileName);
                if (extension.ToLower() == ".jpg" || extension.ToLower() == ".jpeg" || extension.ToLower() == ".png" || extension.ToLower() == ".gif")
                {
                    string filename = Guid.NewGuid().ToString() + extension;
                    string filePath = Server.MapPath("~/Uploads/") + filename;
                    fileUploadPoliza.SaveAs(Server.MapPath("~/Uploads/") + filename);
                    imgPoliza.ImageUrl = "~/Uploads/" + filename;
                    imgPoliza.Visible = true;
                    FileStream fs = new FileStream(filePath, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    Session["polizaFoto"] = br.ReadBytes((int)fs.Length);
                    fs.Close();
                }
                else
                {
                    Response.Write("Por favor, selecciona un archivo de imagen válido.");
                }
            }
        }
    }
}