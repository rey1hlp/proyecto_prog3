package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import pe.edu.pucp.FarmaSoft.config.DBManager;
import java.sql.Types;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.DepartamentoDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.DireccionDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.FarmaciaAsociadaDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Departamento;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Direccion;

public class DireccionMySQL implements DireccionDAO{
    //en rs y rsi se guardaran los resultados de las consultas a la base de datos
    private ResultSet rs;
    private int rsi;
    private DepartamentoDAO daoDepartamento = new DepartamentoMySQL();

    @Override 
    public Direccion obtenerPorId(int idDireccion) { 
        Direccion direccion = new Direccion(); 
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("p_id", idDireccion); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPorId_direccion", 
            parametrosEntrada); 
        try{ 
            if(rs!=null && rs.next()){  
               direccion.setID(rs.getInt("ID"));
               
               direccion.setProvincia(rs.getString("provincia"));
               direccion.setDistrito(rs.getString("distrito"));
               direccion.setCalle(rs.getString("calle"));
               direccion.setReferencia(rs.getString("referencia"));
               direccion.setCompletado(rs.getBoolean("completado"));
               
               Departamento dep = daoDepartamento.obtenerPorId(rs.getInt("ID_Departamento"));
               direccion.setDepartamento(dep);
            } 
        }catch(SQLException ex){
            System.out.println("Error leyendo datos: " + ex.getMessage()); 
        } 
        return direccion;
    } 
    
}
