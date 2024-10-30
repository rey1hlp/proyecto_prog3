using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FarmaSoftWA
{
    public partial class AgregarMedicinasGenericas : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            ddlMedicina.DataSource = Application["listaMedicamentos"] as medicinaGeneral[];
            ddlMedicina.DataTextField = "nombre";
            ddlMedicina.DataValueField = "ID";
            ddlMedicina.DataBind();
        }
    }
}