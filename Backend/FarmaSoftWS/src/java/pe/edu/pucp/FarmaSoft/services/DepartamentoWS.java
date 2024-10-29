/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.services;

import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.DepartamentoDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL.DepartamentoMySQL;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Departamento;

/**
 *
 * @author there
 */
@WebService(serviceName = "DepartamentoWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe")
public class DepartamentoWS {
    private final DepartamentoDAO daoDepartamento = new DepartamentoMySQL();
    /**
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "listarTodosDepartamentos")
    public ArrayList<Departamento> listarTodosDepartamentos() {
         ArrayList<Departamento> departamentos = null;
         try{
             departamentos = daoDepartamento.listarTodos();
         }
         catch(Exception ex){ 
            System.out.println(ex.getMessage()); 
        } 
        return departamentos;
    }
}
