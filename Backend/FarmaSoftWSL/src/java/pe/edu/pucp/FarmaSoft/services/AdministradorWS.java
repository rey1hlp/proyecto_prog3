package pe.edu.pucp.FarmaSoft.services; 
 
import jakarta.jws.WebService; 
import jakarta.jws.WebMethod; 
import jakarta.jws.WebParam; 
import java.util.ArrayList; 
import pe.edu.pucp.FarmaSoft.Usuario.DAO.AdministradorDAO;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Administrador;
import pe.edu.pucp.FarmaSoft.Usuario.MySQL.AdministradorMySQL;
 
@WebService(serviceName = "AdministradorWS", targetNamespace = 
"http://services.FarmaSoft.pucp.edu.pe") 
public class AdministradorWS { 
 
    private final AdministradorDAO daoAdministrador = new AdministradorMySQL();
    
    @WebMethod(operationName = "insertarAdministrador") 
    public int insertarAdministrador(@WebParam(name = "admin") Administrador admin) {
        int resultado = 0;
        try{
            resultado = daoAdministrador.insertar(admin);
        }catch(Exception ex){
            System.out.println("Error en la insercion de administrador: " + ex.getMessage()); 
        }
        return resultado; 
    }
    
    @WebMethod(operationName = "obtenerAdministradorPorDni")
    public Administrador obtenerAdministradorPorDni(@WebParam(name = "dni_admin") int dni_admin) {
        Administrador admin = null;
        try {
            admin = daoAdministrador.obtenerPorDni(dni_admin);
        }
        catch(Exception ex) {
            System.out.println("Error en la consulta de administrador: " + ex.getMessage());
        }
        return admin;
    }
    
    @WebMethod(operationName = "darDeBajaAdministradores")
    public int darDeBajaAdministradores(@WebParam(name = "listaDniAdmins") ArrayList<Integer> listaDniAdmins) {
        int resultado = 0;
        try {
            for(Integer dni_admin : listaDniAdmins) {
                resultado += daoAdministrador.darDeBaja(dni_admin);
            }
        }
        catch(Exception ex) {
            System.out.println("Error en la modificacion de administradores: " + ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "darDeAltaAdministradores")
    public int darDeAltaAdministradores(@WebParam(name = "listaDniAdmins") ArrayList<Integer> listaDniAdmins) {
        int resultado = 0;
        try {
            for(Integer dni_admin : listaDniAdmins) {
                resultado += daoAdministrador.darDeAlta(dni_admin);
            }
        }
        catch(Exception ex) {
            System.out.println("Error en la modificacion de administradores: " + ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "actualizarAdministrador")
    public int actualizarAdministrador(@WebParam(name = "admin") Administrador admin) {
        int resultado = 0;
        try {
            resultado = daoAdministrador.actualizar(admin);
        }
        catch(Exception ex) {
            System.out.println("Error en la actualizacion de administrador: " + ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarAdministrador")
    public int eliminarAdministrador(@WebParam(name = "dni_admin") int dni_admin) {
        int resultado = 0;
        try {
            resultado = daoAdministrador.eliminar(dni_admin);
        }
        catch(Exception ex) {
            System.out.println("Error en el borrado de administrador: " + ex.getMessage());
        }
        return resultado;
    }
    
    // Proximamente: filtrado generico
} 
