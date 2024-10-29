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
        private class Solicitud
        {
            public int Id { get; set; }
            public string Nombre { get; set; }
            public string Apellido { get; set; }
            public DateTime Fecha { get; set; }
            public int Telefono { get; set; }
        }

        private List<Solicitud> solicitudes = new List<Solicitud>();



        protected void Page_Load(object sender, EventArgs e)
        {
            lblTitulo.Text = "Listado de solicitudes pendientes";

            Solicitud soliPrueba = new Solicitud
            {
                Id = 1,
                Nombre = "Carlos",
                Apellido = "Garcia",
                Fecha = DateTime.Now,
                Telefono = 996060021
            };
            solicitudes.Add(soliPrueba);
            gvSolicitudes.DataSource = solicitudes;
            gvSolicitudes.DataBind();

        }

        protected void lbAtender_Click(object sender, EventArgs e)
        {
            Response.Redirect("SubirArchivo.aspx");
        }
    }
}