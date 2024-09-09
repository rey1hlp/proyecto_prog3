public class Administrador extends Usuario{

	private ArrayList<Empleado> empleados;      //Estos son todos los empleados de la empresa
	
	public Administrador(int DNI,String nombre,String apellidoPaterno,String apellidoMaterno,int telefono,EstadoUsuario estado){
		//super(DNI,nombre,apellidoPaterno,apellidoMaterno,telefono,estado);
	}
	@Override
	void consultarDatos(){
		//Sería bueno que el administrador tuviera atributos propios
	}
	void registrarEmpleado(Empleado empleado){
		//Registra empleado en la base de datos
	}
	void modificarEstadoEmpleado(int idUsuario,EstadoUsuario estadoUsuario){
		//Cambia el estado del empleado como activo o inactivo
	}
	void editarPerfilPropio(Administrador administrador){
		//El objeto administrador encapsula los datos a modificar del admin
		//Aquí se hace los setter o un 
	}         
	void editarPerfilEmpleado(int idUsuario,Empleado empleado){
		//Buscara en el array de empleados y editará la info de un empleado
		//El objeto empleado enviado lleva los datos a editra del iésimo empleado
	}
	void consultarRendimientoEmpleados();
}
