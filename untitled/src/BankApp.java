import views.LoginSignupView;

public class BankApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginSignupView().setVisible(true);
        });
    }
}
