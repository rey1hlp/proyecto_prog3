public class Direccion {
	private String departamento;
	private String provincia;
	private String distrito;
	private String calle;
	private String referencia;
	private String codigoPostal;

	public Direccion(String departamento, String provincia, String distrito, String calle,
			String referencia, String codigoPostal) {
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
		this.calle = calle;
		this.referencia = referencia;
		this.codigoPostal = codigoPostal;
	}
	public void modificarDireccion(Direccion direccion){
		//Asigna una nueva dirección con los datos que envie el C3
	}
}
