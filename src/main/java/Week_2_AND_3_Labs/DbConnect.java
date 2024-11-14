package Week_2_AND_3_Labs;

import java.sql.*;

public class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/employees";
    private static final String USERNAME = "my_user"; // Proveri da li je ovo tačno
    private static final String PASSWORD = "my_password"; // Proveri da li je ovo tačno



    private Connection connection = null;

    public DbConnect() {
        try {
            connection = DriverManager.getConnection(
                    CONNECTION_STRING,
                    USERNAME,
                    PASSWORD
            );
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to the database: " + e.getMessage(), e);
        }
    }

    public void getAllTitles() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM titles LIMIT 5"
        );
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("title")); // Zavisno od naziva kolone
            System.out.println(resultSet.getInt("emp_no")); // Broj zaposlenog
            System.out.println(resultSet.getDate("from_date")); // Datum od kada je naslov
            System.out.println(resultSet.getDate("to_date")); // Datum do kada je naslov
        }
    }

    public void getTitlesByEmployeeId(int empNo) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM titles WHERE emp_no = ?"
        );
        statement.setInt(1, empNo);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("title")); // Zavisno od naziva kolone
            System.out.println(rs.getDate("from_date"));
            System.out.println(rs.getDate("to_date"));
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Failed to close connection: " + e.getMessage());
            }
        }
    }
}
