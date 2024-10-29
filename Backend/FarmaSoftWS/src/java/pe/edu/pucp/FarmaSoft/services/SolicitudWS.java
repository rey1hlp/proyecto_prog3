/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.services;

import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.SolicitudDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Solicitud;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL.SolicitudMySQL;
/**
 *
 * @author User
 */
@WebService(serviceName = "SolicitudWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe") 
public class SolicitudWS {
    private SolicitudDAO daoSolicitud; 
    /**
     * This is a sample web service operation
     * @return 
     */
    
    @WebMethod(operationName = "listarTodasSolicitudes") 
    public ArrayList<Solicitud> listarTodasSolicitudes() { 
        ArrayList<Solicitud> solicitudes = null; 
        try{ 
            daoSolicitud = new SolicitudMySQL(); 
            solicitudes = daoSolicitud.listarTodas(); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return solicitudes; 
    } 
    
    @WebMethod(operationName = "insertarSolicitud") 
    public int insertarSolicitud(@WebParam(name = "solicitud") Solicitud solicitud) { 
        //Solicitud solicitud;
        int resultado = 0; 
        try{ 
            daoSolicitud = new SolicitudMySQL();
            resultado = daoSolicitud.insertar(solicitud); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return resultado; 
    }

    @WebMethod(operationName = "obtenerSolicitudPorId") 
    public Solicitud obtenerSolicitudPorId(@WebParam(name = "idSolicitud") int idSolicitud) { 
        Solicitud solicitud = null; 
        try{ 
            daoSolicitud = new SolicitudMySQL(); 
            solicitud = daoSolicitud.obtenerPorId(idSolicitud); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return solicitud; 
    } 
    
    
}
