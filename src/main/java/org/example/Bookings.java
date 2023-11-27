package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bookings {

    private final String url = "jdbc:mysql://localhost:3306/AirLineTicketReservationSystem";
    private final String username = "root";
    private final String password = "niri2214";

    public void insertBookings(int BookingID, int CustomerID, int FlightID, String BookingDate, int NumberOfPassengers , String Status ) {
        String insertQuery = "INSERT INTO Bookings (BookingID,CustomerID,FlightID," +
                "BookingDate,NumberOfPassengers,Status) VALUES (?, ?, ?, ?, ?, ?)";


        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, BookingID);
            preparedStatement.setInt(2, CustomerID);
            preparedStatement.setInt(3, FlightID);
            preparedStatement.setString(4, BookingDate);
            preparedStatement.setInt(5, NumberOfPassengers);
            preparedStatement.setString(6, Status);


            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Booking record inserted successfully!");
            } else {
                System.out.println("Failed to insert booking record.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Bookings booking = new Bookings();

        booking.insertBookings(204, 4, 104, "2023-11-23", 4, "Pending");


    }


}