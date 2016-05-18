/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Principal.Orden;
import Principal.Producto;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joaquin Martinez
 */
public class TablaVerOrdenes {
    
     private void establecerModeloJTable(DefaultTableModel modelo, JTable tabla) {
        tabla.setModel(modelo);
    }

    /*Métodos que sirven para llenar la info de la orden actual:*/
    public void llenarTablaProductosOrdenados(JTable tabla, Orden orden) {
        //Construimos la tabla:
        DefaultTableModel nuevoModelo = poblarDatosEnTabla(orden);
        this.establecerModeloJTable(nuevoModelo, tabla);
    }

    private DefaultTableModel poblarDatosEnTabla(Orden orden) {

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Número de orden");
        columnNames.add("Fecha de compra");
        columnNames.add("Clasificación");
        columnNames.add("Precio del producto");

        Vector<Vector<Object>> data = new Vector<>();
        for (Producto prod : orden.getListaProductos()) {
            Vector<Object> vector = new Vector<>();

            vector.add(orden.getNumeroOrden());
            vector.add(prod.getNombreProducto());
            vector.add(prod.getClasificacionProducto());
            vector.add(prod.getPrecio());

            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
    
}
