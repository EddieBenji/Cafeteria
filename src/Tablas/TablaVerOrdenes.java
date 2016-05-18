/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Principal.Orden;
import java.util.ArrayList;
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
    public void llenarTablaProductosOrdenados(JTable tabla, ArrayList<Orden> ordenes) {
        //Construimos la tabla:
        DefaultTableModel nuevoModelo = poblarDatosEnTabla(ordenes);
        this.establecerModeloJTable(nuevoModelo, tabla);
    }

    private DefaultTableModel poblarDatosEnTabla(ArrayList<Orden> ordenes) {

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Número de orden");
        columnNames.add("Estado");
        columnNames.add("Fecha de compra");
        columnNames.add("Precio del producto");

        Vector<Vector<Object>> data = new Vector<>();
        for (Orden orden : ordenes) {
            Vector<Object> vector = new Vector<>();

            vector.add(orden.getNumeroOrden());
            vector.add(orden.getStatusOrden());
            vector.add(orden.getFechaCompra());
            vector.add(orden.getPrecioTotal());
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }

}
