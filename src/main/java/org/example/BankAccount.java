package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankAccount {

    private final String url = "jdbc:mysql://localhost:3306/BankAccount";
    private final String username = "root";
    private final String password = "niri2214";

    public void insertBankAccount(int account_id, double balance ) {
        String insertQuery = "INSERT INTO bank_accounts (account_id , balance) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, account_id);
            preparedStatement.setDouble(2, balance);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Account record inserted successfully!");
            } else {
                System.out.println("Failed to insert account record.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        bankAccount.insertBankAccount(3, 5000.00);
        bankAccount.insertBankAccount(4, 4000.00);


    }
}
