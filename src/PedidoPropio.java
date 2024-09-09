import java.util.Date;
import java.time.LocalTime;
import java.util.ArrayList;
public class PedidoPropio {
	private Solicitud solicitudAsociada;
	private int ID;
	private FarmaciaPropia farmaciaEncargada;
	private Tecnico tecnicoEncargado;
	private ArrayList<MedicinaPropia> medicinasPedidas;
	private Date fechaPropuestaEnvio;
	private LocalTime horarioEnvio;
	private double montoTotal;
	private double montoCubierto;
	private DocumentoPago pago;

	public PedidoPropio(Solicitud solicitudAsociada, int ID, FarmaciaPropia farmaciaEncargada,
			   Tecnico tecnicoEncargado, ArrayList<MedicinaPropia> medicinasPedidas,
			   Date fechaPropuestaEnvio, LocalTime horarioEnvio, double montoTotal,
			   double montoCubierto, DocumentoPago pago) {
		//...
	}
	
	public void determinarMontos();
	public double getMontoTotal();
	public double getMontoCubierto();
}
