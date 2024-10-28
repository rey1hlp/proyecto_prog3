/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.services;

import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Empleado;
import pe.edu.pucp.FarmaSoft.Usuario.DAO.EmpleadoDAO;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Empleado;
import pe.edu.pucp.FarmaSoft.Usuario.MySQL.EmpleadoMySQL;

/**
 *
 * @author there
 */
@WebService(serviceName = "EmpleadoWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe")
public class EmpleadoWS {
    
    private final EmpleadoDAO daoEmpleado = new EmpleadoMySQL();
    
    @WebMethod(operationName = "insertarEmpleado") 
    public int insertarEmpleado(@WebParam(name = "emp") Empleado emp) {
        int resultado = 0;
        try{
            resultado = daoEmpleado.insertar(emp);
        }catch(Exception ex){
            System.out.println("Error en la insercion de empleado: " + ex.getMessage()); 
        }
        return resultado; 
    }
    
    @WebMethod(operationName = "obtenerEmpleadoPorDni")
    public Empleado obtenerEmpleadoPorDni(@WebParam(name = "dni_emp") int dni_emp) {
        Empleado emp = null;
        try {
            emp = daoEmpleado.obtenerPorDni(dni_emp);
        }
        catch(Exception ex) {
            System.out.println("Error en la consulta de empleado: " + ex.getMessage());
        }
        return emp;
    }
    
    @WebMethod(operationName = "darDeBajaEmpleados")
    public int darDeBajaEmpleados(@WebParam(name = "listaDniEmp") ArrayList<Integer> listaDniEmp) {
        int resultado = 0;
        try {
            for(Integer dni_emp : listaDniEmp) {
                resultado += daoEmpleado.darDeBaja(dni_emp);
            }
        }
        catch(Exception ex) {
            System.out.println("Error en la modificacion de empleados: " + ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "darDeAltaEmpleados")
    public int darDeAltaEmpleados(@WebParam(name = "listaDniEmp") ArrayList<Integer> listaDniEmp) {
        int resultado = 0;
        try {
            for(Integer dni_emp : listaDniEmp) {
                resultado += daoEmpleado.darDeAlta(dni_emp);
            }
        }
        catch(Exception ex) {
            System.out.println("Error en la modificacion de empleados: " + ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "actualizarEmpleado")
    public int actualizarEmpleado(@WebParam(name = "emp") Empleado emp) {
        int resultado = 0;
        try {
            resultado = daoEmpleado.actualizar(emp);
        }
        catch(Exception ex) {
            System.out.println("Error en la actualizacion de empleado: " + ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarEmpleado")
    public int eliminarEmpleado(@WebParam(name = "dni_emp") int dni_emp) {
        int resultado = 0;
        try {
            resultado = daoEmpleado.eliminar(dni_emp);
        }
        catch(Exception ex) {
            System.out.println("Error en el borrado de empleado: " + ex.getMessage());
        }
        return resultado;
    }
    
    // Proximamente: filtrado generico
}
