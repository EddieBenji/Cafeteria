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
public class Comidas extends Producto{
    private String tipoComida;
    
    //Constructor

    public Comidas(int idProducto, String nombreProducto, String descripcionProducto, double precio, int cantidadProducto, String tipoComida) {
        super(idProducto, nombreProducto, descripcionProducto, precio, cantidadProducto);
        this.tipoComida = tipoComida;
    }
    
    //Getters

    public String getTipoComida() {
        return tipoComida;
    }
    
    //Setters

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }
    
    //Métodos 
    
    //To String
    
    
}
