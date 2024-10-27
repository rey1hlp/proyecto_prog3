package  pe.edu.pucp.FarmaSoft.Usuario.Model;

import java.time.LocalTime;
import java.util.Date;

public class Sesion{
    private Date fechaDia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int atencionesHechas;
    private Empleado empleado;

    public Sesion(Date fechaDia,LocalTime horaInicio,LocalTime horaFin,
            int atencionesHechas){
        this.fechaDia=fechaDia;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
        this.atencionesHechas=atencionesHechas;
    }
    public Sesion(Date fechaDia,LocalTime horaInicio,LocalTime horaFin,
            int atencionesHechas,Empleado empleado){
        this.fechaDia=fechaDia;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
        this.atencionesHechas=atencionesHechas;
        this.empleado=empleado;
    }
    
    public Date getFechaDia(){
        return fechaDia;
    }
    
    public void setFechaDia(Date fechaDia){
        this.fechaDia=fechaDia;
    }
    
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getAtencionesHechas() {
        return atencionesHechas;
    }

    public void setAtencionesHechas(int atencionesHechas) {
        this.atencionesHechas = atencionesHechas;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
