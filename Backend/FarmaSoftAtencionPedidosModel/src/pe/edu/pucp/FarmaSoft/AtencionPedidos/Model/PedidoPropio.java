package pe.edu.pucp.FarmaSoft.AtencionPedidos.Model;

import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Solicitud;
import java.util.Date;
import java.time.LocalTime;
import java.util.ArrayList;

public class PedidoPropio {
    private int ID;
    private Solicitud solicitudAsociada;
    private Date fechaCreacion;
    private LocalTime horaCreacion;
    private EstadoPedido estadoPedido;
    private Tecnico tecnicoEncargado;
    private ArrayList<DetallePedido> detallesPedido;
    private double montoTotal;
    private double montoCubierto;
    private Pago pago;
    private boolean completado;

    public PedidoPropio() {
        
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
    public Solicitud getSolicitudAsociada() {
        return solicitudAsociada;
    }

    /**
     * @param solicitudAsociada the solicitudAsociada to set
     */
    public void setSolicitudAsociada(Solicitud solicitudAsociada) {
        this.solicitudAsociada = solicitudAsociada;
    }
    
    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the horaCreacion
     */
    public LocalTime getHoraCreacion() {
        return horaCreacion;
    }

    /**
     * @param horaCreacion the horaCreacion to set
     */
    public void setHoraCreacion(LocalTime horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    /**
     * @return the tecnicoEncargado
     */
    public Tecnico getTecnicoEncargado() {
        return tecnicoEncargado;
    }

    /**
     * @param tecnicoEncargado the tecnicoEncargado to set
     */
    public void setTecnicoEncargado(Tecnico tecnicoEncargado) {
        this.tecnicoEncargado = tecnicoEncargado;
    }

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
}
