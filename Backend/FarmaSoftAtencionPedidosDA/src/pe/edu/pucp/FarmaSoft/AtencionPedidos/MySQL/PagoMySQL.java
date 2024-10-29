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
import pe.edu.pucp.FarmaSoft.AtencionPedidos.DAO.PagoDAO;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.Pago;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.PedidoPropio;

/**
 *
 * @author User
 */
public class PagoMySQL implements PagoDAO{
    private ResultSet rs;
    @Override
    public int insertar(Pago pago) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("p_pedidoPropio_id", pago.getPedidoPropio().getID()); 
        parametrosEntrada.put("p_metodoPago", pago.getMetodoPago()); 
        parametrosEntrada.put("p_numeroOperacion", pago.getNumOperaciones()); 
        parametrosEntrada.put("p_montoPagado", pago.getMontoPagado()); 
        parametrosEntrada.put("p_comprobante", pago.getComprobante()); 
        parametrosEntrada.put("p_completado", pago.getComprobante()); 

        return (int) DBManager.getInstance().ejecutarProcedimiento("insertar_pago", parametrosEntrada, 
            null); 
    }

    @Override
    public ArrayList<Pago> listarTodas() {
        ArrayList<Pago> pagos = new ArrayList<>(); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listar_pagos", null); 
        try{ 
            while(rs.next()){ 
                Pago pago = new Pago(); 
                pago.setID(rs.getInt("ID"));
                PedidoPropio pedido = new PedidoPropio();
                pedido.setID(rs.getInt("ID_PedidoPropio"));
                pago.setPedidoPropio(pedido);
                pago.setMetodoPago(rs.getString("metodoPago"));
                pago.setNumOperaciones(rs.getString("numeroOperacion"));
                pago.setMontoPagado(rs.getDouble("montoPagado"));
                pago.setComprobante(rs.getBytes("comprobante"));
                pago.setCompletado(rs.getBoolean("completado"));
                pagos.add(pago); 
            } 
        }catch(SQLException ex){ 
            System.out.println("Error leyendo datos: " + ex.getMessage()); 
        } 
        return pagos; 
    }

    @Override
    public Pago obtenerPorId(int idPago) {
        Pago pago = null;  
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("p_id", idPago); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPorId_pago", 
    parametrosEntrada); 
        try{ 
            if(rs!=null && rs.next()){
                pago = new Pago();
                pago.setID(rs.getInt("ID"));
                PedidoPropio pedido = new PedidoPropio();
                pedido.setID(rs.getInt("ID_PedidoPropio"));
                pago.setPedidoPropio(pedido);
                pago.setMetodoPago(rs.getString("metodoPago"));
                pago.setNumOperaciones(rs.getString("numeroOperacion"));
                pago.setMontoPagado(rs.getDouble("montoPagado"));
                pago.setComprobante(rs.getBytes("comprobante"));
                pago.setCompletado(rs.getBoolean("completado"));
            } 
        }catch(SQLException ex){ 
            System.out.println("Error leyendo datos: " + ex.getMessage()); 
        } 
        return pago;
    }

    @Override
    public int eliminar(int idPago) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        parametrosEntrada.put("p_id", idPago);
        
        int resultado = DBManager.getInstance().ejecutarProcedimiento("eliminar_pago",
                parametrosEntrada, null);
        
        return resultado;
    }

    @Override
    public int actualizar(Pago pago) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        parametrosEntrada.put("p_id", pago.getID());
        parametrosEntrada.put("p_pedidoPropio_id", pago.getPedidoPropio().getID()); 
        parametrosEntrada.put("p_metodoPago", pago.getMetodoPago()); 
        parametrosEntrada.put("p_numeroOperacion", pago.getNumOperaciones()); 
        parametrosEntrada.put("p_montoPagado", pago.getMontoPagado()); 
        parametrosEntrada.put("p_comprobante", pago.getComprobante()); 
        parametrosEntrada.put("p_completado", pago.getComprobante()); 

        int resultado = DBManager.getInstance().ejecutarProcedimiento("actualizar_pedido_propio",
                parametrosEntrada, null);
        
        return resultado;
    }
    
}
