package org.example;

import java.sql.*;

public class Courses {

    private final String url = "jdbc:mysql://localhost:3306/AirLineTicketReservationSystem";
    private final String username = "root";
    private final String password = "niri2214";
    public void insertCourses(int ID, String CourseName, String CourseDescription ) {
        String insertQuery = "INSERT INTO Courses (ID,CourseName,CourseDescription) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, ID);
            preparedStatement.setString(2, CourseName);
            preparedStatement.setString(3, CourseDescription);



            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Course record inserted successfully!");
            } else {
                System.out.println("Failed to insert course record.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Courses course = new Courses();

        course.insertCourses(1, "Math", "Masters Course");
        course.insertCourses(2, "English","Bachelors Course" );
        course.insertCourses(3, "Computers","Diploma  Course" );
    }
}
