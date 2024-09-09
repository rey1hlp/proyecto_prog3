import java.util.Date;
import java.time.LocalTime;
import java.util.ArrayList;

public class Solicitud {
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
	private char estado;
	private boolean generaPedido;
}