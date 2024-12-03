package Week_2_AND_3_Labs;

import java.sql.*;

   public class DbConnect {
            private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/employees";
            private static final String USERNAME = "my_user";
            private static final String PASSWORD = "my_password";

            private Connection connection = null;

            public DbConnect() {
                try {
                    connection = DriverManager.getConnection(
                            CONNECTION_STRING,
                            USERNAME,
                            PASSWORD
                    );
                } catch (SQLException e) {
                    throw new RuntimeException("Cant Connect... " + e.getMessage() + e);
                }
            }

            public void getAllTitles() throws SQLException {
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * From employees"
                );

                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()) {
                    resultSet.getString("title");
                    resultSet.getInt("emp_no");
                }

            }

            public void closeConnection() {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.err.println("Failed to give..." + e.getMessage() + e);
                    }
                }
            }



        } // end