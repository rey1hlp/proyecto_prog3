<%@ Page Title="" Language="C#" MasterPageFile="~/Pedidos.Master" AutoEventWireup="true" CodeBehind="ResumenPedido.aspx.cs" Inherits="FarmaSoftWA.ResumenPedido" %>
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
                    <asp:Label ID="lblTitulo" runat="server" Text="Resumen del pedido"></asp:Label>
                </h2>
            </div>


            <div class="card-body pb-2">
                <!-- Segmento de cliente -->
                
                <div class="row pb-3 px-3">
                    <div class="card">
                        <asp:Label ID="lblTituloContacto" runat="server" Text="Datos del cliente" CssClass="col-form-label fw-bold"></asp:Label>
                        <div class="card-body pb-2">
                            <div class="row">
                                <div class="col-md-6">
                                    <asp:Label ID="lblNombre" runat="server" Text="Nombre" CssClass="col-form-label"></asp:Label>
                                    <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" Enabled="false" ></asp:TextBox>
                                </div>
                                <div class="col-md-6">
                                    <asp:Label ID="lblTelefono" runat="server" Text="Telefono" CssClass="col-form-label"></asp:Label>
                                    <asp:TextBox ID="txtTelefono" runat="server" CssClass="form-control" Enabled="false" ></asp:TextBox>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Fin de segmento de cliente -->

                <!-- Segmento de medicinas -->

                <div class="row mt-1">
                    <div class="col-md-12">
                        <asp:GridView ID="gvMedicinas" runat="server" AllowPaging="true" PageSize="5" OnPageIndexChanging="gvMedicinas_PageIndexChanging" AutoGenerateColumns="false" 
                            CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true" >
                            <Columns>

                                <asp:BoundField HeaderText="Código" DataField="medicina.IDP" ItemStyle-CssClass="align-content-center"/>
                                <asp:BoundField HeaderText="Nombre" DataField="medicina.nombre" ItemStyle-CssClass="align-content-center"/>
                                <asp:BoundField HeaderText="Cantidad" DataField="cantidadPedida" ItemStyle-CssClass="align-content-center"/>
                                <asp:BoundField HeaderText="P.U." DataField="precioUnitario" ItemStyle-CssClass="align-content-center"/>
                                <asp:TemplateField HeaderText="Subtotal"> 
                                    <ItemTemplate> <%# Convert.ToDecimal(Eval("precioUnitario")) * Convert.ToDecimal(Eval("cantidadPedida")) %> </ItemTemplate> 
                                    <ItemStyle CssClass="align-content-center" /> 
                                </asp:TemplateField>

                            </Columns>
                        </asp:GridView>
                    </div>
                </div>

                <!-- Fin de segmento de medicinas -->

                <!-- Segmento de detalles del pago -->
                <div class="row pb-3">

                    <div class="col-md-6 pb-3">
                        <div class="card">
                            <asp:Label ID="lblTituloPago" runat="server" Text="Monto pago" CssClass="col-form-label fw-bold ps-3"></asp:Label>
                            <div class="card-body pb-2">
                                <div class="row">
                                    <div class="col-md-4">
                                        <asp:label id="lblTotal" runat="server" text="Total"></asp:label>
                                        <asp:textbox id="txtTotal" runat="server" cssclass="form-control" enabled="false" ></asp:textbox>
                                    </div>
                                    <div class="col-md-4">
                                        <asp:label id="lblMontoCubierto" runat="server" text="Monto cubierto"></asp:label>
                                        <asp:textbox id="txtMontoCubierto" runat="server" cssclass="form-control" enabled="false" ></asp:textbox>
                                    </div>
                                    <div class="col-md-4">
                                        <asp:label id="lblTotalAPagar" runat="server" text="Total a pagar"></asp:label>
                                        <asp:textbox id="txtTotalAPagar" runat="server" cssclass="form-control" enabled="false" ></asp:textbox>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>



                    <div class="col-md-6">
                        <div class="card">
                            <asp:Label ID="Label1" runat="server" Text="Detalles de pago" CssClass="col-form-label fw-bold ps-3"></asp:Label>
                            <div class="card-body pb-2">
                                <div class="row">
                                    <div class="col-md-4">
                                        <asp:Label ID="lblMetodoPago" runat="server" Text="Metodo de pago" CssClass="col-form-label"></asp:Label>
                                        <asp:TextBox ID="txtMetodoPago" runat="server" CssClass="form-control" enabled="false"></asp:TextBox>
                                    </div>
                                    <div class="col-md-4">
                                        <asp:Label ID="lblNumOperacion" runat="server" Text="Número de operación:" CssClass="col-form-label" ></asp:Label>
                                        <asp:TextBox ID="txtNumeroOperacion" runat="server" CssClass="form-control" enabled="false"></asp:TextBox>
                                    </div>
                                    <div class="col-md-4">
                                        <asp:Label ID="lblMontoPagado" runat="server" Text="Monto pagado" CssClass="col-form-label" ></asp:Label>
                                        <asp:TextBox ID="txtMontoPagado" runat="server" CssClass="form-control" enabled="false"></asp:TextBox>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- Fin de segmento de detalles del pago -->


            </div>

            <div class="card-footer clearfix">
                <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click"/>
                <asp:LinkButton ID="lbFinalizar" runat="server" Text="<i class='fa-regular fa-floppy-disk'></i> Finalizar pedido" CssClass="float-end btn btn-primary" OnClick="lbFinalizar_Click"/>
            </div>

        </div>
    </div>
</asp:Content>
