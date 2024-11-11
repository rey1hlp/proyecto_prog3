package pe.edu.pucp.FarmaSoft.Medicina.Model;

//import pe.edu.pucp.FarmaSoft.Util.Model.IConsultable;

public class MedicinaGeneral implements IConsultable {
    private String IDP;
    private String nombre;
    private TipoMedicamento tipoMedicamento;
    
    public MedicinaGeneral(){};
    
    public MedicinaGeneral(String ID, String nombre){
            this.IDP=ID;
            this.nombre=nombre;
    }
    
    public String getIDP() {
        return IDP;
    }

    public void setIDP(String ID) {
        this.IDP = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoMedicamento getTipoMedicamento() {
        return tipoMedicamento;
    }

    public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }
    
    @Override
    public void consultarDatos(){
        
    }
    
}
