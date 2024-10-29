package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import pe.edu.pucp.FarmaSoft.config.DBManager;
import java.sql.Types;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.DireccionDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.FarmaciaAsociadaDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.DetalleSolicitud;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Direccion;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.FarmaciaAsociada;

public class FarmaciaAsociadaMySQL implements FarmaciaAsociadaDAO{
    //en rs y rsi se guardaran los resultados de las consultas a la base de datos
    private ResultSet rs;
    private int rsi;
    private FarmaciaAsociadaDAO daoFarmaciaAsociada;
    private DireccionDAO daoDireccion;
    
    @Override 
    public ArrayList<FarmaciaAsociada> listarTodas() { 
        ArrayList<FarmaciaAsociada> farmacias = new ArrayList<>();
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listar_farmacias_asociadas", null); 
        try{ 
            while(rs.next()){ 
                FarmaciaAsociada farmacia = new FarmaciaAsociada();
                
                farmacia.setID(rs.getInt("ID"));
                farmacia.setNombre(rs.getString("nombre"));
                daoDireccion = new DireccionMySQL();
                Direccion direccion = daoDireccion.obtenerPorId(rs.getInt("ID_Direccion"));
                farmacia.setDireccion(direccion);
                farmacia.setTelefono(rs.getInt("telefono"));
                farmacia.setCorreo(rs.getString("correo"));
                farmacias.add(farmacia); 
            } 
        }catch(SQLException ex){ 
            System.out.println("Error leyendo datos: " + ex.getMessage()); 
        } 
        return farmacias; 
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
