package pe.edu.pucp.FarmaSoft.Medicina.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaGeneral;

public interface MedicinaGeneralDAO {
    int insertar(MedicinaGeneral medicinaGeneral);
    ArrayList<MedicinaGeneral> listarTodas();
    //ArrayList<MedicinaPropia> listarPorNombre(String nombre);
    //MedicinaPropia obtenerPorId(int idMedicina);
}