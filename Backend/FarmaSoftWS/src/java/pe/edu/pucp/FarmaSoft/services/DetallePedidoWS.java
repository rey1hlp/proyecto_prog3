package pe.edu.pucp.FarmaSoft.services; 
 
import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList; 
import pe.edu.pucp.FarmaSoft.AtencionPedidos.DAO.DetallePedidoDAO;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.DetallePedido;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.MySQL.DetallePedidoMySQL;
 
@WebService(serviceName = "DetallePedidoWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe") 
public class DetallePedidoWS { 
 
    private DetallePedidoDAO daoDetallePedido; 
    
    @WebMethod(operationName = "insertarDetallePedido") 
    public int insertarDetallePedido(DetallePedido detallePedido,int id) {
        int resultado = 0; 
        try{ 
            daoDetallePedido = new DetallePedidoMySQL();
            resultado = daoDetallePedido.insertar(detallePedido,id);   //El 1 es el id del pedido
            //En front end una lista de detalles de solicitud deberían
            //ser insertadas con un id de la solicitud a la que le corresponden
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return resultado; 
    }
    
    
    
//    @WebMethod(operationName = "listarDetallesSolicitudPorIDSolicitud") 
//    public ArrayList<DetalleSolicitud> listarDetallesSolicitudPorIDSolicitud(@WebParam(name = "idSoli") int idSoli) { 
//        ArrayList<DetalleSolicitud> detalles = null; 
//        try{ 
//            daoDetalleSolicitud = new DetalleSolicitudMySQL(); 
//            detalles = daoDetalleSolicitud.listarPorId(idSoli); 
//        }catch(Exception ex){ 
//            System.out.println(ex.getMessage()); 
//        } 
//        return detalles; 
//    } 
    
} 
