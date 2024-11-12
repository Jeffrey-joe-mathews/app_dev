////package services;
////
////import db.Database;
////import models.User;
////import java.sql.*;
////
////public class BankService {
////
////    // Method to get the current balance of the user
////    public double getBalance(String username) {
////        String query = "SELECT balance FROM Users WHERE username = ?";
////        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
////            pstmt.setString(1, username);
////            ResultSet rs = pstmt.executeQuery();
////            if (rs.next()) {
////                return rs.getDouble("balance");
////            }
////        } catch (SQLException e) {
////            System.out.println("Error fetching balance: " + e.getMessage());
////        }
////        return 0;
////    }
////
////    // Method to deposit an amount to the user's balance
////    public boolean deposit(User user, double amount) {
////        if (amount <= 0) {
////            System.out.println("Deposit amount must be positive.");
////            return false;
////        }
////
////        String query = "UPDATE Users SET balance = balance + ? WHERE username = ?";
////        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
////            pstmt.setDouble(1, amount);
////            pstmt.setString(2, user.getUsername());
////            int rowsUpdated = pstmt.executeUpdate();
////
////            if (rowsUpdated > 0) {
////                user.setBalance((int) (user.getBalance() + amount)); // Update the user's balance in memory
////                System.out.println("Deposit successful. New balance: $" + user.getBalance());
////                return true;
////            }
////        } catch (SQLException e) {
////            System.out.println("Deposit failed: " + e.getMessage());
////        }
////        return false;
////    }
////
////    // Method to withdraw an amount from the user's balance
////    public boolean withdraw(User user, double amount) {
////        if (amount <= 0) {
////            System.out.println("Withdrawal amount must be positive.");
////            return false;
////        }
////
////        if (amount > user.getBalance()) {
////            System.out.println("Insufficient funds.");
////            return false;
////        }
////
////        String query = "UPDATE Users SET balance = balance - ? WHERE username = ?";
////        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
////            pstmt.setDouble(1, amount);
////            pstmt.setString(2, user.getUsername());
////            int rowsUpdated = pstmt.executeUpdate();
////
////            if (rowsUpdated > 0) {
////                user.setBalance((int) (user.getBalance() - amount)); // Update the user's balance in memory
////                System.out.println("Withdrawal successful. New balance: $" + user.getBalance());
////                return true;
////            }
////        } catch (SQLException e) {
////            System.out.println("Withdrawal failed: " + e.getMessage());
////        }
////        return false;
////    }
////}
//
//package services;
//
//import models.User;
//import models.Transaction;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BankService {
//    private List<Transaction> transactionHistory;
//
//    public BankService() {
//        transactionHistory = new ArrayList<>();
//    }
//
//    // Assuming you have a way to get balance for the user.
//    public double getBalance(String username) {
//        // Logic to get balance, for simplicity, returning a dummy balance
//        return 1000.00;
//    }
//
//    // Deposit method with transaction recording
//    public boolean deposit(User user, double amount) {
//        // Logic to deposit amount into the user's account
//        // For now, we assume it's successful.
//
//        // Add transaction to the history
//        transactionHistory.add(new Transaction("Deposit", amount));
//        return true;
//    }
//
//    // Withdraw method with transaction recording
//    public boolean withdraw(User user, double amount) {
//        // Logic to withdraw amount from the user's account
//        // For simplicity, assuming it's always successful.
//
//        // Add transaction to the history
//        transactionHistory.add(new Transaction("Withdraw", amount));
//        return true;
//    }
//
//    // Get transaction history
//    public List<Transaction> getTransactionHistory() {
//        return transactionHistory;
//    }
//}
//

package services;

import models.User;
import models.Transaction;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<Transaction> transactionHistory;
    private double balance;

    public BankService() {
        transactionHistory = new ArrayList<>();
        this.balance = 1000.00;
    }

    // Method to get the balance for the user
    public double getBalance(String username) {
        return balance;
    }

    // Deposit method
    public boolean deposit(User user, double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
            return true;
        }
        return false;
    }

    // Withdraw method with balance check
    public boolean withdraw(User user, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            return true;
        } else {
            return false;
        }
    }

    // Get transaction history
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
