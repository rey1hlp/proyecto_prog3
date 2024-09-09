public abstract class Usuario{
	private int DNI;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private int telefono;
	private EstadoUsuario estado;

	void llenarDatosPersonalesUsuario();
	void mostrarDatosPersonalesUsuario();
	void iniciarSesion();

	public Usuario(int DNI,String nombre,String apellidoPaterno,String apellidoMaterno,int telefono){
		
	}
	
}
