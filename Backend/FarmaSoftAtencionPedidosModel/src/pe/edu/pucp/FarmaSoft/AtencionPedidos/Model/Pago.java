
package pe.edu.pucp.FarmaSoft.AtencionPedidos.Model;

public class Pago {
    private int ID;
    private String metodoPago;
    private int numOperaciones;
    private double montoPagado;
    private byte comprobante[];
    private boolean completado;
    
    //archivo comprobante de pago
    public Pago(){
        
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
     * @return the metodoPago
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /**
     * @param metodoPago the metodoPago to set
     */
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * @return the numOperaciones
     */
    public int getNumOperaciones() {
        return numOperaciones;
    }

    /**
     * @param numOperaciones the numOperaciones to set
     */
    public void setNumOperaciones(int numOperaciones) {
        this.numOperaciones = numOperaciones;
    }

    /**
     * @return the montoPagado
     */
    public double getMontoPagado() {
        return montoPagado;
    }

    /**
     * @param montoPagado the montoPagado to set
     */
    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }

    /**
     * @return the comprobante
     */
    public byte[] getComprobante() {
        return comprobante;
    }

    /**
     * @param comprobante the comprobante to set
     */
    public void setComprobante(byte[] comprobante) {
        this.comprobante = comprobante;
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
