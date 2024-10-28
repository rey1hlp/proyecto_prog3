
package  pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Empleado;
import pe.edu.pucp.FarmaSoft.Usuario.Model.RolEmpleado;

public class Intermediario extends Empleado {
    private ArrayList<Solicitud> solicitudesGeneradas;
    
    public Intermediario(){
        super();
        rol = RolEmpleado.Intermediario;
    }
}
