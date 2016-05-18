/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

import java.sql.Connection;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import Principal.Producto;
import Principal.Mesero;
import Principal.Nota;
import Principal.Orden;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joaquin Martinez
 */
public class Prueba {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost/cafeteria?"
            + "characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC",
            USER_DB = "root",
            PASSWORD = "root";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(DRIVER);

            connection = DriverManager.getConnection(DATABASE_URL, USER_DB, PASSWORD);
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT id, nombre, clasificacion,"
                    + " precio FROM menu WHERE clasificacion = 'Bebidas' OR"
                    + " clasificacion = 'Cafes'");

            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("base menu");

            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            }

            System.out.println();
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

        ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        listaProductos.add(new Producto(1, "Torta de jamon", "Es una torta con jamon", 12.5, 2));
        listaProductos.add(new Producto(2, "Torta de quesso", "Es una torta con queso", 15, 2));

        Mesero unMesero = new Mesero(1, "Juan", "Perez", "Martinez");
        Orden unaOrden = new Orden("En curso", listaProductos, unMesero, 1);

        Nota unaNota = new Nota(unaOrden, unaOrden.calcularCostoTotal(), unaOrden.calcularHoraYFecha());

    }

}
