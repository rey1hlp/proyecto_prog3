using FarmaSoftWA.FarmaSoftWS;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FarmaSoftWA
{
    public partial class CompletarDatosPedido : System.Web.UI.Page
    {
        private PedidoPropioWSClient daoPedidoPropio = new PedidoPropioWSClient();
        private PolizaWSClient daoPoliza = new PolizaWSClient();
        poliza poliza;
        private static pedidoPropio pedidoPropio;
        protected void Page_Load(object sender, EventArgs e)
        {
            pedidoPropio = (pedidoPropio)Session["pedidoAtendido"];
            //pedidoPropio pedidoPropio = daoPedidoPropio.obtenerPedidoPropioPorId(Int32.Parse(idPedidoPropio));
            //pedidoPropio = daoPedidoPropio.obtenerPedidoPropioPorId(3);

            if (!IsPostBack)
            {
                txtIDPedido.Text = pedidoPropio.solicitudAsociada.ID.ToString();
                dtpFechaEmisionCli.Value = pedidoPropio.fechayHoraCreacion.ToString("yyyy-MM-dd");
                ddlTipoDocumento.SelectedValue = pedidoPropio.solicitudAsociada.cliente.tipoDocumento.ToString();
                txtNumeroDocumento.Text = pedidoPropio.solicitudAsociada.cliente.numDocumento.ToString();
                txtNombreCompleto.Text = pedidoPropio.solicitudAsociada.cliente.nombre.ToString() +
                    pedidoPropio.solicitudAsociada.cliente.apellidoPaterno.ToString();
                if(pedidoPropio.solicitudAsociada.cliente.correoContacto!=null)
                    txtCorreoElectronico.Text = pedidoPropio.solicitudAsociada.cliente.correoContacto.ToString();
                dtpFechaNacimiento.Value = pedidoPropio.solicitudAsociada.cliente.fechaNacimiento.ToString("yyyy-MM-dd");
                txtTelefono.Text = pedidoPropio.solicitudAsociada.cliente.telefonoContacto.ToString();
                Deshabilitar_Componentes();
            }
            if (!pedidoPropio.solicitudAsociada.cliente.tienePoliza)
            {

                txtEstado.SelectedValue = "2";
                lbRegistrar.Visible = false;
                lbActualizar.Visible = false;
                lbDescargar.Visible = false;
            }
            else
            {
                poliza = daoPoliza.obtenerPolizaPorId(pedidoPropio.solicitudAsociada.cliente.poliza.ID);
                Session["poliza"] = poliza;
                if (poliza.codigo == 0)
                {
                    lblModalPoliza.Text = "Registrar Poliza";
                    txtEstado.SelectedValue = "2";
                    lbRegistrar.Visible = true;
                    lbActualizar.Visible = false;
                    lbDescargar.Visible = true;
                }
                else if (DateTime.Today > poliza.fechaVencimiento)
                {
                    txtEstado.SelectedValue = "1";
                    lbRegistrar.Visible = false;
                    lbActualizar.Visible = true;
                    lbDescargar.Visible = true;
                }
                else
                {
                    //Borrar esto, el monto cubierto va en la pantalla de agregar medicinas propias
                    txtEstado.SelectedValue = "0";
                    double cubre = (poliza.porcentajeCobertura * pedidoPropio.montoTotal) / 100;
                    if (poliza.coberturaMaxima >= cubre)
                    {
                        pedidoPropio.montoCubierto = cubre;
                        pedidoPropio.montoTotal -= cubre;
                    }
                    else
                    {
                        pedidoPropio.montoCubierto = pedidoPropio.solicitudAsociada.cliente.poliza.coberturaMaxima;
                        pedidoPropio.montoTotal -= pedidoPropio.montoCubierto;
                    }
                    lbRegistrar.Visible = false;
                    lbActualizar.Visible = true;
                    lbDescargar.Visible = true;
                }
                if (!IsPostBack)
                {
                    txtPedCodigo.Text = poliza.codigo.ToString();
                    txtPedTipoSeguro.Text = poliza.tipoSeguro.ToString();
                    dtpPedFechaEmision.Value = poliza.fechaEmision.ToString("yyyy-MM-dd");
                    dtpPedFechaVencimiento.Value = poliza.fechaVencimiento.ToString("yyyy-MM-dd");
                    txtPedCoberturaMaxima.Text = poliza.coberturaMaxima.ToString();
                    txtPedPorcCobertura.Text = poliza.porcentajeCobertura.ToString();
                    txtPedAseguradora.Text = poliza.aseguradora.ToString();
                    txtPedDniAsegurado.Text = poliza.DNIAsegurado.ToString();
                    txtPedNombreAsegurado.Text = poliza.nombreAsegurado.ToString();
                    txtNumeroPoliza.Text = poliza.codigo.ToString();
                    txtMontoPagar.Text = pedidoPropio.montoCubierto.ToString();

                }
            }
        }
        public void Deshabilitar_Componentes()
        {
            txtIDPedido.Enabled = false;
            dtpFechaEmisionCli.Disabled = true;
            ddlTipoDocumento.Enabled = false;
            txtNumeroDocumento.Enabled = false;
            txtNombreCompleto.Enabled = false;
            txtCorreoElectronico.Enabled = false;
            dtpFechaNacimiento.Disabled = true;
            txtTelefono.Enabled = false;
            txtNumeroPoliza.Enabled = false;
            txtMontoPagar.Enabled = false;
            txtEstado.Enabled = false;
        }
        protected void lbRegistrar_Click(object sender, EventArgs e)
        {


        }

        protected void lbActualizar_Click(object sender, EventArgs e)
        {

        }

        protected void lbDescargar_Click(object sender, EventArgs e)
        {

        }

        protected void bGuardado_Click(object sender, EventArgs e)
        {
            poliza.codigo = Int32.Parse(txtPedCodigo.Text);
            poliza.tipoSeguro = txtPedTipoSeguro.Text;
            poliza.aseguradora = txtPedAseguradora.Text;
            poliza.DNIAsegurado = Int32.Parse(txtPedDniAsegurado.Text);
            poliza.nombreAsegurado = txtPedNombreAsegurado.Text;
            poliza.fechaEmision = DateTime.Parse(dtpPedFechaEmision.Value);
            poliza.fechaVencimiento = DateTime.Parse(dtpPedFechaVencimiento.Value);
            poliza.coberturaMaxima = Double.Parse(txtPedCoberturaMaxima.Text);
            poliza.porcentajeCobertura = Double.Parse(txtPedPorcCobertura.Text);
            poliza.esValida = true;
            poliza.completado = true;
            int resultado = daoPoliza.actualizarPoliza(poliza);
            if (resultado != 0)
            {
                Response.Write("Se ha registrado con exito...");
            }
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarPedidos.aspx");
        }

        protected void lbContinuar_Click(object sender, EventArgs e)
        {
            Session["PedidoPropio"] = pedidoPropio;
            Response.Redirect("AgregarMedicinasPropias.aspx");
        }


    }


}