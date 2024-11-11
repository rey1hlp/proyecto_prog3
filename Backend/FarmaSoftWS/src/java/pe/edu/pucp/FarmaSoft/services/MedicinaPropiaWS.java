package pe.edu.pucp.FarmaSoft.services; 
 
import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList; 
import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaPropia; 
import pe.edu.pucp.FarmaSoft.Medicina.Model.TipoMedicamento;
import pe.edu.pucp.FarmaSoft.Medicina.DAO.MedicinaPropiaDAO;
import pe.edu.pucp.FarmaSoft.Medicina.MySQL.MedicinaPropiaMySQL;
 
@WebService(serviceName = "MedicinaPropiaWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe") 
public class MedicinaPropiaWS { 
 
    private MedicinaPropiaDAO daoMedicinaPropia; 
     
//    @WebMethod(operationName = "listarEventosPorNombre") 
//    public ArrayList<MedicinaPropia> listarEventosPorNombre(@WebParam(name = "nombre") String nombre) { 
//        ArrayList<Evento> eventos = null; 
//        try{ 
//            daoEvento = new EventoMySQL(); 
//            eventos = daoEvento.listarPorNombre(nombre); 
//        }catch(Exception ex){ 
//            System.out.println(ex.getMessage()); 
//        } 
//        return eventos; 
//    } 
    
    @WebMethod(operationName = "insertarMedicinaPropia") 
    public int insertarMedicinaPropia(MedicinaPropia medicinaPropia) { 
        int resultado = 0; 
        try{ 
            daoMedicinaPropia = new MedicinaPropiaMySQL();
//            medicinaPropia=new MedicinaPropia();
//            medicinaPropia.setId(1);
//            medicinaPropia.setIDP("X86");
//            medicinaPropia.setNombre("PARACETAMOL");
//            medicinaPropia.setPrecio(12.99);
//            medicinaPropia.setStock(20);
//            medicinaPropia.setTipoMedicamento(TipoMedicamento.ANTIBIOTICO);
            resultado = daoMedicinaPropia.insertar(medicinaPropia); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return resultado; 
    }
    
    @WebMethod(operationName = "listarTodasMedicinasPropias") 
    public ArrayList<MedicinaPropia> listarTodasMedicinasPropias() { 
        ArrayList<MedicinaPropia> medicinas = null; 
        try{ 
            daoMedicinaPropia = new MedicinaPropiaMySQL(); 
            medicinas = daoMedicinaPropia.listarTodas(); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return medicinas; 
    } 
    
    @WebMethod(operationName = "obtenerPorId") 
    public MedicinaPropia obtenerMedicinaPorId(@WebParam(name = "idMedicina") String idMedicina) { 
        MedicinaPropia medicina = null; 
        try{ 
            daoMedicinaPropia = new MedicinaPropiaMySQL(); 
            medicina = daoMedicinaPropia.obtenerPorId(idMedicina); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return medicina; 
    } 
    
} 
