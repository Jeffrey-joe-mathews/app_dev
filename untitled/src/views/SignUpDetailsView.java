package views;

import models.User;
import services.AuthService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpDetailsView extends JFrame {

    private JTextField usernameField, fullNameField, dobField, genderField, ageField, bankAccountField;
    private JPasswordField passwordField;
    private JButton signupButton;
    private AuthService authService;

    public SignUpDetailsView() {
        authService = new AuthService();  // Initialize AuthService to handle user signup

        // Set up the frame
        setTitle("User Registration");
        setSize(400, 500);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create input fields and labels
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameField = new JTextField();

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");
        genderField = new JTextField();

        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();

        JLabel bankAccountLabel = new JLabel("Bank Account:");
        bankAccountField = new JTextField();

        // Add labels and text fields to the panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(fullNameLabel);
        panel.add(fullNameField);
        panel.add(dobLabel);
        panel.add(dobField);
        panel.add(genderLabel);
        panel.add(genderField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(bankAccountLabel);
        panel.add(bankAccountField);

        // Sign up button
        signupButton = new JButton("Sign Up");
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new User object with all the fields
                User user = new User(
                        usernameField.getText(),
                        new String(passwordField.getPassword()),
                        fullNameField.getText(),
                        dobField.getText(),
                        genderField.getText(),
                        Integer.parseInt(ageField.getText()),
                        bankAccountField.getText()
                );

                // Call the AuthService signup method
                if (authService.signup(user)) {
                    JOptionPane.showMessageDialog(null, "Signup successful! Please log in.");
                    dispose(); // Close the SignUp page after successful signup
                    new LoginSignupView().setVisible(true); // Open Login page
                } else {
                    JOptionPane.showMessageDialog(null, "Signup failed. Please check the details and try again.");
                }
            }
        });

        // Add components to the frame
        add(panel, BorderLayout.CENTER);
        add(signupButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignUpDetailsView().setVisible(true));
    }
}
