package gl.jdc.question2.approach2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecords {
    public static void main(String[] args) {
        try (Connection connection = JDBCConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE Id IN (?, ?)")) {

            // Delete employee records 3 and 4
            preparedStatement.setInt(1, 3);
            preparedStatement.setInt(2, 4);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}