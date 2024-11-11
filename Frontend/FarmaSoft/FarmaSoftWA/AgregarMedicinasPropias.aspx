<%@ Page Title="" Language="C#" MasterPageFile="~/Pedidos.Master" AutoEventWireup="true" CodeBehind="AgregarMedicinasPropias.aspx.cs" Inherits="FarmaSoftWA.AgregarMedicinasPropias" %>
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
                    <asp:Label ID="lblTitulo" runat="server" Text="Completar medicinas"></asp:Label>
                </h2>
            </div>

            <div class="px-3">
                <div class="card-body pb-2">
                    <!-- Segmento de datos de contacto del cliente -->
                    <div class="row ">
                        <div class="card">
                            <asp:Label ID="lblTituloContacto" runat="server" Text="Datos de contacto del cliente" CssClass="fw-bold"></asp:Label>
                            <div class="card-body pb-2">
                                <div class="row">
                                    <div class="col-md-6">
                                        <asp:Label ID="lblNombre" runat="server" Text="Nombre"></asp:Label>
                                        <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" Enabled="false" ></asp:TextBox>
                                    </div>
                                    <div class="col-md-6">
                                        <asp:Label ID="lblTelefono" runat="server" Text="Telefono"></asp:Label>
                                        <asp:TextBox ID="txtTelefono" runat="server" CssClass="form-control" Enabled="false" ></asp:TextBox>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Fin de segmento de datos de contacto del cliente -->
                    <!-- Segmento de datos de medicinas propias -->
                    <div class="row mt-3">
                        <div class="col-md-9 d-flex align-items-center">
                            <asp:Label ID="lblListadoMedicinas" runat="server" Text="Listado de medicinas" CssClass="col-form-label fw-bold"></asp:Label>
                        </div>
                        <div class="col-md-3">
                            <asp:LinkButton ID="lbAgregarMedicina" runat="server" CssClass="float-end btn btn-success" OnClick="lbAgregarMedicina_Click">
                                Agregar medicina
                            </asp:LinkButton>
                        </div>
                    </div>
                    <div class="row mt-3">
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
                                    <asp:TemplateField HeaderText="Acciones"> 
                                        <ItemTemplate> 
                                            <asp:LinkButton ID="btnEdit" runat="server" CssClass="btn btn-sm me-2" OnClick="btnEdit_Click" CommandArgument='<%# Eval("medicina.IDP") %>'> 
                                                <i class="fas fa-edit"></i> 
                                            </asp:LinkButton> 
                                            <asp:LinkButton ID="btnDelete" runat="server" CssClass="btn btn-sm" OnClick="btnDelete_Click" CommandArgument='<%# Eval("medicina.IDP") %>'>
                                                <i class="fas fa-trash"></i> 
                                            </asp:LinkButton> 
                                        </ItemTemplate> 
                                        <ItemStyle CssClass="align-content-center" /> 
                                    </asp:TemplateField>
                                
                                </Columns>
                            </asp:GridView>
                        </div>
                    </div>
                    <!-- Fin de segmento de datos de medicinas propias -->
                    <!-- Segmento de detalles del pago -->
                    <div class="row">
                        <div class="card">
                            <asp:Label ID="lblTituloPago" runat="server" Text="Detalles de pago" CssClass="fw-bold"></asp:Label>
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
                    <!-- Fin de segmento de detalles del pago -->
                </div>
            </div>

            

            <div class="card-footer clearfix">
                <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click"/>
                <asp:LinkButton ID="lbContinuar" runat="server" Text="<i class='fa-regular fa-play'></i> Continuar" CssClass="float-end btn btn-primary" OnClick="lbContinuar_Click"/>
            </div>

        </div>
    </div>


     <!-- Modal -->
    <div class="modal fade" id="modalMedicinas" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">
                        <asp:Label ID="lblMedTitulo" runat="server" Text="A"></asp:Label>
                    </h5>
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
