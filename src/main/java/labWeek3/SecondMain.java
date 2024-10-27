package labWeek3;



import java.sql.SQLException;


public class SecondMain{
    public static void main(String[] args) {
        DbConnect dbConnect = new DbConnect();

        try {
            // Poziva getAllTitles metodu da prikaže prvih 5 naslova
            dbConnect.getAllTitles();

            // Poziva getTitlesByEmployeeId metodu za prikaz naslova zaposlenog sa ID-em 10001
            dbConnect.getTitlesByEmployeeId(10001);
        } catch (SQLException e) {
            e.printStackTrace(); // catch metoda
        }
    }
}
