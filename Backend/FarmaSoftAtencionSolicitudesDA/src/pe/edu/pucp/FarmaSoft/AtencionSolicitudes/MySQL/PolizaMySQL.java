/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.PolizaDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Poliza;
import pe.edu.pucp.FarmaSoft.config.DBManager;
/**
 *
 * @author User
 */
public class PolizaMySQL implements PolizaDAO {
    protected ResultSet rs;
    
    @Override
    public Poliza obtenerPorId(int idPoliza) {
        Poliza poliza = null;
        HashMap<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", idPoliza); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPorId_poliza", 
            parametrosEntrada);
        
        try {
            if(rs != null && rs.next()) {
                poliza = new Poliza();
                poliza.setID(rs.getInt("ID"));
                poliza.setTipoSeguro(rs.getString("tipoSeguro"));
                poliza.setCodigo(rs.getInt("codigo"));
                poliza.setAseguradora(rs.getString("aseguradora"));
                poliza.setDNIAsegurado(rs.getInt("DNIAsegurado"));
                poliza.setNombreAsegurado(rs.getString("nombreAsegurado"));
                poliza.setFechaEmision(rs.getDate("fechaEmision"));
                poliza.setFechaVencimiento(rs.getDate("fechaVencimiento"));
                poliza.setCoberturaMaxima(rs.getDouble("coberturaMaxima"));
                poliza.setPorcentajeCobertura(rs.getDouble("porcentajeCobertura"));
                poliza.setEsValida(rs.getBoolean("esValida"));
                poliza.setImagen(rs.getBytes("imagen"));
                poliza.setCompletado(rs.getBoolean("completado"));
            }
        }
        catch(SQLException ex) {
            System.out.println("Error leyendo datos: " + ex.getMessage()); 
        }
        
        return poliza;
    }

    @Override
    public int actualizar(Poliza poliza) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        parametrosEntrada.put("p_id", poliza.getID());
        parametrosEntrada.put("p_tipoSeguro", poliza.getTipoSeguro()); 
        parametrosEntrada.put("p_codigo", poliza.getCodigo()); 
        parametrosEntrada.put("p_aseguradora", poliza.getAseguradora()); 
        parametrosEntrada.put("p_DNIAsegurado", poliza.getDNIAsegurado()); 
        parametrosEntrada.put("p_nombreAsegurado", poliza.getNombreAsegurado()); 
        parametrosEntrada.put("p_fechaEmision", poliza.getFechaEmision()); 
        parametrosEntrada.put("p_fechaVencimiento", poliza.getFechaVencimiento()); 
        parametrosEntrada.put("p_coberturaMaxima", poliza.getCoberturaMaxima()); 
        parametrosEntrada.put("p_porcentajeCobertura", poliza.getPorcentajeCobertura()); 
        parametrosEntrada.put("p_esValida", poliza.isEsValida()); 
        
        if (poliza.getImagen() == null) {
            parametrosEntrada.put("p_imagen", java.sql.Types.BINARY);
        } else {
            parametrosEntrada.put("p_imagen", poliza.getImagen());
        }

        parametrosEntrada.put("p_completado", poliza.isCompletado());
        
        int resultado = DBManager.getInstance().ejecutarProcedimiento("actualizar_poliza",
            parametrosEntrada, null);
        
        return resultado;
    }
    @Override
    public int insertar(Poliza poliza) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("tipoSeguro", poliza.getTipoSeguro()); 
        parametrosEntrada.put("codigoi", poliza.getCodigo()); 
        parametrosEntrada.put("aseguradora", poliza.getAseguradora()); 
        parametrosEntrada.put("DNIAsegurado", poliza.getDNIAsegurado()); 
        parametrosEntrada.put("nombreAsegurado", poliza.getNombreAsegurado()); 
        parametrosEntrada.put("fechaEmision", poliza.getFechaEmision()); 
        parametrosEntrada.put("fechaVencimiento", poliza.getFechaVencimiento()); 
        parametrosEntrada.put("coberturaMaxima", poliza.getCoberturaMaxima()); 
        parametrosEntrada.put("porcentajeCobertura", poliza.getPorcentajeCobertura()); 
        parametrosEntrada.put("esValida", poliza.isEsValida()); 
        parametrosEntrada.put("imagen", poliza.getImagen()); 
        parametrosEntrada.put("completado", poliza.isCompletado()); 

        return (int) DBManager.getInstance().ejecutarProcedimiento("insertar_poliza", parametrosEntrada, 
            null); 
    }
    
}
