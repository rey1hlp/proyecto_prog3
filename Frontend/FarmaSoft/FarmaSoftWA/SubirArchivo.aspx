    <%@ Page Title="" Language="C#" MasterPageFile="~/FarmaSoft.Master" AutoEventWireup="true" CodeBehind="SubirArchivo.aspx.cs" Inherits="FarmaSoftWA.SubirArchivo" %>
    <asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    </asp:Content>
    <asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
        <script type="text/javascript">
            function mostrarImagenReceta(event) {
                var archivo = event.target.files[0];
                if (archivo) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        // Acceder a imgVistaPrevia usando su ClientID dinámico
                        var imgVistaPrevia = document.getElementById('<%= imgReceta.ClientID %>');
                        imgVistaPrevia.src = e.target.result;
                        imgVistaPrevia.style.display = 'block';
                    };
                    reader.readAsDataURL(archivo);
                }
            }
</script>
                <script type="text/javascript">
                    function mostrarImagenPoliza(event) {
                        var archivo = event.target.files[0];
                        if (archivo) {
                            var reader = new FileReader();
                            reader.onload = function (e) {
                                // Acceder a imgVistaPrevia usando su ClientID dinámico
                                var imgVistaPrevia = document.getElementById('<%= imgPoliza.ClientID %>');
                                imgVistaPrevia.src = e.target.result;
                                imgVistaPrevia.style.display = 'block';
                            };
                            reader.readAsDataURL(archivo);
                        }
                    }
</script>
    </asp:Content>

    <asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
        <div class="container">
            <!-- Nuevos Labels para mostrar datos -->
            <asp:Label ID="lblSubtitulo" runat="server" Text="Detalles de la Solicitud" CssClass="h5"></asp:Label><br />
            <asp:Label ID="lblId" runat="server" CssClass="text-muted"></asp:Label><br />
            <asp:Label ID="lblNombre" runat="server" CssClass="text-muted"></asp:Label><br />
            <asp:Label ID="lblFecha" runat="server" CssClass="text-muted"></asp:Label><br />

        </div>
        <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>
                    <!-- Cambiar el titulo dependiendo de si se registran o muestran datos -->
                    <asp:Label ID="lblTitulo" runat="server" Text="Documentos"></asp:Label>
                </h2>
            </div>

            <div class="card-body pb-2">
            
                <div class="row">
                
                    <div class="col-md-12">
                        <asp:Label ID="lblDocumentos" runat="server" Text="Registro de documentos:" CssClass="col-form-label fw-bold" ></asp:Label>
                    </div>

                    <div class="col-md-6">
                        <asp:Label ID="lblReceta" runat="server" Text="Receta:" CssClass="col-form-label fw-bold" ></asp:Label>
                        <asp:Image ID="imgReceta" runat="server" CssClass="img-fluid img-thumbnail" ImageUrl="/Images/placeholder.jpg" alt="Imagen receta" style="max-width: 720px; max-height: 235px;" /> 
                        <asp:FileUpload ID="fileUploadReceta" CssClass="form-control mb-2" runat="server" accept="image/*" onchange="mostrarImagenReceta(event);" />
                    </div>
                    <div class="col-md-6">
                        <asp:Label ID="lblPoliza" runat="server" Text="Poliza:" CssClass="col-form-label fw-bold" ></asp:Label>
                        <asp:Image ID="imgPoliza" runat="server" CssClass="img-fluid img-thumbnail" ImageUrl="/Images/placeholder.jpg" alt="Imagen poliza" style="max-width: 720px; max-height: 235px;" /> 
                        <asp:FileUpload ID="fileUploadPoliza" CssClass="form-control mb-2" runat="server" accept="image/*" onchange="mostrarImagenPoliza(event);" />
                    </div>

                </div>

            </div>

            <div class="card-footer clearfix">
                <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Devolver a pendiente" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click"
                    OnClientClick="return confirm('¿Estás seguro de volver al listado de solicitudes? Ningún dato se guardará y la solicitud volverá a estar pendiente.');"/>
                <asp:LinkButton ID="lbContinuar" runat="server" Text="<i class='fa-regular fa-play'></i> Continuar" CssClass="float-end btn btn-primary" OnClick="lbContinuar_Click"/>
            
            </div>


        </div>
    </div>

    </asp:Content>
