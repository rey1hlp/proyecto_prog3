package  pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaGeneral;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Usuario;

public class Solicitud {
    private int ID;
    private Date fechayhoraCreacion;
    private EstadoSolicitud estado; 
    private byte recetaMedica[];
    private Cliente cliente;
    private Usuario intermediario;
    private Usuario receptor;
    private ArrayList<DetalleSolicitud> detallesSolicitud;
    private FarmaciaAsociada farmaciaAsociada;
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
    public Usuario getIntermediario() {
        return intermediario;
    }

    /**
     * @param intermediario the intermediario to set
     */
    public void setIntermediario(Usuario intermediario) {
        this.intermediario = intermediario;
    }

    /**
     * @return the receptor
     */
    public Usuario getReceptor() {
        return receptor;
    }

    /**
     * @param receptor the receptor to set
     */
    public void setReceptor(Usuario receptor) {
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
    public FarmaciaAsociada getFarmaciaAsociada() {
        return farmaciaAsociada;
    }

    public void setFarmaciaAsociada(FarmaciaAsociada farmaciaAsociada) {
        this.farmaciaAsociada = farmaciaAsociada;
    }
    public Date getFechayhoraCreacion() {
        return fechayhoraCreacion;
    }

    public void setFechayhoraCreacion(Date fechayhoraCreacion) {
        this.fechayhoraCreacion = fechayhoraCreacion;
    }
}
