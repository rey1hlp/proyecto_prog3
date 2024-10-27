package pe.edu.pucp.FarmaSoft.AtencionPedidos.Model;

import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Direccion;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Empleado;
import java.util.ArrayList;
import java.util.Date;

public class Tecnico extends Empleado {
    private ArrayList<PedidoPropio> pedidosAtendidos;

    public Tecnico(int DNI,String nombre,String apellidoPaterno,
            String apellidoMaterno,int telefono,boolean estado,
            String password,Date fechaIngreso){
        super(DNI,nombre,apellidoPaterno,apellidoMaterno,telefono,
                estado,password,fechaIngreso);
        
    }

    public void atenderPedido(int ID) {
        
    }

    public void descartarPedido(int ID) {
        
    }

    public void llenarMedicinas(int ID) {
        
    }

    public void llenarDatosPoliza(int ID) {
        
    }

    public void consultarDatosPoliza(int ID) {
        
    }

    public void registrarDireccionEnvio(int ID) {
        
    }

    public void subirDocumentoPago(int ID) {
        
    }

    @Override
    public void consultarDatos() {
        //Implementa método de la interfaz IConsultable
    }

    public boolean validarPago(int ID) {
        //Valida el pago de un pedido con los documentos proporcionados
        return true;
    }

    public void modificarDireccion(int ID, Direccion direccion) {
        //EL técnico puede modificar la dirección de envío de un pedido -> ID
    }
}
