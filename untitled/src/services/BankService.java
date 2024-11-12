// src/services/BankService.java
package services;

import db.Database;
import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankService {

    // Method to get the current balance of the user
    public double getBalance(String username) {
        String query = "SELECT balance FROM Users WHERE username = ?";
        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching balance: " + e.getMessage());
        }
        return 0;
    }

    // Method to deposit an amount to the user's balance
    public boolean deposit(User user, double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return false;
        }

        String query = "UPDATE Users SET balance = balance + ? WHERE username = ?";
        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, user.getUsername());
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                user.setBalance(user.getBalance() + amount); // Update the user's balance in memory
                System.out.println("Deposit successful. New balance: $" + user.getBalance());
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }
        return false;
    }

    // Method to withdraw an amount from the user's balance
    public boolean withdraw(User user, double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }

        if (amount > user.getBalance()) {
            System.out.println("Insufficient funds.");
            return false;
        }

        String query = "UPDATE Users SET balance = balance - ? WHERE username = ?";
        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, user.getUsername());
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                user.setBalance(user.getBalance() - amount); // Update the user's balance in memory
                System.out.println("Withdrawal successful. New balance: $" + user.getBalance());
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
        return false;
    }
}
