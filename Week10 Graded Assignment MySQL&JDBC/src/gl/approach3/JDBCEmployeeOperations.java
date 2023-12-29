package gl.jdbc.question2.approach3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCEmployeeOperations {
	static final String jdbc_Driver = "com.mysql.cj.jdbc.Driver";
	static final String db_URL = "jdbc:mysql://localhost:3306/GL";
	static final String user_Name = "root";
	static final String pass = "root";  

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			// Register JDBC driver
			Class.forName(jdbc_Driver);

			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(db_URL, user_Name, pass);

			// a. Insert 5 records
			insertRecords(conn, stmt, 1, "John Doe", "john@example.com", "1234567890");
                        insertRecords(conn, stmt, 2, "Jane Smith", "jane@example.com", "9876543210");
                        insertRecords(conn, stmt, 3, "Bob Johnson", "bob@example.com", "4567890123");
                        insertRecords(conn, stmt, 4, "Alice Brown", "alice@example.com", "7890123456");
                        insertRecords(conn, stmt, 5, "Charlie Wilson", "charlie@example.com", "0123456789");

			// b. Modify Email_Id column to varchar(30) NOT NULL
			modifyEmailColumn(conn);

			// c. Insert 2 records and check
			insertRecords(conn, stmt, 6, "Eva Davis", "eva@example.com", "1112223333");
                        insertRecords(conn, stmt, 7, "Frank White", "frank@example.com", "4445556666");

			// d. Update the name of employee Id 3 to Karthik and phone number to 1234567890
			updateEmployeeDetails(conn, 3, "Karthik", "1234567890");

			// e. Delete employee records 3 and 4
			deleteEmployeeRecords(conn, 3);
			deleteEmployeeRecords(conn, 4);

			// f. Remove all records from the table employee
			removeAllRecords(conn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) 
					stmt.close();
				if (conn != null) 
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	private static void insertRecords(Connection conn, PreparedStatement stmt, int id, String name, String email, String phoneNumber) throws SQLException {
        stmt = conn.prepareStatement("INSERT INTO employee (Id, Name, Email_Id, Phone_Number) VALUES (?, ?, ?, ?)");
        stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setString(3, email);
		stmt.setString(4, phoneNumber);
		stmt.executeUpdate();
	}


	private static void modifyEmailColumn(Connection conn) throws SQLException {
		String modifyQuery = "ALTER TABLE employee MODIFY Email_Id VARCHAR(30) NOT NULL";
		try (PreparedStatement stmt = conn.prepareStatement(modifyQuery)) {
			stmt.executeUpdate();
		}
	}

	private static void updateEmployeeDetails(Connection conn, int employeeId, String name, String phoneNumber) throws SQLException {
		String updateQuery = "UPDATE employee SET Name=?, Phone_Number=? WHERE Id=?";
		try (PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
			stmt.setString(1, name);
			stmt.setString(2, phoneNumber);
			stmt.setInt(3, employeeId);
			stmt.executeUpdate();
		}
	}

	private static void deleteEmployeeRecords(Connection conn, int employeeId) throws SQLException {
		String deleteQuery = "DELETE FROM employee WHERE Id=?";
		try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
			stmt.setInt(1, employeeId);
			stmt.executeUpdate();
		}
	}

	private static void removeAllRecords(Connection conn) throws SQLException {
		String deleteAllQuery = "DELETE FROM employee";
		try (PreparedStatement stmt = conn.prepareStatement(deleteAllQuery)) {
			stmt.executeUpdate();
		}
	}
}
