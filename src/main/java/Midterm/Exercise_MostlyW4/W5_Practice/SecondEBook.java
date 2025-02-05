package Midterm.Exercise_MostlyW4.W5_Practice;
import java.util.ArrayList;

// Implementira Readable iz InterfacePractice.java
public class SecondEBook implements Readable {
    private String name;
    private ArrayList<String> pages;
    private int pageNumber;

    public SecondEBook(String name, ArrayList<String> pages) {
        this.name = name;
        this.pages = pages;
        this.pageNumber = 0;
    }

    public String getName() {
        return name;
    }

    public int numOfPages() {
        return this.pages.size();
    }

    private void nextPage() {
        this.pageNumber += 1;
    }

    public String read() {
        String pageNum = this.pages.get(this.pageNumber);
        nextPage();
        return pageNum;
    }

    public String readThis() {
        String pageNumber = this.pages.get(this.pageNumber);
        nextPage();
        nextPage();
        System.out.println("oof I skipped 2 pages! ");
        return pageNumber;
    }


    public String toString() {
        String formatting = "";
        for (String stranice : pages) {
            formatting += stranice.toString() + "\n";
        } return this.name + " " + formatting;
    }



    public static void main(String[] args) {
        ArrayList<String> pages = new ArrayList<>();
        pages.add("This is page 1");
        pages.add("This is page 2");
        pages.add("This is page 3");

        SecondEBook formattedText = new SecondEBook("Tvrdjava \n", pages);
        System.out.println(formattedText);

        ArrayList<Person> osoba = new ArrayList<>();
        myDate godine = new myDate(30,8,2004);
        osoba.add(new Person("Haris",24, godine));

    }
}


