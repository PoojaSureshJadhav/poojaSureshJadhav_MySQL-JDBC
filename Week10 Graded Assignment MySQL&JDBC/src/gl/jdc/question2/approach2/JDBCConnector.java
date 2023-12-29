package gl.jdc.question2.approach2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
	public static Connection getConnection() throws SQLException {
        String jdbc_Url = "jdbc:mysql://localhost:3306/GL";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(jdbc_Url, username, password);
    }
}
