public abstract class EmpresaEntrega implements IConsultable {
	private int ID;
	private String nombre;
	private Departamento departamento;
	private String direccion;
	private int telefono;

	public EmpresaEntrega(int ID, String nombre, Departamento departamento,
			     String direccion, int telefono) {
		// ...
	}
}
