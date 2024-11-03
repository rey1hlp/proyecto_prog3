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
    public partial class AgregarMedicinasGenericas : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                ddlMedicina.DataSource = Application["listaMedicamentos"] as medicinaGeneral[];
                ddlMedicina.DataTextField = "nombre";
                ddlMedicina.DataValueField = "ID";
                ddlMedicina.DataBind();

                ddlMedicina.Items.Insert(0, new ListItem("-- Selecciona una opción --", ""));

                Session["detallesSolicitud"] = new BindingList<detalleSolicitud>();
            }
        }

        protected void bGuardado_Click(object sender, EventArgs e)
        {
            string codMedicina = ddlMedicina.SelectedValue;
            int cantMedicina = int.Parse(txtCantidad.Text);

            medicinaGeneral[] medicinasGenerales = Application["listaMedicamentos"] as medicinaGeneral[];
            BindingList<detalleSolicitud> listaDetalles = Session["detallesSolicitud"] as BindingList<detalleSolicitud>;

            foreach (medicinaGeneral medicinaGen in medicinasGenerales)
            {
                if (medicinaGen.ID == codMedicina)
                {
                    listaDetalles.Add(new detalleSolicitud()
                    {
                        medicina = new medicinaGeneral1()
                        {
                            ID = codMedicina,
                            nombre = medicinaGen.nombre,
                            tipoMedicamento = transformarTipoMedicamento(medicinaGen.tipoMedicamento),
                            tipoMedicamentoSpecified = true
                        },
                        cantidadPedida = cantMedicina
                    });
                    break;
                }
            }

            gvMedicinas.DataSource = listaDetalles;
            gvMedicinas.DataBind();

            Session["detallesSolicitud"] = listaDetalles;
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("SubirArchivo.aspx");
        }

        protected void lbGuardar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CompletarDireccionEnvio.aspx");
        }

        private tipoMedicamento1 transformarTipoMedicamento(tipoMedicamento tipoATransformar)
        {
            string valorStr = tipoATransformar.ToString();
            return (tipoMedicamento1)Enum.Parse(typeof(tipoMedicamento1), valorStr);
        }
    }
}