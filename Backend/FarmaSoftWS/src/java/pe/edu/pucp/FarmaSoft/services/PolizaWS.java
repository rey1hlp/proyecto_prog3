/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.services;

import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.PolizaDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Poliza;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL.PolizaMySQL;

/**
 *
 * @author User
 */
@WebService(serviceName = "PolizaWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe") 
public class PolizaWS {
    private PolizaDAO daoPoliza; 
    /**
     * This is a sample web service operation
     */
     @WebMethod(operationName = "insertarPoliza") 
    public int insertarPoliza(@WebParam(name = "poliza") Poliza poliza) { 

        int resultado = 0; 
        try{ 
            daoPoliza = new PolizaMySQL();
            resultado = daoPoliza.insertar(poliza); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return resultado; 
    }

    @WebMethod(operationName = "obtenerPolizaPorId") 
    public Poliza obtenerPolizaPorId(@WebParam(name = "idPoliza") int idPoliza) { 
        Poliza poliza = null; 
        try{ 
            daoPoliza = new PolizaMySQL(); 
            poliza = daoPoliza.obtenerPorId(idPoliza); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return poliza; 
    } 
    
    @WebMethod(operationName = "actualizarPoliza") 
    public int actualizarPoliza(@WebParam(name = "poliza") Poliza poliza) { 
        int resultado = 0; 
        try{ 
            daoPoliza = new PolizaMySQL();
            resultado = daoPoliza.actualizar(poliza); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return resultado; 
    }
}
