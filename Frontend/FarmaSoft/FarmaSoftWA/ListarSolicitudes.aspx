<%@ Page Title="" Language="C#" MasterPageFile="~/FarmaSoft.Master" AutoEventWireup="true" CodeBehind="ListarSolicitudes.aspx.cs" Inherits="FarmaSoftWA.ListarSolicitudes" %>
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
                
                <div class="col-md-12 pb-md-3">
                    <!--Aqui van la tabla-->
                    <asp:GridView ID="gvSolicitudes" runat="server" AllowPaging="true" PageSize="5" 
                        AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" 
                        ShowHeaderWhenEmpty="true">
                        <Columns>
                            <asp:TemplateField HeaderText="">
                                <ItemStyle Width="5%" />
                                <ItemTemplate>
                                    <input type="radio" name="ProveedorSeleccionado" />
                                </ItemTemplate>
                            </asp:TemplateField>
                            <asp:BoundField HeaderText="Id" DataField="id" />
                            <asp:TemplateField HeaderText="Nombre y apellido">
                                <ItemTemplate>
                                    <%# Eval("nombre") + ", " + Eval("apellido") %>
                                </ItemTemplate>
                            </asp:TemplateField>
                            <asp:BoundField HeaderText="Fecha y hora" DataField="fecha"/>
                            <asp:BoundField HeaderText="Telefono" DataField="telefono" />
                        </columns>
                    </asp:GridView>
                </div>

            </div>
        </div>

        <div class="card-footer clearfix">
            <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" />
            <asp:LinkButton ID="lbAtender" runat="server" Text="<i class='fa-regular fa-play'></i> Atender" CssClass="float-end btn btn-primary" OnClick="lbAtender_Click"/>
            
        </div>


    </div>
</div>

</asp:Content>
