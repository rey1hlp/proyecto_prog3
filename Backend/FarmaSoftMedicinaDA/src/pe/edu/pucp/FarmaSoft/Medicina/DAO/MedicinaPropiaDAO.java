package pe.edu.pucp.FarmaSoft.Medicina.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaPropia;

public interface MedicinaPropiaDAO {
    int insertar(MedicinaPropia medicinaPropia);
    ArrayList<MedicinaPropia> listarTodas();
    //ArrayList<MedicinaPropia> listarPorNombre(String nombre);
    //MedicinaPropia obtenerPorId(int idEvento);
}