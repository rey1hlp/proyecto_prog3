/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO;

import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Poliza;

/**
 *
 * @author User
 */
public interface PolizaDAO {
    Poliza obtenerPorId(int idPoliza);
    int actualizar(Poliza poliza);
    int insertar(Poliza poliza);
}
