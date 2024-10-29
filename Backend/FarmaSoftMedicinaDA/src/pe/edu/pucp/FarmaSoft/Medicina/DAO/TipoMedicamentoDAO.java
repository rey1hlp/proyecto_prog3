/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.Medicina.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Medicina.Model.TipoMedicamento;

/**
 *
 * @author there
 */
public interface TipoMedicamentoDAO {
    TipoMedicamento obtenerPorId(int id);
    ArrayList<TipoMedicamento> listarTodos();
}
