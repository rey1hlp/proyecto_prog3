
package  pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Empleado;

public class Intermediario extends Empleado {
    private ArrayList<Solicitud> solicitudesGeneradas;
    
    public Intermediario(){
        super();
    }
}
