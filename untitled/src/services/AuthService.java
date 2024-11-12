package services;

import db.Database;
import models.User;
import java.sql.*;

public class AuthService {

    // Signup method to store user data in the database
    public boolean signup(User user) {
        String query = "INSERT INTO Users(username, password, fullName, dob, gender, age, bankAccount) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFullName());  // fullName from User
            pstmt.setString(4, user.getDob());      // dob from User
            pstmt.setString(5, user.getGender());  // gender from User
            pstmt.setInt(6, user.getAge());         // age from User
            pstmt.setString(7, user.getBankAccount());  // bankAccount from User
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Signup failed: " + e.getMessage());
            return false;
        }
    }

    // Login method (no changes required)
    public User login(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullName"),
                        rs.getString("dob"),
                        rs.getString("gender"),
                        rs.getInt("age"),
                        rs.getString("bankAccount")
                );
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        return null;
    }
}
