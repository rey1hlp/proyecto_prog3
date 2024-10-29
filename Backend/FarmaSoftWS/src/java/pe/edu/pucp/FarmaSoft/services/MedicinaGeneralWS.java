/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.services;

import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaGeneral;
import pe.edu.pucp.FarmaSoft.Medicina.DAO.MedicinaGeneralDAO;
import pe.edu.pucp.FarmaSoft.Medicina.MySQL.MedicinaGeneralMySQL;

/**
 *
 * @author there
 */
@WebService(serviceName = "MedicinaGeneralWS")
public class MedicinaGeneralWS {
    private final MedicinaGeneralDAO daoMedicinaGeneral = new MedicinaGeneralMySQL();
    /**
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "listarTodasMedicinasGenerales") 
    public ArrayList<MedicinaGeneral> listarTodasMedicinasGenerales() { 
        ArrayList<MedicinaGeneral> medicinas = null; 
        try{
            medicinas = daoMedicinaGeneral.listarTodas(); 
        }catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return medicinas; 
    } 
}
