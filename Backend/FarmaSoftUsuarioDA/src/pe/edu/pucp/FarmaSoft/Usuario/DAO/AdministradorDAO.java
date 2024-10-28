/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.Usuario.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Administrador;

/**
 *
 * @author there
 */
public interface AdministradorDAO {
    int insertar(Administrador usuario);
    Administrador obtenerPorDni(int dni);
    int actualizar(Administrador usuario);
    int eliminar(int dni);
    
    int darDeBaja(int dni);
    int darDeAlta(int dni);
    ArrayList<Administrador> listarTodos();
    ArrayList<Administrador> listarPorFiltros(
        Integer dni_admin, String nombre, String apellidoPaterno,
            String apellidoMaterno, Integer telefono, Boolean estado);
}
