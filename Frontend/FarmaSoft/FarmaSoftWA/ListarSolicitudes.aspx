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
                <asp:Label ID="lblTitulo" runat="server" Text="Listado de solicitudes pendientes"></asp:Label>
            </h2>
        </div>


        <div class="card-body pb-2">
            
            <div class="row">
                
                <div class="col-md-12 pb-md-3">
                    <!--Aqui van la tabla-->
                    <asp:GridView ID="gvSolicitudes" runat="server" AllowPaging="true" PageSize="5" OnPageIndexChanging="gvSolicitudes_PageIndexChanging" 
                        AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped"
                        ShowHeaderWhenEmpty="true" DataKeyNames="ID">
                        <Columns>
                            <asp:TemplateField HeaderText="Seleccionar">
                                <ItemStyle Width="5%" />
                                <ItemTemplate>
                                    <asp:RadioButton ID="rbSeleccionado" runat="server" GroupName="SolicitudSeleccionada" AutoPostBack="true" OnCheckedChanged="rbSeleccionado_CheckedChanged"/>
                                </ItemTemplate>
                            </asp:TemplateField>
                            <asp:BoundField HeaderText="ID" DataField="ID" />
                            <asp:TemplateField HeaderText="Nombre y apellido">
                                <ItemTemplate>
                                    <%# Eval("cliente.nombre") + ", " + Eval("cliente.apellidoPaterno") + " " + Eval("cliente.apellidoMaterno") %>
                                </ItemTemplate>
                            </asp:TemplateField>
                            <asp:BoundField HeaderText="Fecha y hora" DataField="fechayhoraCreacion"/>
                            <asp:BoundField HeaderText="Telefono" DataField="cliente.telefonoContacto" />
                        </columns>
                    </asp:GridView>
                </div>

            </div>
        </div>

        <div class="card-footer clearfix">
            <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click"/>
            <asp:LinkButton ID="lbAtender" runat="server" Text="<i class='fa-regular fa-play'></i> Atender" CssClass="float-end btn btn-primary" OnClick="lbAtender_Click"/>
            
        </div>


    </div>
</div>

</asp:Content>
