package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model;

import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaGeneral;

public class DetalleSolicitud {
    private int cantidadPedida;
    private MedicinaGeneral medicina;
    
    public DetalleSolicitud(){
        
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
     * @return the medicina
     */
    public MedicinaGeneral getMedicina() {
        return medicina;
    }

    /**
     * @param medicina the medicina to set
     */
    public void setMedicina(MedicinaGeneral medicina) {
        this.medicina = medicina;
    }
    
}
