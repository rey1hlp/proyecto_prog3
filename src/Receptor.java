import java.util.ArrayList;
public class Receptor extends Empleado{
	private ArrayList<Solicitud> solicitudesRecibidas;

	public Receptor(int DNI,String nombre,String apellidoPaterno,String apellidoMaterno,int telefono,EstadoUsuario estado){
		
	}

	public void generaSolicitud(Solicitud solicitud); 
	public void atenderSolicitud(int ID);
	public void eliminarSolicitud(int ID);
	public void llenarDatosPaciente();
	public void cargarDocumentos();
	public void asignarFarmacia();          //Lima o provincia
	public void generarPedido(); 		//

}
