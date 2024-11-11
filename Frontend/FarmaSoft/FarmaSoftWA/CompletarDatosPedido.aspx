<%@ Page Title="" Language="C#" MasterPageFile="~/Pedidos.Master" AutoEventWireup="true" CodeBehind="CompletarDatosPedido.aspx.cs" Inherits="FarmaSoftWA.CompletarDatosPedido" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>
                    <!-- Cambiar el titulo dependiendo de si se registran o muestran datos -->
                    <asp:Label ID="lblTitulo" runat="server" Text="Completar los datos del pedido"></asp:Label>
                </h2>
            </div>


            <div class="card-body pb-2">

                <div class="row">
                    <asp:Label ID="lblDatosCliente" runat="server" Text="Datos del cliente" CssClass="h4 fw-bold"></asp:Label>
                    <div class="col-md-6">
                        <div class="row mt-2">
                            <div class="col-md-5 pb-md-3">
                                <asp:Label ID="lblIDPedido" runat="server" Text="ID Pedido" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtIDPedido" runat="server" CssClass="form-control" ReadOnly="true"></asp:TextBox>
                            </div>
                            <div class="col-md-5 pb-md-3 ms-auto">
                                <asp:Label ID="lblFechaEmisionCli" runat="server" Text="Fecha de emisión" CssClass="col-form-label fw-bold"></asp:Label>
                                <input id="dtpFechaEmisionCli" runat="server" type="date" class="form-control" />
                            </div>
                            <div class="col-md-5 pb-md-3">
                                <asp:Label ID="lblTipoDocumento" runat="server" Text="Tipo de documento" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:DropDownList ID="ddlTipoDocumento" runat="server" AutoPostBack="true" CssClass="form-select">
                                    <asp:ListItem Value="DNI"> DNI </asp:ListItem>
                                    <asp:ListItem Value="CE"> CE </asp:ListItem>
                                    <asp:ListItem Value="PASAPORTE"> PASAPORTE </asp:ListItem>
                                </asp:DropDownList>
                            </div>
                            <div class="col-md-5 pb-md-3 ms-auto">
                                <asp:Label ID="lblNumeroDocumento" runat="server" Text="Número de documento" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtNumeroDocumento" runat="server" CssClass="form-control" ReadOnly="true"></asp:TextBox>
                            </div>
                            <div class="col-md-12 pb-md-3 ms-auto">
                                <asp:Label ID="lblNombreCompleto" runat="server" Text="Nombre completo" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtNombreCompleto" runat="server" CssClass="form-control" ReadOnly="true"></asp:TextBox>
                            </div>
                            <div class="col-md-12 pb-md-3 ms-auto">
                                <asp:Label ID="lblCorreoElectronico" runat="server" Text="Correo electrónico" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtCorreoElectronico" runat="server" CssClass="form-control" ReadOnly="true"></asp:TextBox>
                            </div>
                            <div class="col-md-5 pb-md-3">
                                <asp:Label ID="lblFechaNacimiento" runat="server" Text="Fecha de nacimiento" CssClass="col-form-label fw-bold"></asp:Label>
                                <input id="dtpFechaNacimiento" runat="server" type="date" class="form-control" />
                            </div>
                            <div class="col-md-5 pb-md-3 ms-auto">
                                <asp:Label ID="lblTelefono" runat="server" Text="Teléfono-celular" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtTelefono" runat="server" CssClass="form-control" ReadOnly="true"></asp:TextBox>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 custom-border">
                        <div class="row mt-2">
                            <!-- <asp:Label ID="lblRecetaMedica" runat="server" Text="Receta Médica" CssClass="h4 fw-bold" ></asp:Label>
                        <div class="col-md-5 pb-md-3">
                            <asp:Label ID="lblFechaEmisionRec" runat="server" Text="Fecha emisión*" CssClass="col-form-label fw-bold"></asp:Label>
                            <input id="dtpFechaEmisionRec" runat="server" type="date" class="form-control"/>
                        </div>
                        <div class="col-md-5 pb-md-3 ms-auto">
                            <asp:Label ID="lblFechaVigencia" runat="server" Text="Fecha vigencia*" CssClass="col-form-label fw-bold"></asp:Label>
                            <input id="dtpFechaVigencia" runat="server" type="date" class="form-control"/>
                        </div>
                        <div class="col-md-12 pb-md-3 ms-auto">
                            <asp:Label ID="lblDescripcion" runat="server" Text="Descripción" CssClass="col-form-label fw-bold"></asp:Label>
                            <asp:TextBox ID="txtDescripcion" runat="server" CssClass="form-control" ReadOnly="true"></asp:TextBox>
                        </div>-->
                            <asp:Label ID="lblPoliza" runat="server" Text="Póliza" CssClass="h4 fw-bold"></asp:Label>
                            <div class="col-md-4 pb-md-3">
                                <asp:Label ID="lblNumeroPoliza" runat="server" Text="Número de póliza" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtNumeroPoliza" runat="server" CssClass="form-control" ReadOnly="true"></asp:TextBox>
                            </div>
                            <div class="col-md-4 pb-md-3">
                                <asp:Label ID="lblMontoPagar" runat="server" Text="Monto a pagar" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtMontoPagar" runat="server" CssClass="form-control" ReadOnly="true"></asp:TextBox>
                            </div>
                            <div class="col-md-4 pb-md-3">
                                <asp:Label ID="lblEstado" runat="server" Text="Estado" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:DropDownList ID="txtEstado" runat="server" AutoPostBack="true" CssClass="form-select">
                                    <asp:ListItem Value="0"> VIGENTE </asp:ListItem>
                                    <asp:ListItem Value="1"> CADUCADO </asp:ListItem>
                                    <asp:ListItem Value="2"> NO INGRESADO </asp:ListItem>
                                </asp:DropDownList>
                            </div>
                            <div class="col-md-12 text-md-end pb-md-3">
                                <asp:Panel ID="panelBotones" runat="server" CssClass="text-md-end">
                                    <asp:LinkButton ID="lbRegistrar" runat="server" CssClass="btn btn-primary" Text="<i class='fa-solid fa-plus'></i> Registrar" OnClientClick="openModalPoliza(); return false;" OnClick="lbRegistrar_Click" />
                                    <asp:LinkButton ID="lbActualizar" runat="server" CssClass="btn btn-primary" Text="<i class='fa-solid fa-pencil-alt'></i> Actualizar" OnClientClick="openModalPoliza(); return false;" OnClick="lbActualizar_Click" />
                                </asp:Panel>
                            </div>
                            <div class="col-md-12 col-md text-md-end pb-md-3 ">
                                <asp:LinkButton ID="lbDescargar" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-download'></i> Descargar" OnClick="lbDescargar_Click" />

                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card-footer clearfix">
                <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click"/>
                <asp:LinkButton ID="lbContinuar" runat="server" Text="<i class='fa-regular fa-play'></i> Continuar" CssClass="float-end btn btn-primary" OnClick="lbContinuar_Click"/>

            </div>


        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="modalPoliza" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5>
                        <asp:Label ID="lblModalPoliza" runat="server" Text="Actualizar Poliza"></asp:Label>
                    </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-6 pb-md-3">
                                <asp:Label ID="lblPedCodigo" runat="server" Text="Código" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtPedCodigo" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                            <div class="col-md-6 pb-md-3 ms-auto">
                                <asp:Label ID="lblPedTipoSeguro" runat="server" Text="Tipo de Seguro" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtPedTipoSeguro" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                            <div class="col-md-6 pb-md-3">
                                <asp:Label ID="lblPedFechaEmision" runat="server" Text="Fecha de Emisión" CssClass="col-form-label fw-bold"></asp:Label>
                                <input id="dtpPedFechaEmision" runat="server" type="date" class="form-control" />
                            </div>
                            <div class="col-md-6 pb-md-3  ms-auto">
                                <asp:Label ID="lblPedFechaVencimiento" runat="server" Text="Fecha de Vencimiento" CssClass="col-form-label fw-bold"></asp:Label>
                                <input id="dtpPedFechaVencimiento" runat="server" type="date" class="form-control" />
                            </div>
                            <div class="col-md-6 pb-md-3">
                                <asp:Label ID="lblPedCoberturaMaxima" runat="server" Text="Cobertura Maxima" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtPedCoberturaMaxima" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                            <div class="col-md-6 pb-md-3 ms-auto">
                                <asp:Label ID="lblPedPorcCobertura" runat="server" Text="Porcentaje de Cobertura" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtPedPorcCobertura" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                            <div class="col-md-6 pb-md-3">
                                <asp:Label ID="lblPedAseguradora" runat="server" Text="Aseguradora" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtPedAseguradora" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                            <div class="col-md-6 pb-md-3 ms-auto">
                                <asp:Label ID="lblPedDniAsegurado" runat="server" Text="DNI Asegurado" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtPedDniAsegurado" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                            <div class="col-md-12 pb-md-3">
                                <asp:Label ID="lblPedNombreAsegurado" runat="server" Text="Nombre Asegurado" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtPedNombreAsegurado" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                        </div>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                <asp:Button ID="bGuardado" runat="server" CssClass="btn btn-primary" Text="Guardar Cambios" OnClick="bGuardado_Click" />
            </div>
        </div>
    </div>
    </div>
</asp:Content>
