import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    // Define the connection parameters
    private static final String SERVER = "jdbc:mysql://localhost:3306/chores_mgt"; // JDBC URL for the database
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // Method to establish a connection to the database
    public static Connection connectToDatabase() throws SQLException {
        // Load the JDBC driver for MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establish a connection using DriverManager
        Connection connection = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

        // Check if the connection was successful
        if (connection != null) {
            System.out.println("Connection established successfully!");
        } else {
            System.out.println("Failed to establish connection.");
        }

        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection connection = connectToDatabase();
            // You can perform database operations here
            // Remember to close the connection when done
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}