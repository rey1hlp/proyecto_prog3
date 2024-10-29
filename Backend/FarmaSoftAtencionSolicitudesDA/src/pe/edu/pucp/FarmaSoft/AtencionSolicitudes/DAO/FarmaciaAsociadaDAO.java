package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.FarmaciaAsociada;

public interface FarmaciaAsociadaDAO {
    ArrayList<FarmaciaAsociada> listarTodas();
    //ArrayList<MedicinaPropia> listarPorNombre(String nombre);
    //MedicinaPropia obtenerPorId(int idEvento);
}