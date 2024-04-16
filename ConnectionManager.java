import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
    // Logger for logging errors and information
    private static final Logger LOGGER = Logger.getLogger(ConnectionManager.class.getName());

    // Define the connection parameters
    private static final String SERVER = "jdbc:mysql://localhost:3306/food"; // JDBC URL for the database
    private static final String USERNAME = System.getenv("root");
    private static final String PASSWORD = System.getenv("");

    // Method to establish a connection to the database
    public static Connection connectToDatabase() throws SQLException {
        // Load the JDBC driver for MySQL (optional in modern JDBC)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Failed to load MySQL driver", e);
            throw new SQLException("MySQL driver not found", e);
        }

        // Establish a connection using DriverManager
        Connection connection = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

        // Log successful connection
        LOGGER.log(Level.INFO, "Connection established successfully!");

        return connection;
    }
}
