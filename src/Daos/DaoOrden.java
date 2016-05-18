/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Principal.Orden;
import Principal.Producto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Joaquin Martinez
 */
public class DaoOrden extends DaoGeneral {

    private ArrayList<Producto> productos;
    private Orden orden;

    //Para la conexión con la BD:
    PreparedStatement preparedStatement = null;

    //Índices
    int indiceParaIdMenu = 1,
            indiceParaTipoOrden = 2,
            indiceParaIdOrden = 3,
            indiceParaFechaDeCompra = 1;

    public DaoOrden() throws SQLException, ClassNotFoundException {
        super();
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public int obtenerNumeroOrdenSiguiente() throws SQLException {
        String query = "SELECT * FROM orden ORDER BY id DESC LIMIT 1";
        this.statement = this.getConnection().createStatement();
        this.resultSet = this.statement.executeQuery(query);
        int numero = this.resultSet.next() ? this.resultSet.getInt("id") : 0;
        //Cerramos todo:
        resultSet.close();
        statement.close();

        return numero;
    }

    public void insertarEnOrden() throws SQLException {
        //Solo inserta, si hay productos registrados.
        if (this.orden.getListaProductos() != null || !this.orden.getListaProductos().isEmpty()) {
            String insertTableSQL = "INSERT INTO orden"
                    + "(fechaCompra) VALUES"
                    + "(?)";
            java.sql.Date sqlDate = new java.sql.Date(this.orden.getFechaCompra().getTime());
            this.preparedStatement = this.getConnection().prepareStatement(insertTableSQL);
            this.preparedStatement.setDate(indiceParaFechaDeCompra, sqlDate);
            this.preparedStatement.executeUpdate();
            this.preparedStatement.close();

        }
        //obtenemos el id, que la BD le puso:
        orden.setNumeroOrden(this.obtenerNumeroOrdenSiguiente());
        //Agregamos los productos en la tabla "compra":
        insertarProductosDeOrden(orden);
    }

    private void insertarProductosDeOrden(Orden orden) throws SQLException {
        String insertTableSQL = "INSERT INTO compra"
                + "(idMenu, idEstadoOrden, idOrden) VALUES"
                + "(?,?,?)";
        double precioTotal = 0.0;
        for (Producto producto : orden.getListaProductos()) {
            this.preparedStatement = this.getConnection().prepareStatement(insertTableSQL);
            this.preparedStatement.setInt(indiceParaIdMenu, producto.getIdProducto());
            this.preparedStatement.setInt(indiceParaTipoOrden, this.orden.getStatusOrden());
            this.preparedStatement.setInt(indiceParaIdOrden, this.orden.getNumeroOrden());
            precioTotal += producto.getPrecio();
            this.preparedStatement.executeUpdate();
            this.preparedStatement.close();
        }
        orden.setPrecioTotal(precioTotal);
        this.getConnection().close();
    }
}
