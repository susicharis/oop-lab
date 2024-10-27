package Exercises;
import java.sql.*;

public class DBConnectExercise {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/employees";
    private static final String USERNAME = "haris";
    private static final String PASSWORD = "haris123";

    private Connection connection = null;

    public DBConnectExercise() {

        try {
            connection = DriverManager.getConnection(
                    CONNECTION_STRING,
                    USERNAME,
                    PASSWORD
            );

            } catch (SQLException e) {
            throw new RuntimeException("Cant connect to the database!");
        }
    }



    public void getAllTitles() throws SQLException{
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * from employees"
        );

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
        } // lista redom
    }



}
