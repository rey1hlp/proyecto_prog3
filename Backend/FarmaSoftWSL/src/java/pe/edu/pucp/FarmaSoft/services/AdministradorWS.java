package pe.edu.pucp.FarmaSoft.services; 
 
import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList; 
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.DetalleSolicitud;
import pe.edu.pucp.FarmaSoft.Usuario.DAO.AdministradorDAO;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Administrador;
import pe.edu.pucp.FarmaSoft.Usuario.MySQL.AdministradorMySQL;
import pe.edu.pucp.FarmaSoft.dao.DetalleSolicitudDAO;
import pe.edu.pucp.FarmaSoft.mysql.DetalleSolicitudMySQL;
 
@WebService(serviceName = "AdministradorWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe") 
public class AdministradorWS { 
 
    private AdministradorDAO daoAdministrador; 
    
    @WebMethod(operationName = "insertarAdministrador") 
    public int insertarAdministrador() { 
        Administrador admin;
        int resultado = 0; 
        try{ 
            daoAdministrador = new AdministradorMySQL();
            admin=new Administrador();
            admin.setDNI(76591764);
            admin.setApellidoPaterno("Condorhuaman");
            admin.setApellidoMaterno("Gastanaga");
            admin.setNombre("Carlos");
            admin.setPassword("Password");
            admin.setTelefono(902744125);
            resultado = daoAdministrador.insertar(admin);
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        } 
        return resultado; 
    }
    
//    @WebMethod(operationName = "listarTodosDeatalleSolicitud") 
//    public ArrayList<DetalleSolicitud> listarTodosDeatalleSolicitud(@WebParam(name = "idSolicitud") int idSolicitud) { 
//        ArrayList<DetalleSolicitud> detalles = null; 
//        try{ 
//            daoDetalleSolicitud = new DetalleSolicitudMySQL(); 
//            detalles = daoDetalleSolicitud.listarTodas(idSolicitud); 
//        }catch(Exception ex){ 
//            System.out.println(ex.getMessage()); 
//        } 
//        return detalles; 
//    } 
    
    
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
