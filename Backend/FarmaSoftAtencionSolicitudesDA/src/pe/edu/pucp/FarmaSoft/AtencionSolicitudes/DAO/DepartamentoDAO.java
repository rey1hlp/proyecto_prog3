/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Departamento;

/**
 *
 * @author there
 */
public interface DepartamentoDAO {
    Departamento obtenerPorId(int id);
    ArrayList<Departamento> listarTodos();
}
