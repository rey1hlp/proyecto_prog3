package  pe.edu.pucp.FarmaSoft.Usuario.Model;

import java.util.Date;
import java.util.ArrayList;

public class DiaLaboral{
    private Date fechaDia;
    private int solicitudesAtendidas;
    private int pedidosAtendidos;
    private double ventasGeneradas;
    private ArrayList<Sesion> sesiones;
    
    public DiaLaboral(){}
    
    public DiaLaboral(Date fechaDia,int solicitudesAtendidas,int pedidosAtendidos,
            double ventasGeneradas){
        this.fechaDia=fechaDia;
        this.solicitudesAtendidas=solicitudesAtendidas;
        this.pedidosAtendidos=pedidosAtendidos;
        this.ventasGeneradas=ventasGeneradas;
    }

    public Date getFechaDia() {
        return fechaDia;
    }

    public void setFechaDia(Date fechaDia) {
        this.fechaDia = fechaDia;
    }

    public int getSolicitudesAtendidas() {
        return solicitudesAtendidas;
    }

    public void setSolicitudesAtendidas(int solicitudesAtendidas) {
        this.solicitudesAtendidas = solicitudesAtendidas;
    }

    public int getPedidosAtendidos() {
        return pedidosAtendidos;
    }

    public void setPedidosAtendidos(int pedidosAtendidos) {
        this.pedidosAtendidos = pedidosAtendidos;
    }

    public double getVentasGeneradas() {
        return ventasGeneradas;
    }

    public void setVentasGeneradas(double ventasGeneradas) {
        this.ventasGeneradas = ventasGeneradas;
    }

    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(ArrayList<Sesion> sesiones) {
        this.sesiones = sesiones;
    }
    
}
