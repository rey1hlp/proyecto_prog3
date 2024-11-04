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
                    <asp:GridView ID="gvMedicinas" runat="server" AllowPaging="true" PageSize="5" OnPageIndexChanging="gvMedicinas_PageIndexChanging" AutoGenerateColumns="false" 
                        CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
                        <Columns>
                            <asp:BoundField HeaderText="Código" DataField="medicina.ID" ItemStyle-CssClass="align-content-center"/>
                            <asp:BoundField HeaderText="Nombre" DataField="medicina.nombre" ItemStyle-CssClass="align-content-center"/>
                            <asp:BoundField HeaderText="Cantidad" DataField="cantidadPedida" ItemStyle-CssClass="align-content-center"/>
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <asp:Button ID="btnEliminarMedicina" runat="server" Text="Eliminar" CommandName="Eliminar" CommandArgument='<%# Eval("medicina.ID") %>'
                                        OnClick="btnEliminarMedicina_Click" OnClientClick="return confirm('¿Estás seguro de que deseas eliminar este registro?');" CssClass="btn btn-danger"/>
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>
                </div>
            </div>
        </div>
        <div class="card-footer clearfix">
            <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click"/>
            <asp:LinkButton ID="lbGuardar" runat="server" Text="<i class='fa-regular fa-floppy-disk'></i> Guardar" CssClass="float-end btn btn-primary" OnClick="lbGuardar_Click"/>
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
                                <asp:DropDownList ID="ddlMedicina" runat="server" AutoPostBack="false" CssClass="form-select" Enabled="true"></asp:DropDownList>
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
                    <asp:Button ID="bGuardado" runat="server" CssClass="btn btn-success" Text="Guardar Cambios" OnClick="bGuardado_Click"/>
                </div>
            </div>
        </div>
    </div>

</asp:Content>
