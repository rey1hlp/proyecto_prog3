import java.util.ArrayList;

public class FarmaciaPropia extends EmpresaEntrega {
	private ArrayList<Tecnico> tecnicos;
	private ArrayList<PedidoPropio> pedidosEncargados;
	private ArrayList<MedicinaPropia> medicinasPropias;

	public FarmaciaPropia(int ID, String nombre, String direccion, int telefono,
			     Departamento departamento) {
		// ....
	}

	public void agregarPedido(Solicitud solicitud) {
		// toma una solicitud y la transforma a un pedido que será procesado
		// por la farmacia y atendido por un técnico de esta
	}
	public void procesarPedido(int ID){    //AAAA
		//El técnico llama a la función de procesar el pedido cuando se ha confirmado el pago
	}
	public void descontarStock(PedidoPropio pedidoPropio){    //AAAA
		//Se descuenta el stock de las medicinas asociadas al pedido
	}
}
