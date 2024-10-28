/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.SolicitudDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Cliente;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.EstadoSolicitud;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.FarmaciaAsociada;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Intermediario;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Receptor;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Solicitud;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Usuario;
import pe.edu.pucp.FarmaSoft.config.DBManager;

/**
 *
 * @author User
 */
public class SolicitudMySQL implements SolicitudDAO{
    
    protected ResultSet rs;
    
    @Override
    public int insertar(Solicitud solicitud) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("fechaYHoraCreacion", solicitud.getFechayhoraCreacion()); 
        parametrosEntrada.put("estado", solicitud.getEstado()); 
        parametrosEntrada.put("recetaMedica", solicitud.getRecetaMedica()); 
        parametrosEntrada.put("generaPedido", solicitud.isGeneraPedido()); 
        parametrosEntrada.put("ID_Cliente", solicitud.getCliente().getID()); 
        parametrosEntrada.put("DNI_Intermediario", solicitud.getIntermediario().getDni()); 
        parametrosEntrada.put("DNI_Receptor", solicitud.getReceptor().getDni()); 
        parametrosEntrada.put("ID_FarmaciaAsociada", solicitud.getFarmaciaAsociada().getID()); 
        parametrosEntrada.put("completado", solicitud.isCompletado()); 

        return (int) DBManager.getInstance().ejecutarProcedimiento("insertar_solcitud", parametrosEntrada, 
            null); 
    }

    @Override
    public ArrayList<Solicitud> listarTodas() {
        ArrayList<Solicitud> solicitudes = new ArrayList<>(); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listar_solicitudes", null); 
        try{ 
            while(rs.next()){ 
                Solicitud solicitud = new Solicitud(); 
                solicitud.setID(rs.getInt("ID"));
                solicitud.setFechayhoraCreacion(rs.getDate("fechaYHoraCreacion"));
                solicitud.setEstado(EstadoSolicitud.valueOf(rs.getString("estado")));
                solicitud.setRecetaMedica(rs.getBytes("recetaMedica"));
                solicitud.setGeneraPedido(rs.getBoolean("generaPedido")); 
                Cliente cliente = new Cliente();
                cliente.setID(rs.getInt("ID_Cliente"));
                solicitud.setCliente(cliente);
                Usuario intermediario = new Intermediario();
                intermediario.setDNI(rs.getInt("DNI_Intermediario"));
                solicitud.setIntermediario(intermediario);
                Usuario receptor = new Receptor();
                receptor.setDNI(rs.getInt("DNI_Receptor"));
                solicitud.setReceptor(receptor);
                FarmaciaAsociada farmaciaAsociada = new FarmaciaAsociada();
                farmaciaAsociada.setID(rs.getInt("ID_FarmaciaAsociada"));
                solicitud.setFarmaciaAsociada(farmaciaAsociada);
                solicitud.setCompletado(rs.getBoolean("completado"));
                solicitudes.add(solicitud); 
            } 
        }catch(SQLException ex){ 
            System.out.println("Error leyendo datos: " + ex.getMessage()); 
        } 
        return solicitudes; 
    }

    @Override
    public Solicitud obtenerPorId(int idSolicitud) {
        Solicitud solicitud = new Solicitud();  
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("p_id", idSolicitud); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPorId_solicitud", 
    parametrosEntrada); 
        try{ 
            if(rs.next()){  
                solicitud.setID(rs.getInt("ID"));
                solicitud.setFechayhoraCreacion(rs.getDate("fechaYHoraCreacion"));
                solicitud.setEstado(EstadoSolicitud.valueOf(rs.getString("estado")));
                solicitud.setRecetaMedica(rs.getBytes("recetaMedica"));
                solicitud.setGeneraPedido(rs.getBoolean("generaPedido")); 
                Cliente cliente = new Cliente();
                cliente.setID(rs.getInt("ID_Cliente"));
                solicitud.setCliente(cliente);
                Usuario intermediario = new Intermediario();
                intermediario.setDNI(rs.getInt("DNI_Intermediario"));
                solicitud.setIntermediario(intermediario);
                Usuario receptor = new Receptor();
                receptor.setDNI(rs.getInt("DNI_Receptor"));
                solicitud.setReceptor(receptor);
                FarmaciaAsociada farmaciaAsociada = new FarmaciaAsociada();
                farmaciaAsociada.setID(rs.getInt("ID_FarmaciaAsociada"));
                solicitud.setFarmaciaAsociada(farmaciaAsociada);
                solicitud.setCompletado(rs.getBoolean("completado"));
            } 
        }catch(SQLException ex){ 
            System.out.println("Error leyendo datos: " + ex.getMessage()); 
        } 
        return solicitud; 
    }

    @Override
    public int eliminar(int idSolicitud) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        parametrosEntrada.put("idi", idSolicitud);
        
        int resultado = DBManager.getInstance().ejecutarProcedimiento("eliminar_solicitud",
                parametrosEntrada, null);
        
        return resultado;
    }
    
    @Override
    public int actualizar(Solicitud solicitud) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        parametrosEntrada.put("idi", solicitud.getID());
        parametrosEntrada.put("nueva_fechaHoraCreacion", solicitud.getFechayhoraCreacion()); 
        parametrosEntrada.put("nuevo_estado", solicitud.getEstado()); 
        parametrosEntrada.put("nueva_recetaMedica", solicitud.getRecetaMedica()); 
        parametrosEntrada.put("nuevo_generaPedido", solicitud.isGeneraPedido()); 
        parametrosEntrada.put("nuevo_id_cliente", solicitud.getCliente().getID()); 
        parametrosEntrada.put("nuevo_DNI_Intermediario", solicitud.getIntermediario().getDni()); 
        parametrosEntrada.put("nuevo_DNI_Receptor", solicitud.getReceptor().getDni()); 
        parametrosEntrada.put("nueva_id_FarmaciaAsociada", solicitud.getFarmaciaAsociada().getID()); 
        parametrosEntrada.put("nuevo_completado", solicitud.isCompletado()); 

        int resultado = DBManager.getInstance().ejecutarProcedimiento("actualizar_solicitud",
                parametrosEntrada, null);
        
        return resultado;
    }
}


