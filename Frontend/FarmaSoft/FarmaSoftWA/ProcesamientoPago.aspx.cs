using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FarmaSoftWA
{
    public partial class ProcesamientoPago : System.Web.UI.Page
    {
        private byte[] comprobantePago;
        private static pago nuevoPago;
        private static pago pagoAux;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (nuevoPago != null)
            {
                //Para recuperar los datos al retroceder
                pagoAux = (pago)Session["pago"];
                txtNumeroOperacion.Text = pagoAux.numOperaciones;
                txtMetodoPago.Text = pagoAux.metodoPago;
                txtMontoPagado.Text = pagoAux.montoPagado.ToString();
            }
            if (Session["comprobantePago"] != null)
                comprobantePago = (byte[])Session["comprobantePago"];
            cargarComprobante(sender, e);
        }
        private void cargarComprobante(object sender, EventArgs e)
        {
            string extension = System.IO.Path.GetExtension(fileUploadComprobante.FileName);
            if (extension.ToLower() == ".jpg" || extension.ToLower() == ".jpeg" || extension.ToLower() == ".png" || extension.ToLower() == ".gif")
            {
                string filename = Guid.NewGuid().ToString() + extension;
                string filePath = Server.MapPath("~/Uploads/") + filename;
                fileUploadComprobante.SaveAs(Server.MapPath("~/Uploads/") + filename);
                imgComprobante.ImageUrl = "~/Uploads/" + filename;
                imgComprobante.Visible = true;
                FileStream fs = new FileStream(filePath, FileMode.Open, FileAccess.Read);
                BinaryReader br = new BinaryReader(fs);
                Session["comprobantePago"] = br.ReadBytes((int)fs.Length);
                fs.Close();
            }
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("AgregarMedicinasPropias.aspx");
        }
        protected void lbContinuar_Click(object sender, EventArgs e)
        {
            if (fileUploadComprobante.HasFile)
            {
                //private int idField;   me lo da la base de datos
                nuevoPago = new pago();
                nuevoPago.numOperaciones = txtNumeroOperacion.Text;
                nuevoPago.metodoPago = txtMetodoPago.Text;
                nuevoPago.montoPagado = double.Parse(txtMontoPagado.Text);
                nuevoPago.completado = true;
                nuevoPago.pedidoPropio = new pedidoPropio();
                nuevoPago.comprobante = comprobantePago;        //Solo se asigna cuando ya hay un comprobante
                if (Session["pedidoPropio"] != null)
                {
                    //private pedidoPropio pedidoPropioField ;    DE ALGUNA VARIABLE SESSION GUARDADA POR AHI
                    nuevoPago.pedidoPropio = (pedidoPropio)Session["pedidoPropio"];
                }
                Session["pago"] = nuevoPago;       //Guardamos el pago en un session
            }
            //Caso contrario mostrar mensaje de error ya que no hay un archivo
        }
    }
    //En otras pantallas usar el Session["pago"] que contiene toda la información importante de esta parte
}