/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL;

import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.DepartamentoDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Departamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import pe.edu.pucp.FarmaSoft.config.DBManager;

/**
 *
 * @author there
 */
public class DepartamentoMySQL implements DepartamentoDAO {
    private ResultSet rs;
    
    @Override
    public Departamento obtenerPorId(int id) {
        Departamento dep = null;
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPorId_departamento", 
            parametrosEntrada);
        
        try {
            if(rs != null && rs.next()) {
                dep = Departamento.valueOf(rs.getString("nombre"));
            }
        }
        catch(SQLException ex) {
            System.out.println("Error leyendo datos: " + ex.getMessage()); 
        }
        
        return dep;
    }

    @Override
    public ArrayList<Departamento> listarTodos() {
        ArrayList<Departamento> listaDep = new ArrayList<>();
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listar_departamentos", null);
        
        try {
            while(rs.next()) {
                Departamento dep = Departamento.valueOf(rs.getString("nombre"));
                listaDep.add(dep);
            }
        }
        catch(SQLException ex) {
            System.out.println("Error en consulta de datos: " + ex.getMessage()); 
        }
        
        return listaDep;
    }
    
}
