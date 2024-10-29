/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.services;


import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.DAO.PedidoPropioDAO;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.PedidoPropio;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.MySQL.PedidoPropioMySQL;
/**
 *
 * @author User
 */
@WebService(serviceName = "PedidoPropioWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe") 
public class PedidoPropioWS {
    private PedidoPropioDAO daoPedidoPropio; 
    /**
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "listarTodosPedidosPropios") 
    public ArrayList<PedidoPropio> listarTodosPedidosPropios() { 
        ArrayList<PedidoPropio> pedidosPropios = null; 
        try{ 
            daoPedidoPropio = new PedidoPropioMySQL(); 
            pedidosPropios = daoPedidoPropio.listarTodas(); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return pedidosPropios; 
    } 
    
    @WebMethod(operationName = "insertarPedidoPropio") 
    public int insertarPedidoPropio(@WebParam(name = "pedidoPropio") PedidoPropio pedidoPropio) { 
        int resultado = 0; 
        try{ 
            daoPedidoPropio = new PedidoPropioMySQL();
            resultado = daoPedidoPropio.insertar(pedidoPropio); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return resultado; 
    }
    
    @WebMethod(operationName = "obtenerPedidoPropioPorId") 
    public PedidoPropio obtenerPedidoPropioPorId(@WebParam(name = "idPedidoPropio") int idPedidoPropio) { 
        PedidoPropio pedidoPropio = null; 
        try{ 
            daoPedidoPropio = new PedidoPropioMySQL(); 
            pedidoPropio = daoPedidoPropio.obtenerPorId(idPedidoPropio); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return pedidoPropio; 
    } 
}
