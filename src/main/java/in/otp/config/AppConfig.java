package in.otp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppConfig {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/otp_system";
    private static final String DB_USER = "root";    
    private static final String DB_PASSWORD = "Nikk123@";  
    private static Connection connection = null;

    static {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish database connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Database connection established successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Returns the established connection if it's valid
    public static Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            } else {
                System.out.println("Database connection is not established or has been closed.");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error checking connection validity: " + e.getMessage());
            return null;
        }
    }

    // Close the connection gracefully
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the connection: " + e.getMessage());
        }
    }
}
