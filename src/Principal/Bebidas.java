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
public class Bebidas extends Producto{
    private String tipoBebida;
    
    //Constrauctor
    public Bebidas(int idProducto, String nombreProducto, String descripcionProducto, double precio, int cantidadProducto, String tipoBebida) {
        super(idProducto, nombreProducto, descripcionProducto, precio, cantidadProducto);
        this.tipoBebida = tipoBebida;
    }
    
    //Getters

    public String getTipoBebida() {
        return tipoBebida;
    }
    
    //Setters

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }
    
    //Metodos
    
    //To String
}
