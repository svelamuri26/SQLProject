package org.example;
import java.sql.*;


public class DatabaseUtil1 {

    private static final String URL = "jdbc:mysql://localhost:3306/NewDatabases";

    private static final String user = "root";

    private static final String password = "niri2214";

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewDatabases", user,
                password)) {

            System.out.println("Connected to the database successfully");



        } catch (SQLException e) {

            System.out.println("Error connecting to the database");

            e.printStackTrace();

        }
    }
}





