package pe.edu.pucp.FarmaSoft.AtencionPedidos.Model;

import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaPropia;

public class DetallePedido {
    private int cantidadPedida;
    private double precioUnitario;
    private MedicinaPropia medicina;
    
    public DetallePedido() {
        
    }

    /**
     * @return the cantidadPedida
     */
    public int getCantidadPedida() {
        return cantidadPedida;
    }

    /**
     * @param cantidadPedida the cantidadPedida to set
     */
    public void setCantidadPedida(int cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }

    /**
     * @return the precioUnitario
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * @return the medicina
     */
    public MedicinaPropia getMedicina() {
        return medicina;
    }

    /**
     * @param medicina the medicina to set
     */
    public void setMedicina(MedicinaPropia medicina) {
        this.medicina = medicina;
    }
}
