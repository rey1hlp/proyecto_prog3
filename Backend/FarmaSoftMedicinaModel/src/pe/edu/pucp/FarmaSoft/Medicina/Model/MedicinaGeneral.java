package pe.edu.pucp.FarmaSoft.Medicina.Model;

//import pe.edu.pucp.FarmaSoft.Util.Model.IConsultable;

public abstract class MedicinaGeneral implements IConsultable {
    private String ID;
    private String nombre;
    private TipoMedicamento tipoMedicamento;
    
    public MedicinaGeneral(){};
    
    public MedicinaGeneral(String ID, String nombre){
            this.ID=ID;
            this.nombre=nombre;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
