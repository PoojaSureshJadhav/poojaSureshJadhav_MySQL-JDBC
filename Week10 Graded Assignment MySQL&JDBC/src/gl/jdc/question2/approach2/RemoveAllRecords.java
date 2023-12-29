package gl.jdc.question2.approach2;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class RemoveAllRecords {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = JDBCConnector.getConnection();
				Statement statement = connection.createStatement()) {

			String removeAllRecordsQuery = "DELETE FROM employee";
			statement.executeUpdate(removeAllRecordsQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
