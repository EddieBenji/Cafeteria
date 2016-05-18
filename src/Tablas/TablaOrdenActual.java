/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Principal.Producto;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joaquin Martinez
 */
public class TablaOrdenActual {
    public ArrayList ArregloOrdenActual = new ArrayList();
    
    
     public void agregarElemento(int idProducto, String nombreProducto,
             String descripcionProducto, double precio, int cantidadProducto){
         
        ArregloOrdenActual.add(new Producto(idProducto, nombreProducto, 
                descripcionProducto, precio, cantidadProducto));
        
    }
     public void emliminarElemento(int indice){
        ArregloOrdenActual.remove(indice);        
    }
     
      public void inicializaTabla(JTable tabla){
        Vector <String> titulos = new Vector<String>();
        Vector <Vector <Object>> data = new Vector <Vector <Object>>();
        
        
        for (Object orden : ArregloOrdenActual) {
            Vector<Object> row = new Vector<Object>();
            titulos.add("Id del producto");
            titulos.add("Nombre");
            titulos.add("Descripcion");
            titulos.add("Precio");
            titulos.add("Cantidad");
            row.add(((Producto) orden).getIdProducto());
            row.add(((Producto) orden).getNombreProducto());
            row.add(((Producto) orden).getDescripcionProducto());
            row.add(((Producto) orden).getPrecio());
            row.add(((Producto) orden).getCantidadProducto());
            data.add(row);            
        }
        
        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(data, titulos);
        this.establecerModeloJTable(modelo, tabla);              
    }
      
       
      
       private void establecerModeloJTable(DefaultTableModel modelo, JTable tabla){
        tabla.setModel(modelo);
    }
}
