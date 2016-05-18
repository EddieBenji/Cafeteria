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
public class Mesero {
    private int idEmpleado;
    private String Nombre;
    private String ApellidoPat;
    private String ApellidoMat;

    public Mesero(int idEmpleado, String Nombre, String ApellidoPat, String ApellidoMat) {
        this.idEmpleado = idEmpleado;
        this.Nombre = Nombre;
        this.ApellidoPat = ApellidoPat;
        this.ApellidoMat = ApellidoMat;
    }
    
    //Getters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidoPat() {
        return ApellidoPat;
    }

    public String getApellidoMat() {
        return ApellidoMat;
    }
    
    //Setters

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidoPat(String ApellidoPat) {
        this.ApellidoPat = ApellidoPat;
    }

    public void setApellidoMat(String ApellidoMat) {
        this.ApellidoMat = ApellidoMat;
    }
    
    //Métodos
    
    
    
    //ToString
    @Override
    public String toString(){
        return "Id del empleado: " + getIdEmpleado() + "\nNombre completo del mesero: " + getNombre() + " " + getApellidoPat() + " " + getApellidoMat();
        
    }
    
    
}
