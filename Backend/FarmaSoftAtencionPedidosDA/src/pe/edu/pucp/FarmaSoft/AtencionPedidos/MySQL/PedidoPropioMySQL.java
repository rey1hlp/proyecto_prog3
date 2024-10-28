/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.AtencionPedidos.MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import pe.edu.pucp.FarmaSoft.config.DBManager;
import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.DAO.PedidoPropioDAO;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.EstadoPedido;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.PedidoPropio;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.Tecnico;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Solicitud;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Usuario;
/**
 *
 * @author User
 */
public class PedidoPropioMySQL implements PedidoPropioDAO{
    private ResultSet rs;
    @Override
    public int insertar(PedidoPropio pedidoPropio) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("p_solicitud_id", pedidoPropio.getSolicitudAsociada().getID()); 
        parametrosEntrada.put("p_fechaHora", pedidoPropio.getFechayHoraCreacion()); 
        parametrosEntrada.put("p_estado", pedidoPropio.getEstadoPedido()); 
        parametrosEntrada.put("p_dni_tecnico", pedidoPropio.getTecnicoEncargado().getDni()); 
        parametrosEntrada.put("p_montoTotal", pedidoPropio.getMontoTotal()); 
        parametrosEntrada.put("p_montoCubierto", pedidoPropio.getMontoCubierto()); 
        parametrosEntrada.put("p_completado", pedidoPropio.isCompletado()); 

        return (int) DBManager.getInstance().ejecutarProcedimiento("insertar_pedido_propio", parametrosEntrada, 
            null); 
    }

    @Override
    public ArrayList<PedidoPropio> listarTodas() {
        ArrayList<PedidoPropio> pedidos = new ArrayList<>(); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listar_pedidos_propios", null); 
        try{ 
            while(rs.next()){ 
                PedidoPropio pedidoPropio = new PedidoPropio(); 
                
                pedidoPropio.setID(rs.getInt("ID"));
                Solicitud solicitud = new Solicitud();
                solicitud.setID(rs.getInt("ID_Solicitud"));
                pedidoPropio.setSolicitudAsociada(solicitud);
                pedidoPropio.setFechayHoraCreacion(rs.getDate("fechaYHoraCreacion"));
                pedidoPropio.setEstadoPedido(EstadoPedido.valueOf(rs.getString("estado")));
                Usuario tecnico = new Tecnico();
                tecnico.setDNI(rs.getInt("DNI_Tecnico"));
                pedidoPropio.setTecnicoEncargado(tecnico);
                pedidoPropio.setMontoTotal(rs.getDouble("montoTotal"));
                pedidoPropio.setMontoCubierto(rs.getDouble("montoCubierto"));
                pedidoPropio.setCompletado(rs.getBoolean("completado"));
                pedidos.add(pedidoPropio); 
            } 
        }catch(SQLException ex){ 
            System.out.println("Error leyendo datos: " + ex.getMessage()); 
        } 
        return pedidos; 
    }

    @Override
    public PedidoPropio obtenerPorId(int idPedidoPropio) {
        PedidoPropio pedidoPropio = new PedidoPropio();  
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("p_id", idPedidoPropio); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPorId_pedido_propio", 
    parametrosEntrada); 
        try{ 
            if(rs.next()){  
                pedidoPropio.setID(rs.getInt("ID"));
                Solicitud solicitud = new Solicitud();
                solicitud.setID(rs.getInt("ID_Solicitud"));
                pedidoPropio.setSolicitudAsociada(solicitud);
                pedidoPropio.setFechayHoraCreacion(rs.getDate("fechaYHoraCreacion"));
                pedidoPropio.setEstadoPedido(EstadoPedido.valueOf(rs.getString("estado")));
                Usuario tecnico = new Tecnico();
                tecnico.setDNI(rs.getInt("DNI_Tecnico"));
                pedidoPropio.setTecnicoEncargado(tecnico);
                pedidoPropio.setMontoTotal(rs.getDouble("montoTotal"));
                pedidoPropio.setMontoCubierto(rs.getDouble("montoCubierto"));
                pedidoPropio.setCompletado(rs.getBoolean("completado"));
            } 
        }catch(SQLException ex){ 
            System.out.println("Error leyendo datos: " + ex.getMessage()); 
        } 
        return pedidoPropio; 
    }

    @Override
    public int eliminar(int idPedidoPropio) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        parametrosEntrada.put("p_id", idPedidoPropio);
        
        int resultado = DBManager.getInstance().ejecutarProcedimiento("eliminar_pedido_propio",
                parametrosEntrada, null);
        
        return resultado;
    }

    @Override
    public int actualizar(PedidoPropio pedidoPropio) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        parametrosEntrada.put("p_id", pedidoPropio.getID());
        parametrosEntrada.put("p_solicitud_id", pedidoPropio.getSolicitudAsociada().getID()); 
        parametrosEntrada.put("p_fechaHora", pedidoPropio.getFechayHoraCreacion()); 
        parametrosEntrada.put("p_estado", pedidoPropio.getEstadoPedido()); 
        parametrosEntrada.put("p_dni_tecnico", pedidoPropio.getTecnicoEncargado().getDni()); 
        parametrosEntrada.put("p_montoTotal", pedidoPropio.getMontoTotal()); 
        parametrosEntrada.put("p_montoCubierto", pedidoPropio.getMontoCubierto()); 
        parametrosEntrada.put("p_completado", pedidoPropio.isCompletado()); 

        int resultado = DBManager.getInstance().ejecutarProcedimiento("actualizar_pedido_propio",
                parametrosEntrada, null);
        
        return resultado;
    }
    
}
