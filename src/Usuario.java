public abstract class Usuario implements IConsultable{
	private int DNI;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private int telefono;
	private EstadoUsuario estado;

	public Usuario(int DNI,String nombre,String apellidoPaterno,String apellidoMaterno,int telefono,EstadoUsuario estado){
		
	}
	
	void consultarDatos();
	void llenarDatosPersonalesUsuario(){
		//Esta función sirve para llenar los datos de un nuevo perfil de usuario y también para modificarlo
	}
	void iniciarSesion(int DNI,String password){   //Un usuario utiliza su DNI y password (creado por el administrador) para iniciar sesión
		
	}
	
}
