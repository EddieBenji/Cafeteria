/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.Date;

/**
 *
 * @author Joaquin Martinez
 */
public class Nota {
    private Orden orden;
    private double costoTotal;
    private Date horaYFecha;
    
    //Constructor
    public Nota(Orden orden, double costoTotal, Date horaYFecha) {
        this.orden = orden;
        //this.costoTotal = orden.calcularCostoTotal();
        this.horaYFecha = calcularHoraYFecha();
    }
    
    //Getters

    public Orden getOrden() {
        return orden;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public Date getHoraYFecha() {
        return horaYFecha;
    }
    
    //Setters

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public void setHoraYFecha(Date horaYFecha) {
        this.horaYFecha = horaYFecha;
    }
    
    //Metodos
    
    public Date calcularHoraYFecha(){
        java.util.Date fecha = new Date();
        return fecha;
    }
    
    
    //To string

    @Override
    public String toString() {
        return orden + "\nHora y feha de la orden: " + horaYFecha;
    }
    
}
