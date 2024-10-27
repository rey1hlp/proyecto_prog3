package  pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model;

import java.util.Date;
import java.time.LocalTime;
import java.util.ArrayList;

import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaGeneral;

public class Solicitud {
    private int ID;
    private Date fechaCreacion;
    private LocalTime horaCreacion;
    private EstadoSolicitud estado; 
    private byte recetaMedica[];
    private Cliente cliente;
    private Intermediario intermediario;
    private Receptor receptor;
    private ArrayList<DetalleSolicitud> detallesSolicitud;
    private boolean generaPedido;
    private boolean completado;

    public Solicitud(){
        
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
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    /**
    
    /**
     * @return the estado
     */
    public EstadoSolicitud getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    /**
     * @return the generaPedido
     */
    public boolean isGeneraPedido() {
        return generaPedido;
    }

    /**
     * @param generaPedido the generaPedido to set
     */
    public void setGeneraPedido(boolean generaPedido) {
        this.generaPedido = generaPedido;
    }
    
    public void agregarMedicina(MedicinaGeneral medicina){
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
     * @return the recetaMedica
     */
    public byte[] getRecetaMedica() {
        return recetaMedica;
    }

    /**
     * @param recetaMedica the recetaMedica to set
     */
    public void setRecetaMedica(byte[] recetaMedica) {
        this.recetaMedica = recetaMedica;
    }

    /**
     * @return the intermediario
     */
    public Intermediario getIntermediario() {
        return intermediario;
    }

    /**
     * @param intermediario the intermediario to set
     */
    public void setIntermediario(Intermediario intermediario) {
        this.intermediario = intermediario;
    }

    /**
     * @return the receptor
     */
    public Receptor getReceptor() {
        return receptor;
    }

    /**
     * @param receptor the receptor to set
     */
    public void setReceptor(Receptor receptor) {
        this.receptor = receptor;
    }

    /**
     * @return the detallesSolicitud
     */
    public ArrayList<DetalleSolicitud> getDetallesSolicitud() {
        return detallesSolicitud;
    }

    /**
     * @param detallesSolicitud the detallesSolicitud to set
     */
    public void setDetallesSolicitud(ArrayList<DetalleSolicitud> detallesSolicitud) {
        this.detallesSolicitud = detallesSolicitud;
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
    
}
