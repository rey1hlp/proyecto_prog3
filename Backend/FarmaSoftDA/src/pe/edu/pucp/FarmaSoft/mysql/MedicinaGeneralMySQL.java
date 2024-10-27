package pe.edu.pucp.FarmaSoft.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import pe.edu.pucp.FarmaSoft.config.DBManager;
import pe.edu.pucp.FarmaSoft.Medicina.Model.TipoMedicamento;
//import pe.edu.pucp.eventmastersoft.model.Evento;
//import pe.edu.pucp.eventmastersoft.model.Productora;
//import pe.edu.pucp.eventmastersoft.model.TipoEvento;
import java.sql.Types;
import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaGeneral;
import pe.edu.pucp.FarmaSoft.dao.MedicinaGeneralDAO;
import pe.edu.pucp.FarmaSoft.dao.MedicinaPropiaDAO;

public class MedicinaGeneralMySQL implements MedicinaGeneralDAO{

    private ResultSet rs;
    private int rsi;
    
    @Override 
    public int insertar(MedicinaGeneral medicinaGeneral) { 
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("idi", medicinaGeneral.getID()); 
        parametrosEntrada.put("nombre", medicinaGeneral.getNombre()); 
        parametrosEntrada.put("tipo_medicamento", medicinaGeneral.getTipoMedicamento());

        //HashMap<String,Object> parametrosSalida = new HashMap<>(); 
        //parametrosSalida.put("_id_evento", Types.INTEGER); 

        rsi = DBManager.getInstance().ejecutarProcedimiento("insertar_medicina_general", 
                parametrosEntrada,null); 
        //return (int) parametrosSalida.get("_id_evento"); 
        return rsi;
    } 

//    @Override 
//    public ArrayList<MedicinaPropia> listarPorNombre(String nombre) { 
//        ArrayList<Evento> eventos = new ArrayList<>(); 
//        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
//        parametrosEntrada.put("_nombre", nombre); 
//        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_EVENTOS_X_NOMBRE", 
//    parametrosEntrada); 
//        try{ 
//            while(rs.next()){ 
//               Evento evento = new Evento(); 
//               evento.setIdEvento(rs.getInt("id_evento")); 
//               evento.setNombre(rs.getString("nombre_evento")); 
//               evento.setFechaRealizacion(rs.getDate("fecha_realizacion")); 
//               Productora productora = new Productora(); 
//               productora.setIdProductora(rs.getInt("id_productora")); 
//               productora.setNombre(rs.getString("nombre_productora")); 
//               evento.setProductora(productora); 
//               eventos.add(evento); 
//            } 
//        }catch(SQLException ex){ 
//            System.out.println("Error leyendo datos: " + ex.getMessage()); 
//        } 
//        return eventos; 
//    }
//
//    @Override 
//    public MedicinaPropia obtenerPorId(int idEvento) { 
//        Evento evento = new Evento(); 
//        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
//        parametrosEntrada.put("_id_evento", idEvento); 
//        rs = DBManager.getInstance().ejecutarProcedimientoLectura("OBTENER_EVENTO_X_ID", 
//    parametrosEntrada); 
//        try{ 
//            if(rs.next()){  
//               evento.setIdEvento(rs.getInt("id_evento")); 
//               evento.setClasificacion(rs.getString("id_clasificacion").charAt(0)); 
//               evento.setCostoRealizacion(rs.getDouble("costo_realizacion")); 
//               evento.setTipoEvento(TipoEvento.valueOf(rs.getString("tipo_evento"))); 
//               evento.setNombre(rs.getString("nombre_evento")); 
//               evento.setDescripcion(rs.getString("descripcion")); 
//               evento.setBannerPromocional(rs.getBytes("banner_promocional")); 
//               evento.setPermiteGrabacion(rs.getBoolean("permite_grabacion")); 
//               evento.setPermiteReingreso(rs.getBoolean("permite_reingreso")); 
//               evento.setFechaRealizacion(rs.getDate("fecha_realizacion")); 
//               Productora productora = new Productora(); 
//               productora.setIdProductora(rs.getInt("id_productora")); 
//               productora.setNombre(rs.getString("nombre_productora")); 
//               evento.setProductora(productora); 
//               evento.setActivo(true); 
//            } 
//        }catch(SQLException ex){ 
//            System.out.println("Error leyendo datos: " + ex.getMessage()); 
//        } 
//        return evento; 
//    } 
    
}
