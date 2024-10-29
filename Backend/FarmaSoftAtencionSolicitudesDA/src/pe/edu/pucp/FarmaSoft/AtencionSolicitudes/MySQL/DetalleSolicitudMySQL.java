package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import pe.edu.pucp.FarmaSoft.config.DBManager;
import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaPropia;
import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaGeneral;
import java.sql.Types;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.DetalleSolicitud;
import pe.edu.pucp.FarmaSoft.Medicina.Model.TipoMedicamento;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.DetalleSolicitudDAO;
import pe.edu.pucp.FarmaSoft.Medicina.DAO.MedicinaGeneralDAO;
import pe.edu.pucp.FarmaSoft.Medicina.DAO.MedicinaPropiaDAO;

public class DetalleSolicitudMySQL implements DetalleSolicitudDAO{
    //en rs y rsi se guardaran los resultados de las consultas a la base de datos
    private ResultSet rs;
    private int rsi;
    private MedicinaGeneralDAO daoMedicinaGeneral;
    @Override 
    public int insertar(DetalleSolicitud detalleSolicitud,int idSolicitud) {
        
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("id_Solicitudi", idSolicitud); 
        parametrosEntrada.put("id_MedicinaGenerali", detalleSolicitud.getMedicina().getID()); 
        parametrosEntrada.put("cantidadPedida", detalleSolicitud.getCantidadPedida()); 

        //HashMap<String,Object> parametrosSalida = new HashMap<>(); 
        //parametrosSalida.put("_id_evento", Types.INTEGER); 

        rsi = DBManager.getInstance().ejecutarProcedimiento("insertar_detalle_solicitud", 
                parametrosEntrada,null); 
        return rsi; 
    } 
    
    @Override 
    public ArrayList<DetalleSolicitud> listarTodas() { 
        ArrayList<DetalleSolicitud> detalles = new ArrayList<>();
        //Obtenemos todos los detalles de una solicitud
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listar_detalle_solicitud", parametrosEntrada); 
        try{
            while(rs.next()){ 
                DetalleSolicitud detalle = new DetalleSolicitud(); 
                detalle.setCantidadPedida(rs.getInt("cantidadPedida")); 
                MedicinaGeneral medicina = new MedicinaPropia();
                medicina.setID(rs.getString("ID_MedicinaGeneral"));
                //Deberia completar los otros datos de la medicina leyendo las medicinas de la base de datos
                detalle.setMedicina(medicina);
                detalles.add(detalle); 
            } 
        }catch(SQLException ex){ 
            System.out.println("Error leyendo datos: " + ex.getMessage()); 
        } 
        return detalles; 
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
