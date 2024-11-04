using FarmaSoftWA.FarmaSoftWS;
using System;
using System.CodeDom;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.SessionState;
using System.Xml.Linq;

namespace FarmaSoftWA
{
    public class Global : System.Web.HttpApplication
    {
        private MedicinaGeneralWSClient medicinaGeneralWS = new MedicinaGeneralWSClient();
        private FarmaciaAsociadaWSClient farmaciaWS = new FarmaciaAsociadaWSClient();
        protected void Application_Start(object sender, EventArgs e)
        {
            Application["listaDepartamentos"] = Enum.GetValues(typeof(departamento));
            Application["listaTiposMedicamentos"] = Enum.GetValues(typeof(tipoMedicamento));
            Application["solicitudesEnAtencion"] = new BindingList<int>();
        }

        protected void Session_Start(object sender, EventArgs e)
        {
            Session["solicitudAtendida"] = null;
            Session["direccion"] = null;
            Session["recetaMedicaFoto"] = null;
            Session["polizaFoto"] = null;
            Session["detallesSolicitud"] = null;
        }

        protected void Application_BeginRequest(object sender, EventArgs e)
        {

        }

        protected void Application_AuthenticateRequest(object sender, EventArgs e)
        {

        }

        protected void Application_Error(object sender, EventArgs e)
        {

        }

        protected void Session_End(object sender, EventArgs e)
        {

        }

        protected void Application_End(object sender, EventArgs e)
        {

        }
    }
}