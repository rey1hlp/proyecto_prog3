package pe.edu.pucp.FarmaSoft.services; 
 
import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList; 
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.DetalleSolicitud;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.DetalleSolicitudDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL.DetalleSolicitudMySQL;
 
@WebService(serviceName = "DetalleSolicitudWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe") 
public class DetalleSolicitudWS { 
 
    private DetalleSolicitudDAO daoDetalleSolicitud; 
    
    @WebMethod(operationName = "insertarDetalleSolicitud") 
    public int insertarDetalleSolicitud(DetalleSolicitud detalleSolicitud,int id) { 
        int resultado = 0; 
        try{ 
            daoDetalleSolicitud = new DetalleSolicitudMySQL();
            resultado = daoDetalleSolicitud.insertar(detalleSolicitud,id);  
            //En front end una lista de detalles de solicitud deberían
            //ser insertadas con un id de la solicitud a la que le corresponden
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return resultado; 
    }
    
    @WebMethod(operationName = "listarTodosDetalleSolicitud") 
    public ArrayList<DetalleSolicitud> listarTodosDeatalleSolicitud() { 
        ArrayList<DetalleSolicitud> detalles = null; 
        try{ 
            daoDetalleSolicitud = new DetalleSolicitudMySQL(); 
            detalles = daoDetalleSolicitud.listarTodas();
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return detalles; 
    } 
    
    
    @WebMethod(operationName = "listarDetallesSolicitudPorIDSolicitud") 
    public ArrayList<DetalleSolicitud> listarDetallesSolicitudPorIDSolicitud(@WebParam(name = "idSoli") int idSoli) { 
        ArrayList<DetalleSolicitud> detalles = null; 
        try{ 
            daoDetalleSolicitud = new DetalleSolicitudMySQL(); 
            detalles = daoDetalleSolicitud.listarPorId(idSoli); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return detalles; 
    } 
    
} 
