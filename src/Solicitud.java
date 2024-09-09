import java.util.Date;
import java.time.LocalTime;
import java.util.ArrayList;

public class Solicitud {
	private static int correlativo=1; 
	private int ID;
	private Date fechaSolicitud;
	private Cliente cliente;
	private LocalTime horaSolicitud;
	private int telefonoUtilizado;
	private Departamento departamento;
	private Receptor receptorEncargado;
	private ArrayList<RecetaMedica> recetasAsociadas;
	private ArrayList<MedicinaAsociada> medicinasSolicitadas;
	private EmpresaEntrega empresaEntrega;
	private EstadoSolicitud estado; 
	private boolean generaPedido;

	public Solicitud(Date fechaSolicitud,Cliente cliente,LocalTime horaSolicitud,int telefonoUtilizado,Departamento departamento,Receptor receptorEncargado,
			EmpresaEntrega empresaEntrega,EstadoSolicitud estado,boolean generaPedido){
	
	}
}
