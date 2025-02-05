package Midterm.Exercise_MostlyW4.ExamPrep;
// private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/employees";
import java.sql.*;

public class DBConnect {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/employees";
    private static final String USERNAME = "my_username";
    private static final String PASSWORD = "my_password";

    Connection connection = null;

    public DBConnect() {
        try {
            connection = DriverManager.getConnection(
                    CONNECTION_STRING,
                    USERNAME,
                    PASSWORD
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void printAllTitles() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
            "SELECT * From employees"
        );

        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            rs.getInt("emp_no");
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


} // end