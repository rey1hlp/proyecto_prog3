package pe.edu.pucp.FarmaSoft.Medicina.Model;

public class MedicinaPropia extends MedicinaGeneral {
    //private int codigo;    //Este no funciona en el C#
    private int id;
    private double precio;
    private int stock;
    
    public MedicinaPropia() {
            super();
    }
   
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
//    public int getcodigo() {
//        return codigo;
//    }
//    public void setCodigo(int codigo) {
//        this.codigo = codigo;
//    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public void consultarDatos(){
    
    }
}
