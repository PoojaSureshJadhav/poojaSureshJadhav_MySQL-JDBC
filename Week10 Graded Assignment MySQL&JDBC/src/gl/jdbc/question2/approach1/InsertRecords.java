package gl.jdbc.question2.approach1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecords {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/GL";
    static final String USER_NAME = "root";
    static final String PASS = "root";
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
        	// Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASS);
            preparedStatement = connection.prepareStatement("INSERT INTO employee (Id, Name, Email_Id, Phone_Number) VALUES (?, ?, ?, ?)");
            
            // Insert 5 records without using a loop
            insertRecord(preparedStatement, 1, "John Doe", "john@example.com", "1234567890");
            insertRecord(preparedStatement, 2, "Jane Smith", "jane@example.com", "9876543210");
            insertRecord(preparedStatement, 3, "Bob Johnson", "bob@example.com", "4567890123");
            insertRecord(preparedStatement, 4, "Alice Brown", "alice@example.com", "7890123456");
            insertRecord(preparedStatement, 5, "Charlie Wilson", "charlie@example.com", "0123456789");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	connection.close();
        }
    }

    static void insertRecord(PreparedStatement preparedStatement, int id, String name, String email, String phoneNumber) throws SQLException {
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, phoneNumber);
        preparedStatement.executeUpdate();
    }
}
