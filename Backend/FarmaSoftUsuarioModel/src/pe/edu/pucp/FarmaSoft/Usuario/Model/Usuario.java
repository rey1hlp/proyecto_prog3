package  pe.edu.pucp.FarmaSoft.Usuario.Model;

//import  pe.edu.pucp.FarmaSoft.Util.Model.IConsultable;

public class Usuario implements IConsultable {
    private int DNI;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int telefono;
    private boolean estado;
    private String password;

    public Usuario(){}
    
    public Usuario(int DNI,String nombre,String apellidoPaterno,
            String apellidoMaterno,int telefono,boolean estado,
            String password){
        this.DNI=DNI;
        this.nombre=nombre;
        this.apellidoPaterno=apellidoPaterno;
        this.apellidoMaterno=apellidoMaterno;
        this.telefono=telefono;
        this.estado=estado;
        this.password=password;
    }

    public int getDni() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public void consultarDatos(){
            //Implementa método de la interfaz IConsultable
            
    }
    public void llenarDatosPersonalesUsuario(){
            //Esta función sirve para llenar los datos de un nuevo perfil de usuario y también para modificarlo
    }
    public void iniciarSesion(int DNI,String password){   
            //Un usuario utiliza su DNI y password (creado por el administrador) para iniciar sesión
            //La contraseña se obtiene de la base de datos
    }
}
