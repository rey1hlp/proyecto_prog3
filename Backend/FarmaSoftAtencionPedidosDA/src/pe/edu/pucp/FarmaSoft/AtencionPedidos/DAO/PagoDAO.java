/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.AtencionPedidos.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.Pago;

/**
 *
 * @author User
 */
public interface PagoDAO {
    int insertar(Pago pago);
    ArrayList<Pago> listarTodas();
    Pago obtenerPorId(int idPago);
    int eliminar(int idPago);
    int actualizar(Pago pago);
}
