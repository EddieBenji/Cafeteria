/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joaquin Martinez
 */
public class Orden {
 
    private String statusOrden;
    private ArrayList<Producto> listaProductos;
    private Mesero mesero;
    private int numeroOrden;
    double precioTotal = 0;
   

    public Orden(String statusOrden, ArrayList<Producto> listaProductos, Mesero mesero, int numeroOrden) {
        this.statusOrden = statusOrden;
        this.listaProductos = listaProductos;
        this.mesero = mesero;
        this.numeroOrden = numeroOrden;
    }
    
    //Getters

    public String getStatusOrden() {
        return statusOrden;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }
    
    //Setters

    public void setStatusOrden(String statusOrden) {
        this.statusOrden = statusOrden;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }
    
    
    //Método
    
    public double calcularCostoTotal(){
        for(int i=0; i<listaProductos.size(); i++){
            precioTotal = precioTotal + ((listaProductos.get(i).getPrecio()) * (listaProductos.get(i).getCantidadProducto()));
        }
        return precioTotal;
    }
    
     public Date calcularHoraYFecha(){
        java.util.Date fecha = new Date();
        return fecha;
    }
    
    //To string

    @Override
    public String toString() {
        return "Orden: " + numeroOrden + "\nLista de Productos\n" + listaProductos + "\nMesero\n" + mesero + "\nPrecioTotal: " + precioTotal;
    }
    
    
}
