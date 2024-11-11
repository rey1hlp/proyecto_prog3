<%@ Page Title="" Language="C#" MasterPageFile="~/FarmaSoft.Master" AutoEventWireup="true" CodeBehind="GenerarPedidoLima.aspx.cs" Inherits="FarmaSoftWA.GenerarPedidoLima" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">

    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDEM02B6oq0JZ4dRU5VcbSrP682JVzsVfQ&callback=initMap" async defer></script>

    <script type="text/javascript">
        // Función para inicializar el mapa
        function initMap() {
            // Verificar que la dirección no esté vacía
            if (clientAddress) {
                var geocoder = new google.maps.Geocoder();

                // Geocodificar la dirección a coordenadas (latitud y longitud)
                geocoder.geocode({ 'address': clientAddress }, function (results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        // Crear un mapa centrado en la dirección obtenida
                        var map = new google.maps.Map(document.getElementById('map'), {
                            zoom: 15, // Nivel de zoom
                            center: results[0].geometry.location
                        });

                        // Colocar un marcador en la dirección
                        var marker = new google.maps.Marker({
                            map: map,
                            position: results[0].geometry.location
                        });
                    } else {
                        alert("No se pudo encontrar la dirección: " + status);
                    }
                });
            } else {
                alert("La dirección no está disponible.");
            }
        }
    </script>

</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container">
    <div class="card">
        <div class="card-header">
            <h2>
                <!-- Cambiar el titulo dependiendo de si se registran o muestran datos -->
                <asp:Label ID="lblTitulo" runat="server" Text="Pedido para Lima"></asp:Label>
            </h2>
        </div>


        <div class="card-body pb-2">
            <div class="row">
                <div class="col-md-4">
                    <!--Aquí van los label y text box para la dirección-->
                    <div class="row">
                        <div class="col-md-12 pb-md-3">
                            <asp:Label ID="lblDepartamento" runat="server" Text="Departamento:" CssClass="col-form-label fw-bold"></asp:Label>
                            <asp:DropDownList ID="ddlDepartamento" runat="server" AutoPostBack="false" CssClass="form-select" Enabled="false"></asp:DropDownList>
                        </div>
                        <div class="col-md-12 pb-md-3">
                            <asp:Label ID="Label1" runat="server" Text="Provincia:" CssClass="col-form-label fw-bold" ></asp:Label>
                            <asp:TextBox ID="txtProvincia" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                        </div>
                        <div class="col-md-12 pb-md-3">
                            <asp:Label ID="lblDistrito" runat="server" Text="Distrito:" CssClass="col-form-label fw-bold" ></asp:Label>
                            <asp:TextBox ID="txtDistrito" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                        </div>
                        <div class="col-md-12 pb-md-3"> 
                            <asp:Label ID="lblCalle" runat="server" Text="Calle:" CssClass="col-form-label fw-bold" ></asp:Label>
                            <asp:TextBox ID="txtCalle" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                        </div>
                        <div class="col-md-12 pb-md-3"> 
                            <asp:Label ID="lblReferencia" runat="server" Text="Referencia:" CssClass="col-form-label fw-bold" ></asp:Label>
                            <asp:TextBox ID="txtReferencia" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                        </div>
                    </div>
                </div>
                <!-- Columna del mapa (a la derecha) -->
                    <div class="col-md-4">
                        <!-- Contenedor para el mapa -->
                        <div id="map" style="height: 400px; width: 200%;"></div>
                    </div>
            </div>
        </div>

        <div class="card-footer clearfix">
            <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click"/>
            <asp:LinkButton ID="lbGuardar" runat="server" Text="<i class='fa-regular fa-floppy-disk'></i> Guardar" CssClass="float-end btn btn-primary" OnClick="lbGuardar_Click"/>
        </div>


    </div>
</div>

</asp:Content>
