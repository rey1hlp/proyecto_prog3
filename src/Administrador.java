public class Administrador extends Usuario{

	private ArrayList<Empleado> empleados;      //Estos son todos los empleados de la empresa
	
	public Administrador(int DNI,String nombre,String apellidoPaterno,String apellidoMaterno,int telefono,EstadoUsuario estado){
		//super(DNI,nombre,apellidoPaterno,apellidoMaterno,telefono,estado);
	}

	void registrarEmpleado();         //Registra empleado en la base de datos
	void modificarEstadoEmpleado(int idUsuario,EstadoUsuario estadoUsuario);      //Modifica datos del empleado en la base de datos
	void editarPerfilPropio();         
	void editarPerfilEmpleado();
	void consultarRendimientoEmpleados();
	
}
