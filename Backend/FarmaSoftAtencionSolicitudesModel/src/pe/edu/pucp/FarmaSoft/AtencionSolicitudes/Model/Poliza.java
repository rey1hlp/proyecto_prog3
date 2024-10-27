package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model;

//import FarmaSoft.Util.IConsultable;
import java.util.Date;
//import pe.edu.pucp.FarmaSoft.Util.Model.IConsultable;

public class Poliza implements IConsultable {
    private int ID;
    private String tipoSeguro;
    private int codigo;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private double coberturaMaxima;
    private double porcentajeCobertura;
    private String aseguradora;
    private boolean esValida;
    private byte imagen[];

    public Poliza() {
        
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
     * @return the tipoSeguro
     */
    public String getTipoSeguro() {
        return tipoSeguro;
    }

    /**
     * @param tipoSeguro the tipoSeguro to set
     */
    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    /**
     * @return the coberturaMaxima
     */
    public double getCoberturaMaxima() {
        return coberturaMaxima;
    }

    /**
     * @param coberturaMaxima the coberturaMaxima to set
     */
    public void setCoberturaMaxima(double coberturaMaxima) {
        this.coberturaMaxima = coberturaMaxima;
    }

    public double getPorcentajeCobertura() {
        return porcentajeCobertura;
    }

    public void setPorcentajeCobertura(double porcentajeCobertura) {
        this.porcentajeCobertura = porcentajeCobertura;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    /**
     * @return the esValida
     */
    public boolean isEsValida() {
        return esValida;
    }

    /**
     * @param esValida the esValida to set
     */
    public void setEsValida(boolean esValida) {
        this.esValida = esValida;
    }

    /**
     * @return the imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    @Override
    public void consultarDatos(){

    }
    
    public double calcularCobertura(double monto){
        return 0;
    }
}
