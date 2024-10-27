package pe.edu.pucp.FarmaSoft.services; 
 
import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList; 
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.DetalleSolicitud;
import pe.edu.pucp.FarmaSoft.dao.DetalleSolicitudDAO;
import pe.edu.pucp.FarmaSoft.mysql.DetalleSolicitudMySQL;
 
@WebService(serviceName = "DetalleSolicitudWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe") 
public class DetalleSolicitudWS { 
 
    private DetalleSolicitudDAO daoDetalleSolicitud; 
    
    @WebMethod(operationName = "insertarDetalleSolicitud") 
    public int insertarDetalleSolicitud() { 
        DetalleSolicitud detalleSolicitud;
        int resultado = 0; 
        try{ 
            daoDetalleSolicitud = new DetalleSolicitudMySQL();
            detalleSolicitud=new DetalleSolicitud();
            detalleSolicitud.setCantidadPedida(10);
            detalleSolicitud.getMedicina().setID("X86");
            resultado = daoDetalleSolicitud.insertar(detalleSolicitud,1);   //El 1 es el id del pedido
            //En front end una lista de detalles de solicitud deberían
            //ser insertadas con un id de la solicitud a la que le corresponden
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return resultado; 
    }
    
    @WebMethod(operationName = "listarTodosDeatalleSolicitud") 
    public ArrayList<DetalleSolicitud> listarTodosDeatalleSolicitud(@WebParam(name = "idSolicitud") int idSolicitud) { 
        ArrayList<DetalleSolicitud> detalles = null; 
        try{ 
            daoDetalleSolicitud = new DetalleSolicitudMySQL(); 
            detalles = daoDetalleSolicitud.listarTodas(idSolicitud); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return detalles; 
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
