package pe.edu.pucp.FarmaSoft.AtencionPedidos.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaPropia;

public interface DetallePedidoDAO {
    int insertar(DetallePedidoDAO medicinaPropia);
    ArrayList<MedicinaPropia> listarTodas();
    //ArrayList<MedicinaPropia> listarPorNombre(String nombre);
    //MedicinaPropia obtenerPorId(int idEvento);
}