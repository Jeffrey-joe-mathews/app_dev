package views;

import models.User;
import javax.swing.*;

public class Dashboard extends JFrame {
    private User user;

    public Dashboard(User user) {
        this.user = user;
        setTitle("User Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome, " + user.getUsername());
        panel.add(welcomeLabel);

        JLabel userDetails = new JLabel("Name: " + user.getFullName() + ", Age: " + user.getAge());
        panel.add(userDetails);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            new LoginSignupView().setVisible(true); // Go back to login/signup page
            dispose();
        });
        panel.add(logoutButton);

        add(panel);
    }
}
