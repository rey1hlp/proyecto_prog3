
package pe.edu.pucp.FarmaSoft.Usuario.MySQL;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.SQLException;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Administrador;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Usuario;
import pe.edu.pucp.FarmaSoft.config.DBManager;


/**
 *
 * @author there
 */
public class AdministradorMySQL extends UsuarioMySQL {
    
    @Override
    public int insertar(Usuario admin) {
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
    public Usuario obtenerPorDni(int dni) {
        Usuario admin = new Administrador();
        
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
    public int actualizar(Usuario usuario) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        //parametrosEntrada.put("id", usuario.getId());
        parametrosEntrada.put("_dni_admin", usuario.getDni()); 
        parametrosEntrada.put("_contrasena", usuario.getPassword()); 
        parametrosEntrada.put("_nombre", usuario.getNombre()); 
        parametrosEntrada.put("_apellidoPaterno", usuario.getApellidoPaterno()); 
        parametrosEntrada.put("_apellidoMaterno", usuario.getApellidoMaterno()); 
        parametrosEntrada.put("_telefono", usuario.getTelefono()); 
        parametrosEntrada.put("_estado", usuario.getEstado()); 

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
    public ArrayList<Usuario> listarTodos() {
        ArrayList<Usuario> listaAdmins = new ArrayList<>();
        
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
    
    //@Override
    //public ArrayList<Usuario> listarPorFiltros() {...}
}
