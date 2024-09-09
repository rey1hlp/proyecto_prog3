public class Administrador extends Usuario{

	public Administrador(int DNI,String nombre,String apellidoPaterno,String apellidoMaterno,int telefono,EstadoUsuario estado){
		//super(DNI,nombre,apellidoPaterno,apellidoMaterno,telefono,estado);
	}

	void registrarEmpleado();         //Registra empleado en la base de datos
	void modificarEstadoEmpleado();      //Modifica datos del empleado en la base de datos
	void editarPerfilPropio();         
	void editarPerfilEmpleado();
	void consultarRendimientoEmpleados();
	
}
