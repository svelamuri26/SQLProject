package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customers {

    private final String url = "jdbc:mysql://localhost:3306/AirLineTicketReservationSystem";
    private final String username = "root";
    private final String password = "niri2214";

    public void insertCustomers(int CustomerID, String Name, String Email, String Phone ) {
        String insertQuery = "INSERT INTO Customers (CustomerID,Name,Email,Phone) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, CustomerID);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, Email);
            preparedStatement.setString(4, Phone);


            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Customer record inserted successfully!");
            } else {
                System.out.println("Failed to insert customer record.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Customers customer = new Customers();

        customer.insertCustomers(4, "Joan Drew", "joandrew@email.com", "321-544-7800");
    }
}

