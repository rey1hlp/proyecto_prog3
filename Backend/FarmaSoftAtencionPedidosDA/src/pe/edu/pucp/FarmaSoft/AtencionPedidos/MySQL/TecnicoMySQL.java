/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.FarmaSoft.AtencionPedidos.MySQL;

import pe.edu.pucp.FarmaSoft.AtencionPedidos.Model.Tecnico;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Empleado;
import pe.edu.pucp.FarmaSoft.Usuario.MySQL.EmpleadoMySQL;

/**
 *
 * @author there
 */
public class TecnicoMySQL extends EmpleadoMySQL {

    @Override
    protected Empleado obtenerInstanciaDeModelo() {
        return new Tecnico();
    }

    @Override
    protected String obtenerRolDeModelo() {
        return "Tecnico";
    }   
    
}
