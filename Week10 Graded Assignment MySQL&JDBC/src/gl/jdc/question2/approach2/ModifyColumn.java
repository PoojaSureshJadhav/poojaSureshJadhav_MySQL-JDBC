package gl.jdc.question2.approach2;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class ModifyColumn {
    public static void main(String[] args) {
        try (Connection connection = JDBCConnector.getConnection();
             Statement statement = connection.createStatement()) {

            String modifyColumnQuery = "ALTER TABLE employee MODIFY Email_Id VARCHAR(30) NOT NULL";
            statement.executeUpdate(modifyColumnQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
