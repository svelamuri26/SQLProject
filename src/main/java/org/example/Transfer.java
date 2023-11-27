package org.example;
import java.sql.*;

public class Transfer {

    static final String DB_URL = "jdbc:mysql://localhost/BankAccount";
    static final String USER = "root";
    static final String PASS = "niri2214";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);

            updateAccountBalance(conn, 1, 400);


            updateAccountBalance(conn, 2, 200);
            conn.commit();

            System.out.println("Transaction completed successfully.");
        } catch (SQLException se) {
            se.printStackTrace();

            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Transaction rolled back.");
                }
            } catch (SQLException re) {
                re.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private static void updateAccountBalance(Connection conn, int accountId, double amount) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE  balance = balance + ? WHERE account_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Account not found or unable to update balance for account: " + accountId);
            }
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }
}