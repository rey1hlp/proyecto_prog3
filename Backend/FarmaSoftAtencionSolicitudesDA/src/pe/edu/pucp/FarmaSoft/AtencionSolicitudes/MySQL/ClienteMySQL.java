/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
author: ariel
*/
package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL;

import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.ClienteDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.DireccionDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO.PolizaDAO;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Direccion;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Poliza;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.TipoDocumento;
import pe.edu.pucp.FarmaSoft.config.DBManager;

public class ClienteMySQL implements ClienteDAO {
    private ResultSet rs;
    
    @Override
    public Cliente obtenerPorId(int id) {
        Cliente cliente = null;
        HashMap<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPorId_cliente", 
            parametrosEntrada);
        
        try {
            if(rs != null && rs.next()) {
                cliente = new Cliente();
                cliente.setID(rs.getInt("ID"));
                cliente.setTipoDocumento(TipoDocumento.valueOf(rs.getString("tipoDocumento")));
                cliente.setNumDocumento(rs.getInt("numDocumento"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellidoPaterno(rs.getString("apellidoPaterno"));
                cliente.setApellidoMaterno(rs.getString("apellidoMaterno"));
                cliente.setTelefonoContacto(rs.getInt("telefonoContacto"));
                cliente.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                cliente.setCorreoContacto(rs.getString("correoContacto"));
                cliente.setTienePoliza(rs.getBoolean("tienePoliza"));
                
                if(cliente.isTienePoliza()){
                    PolizaDAO polizaDA = new PolizaMySQL();
                    Poliza poliza = polizaDA.obtenerPorId(rs.getInt("ID_Poliza"));
                    cliente.setPoliza(poliza);
                }
                int id_dir = rs.getInt("ID_Direccion");
                if(id_dir != 0){
                    DireccionDAO direccioDA = new DireccionMySQL();
                    Direccion direccion = direccioDA.obtenerPorId(id_dir);
                    cliente.setDireccion(direccion);
                }
                cliente.setCompletado(rs.getBoolean("completado"));
            }
        }
        catch(SQLException ex) {
            System.out.println("Error leyendo datos: " + ex.getMessage()); 
        }
        
        return cliente;
    }

    @Override
    public ArrayList<Cliente> listarTodos() {
    throw new UnsupportedOperationException("Not implemented yet");
    }   
    
}
