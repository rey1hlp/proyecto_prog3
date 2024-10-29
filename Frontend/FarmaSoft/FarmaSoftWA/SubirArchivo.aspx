<%@ Page Title="" Language="C#" MasterPageFile="~/FarmaSoft.Master" AutoEventWireup="true" CodeBehind="SubirArchivo.aspx.cs" Inherits="FarmaSoftWA.SubirArchivo" %>
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
                    <asp:Image ID="imgReceta" runat="server" CssClass="img-fluid img-thumbnail" ImageUrl="/Images/placeholder.jpg" Height="235" Width="720" />
                    <asp:FileUpload ID="fileUploadReceta" CssClass="form-control mb-2" runat="server" onchange="this.form.submit()" ClientIDMode="Static" />
                </div>
                <div class="col-md-6">
                    <asp:Label ID="lblPoliza" runat="server" Text="Póliza:" CssClass="col-form-label fw-bold" ></asp:Label>
                    <asp:Image ID="imgPoliza" runat="server" CssClass="img-fluid img-thumbnail" ImageUrl="/Images/placeholder.jpg" Height="235" Width="720" />
                    <asp:FileUpload ID="fileUploadPoliza" CssClass="form-control mb-2" runat="server" onchange="this.form.submit()" ClientIDMode="Static" />
                </div>

            </div>

        </div>

        <div class="card-footer clearfix">
            <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click"/>
            <asp:LinkButton ID="lbContinuar" runat="server" Text="<i class='fa-regular fa-play'></i> Continuar" CssClass="float-end btn btn-primary" OnClick="lbContinuar_Click"/>
            
        </div>


    </div>
</div>

</asp:Content>
