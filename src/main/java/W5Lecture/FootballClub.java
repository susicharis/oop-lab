package W5Lecture;

import java.util.ArrayList;

public class FootballClub {

    private String name;
    private int yearOfFoundation;
    private ArrayList<FBClubPerson> players;

    public FootballClub(String name, int yearOfFoundation) {
        this.name = name;
        this.yearOfFoundation = yearOfFoundation;
        this.players = new ArrayList<FBClubPerson>();
    }

    public String getName() {
        return name;
    }
    public int getYearOfFoundation() {
        return yearOfFoundation;
    }
    public ArrayList<FBClubPerson> getPlayers() {
        return players;
    }

    void setName(String name) {
        this.name = name;
    }
    void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }
    void setPlayers(ArrayList<FBClubPerson> players) {
        this.players = players;
    }


    void addPlayer(FBClubPerson player) {
        // playera kojeg ti proslijedim, proslijedi ga glavnom atributu klase
        this.players.add(player);
    }

    public String toString() {
        String playersString = "";

        for (FBClubPerson player : players) {
            playersString += player.toString();
        }
        return playersString;
    }



    public static void main(String[] args) {

        FootballClub firstClub = new FootballClub("FC Barcelona", 1963);
        FootballClub secondClub = new FootballClub("Real Madrid FC", 1955);

        // pozivamo konstruktor iz FBClubPerson klase
        FBClubPerson firstPlayer = new FBClubPerson("Cristiano Ronaldo", 39);
        FBClubPerson secondPlayer = new FBClubPerson("Haris Susic", 20);

        // u objekte dodajemo playere, jer objekti sadrze atribute klase

        firstClub.addPlayer(firstPlayer);
        secondClub.addPlayer(secondPlayer);

        System.out.println("First club: " + firstClub.getName());
        // automatski se poziva toString metoda iz klase FootballClub, tako da prikazuje igrace
        // u formatu Stringa, umjesto ArrayLista - JER OVERRIDEA
        System.out.println("Their best player: " + firstClub);

        System.out.println("Second club: " + secondClub.getName());
        System.out.println("Their best player: " + secondClub);



    }
}
