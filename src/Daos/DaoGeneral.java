/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author equipo1
 */
public class DaoGeneral {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DATABASE_URL = "jdbc:mysql://localhost/cafeteria?"
            + "characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC",
            USER_DB = "root",
            PASSWORD = "root";

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public DaoGeneral() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER_DB, PASSWORD);
    }

    public void doQuery(String query) {

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

}
