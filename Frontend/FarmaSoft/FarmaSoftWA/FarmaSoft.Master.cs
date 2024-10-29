using System;

namespace FarmaSoft
{
    public partial class FarmaSoft : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            cphTitulo.Controls.Clear();
        }
    }
}