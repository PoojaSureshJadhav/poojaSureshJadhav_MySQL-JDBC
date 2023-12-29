package gl.jdbc.question2.approach1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/GL";
    static final String USER_NAME = "root";
    static final String PASS = "root";
    
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASS);
            preparedStatement = connection.prepareStatement("UPDATE employee SET Name = ?, Phone_Number = ? WHERE Id = ?");
            
            // Update employee Id 3
            preparedStatement.setString(1, "Karthik");
            preparedStatement.setString(2, "1234567890");
            preparedStatement.setInt(3, 3);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	connection.close();
        }
    }
}