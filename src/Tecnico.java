import java.util.ArrayList;
public class Tecnico extends Empleado{
	private FarmaciaPropia farmacia;
	private ArrayList<PedidoPropio> pedidosGenerados;

	public Tecnico() {
		super();
	}

	public void atenderPedido(int ID);
	public void descartarPedido(int ID);
	public void llenarMedicinas();
	public void llenarDatosPoliza();
	public void consultarDatosPoliza();
	public void registrarDireccionEnvio();
	public void subirDocumentoPago();
}
