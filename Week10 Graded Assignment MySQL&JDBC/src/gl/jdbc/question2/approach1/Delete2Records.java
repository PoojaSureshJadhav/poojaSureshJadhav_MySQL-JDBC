package gl.jdbc.question2.approach1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete2Records {
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
            preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE Id IN (?, ?)");

            // Delete employee records 3 and 4
            preparedStatement.setInt(1, 3);
            preparedStatement.setInt(2, 4);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	connection.close();
        }
    }
}
