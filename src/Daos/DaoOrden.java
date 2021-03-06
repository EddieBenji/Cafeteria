/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Principal.Orden;
import Principal.Producto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Joaquin Martinez
 */
public class DaoOrden extends DaoGeneral {

    private ArrayList<Producto> productos;
    private Orden orden;

    //Índices
    int indiceParaIdMenu = 1,
            indiceParaIdOrden = 2,
            indiceParaFechaDeCompra = 1,
            indiceParaEstadoOrden = 2,
            indiceParaPrecioTotal = 3;

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

    public void eliminarDeOrden(Orden orden) throws SQLException {
        String deleteSQL = "DELETE FROM orden WHERE id = ?";
        preparedStatement = this.getConnection().prepareStatement(deleteSQL);
        this.preparedStatement.setInt(1, orden.getNumeroOrden());
        preparedStatement.executeUpdate();
    }

    public void insertarEnOrden() throws SQLException {
        //Solo inserta, si hay productos registrados.
        if (this.orden.getListaProductos() != null || !this.orden.getListaProductos().isEmpty()) {
            String insertTableSQL = "INSERT INTO orden"
                    + "(fechaCompra, estado, precioTotal) VALUES"
                    + "(?,?,?)";
            java.sql.Date sqlDate = new java.sql.Date(this.orden.getFechaCompra().getTime());
            this.preparedStatement = this.getConnection().prepareStatement(insertTableSQL);
            this.preparedStatement.setDate(indiceParaFechaDeCompra, sqlDate);
            this.preparedStatement.setString(indiceParaEstadoOrden, orden.getStatusOrden());
            this.preparedStatement.setDouble(indiceParaPrecioTotal, this.orden.calcularCostoTotal());
            this.preparedStatement.executeUpdate();
            this.preparedStatement.close();
        }
        //obtenemos el id, que la BD le puso:
        orden.setNumeroOrden(this.obtenerNumeroOrdenSiguiente());
        //Agregamos los productos en la tabla "compra":
        insertarProductosDeOrden(orden);
    }

    public void insertarProductosDeOrden(Orden orden) throws SQLException {
        String insertTableSQL = "INSERT INTO compra"
                + "(idMenu, idOrden) VALUES"
                + "(?,?)";
        double precioTotal = 0.0;
        for (Producto producto : orden.getListaProductos()) {
            this.preparedStatement = this.getConnection().prepareStatement(insertTableSQL);
            this.preparedStatement.setInt(indiceParaIdMenu, producto.getIdProducto());
            this.preparedStatement.setInt(indiceParaIdOrden, orden.getNumeroOrden());
            precioTotal += producto.getPrecio();
            this.preparedStatement.executeUpdate();
            this.preparedStatement.close();
        }
        orden.setPrecioTotal(precioTotal);
        this.getConnection().close();
    }

    public ArrayList<Orden> obtenerTodas() throws SQLException {
        this.statement = this.getConnection().createStatement();
        String query = "SELECT * FROM orden"; //Obtenemos toda la info de la BD.
        this.resultSet = this.statement.executeQuery(query);

        ArrayList<Orden> ordenes = new ArrayList<>();
        while (resultSet.next()) {

            ordenes.add(
                    new Orden(
                            resultSet.getInt(1),
                            resultSet.getString(3),
                            resultSet.getDate(2),
                            resultSet.getDouble(4)
                    )
            );

        }
        //cerramos la conexión:

        return ordenes;
    }

    public void actualizarPrecioTotal(Orden orden) throws SQLException {
        String updateTableSQL = "UPDATE orden SET precioTotal = ? WHERE id = ?";
        preparedStatement = this.getConnection().prepareStatement(updateTableSQL);
        preparedStatement.setDouble(1, orden.calcularCostoTotal());
        preparedStatement.setInt(2, orden.getNumeroOrden());
        preparedStatement.executeUpdate();
    }

    public void actualizarEstadoDeLaOrden() throws SQLException {
        String updateTableSQL = "UPDATE orden SET estado = ? WHERE id = ?";
        preparedStatement = this.getConnection().prepareStatement(updateTableSQL);
        preparedStatement.setString(1, this.orden.getStatusOrden());
        preparedStatement.setInt(2, this.orden.getNumeroOrden());
        preparedStatement.executeUpdate();

    }
}
