package  pe.edu.pucp.FarmaSoft.AtencionSolicitudes.Model;

//import  pe.edu.pucp.FarmaSoft.AtencionPedidos.PedidoPropio;

public class FarmaciaAsociada {
    private int ID;
    private String nombre;
    private int telefono;
    private String correo;
    private Direccion direccion;

    public FarmaciaAsociada(){

    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public void mostrarFarmaciaAsociada(){   //AAAA
        //Muestra los datos de contacto de la farmacia asociada para que le operario C2 pueda delegar el pedido
    }
    
    /*public void delegarSolicitudPedido(PedidoPropio pedidoPropio){   //AAAA
            //Envia el pedido propio a la farmacia asociada para que lo tiendan ellos 
    }
	
	!!!De ser asi, se crea un loop de dependencia. Revisar
	*/
}
