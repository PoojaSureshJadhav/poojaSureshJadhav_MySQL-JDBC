package gl.jdbc.question2.approach1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ModifyColumn {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/GL";
    static final String USER_NAME = "root";
    static final String PASS = "root";
    
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = null;
        Statement statement = null;

		try {
			// Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASS);
            String modifyColumnQuery = "ALTER TABLE employee MODIFY Email_Id VARCHAR(30) NOT NULL";
            statement = connection.createStatement();
            statement.executeUpdate(modifyColumnQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	connection.close();
        }
    }
}
