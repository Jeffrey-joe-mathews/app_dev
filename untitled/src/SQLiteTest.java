import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteTest {
    public static void main(String[] args) {
        try {
            // Ensure the SQLite JDBC driver is loaded
            Class.forName("org.sqlite.JDBC");

            // Database URL
            String url = "jdbc:sqlite:/home/malachy/NetBeansProjects/BankManagementSystem/untitled/db/bank.db";

            // Establish a connection
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connection successful!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
