package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


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

    public static void createTables() throws SQLException{
        Connection connection = SqliteJDBCConnector.connection();
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS events \n" +
                "(\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    eventName VARCHAR NOT NULL,\n" +
                "    description TEXT,\n" +
                "    eventDate VARCHAR NOT NULL)" );
    }
}
