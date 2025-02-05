package Midterm.Exercise_MostlyW4.W5_Practice;
import java.util.ArrayList;

public class FootballClub {
    private String name;
    private int yearOfFoundation;
    // list of objects within object "players"
    private ArrayList<Person> players;

    public FootballClub(String name, int yearOfFoundation) {
        this.name = name;
        this.yearOfFoundation = yearOfFoundation;
        this.players = new ArrayList<Person>();
        // lista players postoji ali je prazna
        // odmah je kreirana prilikom inicijalizacije konstruktora
        // moramo napraviti metodu preko koje cemo dodavati igrace
    }

    public String getName() {
        return name;
    }
    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    // DODAJEMO PLAYERE U NASU ARRAYLISTU OBJEKATA
    // Parametar tipa Person u metodi addPlayer mora biti naveden
    // jer metoda treba da zna koji tip objekta će primiti i dodati u ArrayList.
    public void addPlayer(Person igraci) {
        this.players.add(igraci);
    }


    // Method returns an Object
    public Person oldestPlayer() {
        Person oldestOne = players.get(0);
        for(Person findOldest : players) {
            if (oldestOne.getAge() < findOldest.getAge()) {
                oldestOne = findOldest;
            }
        } return oldestOne;
    }

    @Override
    public String toString() {
        String formatting = " ";

        for(Person igraci : players) {
            formatting += igraci.toString() + "\n";
        } return this.name + "-" + this.yearOfFoundation + ", Igrac: " + formatting;
    }



    public static void main(String[] args) {
        FootballClub barcelona = new FootballClub("Barcelona",1953);
        myDate firstPlayerDate = new myDate(30,8,2004);
        Person firstPlayerPerson = new Person("Haris",20, firstPlayerDate);

        barcelona.addPlayer(firstPlayerPerson);

        // barcelona.setYearOfFoundation(1890);

        System.out.println(barcelona);

        // Method returns an Object
        System.out.println("Method returns an Object: \n");
        System.out.println(barcelona.oldestPlayer());
        // Moramo pozvati objekat klase FootballCLub zato sto se tu nalaze svi igraci !!








    }


}
