<%@ Page Title="" Language="C#" MasterPageFile="~/Pedidos.Master" AutoEventWireup="true" CodeBehind="ProcesamientoPago.aspx.cs" Inherits="FarmaSoftWA.ProcesamientoPago" %>
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
                    <asp:Label ID="lblTitulo" runat="server" Text="Completar pago"></asp:Label>
                </h2>
            </div>


            <div class="card-body pb-2">
                <!-- Segmento de datos del pago -->
                <div class="row">
                    <!-- Segmento de datos textuales del pago -->
                    <div class="col-md-6">
                        <div class="col-md-12 pb-md-3">
                            <asp:Label ID="lblMetodoPago" runat="server" Text="Metodo de pago:" CssClass="col-form-label fw-bold"></asp:Label>
                            <asp:TextBox ID="txtMetodoPago" runat="server" CssClass="form-control" ></asp:TextBox>
                        </div>
                        <div class="col-md-12 pb-md-3">
                            <asp:Label ID="lblNumOperacion" runat="server" Text="Número de operación:" CssClass="col-form-label fw-bold" ></asp:Label>
                            <asp:TextBox ID="txtNumeroOperacion" runat="server" CssClass="form-control" ></asp:TextBox>
                        </div>
                        <div class="col-md-6 pb-md-3">
                            <asp:Label ID="lblMontoPagado" runat="server" Text="Monto pagado:" CssClass="col-form-label fw-bold" ></asp:Label>
                            <asp:TextBox ID="txtMontoPagado" runat="server" CssClass="form-control" ></asp:TextBox>
                        </div>
                    </div>
                    <!-- Segmento de foto del comprobante -->
                    <div class="col-md-6">
                        <div class="col-md-4"></div>
                        <div class="col-md-8">
                            <asp:Label ID="lblComprobante" runat="server" Text="Comprobante de pago:" CssClass="col-form-label fw-bold" ></asp:Label>
                            <asp:Image ID="imgComprobante" runat="server" CssClass="img-fluid img-thumbnail" ImageUrl="/Images/placeholder.jpg" Height="235" Width="720" />
                            <asp:FileUpload ID="fileUploadComprobante" CssClass="form-control mb-2" runat="server" onchange="this.form.submit()" ClientIDMode="Static" />
                        </div>
                        <div class="col-md-4"></div>
                    </div>
                </div>
                <!-- Fin de segmento de datos del pago -->
            </div>

            <div class="card-footer clearfix">
                <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click"/>
                <asp:LinkButton ID="lbContinuar" runat="server" Text="<i class='fa-regular fa-play'></i> Continuar" CssClass="float-end btn btn-primary" OnClick="lbContinuar_Click"/>
            </div>

        </div>
    </div>
</asp:Content>
