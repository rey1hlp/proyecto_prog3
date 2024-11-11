package pe.edu.pucp.FarmaSoft.AtencionPedidos.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import pe.edu.pucp.FarmaSoft.config.DBManager;
import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaPropia;
import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaGeneral;
//import pe.edu.pucp.eventmastersoft.model.Evento;
//import pe.edu.pucp.eventmastersoft.model.Productora;
//import pe.edu.pucp.eventmastersoft.model.TipoEvento;
import java.sql.Types;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.DAO.DetallePedidoDAO;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.DetallePedido;
import pe.edu.pucp.FarmaSoft.Medicina.Model.TipoMedicamento;
import pe.edu.pucp.FarmaSoft.Medicina.DAO.MedicinaGeneralDAO;
import pe.edu.pucp.FarmaSoft.Medicina.DAO.MedicinaPropiaDAO;
import pe.edu.pucp.FarmaSoft.Medicina.MySQL.MedicinaGeneralMySQL;

public class DetallePedidoMySQL implements DetallePedidoDAO{
    //en rs y rsi se guardaran los resultados de las consultas a la base de datos
    private ResultSet rs;
    private int rsi;
    private MedicinaGeneralDAO daoMedicinaGeneral;
    @Override 
    public int insertar(DetallePedido detallePedido,int idPedido) {
        //Primero debemos insertar la información de la medicina general
        HashMap<String,Object> parametrosEntrada = new HashMap<>();

        //parametrosEntrada.put("id", usuario.getId());
        parametrosEntrada.put("ID_PedidoPropioi", idPedido); 
        parametrosEntrada.put("ID_MedicinaPropiai", detallePedido.getMedicina().getId()); 
        parametrosEntrada.put("cantidadPedida", detallePedido.getCantidadPedida()); 
        parametrosEntrada.put("precioUnitario", detallePedido.getPrecioUnitario()); 

        int resultado = DBManager.getInstance().ejecutarProcedimiento("insertar_detalle_pedido",
                parametrosEntrada, null);
        return resultado;
    } 
    
//    @Override 
//    public ArrayList<DetallePedido> listarTodas() { 
//        ArrayList<DetallePedido> detallePedidos = new ArrayList<>(); 
//        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listar_detalle_pedido", null); 
//        try{ 
//            while(rs.next()){ 
//                DetallePedido detallePedido = new DetallePedido(); 
//                medicinaPropia.setCodigo(rs.getInt("codigo")); 
//                medicinaPropia.setPrecio(rs.getDouble("precio")); 
//                medicinaPropia.setStock(rs.getInt("stock"));
//                medicinaPropia.setIDP(rs.getString("ID"));
//                medicinaPropia.setNombre(rs.getString("nombre"));
//                String tipo=rs.getString("tipo_medicamento");
//                medicinaPropia.setTipoMedicamento(TipoMedicamento.valueOf(tipo));
//                medicinas.add(medicinaPropia); 
//            } 
//        }catch(SQLException ex){ 
//            System.out.println("Error leyendo datos: " + ex.getMessage()); 
//        } 
//        return detallePedidos; 
//    }    
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
