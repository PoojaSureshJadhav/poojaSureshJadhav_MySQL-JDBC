package gl.jdc.question2.approach2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee {
    public static void main(String[] args) {
        try (Connection connection = JDBCConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET Name = ?, Phone_Number = ? WHERE Id = ?")) {

            // Update employee Id 3
            preparedStatement.setString(1, "Karthik");
            preparedStatement.setString(2, "1234567890");
            preparedStatement.setInt(3, 3);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
