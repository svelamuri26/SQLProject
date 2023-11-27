package org.example;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerBookingJoin {

    private final String url = "jdbc:mysql://localhost:3306/AirLineTicketReservationSystem";
    private final String username = "root";
    private final String password = "niri2214";


    public void CustomerBooking() {

        String joinCustomerBooking = "SELECT c.Name AS CustomerName, c.Email, b.BookingID, b.FlightID, " +
                "b.BookingDate, b.NumberOfPassengers, b.Status " +
                "FROM Customers c " + "INNER JOIN Bookings b ON c.CustomerID = b.CustomerID";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(joinCustomerBooking)) {


            while (resultSet.next()) {

                String customerName = resultSet.getString("CustomerName");
                String email = resultSet.getString("Email");
                int bookingId = resultSet.getInt("BookingID");
                int flightId = resultSet.getInt("FlightID");
                Date bookingDate = resultSet.getDate("BookingDate");
                int numberOfPassengers = resultSet.getInt("NumberOfPassengers");
                String status = resultSet.getString("Status");

                System.out.println("Customer Name: " + resultSet.getString("CustomerName"));
                System.out.println("Email: " + resultSet.getString("Email"));
                System.out.println("Booking ID: " + resultSet.getInt("BookingID"));
                System.out.println("Flight ID: " + resultSet.getInt("FlightID"));
                System.out.println("Booking Date: " + resultSet.getDate("BookingDate"));
                System.out.println("Number of Passengers: " + resultSet.getInt("NumberOfPassengers"));
                System.out.println("Status: " + resultSet.getString("Status"));
                System.out.println("----------------------------------------");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CustomerBookingJoin customerBooking = new CustomerBookingJoin();
        customerBooking.CustomerBooking();
    }
}
