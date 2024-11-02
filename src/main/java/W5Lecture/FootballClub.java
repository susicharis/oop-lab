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
    // Getters
    public String getName() {
        return name;
    }
    public int getYearOfFoundation() {
        return yearOfFoundation;
    }
    public ArrayList<FBClubPerson> getPlayers() {
        return players;
    }
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }
    public void setPlayers(ArrayList<FBClubPerson> players) {
        this.players = players;
    }

// metoda omogucava dodavanje igraca u listu players
    public void addPlayer(FBClubPerson player) {
        this.players.add(player);
    }
// vraca string koji predstavlja sve igrace kluba
// iterira kroz listu players i dodaje string reprezentaciju svakog igraca
    public String toString() {
        String playersString = " ";

        for(FBClubPerson player : players) {
            playersString += player + " ";
        }
        return playersString;
    }


    public static void main(String[] args) {
        FootballClub club1 = new FootballClub("Real Madrid", 1953);
        FootballClub club2 = new FootballClub("Barcelona", 1981);

        FBClubPerson player1 = new FBClubPerson("Cristiano Ronaldo", 39);
        FBClubPerson player2 = new FBClubPerson("Lionel Messi", 37);

        club1.addPlayer(player1);
        club2.addPlayer(player2);

        System.out.println("First club: " + club1.getName());
        System.out.println("Best player: " + player1);

        System.out.println("Their rival: " + club2.getName());
        System.out.println("Best player: " + player2);




    }
}
