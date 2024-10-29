/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.Medicina.MySQL;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Medicina.DAO.TipoMedicamentoDAO;
import pe.edu.pucp.FarmaSoft.Medicina.Model.TipoMedicamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import pe.edu.pucp.FarmaSoft.config.DBManager;

/**
 *
 * @author there
 */
public class TipoMedicamentoMySQL implements TipoMedicamentoDAO {
    private ResultSet rs;
    
    @Override
    public TipoMedicamento obtenerPorId(int id) {
        TipoMedicamento tipoMed = null;
        HashMap<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);
        
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPorId_tipo_medicamento",
                parametrosEntrada);
        
        try {
            if(rs != null && rs.next()) {
                tipoMed = TipoMedicamento.valueOf(rs.getString("nombre"));
            }
        }
        catch(SQLException ex) {
            System.out.println("Error en consulta de datos: " + ex.getMessage()); 
        }
        
        return tipoMed;
    }

    @Override
    public ArrayList<TipoMedicamento> listarTodos() {
        ArrayList<TipoMedicamento> listaTipoMed = new ArrayList<>();
        
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listar_tipos_medicamentos", null);
        
        try {
            while(rs.next()) {
                TipoMedicamento tipoMed = TipoMedicamento.valueOf(rs.getString("nombre"));
                listaTipoMed.add(tipoMed);
            }
        }
        catch(SQLException ex) {
            System.out.println("Error en consulta de datos: " + ex.getMessage()); 
        }
        
        return listaTipoMed;
    }
    
}
