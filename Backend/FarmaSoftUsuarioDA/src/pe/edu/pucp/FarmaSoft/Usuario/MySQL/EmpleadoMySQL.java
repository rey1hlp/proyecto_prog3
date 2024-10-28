
package pe.edu.pucp.FarmaSoft.Usuario.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.SQLException;
import java.util.Date;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.Tecnico;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Intermediario;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Receptor;
import pe.edu.pucp.FarmaSoft.Usuario.DAO.EmpleadoDAO;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Administrador;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Empleado;
import pe.edu.pucp.FarmaSoft.Usuario.Model.RolEmpleado;
import pe.edu.pucp.FarmaSoft.config.DBManager;

public class EmpleadoMySQL implements EmpleadoDAO {
    private ResultSet rs;
    
    @Override
    public int insertar(Empleado empleado) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        //parametrosEntrada.put("id", empleado.getId());
        parametrosEntrada.put("_dni_emp", empleado.getDni());
        parametrosEntrada.put("_dni_jefe", empleado.getJefe().getDni());
        parametrosEntrada.put("_fechaIngreso", empleado.getFechaIngreso());
        parametrosEntrada.put("_rol", empleado.getRol().toString());
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
        Empleado empleado = null;
        
        HashMap<String,Object> parametrosEntrada = new HashMap<>(); 
        parametrosEntrada.put("_dni_emp", dni); 
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPorDni_empleado",
                parametrosEntrada);
        
        try {
            if(rs.next()) {
                empleado = obtenerInstanciaDeModelo(RolEmpleado.valueOf(rs.getString("rol")));
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
    public int actualizar(Empleado empleado) {
        HashMap<String,Object> parametrosEntrada = new HashMap<>();
        
        //parametrosEntrada.put("id", empleado.getId());
        parametrosEntrada.put("_dni_emp", empleado.getDni()); 
        parametrosEntrada.put("_dni_jefe", empleado.getJefe().getDni());
        parametrosEntrada.put("_fechaIngreso", empleado.getFechaIngreso());
        parametrosEntrada.put("_rol", empleado.getRol().toString());
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
                Empleado empleado = obtenerInstanciaDeModelo(RolEmpleado.valueOf(rs.getString("rol")));
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

    @Override
    public ArrayList<Empleado> listarPorFiltros(Integer dni_emp, String nombre,
            String apellidoPaterno, String apellidoMaterno, Integer telefono,
            Boolean estado, Date fechaMin, Date fechaMax, Integer dni_jefe,
            RolEmpleado rol) {
        
        ArrayList<Empleado> listaEmp = new ArrayList<>();
        ArrayList<Object> parametros = new ArrayList<>();
        StringBuilder sql = new StringBuilder("{SELECT * FROM Empleado WHERE 1=1");
        
        if(dni_emp != null) {
            sql.append(" AND DNI LIKE ?");
            parametros.add(dni_emp);
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
        
        if(fechaMin != null) {
            sql.append(" AND fechaIngreso >= ?");
            parametros.add(fechaMin);
        }
        
        if(fechaMax != null) {
            sql.append(" AND fechaIngreso <= ?");
            parametros.add(fechaMax);
        }
        
        if(dni_jefe != null) {
            sql.append(" AND dni_jefe = ?");
            parametros.add(dni_jefe);
        }
        
        if(rol != null) {
            sql.append(" AND rol = ?");
            parametros.add(rol);
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
                    case java.util.Date fecha -> ps.setDate(i, new java.sql.Date(fecha.getTime()));
                    default -> {
                            ps.setString(i, valor.toString());
                    }
                }
            }
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                Empleado empleado = obtenerInstanciaDeModelo(RolEmpleado.valueOf(rs.getString("rol")));
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
                
                listaEmp.add(empleado);
            }
            
        } catch(SQLException ex) {
            System.out.println("Error en consulta: " + ex.getMessage());
        }
        
        return listaEmp;
    }
    
    private Empleado obtenerInstanciaDeModelo(RolEmpleado rol) {
        switch(rol) {
            case RolEmpleado.Intermediario -> {return new Intermediario();}
            case RolEmpleado.Receptor -> {return new Receptor();}
            case RolEmpleado.Tecnico -> {return new Tecnico();}
        }
        
        return null;
    }
}
