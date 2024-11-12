//package views;
//
//import models.User;
//import services.AuthService;
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class LoginSignupView extends JFrame {
//    private JTextField usernameField;
//    private JPasswordField passwordField;
//    private JButton loginButton, signupButton;
//    private AuthService authService;
//
//    public LoginSignupView() {
//        authService = new AuthService();
//        setTitle("Bank System - Login/Signup");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Create the form elements
//        JPanel panel = new JPanel();
//        panel.setLayout(null);
//
//        JLabel usernameLabel = new JLabel("Username:");
//        usernameLabel.setBounds(50, 50, 100, 25);
//        panel.add(usernameLabel);
//
//        usernameField = new JTextField();
//        usernameField.setBounds(150, 50, 150, 25);
//        panel.add(usernameField);
//
//        JLabel passwordLabel = new JLabel("Password:");
//        passwordLabel.setBounds(50, 100, 100, 25);
//        panel.add(passwordLabel);
//
//        passwordField = new JPasswordField();
//        passwordField.setBounds(150, 100, 150, 25);
//        panel.add(passwordField);
//
//        loginButton = new JButton("Login");
//        loginButton.setBounds(50, 150, 100, 25);
//        loginButton.addActionListener(new LoginAction());
//        panel.add(loginButton);
//
//        signupButton = new JButton("Sign Up");
//        signupButton.setBounds(200, 150, 100, 25);
//        signupButton.addActionListener(e -> {
//            new SignUpDetailsView().setVisible(true);  // Open the Sign Up page
//            dispose();
//        });
//        panel.add(signupButton);
//
//        add(panel);
//    }
//
//    // Action Listener for Login
//    private class LoginAction implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            String username = usernameField.getText();
//            String password = new String(passwordField.getPassword());
//
//            User user = authService.login(username, password);
//            if (user != null) {
//                JOptionPane.showMessageDialog(null, "Login Successful! Welcome " + user.getUsername());
//                new Dashboard(user).setVisible(true);
//                dispose();
//            } else {
//                JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
//            }
//        }
//    }
//
//}

package views;
import models.User;
import services.AuthService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSignupView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signupButton;
    private AuthService authService;

    public LoginSignupView() {
        authService = new AuthService();
        setTitle("Bank System - Login/Signup");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set background color
        getContentPane().setBackground(Color.BLACK);

        // Create panel with black background
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);

        // Add logo
        ImageIcon logoIcon = new ImageIcon("path/to/your/logo.png");  // Replace with your logo
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(150, 10, logoIcon.getIconWidth(), logoIcon.getIconHeight());
        panel.add(logoLabel);

        // Add username field and label with contrasting text
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 100, 100, 25);
        usernameLabel.setForeground(Color.WHITE);  // White text
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 100, 150, 25);
        panel.add(usernameField);

        // Add password field and label with contrasting text
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 100, 25);
        passwordLabel.setForeground(Color.WHITE);  // White text
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 150, 25);
        panel.add(passwordField);

        // Add Login button
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 200, 100, 25);
        loginButton.setBackground(Color.GREEN);
        loginButton.setForeground(Color.BLACK);
        loginButton.addActionListener(new LoginAction());
        panel.add(loginButton);

        // Add Sign Up button
        signupButton = new JButton("Sign Up");
        signupButton.setBounds(200, 200, 100, 25);
        signupButton.setBackground(Color.RED);
        signupButton.setForeground(Color.BLACK);
        signupButton.addActionListener(e -> {
            new SignUpDetailsView().setVisible(true);  // Open Sign Up page
            dispose();
        });
        panel.add(signupButton);

        add(panel);
    }

    // Action Listener for Login

    private class LoginAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Try to log in the user using AuthService
            User user = authService.login(username, password);
            if (user != null) {
                // On successful login, open the user dashboard
                new Dashboard(user).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials, please try again.");
            }
        }
    }
}

