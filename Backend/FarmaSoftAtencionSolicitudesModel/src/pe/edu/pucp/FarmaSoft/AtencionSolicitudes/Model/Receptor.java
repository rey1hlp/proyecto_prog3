package  pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model;

import pe.edu.pucp.FarmaSoft.Medicina.Model.MedicinaGeneral;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Empleado;
import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Usuario.Model.RolEmpleado;

public class Receptor extends Empleado{
	private ArrayList<Solicitud> solicitudesAtendidas;

	public Receptor(){
            super();
            rol = RolEmpleado.Receptor;
	}
        
        @Override
	public void consultarDatos(){
		//Implementa método de la interfaz IConsultable
	}
	public void generaSolicitud(Solicitud solicitud){
            //Añade una nueva 
        } 
	public void atenderSolicitud(int ID){
        }
	public void eliminarSolicitud(int ID){
        }
	public void llenarDatosPaciente(int ID){
        }
        public void llenarListaMedicamentos(MedicinaGeneral medicina){
        }
	public void cargarDocumentos(int ID){
        }
	public void asignarFarmacia(int ID){          //Lima o provincia
        }	
        public void generarPedido(int ID){   
        } 		//

}
