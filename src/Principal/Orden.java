/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joaquin Martinez
 */
public class Orden {

    private int numeroOrden;//Es el id que se guardará en la BD.
    private String statusOrden;
    private ArrayList<Producto> listaProductos;
    private double precioTotal;
    private Date fechaCompra;

    public Orden(String statusOrden, ArrayList<Producto> listaProductos) {
        this.statusOrden = statusOrden;
        this.listaProductos = listaProductos;
        this.precioTotal = 0;
        //la fecha de compra es el momento en que se hace la orden:
        fechaCompra = new Date();
    }

    public Orden(int numeroOrden, String statusOden, Date fechaCompra, double precioTotal) {
        this.numeroOrden = numeroOrden;
        this.statusOrden = statusOden;
        this.fechaCompra = fechaCompra;
        this.precioTotal = precioTotal;
    }

    public Orden(int numeroOrden, String statusOden, String fechaCompra, double precioTotal) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.fechaCompra = formatter.parse(fechaCompra);
        this.numeroOrden = numeroOrden;
        this.statusOrden = statusOden;
        this.precioTotal = precioTotal;
    }

    //Getters
    public String getStatusOrden() {
        return statusOrden;
    }

    public void setStatusOrden(String statusOrden) {
        this.statusOrden = statusOrden;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    //Setters
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    //Método
    public double calcularCostoTotal() {
        precioTotal = 0;
        for (Producto producto : listaProductos) {
            precioTotal += producto.getPrecio();
        }
        return precioTotal;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    //To string
    @Override
    public String toString() {
        return "Orden: " + numeroOrden
                + "\nLista de Productos\n" + listaProductos
                + "\nPrecioTotal: " + precioTotal;
    }
}
