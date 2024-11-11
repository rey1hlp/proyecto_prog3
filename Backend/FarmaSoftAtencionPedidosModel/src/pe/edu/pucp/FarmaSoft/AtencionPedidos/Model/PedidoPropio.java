package pe.edu.pucp.FarmaSoft.AtencionPedidos.Model;

import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Solicitud;
import java.util.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Usuario;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.DetalleSolicitud;
import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaPropia;

public class PedidoPropio {
    private int ID;
    private Solicitud solicitudAsociada;
    private Date fechayHoraCreacion;
    private EstadoPedido estadoPedido;
    private Usuario tecnicoEncargado;
    private ArrayList<DetallePedido> detallesPedido;
    private double montoTotal;
    private double montoCubierto;
    private Pago pago;
    private boolean completado;

    public PedidoPropio() {
        
    }
    
    //AGREGAR ESTE METODO
    public void convertirMedicinasGenericasAPropias(){
        //Este metodo solo pasa los datos de un detalle de solicitud a uno de pedido
        ArrayList<DetalleSolicitud> detalles = solicitudAsociada.getDetallesSolicitud();
        //Creamos una nueva lista de detalles de pedido
	ArrayList<DetallePedido> detallesPed = new ArrayList<DetallePedido>();
        for(DetalleSolicitud detalle : detalles){
            //Pasamos de detalle de solicitud a pedido
            DetallePedido detallePed = transformarDetalleSolicitudADetallePedido(detalle);
            //Agregamos a la nueva lista de detalles de pedido
            detallesPed.add(detallePed);
        }
        setDetallesPedido(detallesPed);
    }
    //AGREGAR ESTE METODO
    public DetallePedido transformarDetalleSolicitudADetallePedido(DetalleSolicitud detalleSoli){
        DetallePedido detalle = new DetallePedido();
        MedicinaPropia medicina = new MedicinaPropia();
        
        //Paso de datos de medicina de detalle solicitud a medicina de pedido
        //medicina.setCodigo(detalleSoli.getMedicina().getCodigo);   esto va en el WS
        medicina.setIDP(detalleSoli.getMedicina().getIDP());         //Con esto buscamos datos en el WS
        medicina.setNombre(detalleSoli.getMedicina().getNombre());
        //medicina.setPrecio(precio);     esto va en el WS
        medicina.setTipoMedicamento(detalleSoli.getMedicina().getTipoMedicamento());
        
        detalle.setMedicina(medicina);
        detalle.setCantidadPedida(detalleSoli.getCantidadPedida());
        //detallePedido.setPrecioUnitario(precio);   esto va en el WS
        
        return detalle;
    }
    
    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the solicitudAsociada
     */
    
    /**
     * @return the fechaCreacion
     */

    /**
     * @return the tecnicoEncargado
     */


    /**
     * @return the estadoPedido
     */
    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    /**
     * @param estadoPedido the estadoPedido to set
     */
    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
    
     /**
     * @return the detallesPedido
     */
    public ArrayList<DetallePedido> getDetallesPedido() {
        return detallesPedido;
    }

    /**
     * @param detallesPedido the detallesPedido to set
     */
    public void setDetallesPedido(ArrayList<DetallePedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }
    
    /**
     * @return the montoTotal
     */
    public double getMontoTotal() {
        return montoTotal;
    }

    /**
     * @param montoTotal the montoTotal to set
     */
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * @return the montoCubierto
     */
    public double getMontoCubierto() {
        return montoCubierto;
    }

    /**
     * @param montoCubierto the montoCubierto to set
     */
    public void setMontoCubierto(double montoCubierto) {
        this.montoCubierto = montoCubierto;
    }
    
    /**
     * @return the pago
     */
    public Pago getPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(Pago pago) {
        this.pago = pago;
    }

    /**
     * @return the completado
     */
    public boolean isCompletado() {
        return completado;
    }

    /**
     * @param completado the completado to set
     */
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
    
    public void determinarMontos(){
    } // determina el monto total y el monto cubierto por poliza
    
    public void pasarMedicinaGeneralAMedicinaPropia(){
        //Convierte las medicinas generales de la solicitud en medicinas propias del pedido
    }
    
    public Date getFechayHoraCreacion() {
        return fechayHoraCreacion;
    }

    public void setFechayHoraCreacion(Date fechayHoraCreacion) {
        this.fechayHoraCreacion = fechayHoraCreacion;
    }
    
    public Solicitud getSolicitudAsociada() {
        return solicitudAsociada;
    }

    public void setSolicitudAsociada(Solicitud solicitudAsociada) {
        this.solicitudAsociada = solicitudAsociada;
    }
    
    public Usuario getTecnicoEncargado() {
        return tecnicoEncargado;
    }

    public void setTecnicoEncargado(Usuario tecnicoEncargado) {
        this.tecnicoEncargado = tecnicoEncargado;
    }
}
