package org.example;
import java.sql.*;

public class Flight {

    private final String url = "jdbc:mysql://localhost:3306/AirLineTicketReservationSystem";
    private final String username = "root";
    private final String password = "niri2214";

    public void listFlights(String Airline, String DepartureTime) {
        String query = "SELECT * FROM Flight WHERE Origin = ? AND DATE(DepartureTime) = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, Airline);
            preparedStatement.setString(2, DepartureTime);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int FlightID = resultSet.getInt("FlightID");
                String Origin = resultSet.getString("origin");
                String Destination = resultSet.getString("destination");
                Timestamp ArrivalTime = resultSet.getTimestamp("arrivaltime");
                double price = resultSet.getDouble("price");
                int SeatsAvailable = resultSet.getInt("seatsavailable");

                System.out.println("Flight ID: " + FlightID);
                System.out.println("Airline: " + Airline);
                System.out.println("Origin: " + Origin);
                System.out.println("Destination: " + Destination);
                System.out.println("Departure Time: " + DepartureTime);
                System.out.println("Arrival Time: " + ArrivalTime);
                System.out.println("Price: " + price);
                System.out.println("Seats Available: " + SeatsAvailable);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Flight flight = new Flight();

        flight.listFlights("JFK", "2023-11-25");
        flight.listFlights("LAX", "2023-11-26");
        flight.listFlights("ORD", "2023-11-27");

    }
}



