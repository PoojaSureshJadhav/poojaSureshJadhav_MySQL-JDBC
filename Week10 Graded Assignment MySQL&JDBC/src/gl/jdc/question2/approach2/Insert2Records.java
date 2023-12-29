package gl.jdc.question2.approach2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert2Records {
    public static void main(String[] args) {
        try (Connection connection = JDBCConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee (Id, Name, Email_Id, Phone_Number) VALUES (?, ?, ?, ?)")) {

            // Insert 2 additional records
            InsertRecords.insertRecord(preparedStatement, 6, "Eva Davis", "eva@example.com", "1112223333");
            InsertRecords.insertRecord(preparedStatement, 7, "Frank White", "frank@example.com", "4445556666");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
