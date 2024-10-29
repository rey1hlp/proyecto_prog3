/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.services;

import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Medicina.DAO.TipoMedicamentoDAO;
import pe.edu.pucp.FarmaSoft.Medicina.Model.TipoMedicamento;
import pe.edu.pucp.FarmaSoft.Medicina.MySQL.TipoMedicamentoMySQL;
/**
 *
 * @author there
 */
@WebService(serviceName = "TipoMedicamentoWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe")
public class TipoMedicamentoWS {
    private final TipoMedicamentoDAO daoTipoMedicamento = new TipoMedicamentoMySQL();
    /**
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "listarTodosTiposMedicamentos")
    public ArrayList<TipoMedicamento> listarTodosTiposMedicamentos() {
         ArrayList<TipoMedicamento> listaTiposMed = null;
         try{
             listaTiposMed = daoTipoMedicamento.listarTodos();
         }
         catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return listaTiposMed;
    }
}
