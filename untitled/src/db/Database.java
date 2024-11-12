package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:sqlite:" + System.getProperty("user.dir") + "/db/bank.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
