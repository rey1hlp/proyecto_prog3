package pe.edu.pucp.FarmaSoft.services; 
 
import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList; 
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.FarmaciaAsociadaDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.FarmaciaAsociada;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL.FarmaciaAsociadaMySQL;
 
@WebService(serviceName = "FarmaciaAsociadaWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe") 
public class FarmaciaAsociadaWS { 
 
    private FarmaciaAsociadaDAO daoFarmaciaAsociada; 
    
    @WebMethod(operationName = "listarTodasFarmaciasAsociadas") 
    public ArrayList<FarmaciaAsociada> listarTodasFarmaciasAsociadas() { 
        ArrayList<FarmaciaAsociada> farmacias = null; 
        try{ 
            daoFarmaciaAsociada = new FarmaciaAsociadaMySQL(); 
            farmacias = daoFarmaciaAsociada.listarTodas(); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return farmacias; 
    } 
    
//    @WebMethod(operationName = "obtenerEventoPorId") 
//    public Evento obtenerEventoPorId(@WebParam(name = "idEvento") int idEvento) { 
//        Evento evento = null; 
//        try{ 
//            daoEvento = new EventoMySQL(); 
//            evento = daoEvento.obtenerPorId(idEvento); 
//        }catch(Exception ex){ 
//            System.out.println(ex.getMessage()); 
//        } 
//        return evento; 
//    } 
    
} 
