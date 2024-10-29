<%@ Page Title="" Language="C#" MasterPageFile="~/FarmaSoft.Master" AutoEventWireup="true" CodeBehind="GenerarPedidoProvincia.aspx.cs" Inherits="FarmaSoft.GenerarPedidoProvincia" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Generar pedido provincia
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>
                    <!-- Cambiar el titulo dependiendo de si se registran o muestran datos -->
                    <asp:Label ID="lblTitulo" runat="server" Text="Redirigir pedido a farmacia asociada"></asp:Label>
                </h2>
            </div>


            <div class="card-body pb-2">
                <div class="row">
                    
                    <div class="col-md-6 pb-md-3">
                        <asp:Label ID="lblDepartamento" runat="server" 
                        Text="Departamento:" CssClass="col-form-label fw-bold"></asp:Label>
                        <asp:DropDownList ID="ddlDepartamento" runat="server" AutoPostBack="true" CssClass="form-select" Enabled="false"></asp:DropDownList>
                    </div>
                    <div class="col-md-12 pb-md-3">
                        <asp:Label ID="lblSeleccionProveedores" runat="server" 
                        Text="Seleccione uno de los proveedores disponibles:" CssClass="col-form-label fw-bold"></asp:Label>
                    </div>

                </div>
                <div class="row">
                    
                    <div class="col-md-12 pb-md-3">
                        <!--Aqui van la tabla-->
                        <asp:GridView ID="gvFarmacias" runat="server" AllowPaging="true" PageSize="5" 
                            AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" 
                            ShowHeaderWhenEmpty="true">
                            <Columns>
                                <asp:TemplateField HeaderText="">
                                    <ItemStyle Width="5%" />
                                    <ItemTemplate>
                                        <input type="radio" name="ProveedorSeleccionado" />
                                    </ItemTemplate>
                                </asp:TemplateField>
                                <asp:BoundField HeaderText="Id" DataField="ID" />
                                <asp:BoundField HeaderText="Nombre" DataField="nombre"/>
                                <asp:TemplateField HeaderText="Dirección">
                                    <ItemTemplate>
                                        <%# Eval("direccion.calle") + ", " + Eval("direccion.distrito") + ", " + Eval("direccion.provincia") %>
                                    </ItemTemplate>
                                </asp:TemplateField>
                                <asp:BoundField HeaderText="Telefono" DataField="telefono" />
                            </columns>
                        </asp:GridView>
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
