package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model;

//import  pe.edu.pucp.FarmaSoft.Util.Model.IConsultable;
import java.util.Date;

public class Cliente implements IConsultable {
    private int ID;
    private TipoDocumento tipoDocumento;
    private int numDocumento;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private int telefonoContacto;
    private String correoContacto;
    private boolean tienePoliza;
    private Poliza poliza;
    private boolean completado;

    public Cliente() {
        
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
     * @return the tipoDocumento
     */
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the numDocumento
     */
    public int getNumDocumento() {
        return numDocumento;
    }

    /**
     * @param numDocumento the numDocumento to set
     */
    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    /**
     * @return the telefonoContacto
     */
    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    /**
     * @param telefonoContacto the telefonoContacto to set
     */
    public void setTelefonoContacto(int telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    /**
     * @return the correoContacto
     */
    public String getCorreoContacto() {
        return correoContacto;
    }

    /**
     * @param correoContacto the correoContacto to set
     */
    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }
    
    /**
     * @return the tienePoliza
     */
    public boolean isTienePoliza() {
        return tienePoliza;
    }

    /**
     * @param tienePoliza the tienePoliza to set
     */
    public void setTienePoliza(boolean tienePoliza) {
        this.tienePoliza = tienePoliza;
    }

    /**
     * @return the poliza
     */
    public Poliza getPoliza() {
        return poliza;
    }

    /**
     * @param poliza the poliza to set
     */
    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
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
        
    @Override
    public void consultarDatos(){
        //Consulta datos de un cliente
    }
    
    public void consultarPoliza(){    //AAA
        //Devuelve los datos de la póliza del paciente
    }
    
    public boolean subirArchivos(){   //AAAA
        //Sube los archivos de receta médica y póliza asignados a un cliente y se devuelve un boolean: válidos o inválidos
        return true;
    }
}
