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
 * @author
 */
public class DaoCompra extends DaoGeneral {

    public DaoCompra() throws SQLException, ClassNotFoundException {
        super();
    }

    public void cargarProductosDeLaOrden(Orden orden) throws SQLException {
        //Obtenemos toda la info de la BD, que no sean repetidos:
        String query = "SELECT * FROM compra join menu on compra.idMenu = menu.id where compra.idOrden=?";
        this.preparedStatement = this.getConnection().prepareStatement(query);
        this.preparedStatement.setInt(1, orden.getNumeroOrden());
        this.resultSet = this.preparedStatement.executeQuery();
        ArrayList<Producto> productos = new ArrayList<>();
        while (resultSet.next()) {
            productos.add(
                    new Producto(
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getDouble(7)
                    )
            );
        }
        orden.setListaProductos(productos);
    }

    public void eliminarProductosDeLaCompra(Orden orden) throws SQLException {
        String deleteSQL = "DELETE FROM compra WHERE idOrden = ?";
        preparedStatement = this.getConnection().prepareStatement(deleteSQL);
        this.preparedStatement.setInt(1, orden.getNumeroOrden());
        preparedStatement.executeUpdate();
    }
}
