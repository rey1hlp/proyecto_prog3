/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.AtencionPedidos.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.PedidoPropio;

/**
 *
 * @author User
 */
public interface PedidoPropioDAO {
    int insertar(PedidoPropio pedidoPropio);
    ArrayList<PedidoPropio> listarTodas();
    PedidoPropio obtenerPorId(int idPedidoPropio);
    int eliminar(int idPedidoPropio);
    int actualizar(PedidoPropio pedidoPropio);
}
