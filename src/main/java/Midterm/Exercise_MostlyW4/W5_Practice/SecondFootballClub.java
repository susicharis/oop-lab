package Midterm.Exercise_MostlyW4.W5_Practice;
import java.util.ArrayList;

public class SecondFootballClub {
    private String name;
    private int yearOfFoundation;
    private ArrayList<Person> newPlayers;

    public SecondFootballClub(String name, int yearOfFoundation) {
        this.name = name;
        this.yearOfFoundation = yearOfFoundation;
        this.newPlayers = new ArrayList<Person>();
    }

    // klase Person zato sto je i dole i mora tako jednostavno
    public void addPlayerToList(Person igrac) {
        this.newPlayers.add(igrac);
    }

    @Override
    public String toString() {
        String formatting = " ";

        for (Person players : newPlayers) {
            formatting += players.toString() + "\n";
        }
        return formatting;
    }


    public static void main(String[] args) {
        SecondFootballClub betterFirstClub = new SecondFootballClub("Real Madrid",1958);
        myDate dateForPerson = new myDate(29,10,2000);
        Person bestPlayer = new Person("Cristiano Ronaldo",40,dateForPerson);


        betterFirstClub.addPlayerToList(bestPlayer);
        System.out.println(betterFirstClub);

    }

}
