import java.util.ArrayList;
public class Tecnico extends Empleado{
	private FarmaciaPropia farmacia;
	private ArrayList<PedidoPropio> pedidosGenerados;

	public Tecnico(int DNI, String nombre, String apellidoPaterno, String apellidoMaterno,
		      int telefono, EstadoUsuario estado) {
		super(DNI,nombre,apellidoPaterno,apellidoMaterno,telefono,estado);
	}

	public void atenderPedido(int ID);
	public void descartarPedido(int ID);
	public void llenarMedicinas();
	public void llenarDatosPoliza();
	public void consultarDatosPoliza();
	public void registrarDireccionEnvio();
	public void subirDocumentoPago();

	@Override
	public void consultarDatos(){
		//Implementa método de la interfaz IConsultable
	}
	public boolean validarPago(int ID){
		//Valida el pago de un pedido con los documentos proporcionados
	}
	public void modificarDetalleEnvio(int ID, DetalleEnvio detalleEnvio){   //AAA
		//EL técnico puede modificar el detalle de envío de un pedido -> ID
	}
	public void modificarDireccion(int ID, Direccion direccion){             //AAA
		//EL técnico puede modificar la dirección de envío de un pedido -> ID
	}
}
