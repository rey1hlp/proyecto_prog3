<%@ Page Title="" Language="C#" MasterPageFile="~/FarmaSoft.Master" AutoEventWireup="true" CodeBehind="AgregarMedicinasGenericas.aspx.cs" Inherits="FarmaSoftWA.AgregarMedicinasGenericas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container">
    <div class="card">
        <div class="card-header">
            <h2>
                <asp:Label ID="lblTitulo" runat="server" Text="Agregar medicinas para la solicitud"></asp:Label>
            </h2>
        </div>
        <div class="card-body">
            <!-- Esta es la sección del título y el botón de agregar medicinas-->
            <div class="row">
                <div class="col-md-9 d-flex align-items-center">
                    <asp:Label ID="lblListadoMedicinas" runat="server" Text="Listado de medicinas" CssClass="col-form-label fw-bold"></asp:Label>
                </div>
                <div class="col-md-3">
                    <asp:LinkButton ID="lbAgregarMedicina" runat="server" CssClass="float-end btn btn-success" OnClientClick="openModal(); return false;">
                        Agregar medicina
                    </asp:LinkButton>
                </div>
            </div>
            <!-- Esta es la sección del listado de medicinas-->
            <div class="row">
                <div class="col-md-12 pb-md-3">
                    <asp:GridView ID="gvMedicinas" runat="server" AllowPaging="true" PageSize="6" AutoGenerateColumns="false" 
                        CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
                        <Columns>
                            <asp:BoundField HeaderText="Código" DataField="codigo"/>
                            <asp:BoundField HeaderText="Nombre" DataField="nombre"/>
                            <asp:BoundField HeaderText="Cantidad" DataField="cantidad"/>
                        </Columns>
                    </asp:GridView>
                </div>
            </div>
        </div>
        <div class="card-footer">

        </div>
    </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="modalMedicinas" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Agregar una medicina</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-8">
                                <asp:Label ID="lblMedicina" runat="server" 
                                    Text="Nombre:" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:DropDownList ID="ddlMedicina" runat="server" AutoPostBack="true" CssClass="form-select" Enabled="true"></asp:DropDownList>
                            </div>
                            <div class="col-md-1"></div>
                            <div class="col-md-3">
                                <asp:Label ID="lblCantidad" runat="server" 
                                    Text="Cantidad:" CssClass="col-form-label fw-bold"></asp:Label>
                                <asp:TextBox ID="txtCantidad" runat="server" CssClass="form-control" ></asp:TextBox>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    <button type="button" class="btn btn-primary">Guardar Cambios</button>
                </div>
            </div>
        </div>
    </div>

</asp:Content>
