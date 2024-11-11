<%@ Page Title="Resumen de Solicitud" Language="C#" MasterPageFile="~/FarmaSoft.Master" AutoEventWireup="true" CodeBehind="ResumenSolicitud.aspx.cs" Inherits="FarmaSoftWA.ResumenSolicitud" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    <h2>Resumen de Solicitud</h2>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <!-- Script opcional para algún mapa si se necesita en la dirección -->
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h4>Detalles de la Solicitud</h4>
            </div>

            <div class="card-body">
                <div class="row">
                    <!-- Datos de la Solicitud -->
                    <div class="col-md-6">
                        <h5>Datos de la Solicitud</h5>
                        <div class="pb-2">
                            <strong>Id Solicitud:</strong> <asp:Label ID="lblIdSolicitud" runat="server" Text=""></asp:Label>
                        </div>
                        <div class="pb-2">
                            <strong>Fecha:</strong> <asp:Label ID="lblFecha" runat="server" Text=""></asp:Label>
                        </div>
                        <div class="pb-2">
                            <strong>Cliente:</strong> <asp:Label ID="lblCliente" runat="server" Text=""></asp:Label>
                        </div>
                    </div>

                    <!-- Medicinas Agregadas -->
                    <div class="col-md-6">
                        <h5>Medicinas Agregadas</h5>
                        <asp:GridView ID="gvMedicinas" runat="server" AutoGenerateColumns="false" CssClass="table table-striped">
                            <Columns>
                            <asp:BoundField DataField="medicina.ID" HeaderText="ID" SortExpression="medicina.ID" />
                            <asp:BoundField DataField="medicina.nombre" HeaderText="Nombre" SortExpression="medicina.nombre" />
                            <asp:BoundField DataField="cantidadPedida" HeaderText="Cantidad Pedida" SortExpression="cantidadPedida" />    
                            </Columns>
                        </asp:GridView>
                    </div>
                </div>

                <div class="row">
                    <!-- Dirección -->
                    <div class="col-md-12">
                        <h5>Dirección</h5>
                        <div class="pb-2">
                            <strong>Departamento:</strong> <asp:Label ID="lblDepartamento" runat="server" Text=""></asp:Label>
                        </div>
                        <div class="pb-2">
                            <strong>Provincia:</strong> <asp:Label ID="lblProvincia" runat="server" Text=""></asp:Label>
                        </div>
                        <div class="pb-2">
                            <strong>Distrito:</strong> <asp:Label ID="lblDistrito" runat="server" Text=""></asp:Label>
                        </div>
                        <div class="pb-2">
                            <strong>Calle:</strong> <asp:Label ID="lblCalle" runat="server" Text=""></asp:Label>
                        </div>
                        <div class="pb-2">
                            <strong>Referencia:</strong> <asp:Label ID="lblReferencia" runat="server" Text=""></asp:Label>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <!-- Farmacia Asignada (si no es Lima) -->
                    <div id="divFarmacia" runat="server" style="display:none;">
                        <h5>Farmacia Asignada</h5>
                        <div class="pb-2">
                            <strong>Farmacia:</strong> <asp:Label ID="lblFarmacia" runat="server" Text=""></asp:Label>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card-footer">
                <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="btn btn-secondary" OnClick="lbRegresar_Click" />
                <asp:LinkButton ID="lbTerminar" runat="server" Text="<i class='fa-regular fa-play'></i> Terminar" CssClass="float-end btn btn-primary" OnClick="lbTerminar_Click"/>
            </div>
        </div>
    </div>
</asp:Content>
