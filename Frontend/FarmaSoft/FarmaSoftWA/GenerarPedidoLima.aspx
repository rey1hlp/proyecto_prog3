<%@ Page Title="" Language="C#" MasterPageFile="~/FarmaSoft.Master" AutoEventWireup="true" CodeBehind="GenerarPedidoLima.aspx.cs" Inherits="FarmaSoftWA.GenerarPedidoLima" %>
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
                <asp:Label ID="lblTitulo" runat="server" Text="lblTitulo"></asp:Label>
            </h2>
        </div>


        <div class="card-body pb-2">
            <div class="row">
                <div class="col-md-4">
                    <!--Aquí van los label y text box para la dirección-->
                    <div class="row">
                        <div class="col-md-12 pb-md-3">
                            <asp:Label ID="lblDepartamento" runat="server" Text="Departamento:" CssClass="col-form-label fw-bold"></asp:Label>
                            <asp:DropDownList ID="ddlDepartamento" runat="server" AutoPostBack="true" CssClass="form-select" Enabled="false"></asp:DropDownList>
                        </div>
                        <div class="col-md-12 pb-md-3">
                            <asp:Label ID="Label1" runat="server" Text="Provincia:" CssClass="col-form-label fw-bold" ></asp:Label>
                            <asp:TextBox ID="TextBox1" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                        </div>
                        <div class="col-md-12 pb-md-3">
                            <asp:Label ID="lblDistrito" runat="server" Text="Distrito:" CssClass="col-form-label fw-bold" ></asp:Label>
                            <asp:TextBox ID="txtDistrito" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                        </div>
                        <div class="col-md-12 pb-md-3"> 
                            <asp:Label ID="lblCalle" runat="server" Text="Calle:" CssClass="col-form-label fw-bold" ></asp:Label>
                            <asp:TextBox ID="txtCalle" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                        </div>
                        <div class="col-md-12 pb-md-3"> 
                            <asp:Label ID="lblReferencia" runat="server" Text="Referencia:" CssClass="col-form-label fw-bold" ></asp:Label>
                            <asp:TextBox ID="txtReferencia" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div calss="row">

                    </div>
                    <div class="row">

                        <asp:Label ID="lblDocumentos" runat="server" Text="Documentos:" CssClass="col-form-label fw-bold"></asp:Label>
                        <div class="form-control">
                            <div class="form-check form-check-inline">
                                <asp:CheckBox ID="cbPoliza" runat="server" CssClass="form-check-label" />
                                <label class="form-check-label" for="cbPoliza">POLIZA</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <asp:CheckBox ID="cbMedicina" runat="server" CssClass="form-check-label" />
                                <label class="form-check-label" for="cbMedicina">MEDICINA</label>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </div>

        <div class="card-footer clearfix">
            <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" />
            <asp:LinkButton ID="lbGuardar" runat="server" Text="<i class='fa-regular fa-floppy-disk'></i> Guardar" CssClass="float-end btn btn-primary" />
            
        </div>


    </div>
</div>

</asp:Content>
