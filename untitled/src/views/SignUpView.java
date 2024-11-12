package views;

import models.User;
import services.AuthService;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame {
    private JTextField usernameField, fullNameField, dobField, genderField, ageField, bankAccountField;
    private JPasswordField passwordField;
    private JButton signUpButton, cancelButton;
    private AuthService authService;

    public SignUpView() {
        authService = new AuthService();
        setTitle("Sign Up - Bank System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the form elements
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 25);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 150, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 25);
        panel.add(passwordField);

        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setBounds(50, 150, 100, 25);
        panel.add(fullNameLabel);

        fullNameField = new JTextField();
        fullNameField.setBounds(150, 150, 150, 25);
        panel.add(fullNameField);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(50, 200, 100, 25);
        panel.add(dobLabel);

        dobField = new JTextField();
        dobField.setBounds(150, 200, 150, 25);
        panel.add(dobField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 250, 100, 25);
        panel.add(genderLabel);

        genderField = new JTextField();
        genderField.setBounds(150, 250, 150, 25);
        panel.add(genderField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 300, 100, 25);
        panel.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(150, 300, 150, 25);
        panel.add(ageField);

        JLabel bankAccountLabel = new JLabel("Bank Account #:");
        bankAccountLabel.setBounds(50, 350, 100, 25);
        panel.add(bankAccountLabel);

        bankAccountField = new JTextField();
        bankAccountField.setBounds(150, 350, 150, 25);
        panel.add(bankAccountField);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(50, 400, 100, 25);
        signUpButton.addActionListener(new SignUpAction());
        panel.add(signUpButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 400, 100, 25);
        cancelButton.addActionListener(e -> {
            dispose();  // Close the SignUp view
            new LoginSignupView().setVisible(true);  // Open the login page
        });
        panel.add(cancelButton);

        add(panel);
    }

    // Action Listener for Sign Up button
    private class SignUpAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String fullName = fullNameField.getText();
            String dob = dobField.getText();
            String gender = genderField.getText();
            String ageText = ageField.getText();
            String bankAccount = bankAccountField.getText();

            int age = 0;
            try {
                age = Integer.parseInt(ageText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid number.");
                return;
            }

            User user = new User(username, password, fullName, dob, gender, age, bankAccount);
            if (authService.signup(user)) {
                JOptionPane.showMessageDialog(null, "Signup successful! Please log in.");
                dispose();  // Close the SignUp view
                new LoginSignupView().setVisible(true);  // Show the login page
            } else {
                JOptionPane.showMessageDialog(null, "Signup failed. Username may already exist.");
            }
        }
    }
}
