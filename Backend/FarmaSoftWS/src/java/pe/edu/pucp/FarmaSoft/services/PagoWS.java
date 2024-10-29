
package pe.edu.pucp.FarmaSoft.services;

import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.DAO.PagoDAO;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.Pago;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.MySQL.PagoMySQL;

/**
 *
 * @author User
 */
@WebService(serviceName = "PagoWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe") 
public class PagoWS{

    /**
     * This is a sample web service operation
     */
    private PagoDAO daoPago; 
    /**
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "listarTodosPagos") 
    public ArrayList<Pago> listarTodosPagos() { 
        ArrayList<Pago> pagos = null; 
        try{ 
            daoPago = new PagoMySQL(); 
            pagos = daoPago.listarTodas(); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return pagos; 
    } 
    
    @WebMethod(operationName = "insertarPago") 
    public int insertarPago(@WebParam(name = "pago") Pago pago) { 
        int resultado = 0; 
        try{ 
            daoPago = new PagoMySQL();
            resultado = daoPago.insertar(pago); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return resultado; 
    }
    
    @WebMethod(operationName = "obtenerPagoPorId") 
    public Pago obtenerPagoPorId(@WebParam(name = "idPago") int idPago) { 
        Pago pago = null; 
        try{ 
            daoPago = new PagoMySQL(); 
            pago = daoPago.obtenerPorId(idPago); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return pago; 
    } 
}
