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
public class Postres extends Producto{
    private String tipoPostre;
    
    //Constructor

    public Postres(int idProducto, String nombreProducto, String descripcionProducto, double precio, int cantidadProducto, String tipoPostre) {
        super(idProducto, nombreProducto, descripcionProducto, precio, cantidadProducto);
        this.tipoPostre = tipoPostre;
    }
    
    //Getters

    public String getTipoPostre() {
        return tipoPostre;
    }
    
    //Setters

    public void setTipoPostre(String tipoPostre) {
        this.tipoPostre = tipoPostre;
    }
    
    //Métodos
    
    //To String
}
