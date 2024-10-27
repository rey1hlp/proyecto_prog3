package pe.edu.pucp.FarmaSoft.dao;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.DetalleSolicitud;

public interface DetalleSolicitudDAO {
    int insertar(DetalleSolicitud detalleSolicitud,int idSolicitud);
    ArrayList<DetalleSolicitud> listarTodas(int idSolicitud);
    //ArrayList<MedicinaPropia> listarPorNombre(String nombre);
    //MedicinaPropia obtenerPorId(int idEvento);
}