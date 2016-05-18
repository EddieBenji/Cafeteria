/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author Joaquin Martinez
 */
public class Producto {

    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto, clasificacionProducto;
    private double precio;
    private int cantidadProducto;

    //Constructor
    public Producto(int idProducto, String nombreProducto, String descripcionProducto, double precio, int cantidadProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precio = precio;
        this.cantidadProducto = cantidadProducto;
    }

    public Producto(int idProducto, String nombreProducto, String clasificacion, double precio) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.clasificacionProducto = clasificacion;
        this.precio = precio;

    }

    //Getters
    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    //Setters
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
    
    

    //Metodos
    //To String
    @Override
    public String toString() {
        return "Id del producto: " + idProducto + "  nombreProducto: " + nombreProducto + "  descripcionProducto: " + descripcionProducto + "  precio: " + precio + ", cantidadProducto: " + cantidadProducto + "\n";
    }

    public String getClasificacionProducto() {
        return clasificacionProducto;
    }

    public void setClasificacionProducto(String clasificacionProducto) {
        this.clasificacionProducto = clasificacionProducto;
    }

}
