/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.AtencionSolicitudes.MySQL;

import pe.edu.pucp.FarmaSoft.Usuario.Model.Empleado;
import pe.edu.pucp.FarmaSoft.Usuario.MySQL.EmpleadoMySQL;
import pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model.Intermediario;

/**
 *
 * @author there
 */
public class IntermediarioMySQL extends EmpleadoMySQL{

    @Override
    protected Empleado obtenerInstanciaDeModelo() {
        return new Intermediario();
    }

    @Override
    protected String obtenerRolDeModelo() {
        return "Intermediario";
    }   
}
