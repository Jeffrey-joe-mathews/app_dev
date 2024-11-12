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
        authService = new AuthService();

        // Set up the frame
        setTitle("User Registration");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for the form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());  // Use GridBagLayout for flexible arrangement
        formPanel.setBackground(Color.BLACK);

        // Create constraints for GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Set custom fonts for labels and text fields
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Color labelColor = Color.WHITE;

        // Define labels and fields
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        usernameLabel.setForeground(labelColor);
        usernameLabel.setPreferredSize(new Dimension(150, 30));

        usernameField = new JTextField();
        usernameField.setFont(labelFont);
        usernameField.setPreferredSize(new Dimension(300, 30));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        passwordLabel.setForeground(labelColor);
        passwordLabel.setPreferredSize(new Dimension(150, 30));

        passwordField = new JPasswordField();
        passwordField.setFont(labelFont);
        passwordField.setPreferredSize(new Dimension(300, 30));

        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setFont(labelFont);
        fullNameLabel.setForeground(labelColor);
        fullNameLabel.setPreferredSize(new Dimension(150, 30));

        fullNameField = new JTextField();
        fullNameField.setFont(labelFont);
        fullNameField.setPreferredSize(new Dimension(300, 30));

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(labelFont);
        dobLabel.setForeground(labelColor);
        dobLabel.setPreferredSize(new Dimension(150, 30));

        dobField = new JTextField();
        dobField.setFont(labelFont);
        dobField.setPreferredSize(new Dimension(300, 30));

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(labelFont);
        genderLabel.setForeground(labelColor);
        genderLabel.setPreferredSize(new Dimension(150, 30));

        genderField = new JTextField();
        genderField.setFont(labelFont);
        genderField.setPreferredSize(new Dimension(300, 30));

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(labelFont);
        ageLabel.setForeground(labelColor);
        ageLabel.setPreferredSize(new Dimension(150, 30));

        ageField = new JTextField();
        ageField.setFont(labelFont);
        ageField.setPreferredSize(new Dimension(300, 30));

        JLabel bankAccountLabel = new JLabel("Bank Account:");
        bankAccountLabel.setFont(labelFont);
        bankAccountLabel.setForeground(labelColor);
        bankAccountLabel.setPreferredSize(new Dimension(150, 30));

        bankAccountField = new JTextField();
        bankAccountField.setFont(labelFont);
        bankAccountField.setPreferredSize(new Dimension(300, 30));

        // Add the components to the form panel with GridBagConstraints
        gbc.gridx = 0; gbc.gridy = 0; formPanel.add(usernameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.gridwidth = 2; formPanel.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; formPanel.add(passwordLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 2; formPanel.add(passwordField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; formPanel.add(fullNameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 2; formPanel.add(fullNameField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; formPanel.add(dobLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.gridwidth = 2; formPanel.add(dobField, gbc);

        gbc.gridx = 0; gbc.gridy = 4; formPanel.add(genderLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4; gbc.gridwidth = 2; formPanel.add(genderField, gbc);

        gbc.gridx = 0; gbc.gridy = 5; formPanel.add(ageLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 5; gbc.gridwidth = 2; formPanel.add(ageField, gbc);

        gbc.gridx = 0; gbc.gridy = 6; formPanel.add(bankAccountLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 6; gbc.gridwidth = 2; formPanel.add(bankAccountField, gbc);

        // Sign up button with custom style
        signupButton = new JButton("Sign Up");
        signupButton.setFont(new Font("Arial", Font.BOLD, 18));
        signupButton.setBackground(Color.GREEN);
        signupButton.setForeground(Color.BLACK);
        signupButton.setFocusPainted(false);
        signupButton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        signupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add action listener to the signup button
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

        // Create a panel for the button and place it just above the form panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(signupButton);

        // Add the form panel and button panel to the frame
        JScrollPane scrollPane = new JScrollPane(formPanel); // Add a scroll pane
        add(scrollPane, BorderLayout.CENTER); // Add scrollable form panel to the center
        add(buttonPanel, BorderLayout.SOUTH);

        // Make the window resizable and responsive
        setMinimumSize(new Dimension(600, 800));
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignUpDetailsView().setVisible(true));
    }
}
