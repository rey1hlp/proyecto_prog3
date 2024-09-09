import java.util.ArrayList;

public class FarmaciaPropia extends EmpresaEntrega {
	private ArrayList<Tecnico> tecnicos;
	private ArrayList<PedidoPropio> pedidosEncargados;
	private ArrayList<MedicinaPropia> medicinasPropias;

	public FarmaciaPropia(int ID, String nombre, String direccion, int telefono,
			     Departamento departamento) {
		// ....
	}

	public agregarPedido(Solicitud solicitud) {
		// toma una solicitud y la transforma a un pedido que será procesado
		// por la farmacia y atendido por un técnico de esta
	}
}
