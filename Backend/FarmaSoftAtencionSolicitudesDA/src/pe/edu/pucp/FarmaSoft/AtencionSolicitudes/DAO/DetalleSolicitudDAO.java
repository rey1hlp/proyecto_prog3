package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.DetalleSolicitud;

public interface DetalleSolicitudDAO {
    int insertar(DetalleSolicitud detalleSolicitud,int idSolicitud);
    ArrayList<DetalleSolicitud> listarTodas();
    //ArrayList<MedicinaPropia> listarPorNombre(String nombre);
    //MedicinaPropia obtenerPorId(int idEvento);
}