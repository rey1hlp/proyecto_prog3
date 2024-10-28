/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.Usuario.DAO;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Empleado;
import pe.edu.pucp.FarmaSoft.Usuario.Model.RolEmpleado;

/**
 *
 * @author there
 */
public interface EmpleadoDAO {
    int insertar(Empleado usuario);
    Empleado obtenerPorDni(int dni);
    int actualizar(Empleado usuario);
    int eliminar(int dni);
    
    int darDeBaja(int dni);
    int darDeAlta(int dni);
    ArrayList<Empleado> listarTodos();
    ArrayList<Empleado> listarPorFiltros(
        Integer dni_emp, String nombre, String apellidoPaterno,
            String apellidoMaterno, Integer telefono, Boolean estado,
            Date fechaMin, Date fechaMax, Integer dni_jefe, RolEmpleado rol);
}
