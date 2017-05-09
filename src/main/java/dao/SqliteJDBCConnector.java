package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqliteJDBCConnector {

    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database.db");
        } catch (SQLException e) {
            System.out.println("Cannot create connection");
            System.out.println(e.getMessage());
        }
        return connection;
    }
}