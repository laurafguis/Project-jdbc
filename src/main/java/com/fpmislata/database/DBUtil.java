package com.fpmislata.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public final static String DRIVER = "jdbc:mysql";
    public final static String URL = "localhost:3306";
    public final static String DB = "imdb";
    public final static String USER = "root";
    public final static String PASSWORD = "root";

    static String connection = String.format("%s://%s/%s?user=%s&password=%s", DRIVER, URL, DB, USER,PASSWORD);

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(connection);
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar con la bbdd");
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexción con la bbdd");
        }
    } 
}
