import java.util.Date;
public class Poliza implements IConsultable {
	private int codigo;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private double limiteCobertura;
	private double porcentajeCobertura;
	private String aseguradora;
	private char estado;

	public double calcularCobertura(double monto);
	
}
