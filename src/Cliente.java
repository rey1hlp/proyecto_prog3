import java.util.Date;
import java.util.ArrayList;
public class Cliente implements IConsultable {
	private int DNI;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private int telefono;
	private String correo;
	private Date fechaNacimiento;
	private boolean tienePoliza;
	private Poliza poliza;

	public Cliente(int DNI, String nombre, String apellidoPaterno, String apellidoMaterno) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
	}

	public void consultarDatos(){
		//Consulta datos de un cliente
	}
	public Poliza consultarPoliza(){
		//Devuelve la poliza del paciente o un objeto vacio en caso de no contar con poliza
	}
	public boolean subirArchivos(){
		//Sube los archivos de receta médica y póliza asignados a un cliente y se devuelve un boolean: válidos o inválidos
	}
}
