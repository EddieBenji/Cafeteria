/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Daos.DaoGeneral;
import Principal.Producto;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joaquin Martinez
 */
public class TablaMenu {

    //Para la bd:
    public DaoGeneral dao;
    Statement statement = null;
    ResultSet resultSet = null;

    public ArrayList listaMenu = new ArrayList();

    public void inicializaTabla2(JTable tabla) {
        Vector<String> titulos = new Vector<>();
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Object elementoMenu : listaMenu) {
            Vector<Object> row = new Vector<Object>();
            titulos.add("Id del producto");
            titulos.add("Nombre");
            titulos.add("Clasificacion");
            titulos.add("Precio");
            row.add(((Producto) elementoMenu).getIdProducto());
            row.add(((Producto) elementoMenu).getNombreProducto());
            row.add(((Producto) elementoMenu).getDescripcionProducto());
            row.add(((Producto) elementoMenu).getPrecio());
        }

        DefaultTableModel nuevoModelo = new javax.swing.table.DefaultTableModel(data, titulos);
        this.establecerModeloJTable(nuevoModelo, tabla);

    }

    public void inicializarTabla(JTable tabla) throws SQLException, ClassNotFoundException {
        dao = new DaoGeneral();
        this.statement = dao.getConnection().createStatement();
        String query = "SELECT * FROM menu"; //Obtenemos toda la info de la BD.
        this.resultSet = this.statement.executeQuery(query);

        //Construimos la tabla:
        DefaultTableModel nuevoModelo = buildTableModel(this.resultSet);
        this.establecerModeloJTable(nuevoModelo, tabla);

        //cerramos la conexión:
        this.dao.getConnection().close();
        resultSet.close();
        statement.close();
    }

    private void establecerModeloJTable(DefaultTableModel modelo, JTable tabla) {
        tabla.setModel(modelo);
    }

    public void agregarElemento(int idProducto, String nombreProducto, String descripcionProducto, double precio, int cantidadProducto) {
        listaMenu.add(new Producto(idProducto, nombreProducto, descripcionProducto, precio, cantidadProducto));
    }

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
            System.out.println(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }

    public void llenarTablaProductosOrdenados(JTable tabla, ArrayList<Producto> productos) {
        //Construimos la tabla:
        DefaultTableModel nuevoModelo = populateDateInTable(productos);
        this.establecerModeloJTable(nuevoModelo, tabla);
    }

    private DefaultTableModel populateDateInTable(ArrayList<Producto> productos) {

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID del producto");
        columnNames.add("Nombre del producto");
        columnNames.add("Clasificación");
        columnNames.add("Precio");

        Vector<Vector<Object>> data = new Vector<>();
        for (Producto prod : productos) {
            Vector<Object> vector = new Vector<>();

            vector.add(prod.getIdProducto());
            vector.add(prod.getNombreProducto());
            vector.add(prod.getClasificacionProducto());
            vector.add(prod.getPrecio());

            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
}
