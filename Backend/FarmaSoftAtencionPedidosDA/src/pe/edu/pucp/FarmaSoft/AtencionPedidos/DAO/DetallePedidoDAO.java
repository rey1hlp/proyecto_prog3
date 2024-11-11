package pe.edu.pucp.FarmaSoft.AtencionPedidos.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.DetallePedido;
import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaPropia;

public interface DetallePedidoDAO {
    int insertar(DetallePedido detallePedido,int idPedido);
    //ArrayList<DetallePedido> listarTodas();
    //ArrayList<MedicinaPropia> listarPorNombre(String nombre);
    //MedicinaPropia obtenerPorId(int idEvento);
}