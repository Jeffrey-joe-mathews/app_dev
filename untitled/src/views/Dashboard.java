//package views;
//
//import models.User;
//import services.BankService;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Dashboard extends JFrame {
//    private User user;
//    private BankService bankService;
//
//    private JLabel balanceLabel;
//    private JButton depositButton, withdrawButton;
//
//    public Dashboard(User user) {
//        this.user = user;
//        this.bankService = new BankService(); // Initialize BankService to manage balance
//
//        // Set window title and size
//        setTitle("User Dashboard");
//        setSize(600, 800);  // Adjusted size for better spacing
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Set black background for the entire content pane
//        getContentPane().setBackground(Color.BLACK);
//
//        // Set up the panel with black background and white text
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        panel.setBackground(Color.BLACK); // Set panel background to black
//        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));  // Add margin around the content
//
//        // Add a logo at the top
//        ImageIcon logoIcon = new ImageIcon("path/to/your/logo.png");  // Add your logo image path here
//        JLabel logoLabel = new JLabel(logoIcon);
//        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center the logo
//        panel.add(logoLabel);
//
//        // Add a title label with larger font
//        JLabel welcomeLabel = new JLabel("Welcome, " + user.getUsername());
//        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Larger font size
//        welcomeLabel.setForeground(Color.WHITE);  // Set text color to white
//        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the welcome message
//        panel.add(welcomeLabel);
//
//        // Display user's full name and age in white text
//        JLabel userDetails = new JLabel("Name: " + user.getFullName() + ", Age: " + user.getAge());
//        userDetails.setFont(new Font("Arial", Font.PLAIN, 18));  // Slightly smaller font
//        userDetails.setForeground(Color.WHITE);
//        userDetails.setAlignmentX(Component.CENTER_ALIGNMENT);
//        panel.add(userDetails);
//
//        // Display balance in white text
//        balanceLabel = new JLabel("Current Balance: $" + bankService.getBalance(user.getUsername()));
//        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 20));  // Adjust font size
//        balanceLabel.setForeground(Color.WHITE);
//        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        panel.add(balanceLabel);
//
//        // Add a container for the deposit/withdraw buttons
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10)); // Two buttons side by side
//        buttonPanel.setOpaque(false); // Make it transparent to show the black background
//
//        // Add Deposit button with custom style (same size as logout button)
//        depositButton = new JButton("Deposit");
//        depositButton.setFont(new Font("Arial", Font.BOLD, 16));  // Font size for deposit
//        depositButton.setPreferredSize(new Dimension(50, 25));  // Same size as logout button
//        depositButton.setBackground(Color.GREEN);
//        depositButton.setForeground(Color.BLACK);
//        depositButton.setFocusPainted(false);
//        depositButton.addActionListener(new DepositAction());
//        buttonPanel.add(depositButton);
//
//        // Add Withdraw button with custom style (same size as logout button)
//        withdrawButton = new JButton("Withdraw");
//        withdrawButton.setFont(new Font("Arial", Font.BOLD, 16));  // Font size for withdraw
//        withdrawButton.setPreferredSize(new Dimension(50, 25));  // Same size as logout button
//        withdrawButton.setBackground(Color.RED);
//        withdrawButton.setForeground(Color.BLACK);
//        withdrawButton.setFocusPainted(false);
//        withdrawButton.addActionListener(new WithdrawAction());
//        buttonPanel.add(withdrawButton);
//
//        // Add the button panel to the main panel
//        panel.add(buttonPanel);
//
//        // Add Logout Button with custom style (same size)
//        JButton logoutButton = new JButton("Logout");
//        logoutButton.setFont(new Font("Arial", Font.BOLD, 18));  // Larger font size for logout
//        logoutButton.setPreferredSize(new Dimension(200, 50));  // Same size for logout button
//        logoutButton.setBackground(Color.GRAY);
//        logoutButton.setForeground(Color.BLACK);
//        logoutButton.setFocusPainted(false);
//        logoutButton.addActionListener(e -> {
//            new LoginSignupView().setVisible(true); // Go back to login/signup page
//            dispose();
//        });
//        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center the logout button
//        panel.add(logoutButton);
//
//        // Add the main panel to the frame
//        JScrollPane scrollPane = new JScrollPane(panel); // Make the panel scrollable in case of small screen sizes
//        add(scrollPane);
//
//        setVisible(true);  // Make the frame visible
//    }
//
//    // Action Listener for Deposit
//    private class DepositAction implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            String amountStr = JOptionPane.showInputDialog("Enter deposit amount:");
//            if (amountStr != null && !amountStr.isEmpty()) {
//                try {
//                    double amount = Double.parseDouble(amountStr);
//                    if (amount > 0) {
//                        if (bankService.deposit(user, amount)) {
//                            // Update balance label after successful deposit
//                            balanceLabel.setText("Current Balance: $" + bankService.getBalance(user.getUsername()));
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Please enter a positive amount.");
//                    }
//                } catch (NumberFormatException ex) {
//                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
//                }
//            }
//        }
//    }
//
//    // Action Listener for Withdraw
//    private class WithdrawAction implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            String amountStr = JOptionPane.showInputDialog("Enter withdrawal amount:");
//            if (amountStr != null && !amountStr.isEmpty()) {
//                try {
//                    double amount = Double.parseDouble(amountStr);
//                    if (amount > 0) {
//                        if (bankService.withdraw(user, amount)) {
//                            // Update balance label after successful withdrawal
//                            balanceLabel.setText("Current Balance: $" + bankService.getBalance(user.getUsername()));
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Please enter a positive amount.");
//                    }
//                } catch (NumberFormatException ex) {
//                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
//                }
//            }
//        }
//    }
//
//}

package views;

import models.User;
import services.BankService;
import models.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Dashboard extends JFrame {
    private User user;
    private BankService bankService;

    private JLabel balanceLabel;
    private JButton depositButton, withdrawButton;

    private JTable transactionTable;
    private DefaultTableModel transactionTableModel;

    public Dashboard(User user) {
        this.user = user;
        this.bankService = new BankService(); // Initialize BankService to manage balance

        // Set window title and size
        setTitle("User Dashboard");
        setSize(600, 800);  // Adjusted size for better spacing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set black background for the entire content pane
        getContentPane().setBackground(Color.BLACK);

        // Set up the panel with black background and white text
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK); // Set panel background to black
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));  // Add margin around the content

        // Add a logo at the top
        ImageIcon logoIcon = new ImageIcon("path/to/your/logo.png");  // Add your logo image path here
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center the logo
        panel.add(logoLabel);

        // Add a title label with larger font
        JLabel welcomeLabel = new JLabel("Welcome, " + user.getUsername());
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Larger font size
        welcomeLabel.setForeground(Color.WHITE);  // Set text color to white
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the welcome message
        panel.add(welcomeLabel);

        // Display user's full name and age in white text
        JLabel userDetails = new JLabel("Name: " + user.getFullName() + ", Age: " + user.getAge());
        userDetails.setFont(new Font("Arial", Font.PLAIN, 18));  // Slightly smaller font
        userDetails.setForeground(Color.WHITE);
        userDetails.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(userDetails);

        // Display balance in white text
        balanceLabel = new JLabel("Current Balance: $" + bankService.getBalance(user.getUsername()));
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 20));  // Adjust font size
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(balanceLabel);

        // Add a container for the deposit/withdraw buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10)); // Two buttons side by side
        buttonPanel.setOpaque(false); // Make it transparent to show the black background

        // Add Deposit button with custom style (same size as logout button)
        depositButton = new JButton("Deposit");
        depositButton.setFont(new Font("Arial", Font.BOLD, 16));  // Font size for deposit
        depositButton.setPreferredSize(new Dimension(200, 50));  // Same size as logout button
        depositButton.setBackground(Color.GREEN);
        depositButton.setForeground(Color.BLACK);
        depositButton.setFocusPainted(false);
        depositButton.addActionListener(new DepositAction());
        buttonPanel.add(depositButton);

        // Add Withdraw button with custom style (same size as logout button)
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 16));  // Font size for withdraw
        withdrawButton.setPreferredSize(new Dimension(200, 50));  // Same size as logout button
        withdrawButton.setBackground(Color.RED);
        withdrawButton.setForeground(Color.BLACK);
        withdrawButton.setFocusPainted(false);
        withdrawButton.addActionListener(new WithdrawAction());
        buttonPanel.add(withdrawButton);

        // Add the button panel to the main panel
        panel.add(buttonPanel);

        // Add Logout Button with custom style (same size)
        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 18));  // Larger font size for logout
        logoutButton.setPreferredSize(new Dimension(200, 50));  // Same size for logout button
        logoutButton.setBackground(Color.GRAY);
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(e -> {
            new LoginSignupView().setVisible(true); // Go back to login/signup page
            dispose();
        });
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center the logout button
        panel.add(logoutButton);

        // Transaction History section
        JLabel transactionHistoryLabel = new JLabel("Transaction History");
        transactionHistoryLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Title for the history
        transactionHistoryLabel.setForeground(Color.WHITE);
        transactionHistoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(transactionHistoryLabel);

        // Table to display the transaction history
        String[] columnNames = {"Type", "Amount", "Date"};
        transactionTableModel = new DefaultTableModel(columnNames, 0);
        transactionTable = new JTable(transactionTableModel);
        transactionTable.setBackground(Color.DARK_GRAY);
        transactionTable.setForeground(Color.WHITE);
        transactionTable.setFont(new Font("Arial", Font.PLAIN, 14));
        transactionTable.setRowHeight(25);

        // Add scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        scrollPane.setPreferredSize(new Dimension(500, 200)); // Adjust the size of the transaction history display
        panel.add(scrollPane);

        // Add the main panel to the frame
        add(panel);

        setVisible(true);  // Make the frame visible

        // Update transaction history table initially
        updateTransactionHistory();
    }

    // Action Listener for Deposit
    private class DepositAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String amountStr = JOptionPane.showInputDialog("Enter deposit amount:");
            if (amountStr != null && !amountStr.isEmpty()) {
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (amount > 0) {
                        if (bankService.deposit(user, amount)) {
                            // Update balance label and transaction history after successful deposit
                            balanceLabel.setText("Current Balance: $" + bankService.getBalance(user.getUsername()));
                            updateTransactionHistory();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a positive amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
                }
            }
        }
    }

    // Action Listener for Withdraw
    // Action Listener for Withdraw
    private class WithdrawAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String amountStr = JOptionPane.showInputDialog("Enter withdrawal amount:");
            if (amountStr != null && !amountStr.isEmpty()) {
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (amount > 0) {
                        // Attempt to withdraw and check if it was successful
                        if (bankService.withdraw(user, amount)) {
                            // Update balance label and transaction history after successful withdrawal
                            balanceLabel.setText("Current Balance: $" + bankService.getBalance(user.getUsername()));
                            updateTransactionHistory();
                        } else {
                            // Notify the user if the withdrawal was unsuccessful
                            JOptionPane.showMessageDialog(null, "Insufficient funds or invalid amount. Please try again.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a positive amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
                }
            }
        }
    }


    // Method to update the transaction history table
    private void updateTransactionHistory() {
        // Clear existing rows in the table
        transactionTableModel.setRowCount(0);

        // Get the list of transactions and update the table
        List<Transaction> transactions = bankService.getTransactionHistory();
        for (Transaction transaction : transactions) {
            Object[] row = new Object[3];
            row[0] = transaction.getType();
            row[1] = transaction.getAmount();
            row[2] = transaction.getDate();
            transactionTableModel.addRow(row);
        }
    }

    public static void main(String[] args) {
        // For testing
        User user = new User("john_doe", "password123", "John Doe", "01/01/1990", "Male", 30, "1234567890");
        new Dashboard(user); // Pass a test user
    }
}
