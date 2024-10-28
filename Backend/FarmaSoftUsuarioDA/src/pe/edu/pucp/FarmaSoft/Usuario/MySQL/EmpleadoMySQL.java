
package pe.edu.pucp.FarmaSoft.Usuario.MySQL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.SQLException;
import pe.edu.pucp.FarmaSoft.Usuario.DAO.EmpleadoDAO;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Administrador;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Empleado;
import pe.edu.pucp.FarmaSoft.config.DBManager;

public abstract class EmpleadoMySQL implements EmpleadoDAO {
    private ResultSet rs;
    
    @Override
    public int insertar(Empleado empleado) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        //parametrosEntrada.put("id", empleado.getId());
        parametrosEntrada.put("_dni_emp", empleado.getDni());
        parametrosEntrada.put("_dni_jefe", empleado.getJefe().getDni());
        parametrosEntrada.put("_fechaIngreso", empleado.getFechaIngreso());
        parametrosEntrada.put("_rol", obtenerRolDeModelo());
        parametrosEntrada.put("_contrasena", empleado.getPassword()); 
        parametrosEntrada.put("_nombre", empleado.getNombre()); 
        parametrosEntrada.put("_apellidoPaterno", empleado.getApellidoPaterno()); 
        parametrosEntrada.put("_apellidoMaterno", empleado.getApellidoMaterno()); 
        parametrosEntrada.put("_telefono", empleado.getTelefono()); 
        parametrosEntrada.put("_estado", empleado.getEstado()); 

        int resultado = DBManager.getInstance().ejecutarProcedimiento("insertar_empleado",
                parametrosEntrada, null);
        
        return resultado;
    }
    
    @Override
    public Empleado obtenerPorDni(int dni) {
        Empleado empleado = obtenerInstanciaDeModelo();
        
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("_dni_emp", dni); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPorDni_empleado",
                parametrosEntrada);
        
        try {
            if(rs.next()) {
                empleado.setDNI(rs.getInt("DNI"));
                
                Administrador admin = new Administrador();
                admin.setDNI(rs.getInt("DNI_Jefe"));
                empleado.setJefe(admin);
                
                empleado.setPassword(rs.getString("contrasena"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellidoPaterno(rs.getString("apellidoPaterno"));
                empleado.setApellidoMaterno(rs.getString("apellidoMaterno"));
                empleado.setTelefono(rs.getInt("telefono"));
                empleado.setEstado(rs.getBoolean("estado"));
            }
        } catch(SQLException ex) {
            System.out.println("Error en la obtencion de datos: " + ex.getMessage());
        }
        
        return empleado;
    }
    
    @Override
    public int actualizar(Empleado usuario) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        Empleado empleado = (Empleado) usuario;
        
        //parametrosEntrada.put("id", empleado.getId());
        parametrosEntrada.put("_dni_emp", empleado.getDni()); 
        parametrosEntrada.put("_dni_jefe", empleado.getJefe().getDni());
        parametrosEntrada.put("_fechaIngreso", empleado.getFechaIngreso());
        parametrosEntrada.put("_rol", obtenerRolDeModelo());
        parametrosEntrada.put("_contrasena", empleado.getPassword());
        parametrosEntrada.put("_nombre", empleado.getNombre()); 
        parametrosEntrada.put("_apellidoPaterno", empleado.getApellidoPaterno()); 
        parametrosEntrada.put("_apellidoMaterno", empleado.getApellidoMaterno()); 
        parametrosEntrada.put("_telefono", empleado.getTelefono()); 
        parametrosEntrada.put("_estado", empleado.getEstado()); 

        int resultado = DBManager.getInstance().ejecutarProcedimiento("actualizar_empleado",
                parametrosEntrada, null);
        
        return resultado;
    }
    
    @Override
    public int eliminar(int dni) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        //parametrosEntrada.put("id", usuario.getId());
        parametrosEntrada.put("_dni_emp", dni);
        
        int resultado = DBManager.getInstance().ejecutarProcedimiento("eliminar_empleado",
                parametrosEntrada, null);
        
        return resultado;
    }
    
    @Override
    public int darDeBaja(int dni) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        
        parametrosEntrada.put("_dni_emp", dni);
        parametrosEntrada.put("_estado", false);
        
        int resultado = DBManager.getInstance().ejecutarProcedimiento("cambiarEstado_empleado",
                parametrosEntrada, null);
        
        return resultado;
    }
    
    @Override
    public int darDeAlta(int dni) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        
        parametrosEntrada.put("_dni_emp", dni);
        parametrosEntrada.put("_estado", true);
        
        int resultado = DBManager.getInstance().ejecutarProcedimiento("cambiarEstado_empleado",
                parametrosEntrada, null);
        
        return resultado;
    }
    
    @Override
    public ArrayList<Empleado> listarTodos() {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarTodos_empleado",
                null);
        
        try {
            while(rs.next()) {
                Empleado empleado = obtenerInstanciaDeModelo();
                empleado.setDNI(rs.getInt("DNI"));
                
                Administrador admin = new Administrador();
                admin.setDNI(rs.getInt("DNI_Jefe"));
                empleado.setJefe(admin);
                
                empleado.setPassword(rs.getString("contrasena"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellidoPaterno(rs.getString("apellidoPaterno"));
                empleado.setApellidoMaterno(rs.getString("apellidoMaterno"));
                empleado.setTelefono(rs.getInt("telefono"));
                empleado.setEstado(rs.getBoolean("estado"));
                
                listaEmpleados.add(empleado);
            }
        } catch(SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        
        return listaEmpleados;
    }
    
    //@Override
    //public ArrayList<Empleado> listarPorFiltros() {...}
    
    protected abstract String obtenerRolDeModelo();
    protected abstract Empleado obtenerInstanciaDeModelo();
}
