using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FarmaSoftWA
{
    public partial class SubirArchivo : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarSolicitudes.aspx");
        }

        protected void lbContinuar_Click(object sender, EventArgs e)
        {
            Response.Redirect("AgregarMedicinasGenericas.aspx");
        }
    }
}