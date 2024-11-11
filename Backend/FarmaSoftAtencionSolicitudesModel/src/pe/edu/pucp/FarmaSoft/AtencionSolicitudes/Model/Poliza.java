package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model;

//import FarmaSoft.Util.IConsultable;
import java.util.Date;
//import pe.edu.pucp.FarmaSoft.Util.Model.IConsultable;

public class Poliza implements IConsultable {
    private int ID;
    private String tipoSeguro;
    private int codigo;
    private String aseguradora;
    private int DNIAsegurado;
    private String NombreAsegurado;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private double coberturaMaxima;
    private double porcentajeCobertura;
    private boolean esValida;
    private byte imagen[];
    private boolean completado;
 
    
    
    
    
    
    public Poliza() {
        
    }
    @Override
    public void consultarDatos() {
        
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

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

    public double getCoberturaMaxima() {
        return coberturaMaxima;
    }

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

    public boolean isEsValida() {
        return esValida;
    }

    public void setEsValida(boolean esValida) {
        this.esValida = esValida;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getDNIAsegurado() {
        return DNIAsegurado;
    }

    public void setDNIAsegurado(int DNIAsegurado) {
        this.DNIAsegurado = DNIAsegurado;
    }

    public String getNombreAsegurado() {
        return NombreAsegurado;
    }

    public void setNombreAsegurado(String NombreAsegurado) {
        this.NombreAsegurado = NombreAsegurado;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
    
    

    
    
    /**
     * @return the ID
     */
    
}
