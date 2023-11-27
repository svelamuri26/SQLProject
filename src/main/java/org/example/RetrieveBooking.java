package org.example;

import java.sql.*;

public class RetrieveBooking {

    private final String url = "jdbc:mysql://localhost:3306/AirLineTicketReservationSystem";
    private final String username = "root";
    private final String password = "niri2214";


    public void getBookingsCustomerID(int customerId) {
        String query = "SELECT * FROM Bookings WHERE CustomerID = ?";


        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, customerId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int bookingId = resultSet.getInt("BookingID");
                int flightId = resultSet.getInt("FlightID");
                Date bookingDate = resultSet.getDate("BookingDate");
                int numberOfPassengers = resultSet.getInt("NumberOfPassengers");
                String status = resultSet.getString("Status");


                System.out.println("Booking ID: " + bookingId);
                System.out.println("Flight ID: " + flightId);
                System.out.println("Booking Date: " + bookingDate);
                System.out.println("Number of Passengers: " + numberOfPassengers);
                System.out.println("Status: " + status);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RetrieveBooking bookingRetrieve = new RetrieveBooking();

        bookingRetrieve.getBookingsCustomerID(4);
    }
}

