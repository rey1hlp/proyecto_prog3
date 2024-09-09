import java.util.Date;
public class Poliza implements IConsultable {
	private int codigo;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private double limiteCobertura;
	private double porcentajeCobertura;
	private String aseguradora;
	private boolean estaVigente;

	public Poliza(int codigo, Date fechaEmision, Date fechaVencimiento,
		     double limiteCobertura, double porcentajeCobertura, String aseguradora) {
		this.codigo = codigo;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.limiteCobertura = limiteCobertura;
		this.porcentajeCobertura = porcentajeCobertura;
		this.aseguradora = aseguradora;

		// el atributo estaVigente se determinaría con la comparacion de fecha
		// actual con la de vencimiento
	}

	public double calcularCobertura(double monto);

	public void consultarDatos();
}
