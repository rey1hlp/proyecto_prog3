
package pe.edu.pucp.FarmaSoft.Usuario.MySQL;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Administrador;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Usuario;
import pe.edu.pucp.FarmaSoft.Usuario.DAO.AdministradorDAO;
import pe.edu.pucp.FarmaSoft.config.DBManager;


/**
 *
 * @author there
 */
public class AdministradorMySQL implements AdministradorDAO {
    private ResultSet rs;
    
    @Override
    public int insertar(Administrador admin) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        //parametrosEntrada.put("id", usuario.getId());
        parametrosEntrada.put("_dni_admin", admin.getDni()); 
        parametrosEntrada.put("_contrasena", admin.getPassword()); 
        parametrosEntrada.put("_nombre", admin.getNombre()); 
        parametrosEntrada.put("_apellidoPaterno", admin.getApellidoPaterno()); 
        parametrosEntrada.put("_apellidoMaterno", admin.getApellidoMaterno()); 
        parametrosEntrada.put("_telefono", admin.getTelefono()); 
        parametrosEntrada.put("_estado", admin.getEstado()); 

        int resultado = DBManager.getInstance().ejecutarProcedimiento("insertar_administrador",
                parametrosEntrada, null);
        
        return resultado;
    }
    
    @Override
    public Administrador obtenerPorDni(int dni) {
        Administrador admin = new Administrador();
        
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("_dni_admin", dni); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPorDni_administrador",
                parametrosEntrada);
        
        try {
            if(rs.next()) {
                admin.setDNI(rs.getInt("DNI"));
                admin.setPassword(rs.getString("contrasena"));
                admin.setNombre(rs.getString("nombre"));
                admin.setApellidoPaterno(rs.getString("apellidoPaterno"));
                admin.setApellidoMaterno(rs.getString("apellidoMaterno"));
                admin.setTelefono(rs.getInt("telefono"));
                admin.setEstado(rs.getBoolean("estado"));
            }
        } catch(SQLException ex) {
            System.out.println("Error en la obtencion de datos: " + ex.getMessage());
        }
        
        return admin;
    }
    
    @Override
    public int actualizar(Administrador admin) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        //parametrosEntrada.put("id", usuario.getId());
        parametrosEntrada.put("_dni_admin", admin.getDni()); 
        parametrosEntrada.put("_contrasena", admin.getPassword()); 
        parametrosEntrada.put("_nombre", admin.getNombre()); 
        parametrosEntrada.put("_apellidoPaterno", admin.getApellidoPaterno()); 
        parametrosEntrada.put("_apellidoMaterno", admin.getApellidoMaterno()); 
        parametrosEntrada.put("_telefono", admin.getTelefono()); 
        parametrosEntrada.put("_estado", admin.getEstado()); 

        int resultado = DBManager.getInstance().ejecutarProcedimiento("actualizar_administrador",
                parametrosEntrada, null);
        
        return resultado;
    }
    
    @Override
    public int eliminar(int dni) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        //parametrosEntrada.put("id", usuario.getId());
        parametrosEntrada.put("_dni_admin", dni);
        
        int resultado = DBManager.getInstance().ejecutarProcedimiento("eliminar_administrador",
                parametrosEntrada, null);
        
        return resultado;
    }
    
    @Override
    public int darDeBaja(int dni) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        
        parametrosEntrada.put("_dni_admin", dni);
        parametrosEntrada.put("_estado", false);
        
        int resultado = DBManager.getInstance().ejecutarProcedimiento("cambiarEstado_administrador",
                parametrosEntrada, null);
        
        return resultado;
    }
    
    
    @Override
    public int darDeAlta(int dni) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        
        parametrosEntrada.put("_dni_admin", dni);
        parametrosEntrada.put("_estado", true);
        
        int resultado = DBManager.getInstance().ejecutarProcedimiento("cambiarEstado_administrador",
                parametrosEntrada, null);
        
        return resultado;
    }

    @Override
    public ArrayList<Administrador> listarTodos() {
        ArrayList<Administrador> listaAdmins = new ArrayList<>();
        
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarTodos_administrador",
                null);
        
        try {
            while(rs.next()) {
                Administrador admin = new Administrador();
                admin.setDNI(rs.getInt("DNI"));
                admin.setPassword(rs.getString("contrasena"));
                admin.setNombre(rs.getString("nombre"));
                admin.setApellidoPaterno(rs.getString("apellidoPaterno"));
                admin.setApellidoMaterno(rs.getString("apellidoMaterno"));
                admin.setTelefono(rs.getInt("telefono"));
                admin.setEstado(rs.getBoolean("estado"));
                
                listaAdmins.add(admin);
            }
        } catch(SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        
        return listaAdmins;
    }
    
    @Override
    public ArrayList<Administrador> listarPorFiltros(Integer dni_admin,
            String nombre, String apellidoPaterno, String apellidoMaterno,
            Integer telefono, Boolean estado) {
        
        ArrayList<Administrador> listaAdmins = new ArrayList<>();
        ArrayList<Object> parametros = new ArrayList<>();
        StringBuilder sql = new StringBuilder("{SELECT * FROM Administrador WHERE 1=1");
        
        if(dni_admin != null) {
            sql.append(" AND DNI LIKE ?");
            parametros.add(dni_admin);
        }
        
        if(nombre != null && !nombre.isEmpty()) {
            sql.append(" AND nombre LIKE ?");
            parametros.add(nombre);
        }
        
        if(apellidoPaterno != null && !apellidoPaterno.isEmpty()) {
            sql.append(" AND apellidoPaterno LIKE ?");
            parametros.add(apellidoPaterno);
        }
        
        if(apellidoMaterno != null && !apellidoMaterno.isEmpty()) {
            sql.append(" AND apellidoMaterno LIKE ?");
            parametros.add(apellidoMaterno);
        }
        
        if(telefono != null) {
            sql.append(" AND telefono LIKE ?");
            parametros.add(telefono);
        }
        
        if(estado != null) {
            sql.append(" AND estado = ?");
            parametros.add(estado);
        }
        
        sql.append("}");
        
        try {
            Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            
            for(int i=1;i<=parametros.size();i++) {
                Object valor = parametros.get(i-1);
                
                switch (valor) {
                    case Integer entero -> ps.setInt(i, entero);
                    case String cadena -> ps.setString(i, cadena);
                    case Double decimal -> ps.setDouble(i, decimal);
                    case Boolean booleano -> ps.setBoolean(i, booleano);
                    default -> {
                            ps.setString(i, valor.toString());
                    }
                }
            }
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                Administrador admin = new Administrador();
                admin.setDNI(rs.getInt("DNI"));
                admin.setPassword(rs.getString("contrasena"));
                admin.setNombre(rs.getString("nombre"));
                admin.setApellidoPaterno(rs.getString("apellidoPaterno"));
                admin.setApellidoMaterno(rs.getString("apellidoMaterno"));
                admin.setTelefono(rs.getInt("telefono"));
                admin.setEstado(rs.getBoolean("estado"));
                
                listaAdmins.add(admin);
            }
            
        } catch(SQLException ex) {
            System.out.println("Error en consulta: " + ex.getMessage());
        }
        
        
        return null;
    }
}
