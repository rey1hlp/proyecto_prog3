/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Solicitud;

/**
 *
 * @author User
 */
public interface SolicitudDAO {
    int insertar(Solicitud solicitud);
    ArrayList<Solicitud> listarTodas();
    Solicitud obtenerPorId(int idSolicitud);
    int eliminar(int idSolicitud);
    int actualizar(Solicitud solicitud);
}
