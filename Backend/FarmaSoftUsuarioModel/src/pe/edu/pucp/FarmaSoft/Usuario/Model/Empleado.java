package  pe.edu.pucp.FarmaSoft.Usuario.Model;

import java.util.Date;

public class Empleado extends Usuario{
    private Date fechaIngreso;
    private Administrador jefe;
    
    public Empleado(){
        super();
    }
    
    public Empleado(int DNI,String nombre,String apellidoPaterno,
            String apellidoMaterno,int telefono,boolean estado,
            String password,Date fechaIngreso){
        super(DNI,nombre,apellidoPaterno,apellidoMaterno,telefono,estado,password);
        this.fechaIngreso=fechaIngreso;
    }
    
    public int getDNI(){
        return super.getDni();
    }
    
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setfechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public int getDNIJefe() {
        return jefe.getDNI();
    }
    
    public void setDNIJefe(int DNI) {
        jefe.setDNI(DNI);
    }
    
    public Administrador getJefe() {
        return jefe;
    }

    public void setJefe(Administrador jefe) {
        this.jefe = jefe;
    }
    
    @Override
    public void consultarDatos(){
            //Implementa método de la interfaz IConsultable
    }
    
    
}
