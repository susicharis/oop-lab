package ExamPrep;
import java.sql.*;
/*
Write a Java program that connects to a MysQL database and retrieves data from it.
The program has a method called getAnimals that has two parameters: name: String, id: int
The query should return all animals where name is
equal to the passed name and id is
greater then the passed id. Table name is "animals'
Once you obtain all the results from the database,
iterate through them and write to
the console all results in format: id + -› + name + -> + type
Example of connection string： "jdbe:mysql： //HOSTNAME:3306/DB_NAMENS
USERNAME: oopuser
PASSWORD: ooppassWD
HOSTNAME: oop.ibu.edu.ba
DB_NAME: oopgroup2
 */


class OOP {
    private static final String CONNECTION_STRING = "jdbe:mysql:oop.ibu.edu.ba:3306/oopgroup2";
    private static final String USERNAME = "oopuser";
    private static final String PASSWORD = "ooppassWD";

    Connection connection = null;

    public OOP() {
        try {
            connection = DriverManager.getConnection(
                    CONNECTION_STRING,
                    USERNAME,
                    PASSWORD
            );
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAnimals(String name, int id) throws SQLException {
        String query = "SELECT * FROM animals WHERE name = ? AND id > ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,name);
        statement.setInt(2,id);

        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            String animalName = rs.getString("name");
            int animalId = rs.getInt("id");
            String animalType = rs.getString("type");
        }
    }
}