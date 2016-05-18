/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


/**
 *
 * @author melissa MYSQL Query for print total SELECT orden.id, orden.estado,
 * menu.nombre, menu.precio, orden.total FROM `orden` JOIN `menu_orden` ON
 * orden.id = menu_orden.id_orden JOIN `menu` ON menu.id = menu_orden.id_menu
 * WHERE orden.id = 1
 */
public class Conecta {

    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/cafeteria";

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    //Metodo constructor, vacio por default
    public Conecta() {

    }

    public void QueryBuilder(String query) {
        try {
            Class.forName(DRIVER);

            connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            }

            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();

            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        }
        {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();

            }

        }
    }

    public void getBebidas() {
        String query = "SELECT * FROM menu WHERE clasificacion = 'Bebidas' OR clasificacion = 'Cafés' OR clasificacion = 'Tés' OR clasificacion = 'Frappés' OR clasificacion = 'Malteadas' OR clasificacion = 'Smoothies'";

        this.QueryBuilder(query);
    }

    public void getComidas() {
        String query = "SELECT * FROM menu WHERE clasificacion = 'Crepas' OR clasificacion = 'Especialidades' OR clasificacion = 'Ensaladas' OR clasificacion = 'Ingredientes dulces' OR clasificacion = 'Ingredientes Salados'";

        this.QueryBuilder(query);
    }

    public void getPostres() {
        String query = "SELECT * FROM menu WHERE clasificacion = 'Botanas' OR clasificacion = 'Postres'";

        this.QueryBuilder(query);
    }

    public void printOrder(int order) {
        String query = "SELECT menu.nombre, menu.precio "
                + "FROM `orden` JOIN `menu_orden` ON orden.id = menu_orden.id_orden JOIN `menu` "
                + "ON menu.id = menu_orden.id_menu WHERE orden.id = " + order;

        this.QueryBuilder(query);
    }

    public void getOrderPorEstado(String estado) {
        String query = "SELECT * FROM `orden` WHERE estado = '" + estado + "'";

        this.QueryBuilder(query);
    }

    public void getAllMenu() {
        String query = "SELECT * FROM menu";

        this.QueryBuilder(query);
    }
}
