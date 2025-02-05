package Midterm.Exercise_MostlyW4.W5Lecture;

import java.util.ArrayList;

public class EBook implements YourReadable {
    private String name;
    private ArrayList<String> pages;
    private int pageNumber;

    public EBook(String name, ArrayList<String> pages) {
        this.name = name;
        this.pages = pages;
        this.pageNumber = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public int numberOfPages() {
        return this.pages.size();
    }


    public int nextPage() {
        if (pageNumber < pages.size() - 1) {
            pageNumber++;
        }
        return pageNumber;
    }


    public String read() { // interface read() metoda
        if (pageNumber < pages.size()) {
            String page = this.pages.get(pageNumber);
            nextPage();
            return page;
        } else {
            return "No more pages to read.";
        }
    }

    // MAIN ------------------------------------------------------>
    public static void main(String[] args) {

        ArrayList<String> bookPages = new ArrayList<>();
        bookPages.add("Page 1: Introduction");
        bookPages.add("Page 2: Chapter 1");
        bookPages.add("Page 3: Chapter 2");

        EBook ebook = new EBook("My EBook", bookPages);
        for (int i = 0; i < ebook.numberOfPages(); i++) {
            System.out.println(ebook.read());
        }
        // Pokazivanje pokusaja citanja vise od dostupnih stranica
        System.out.println(ebook.read());// Ocekuje se "No more pages to read"


        ArrayList<YourReadable> numList = new ArrayList<>();
        numList.add(new SecondSMS("Never programmed before."));
        numList.add(new SecondSMS("Maybe I did now?"));
        numList.add(new SecondSMS("Give me something better!"));
        numList.add(ebook);

        for (YourReadable readable : numList) {
            System.out.println(readable.read());
        }



        System.out.println();

        SecondSMS message = new SecondSMS("Becir is an amazing guy!");
        YourReadable secondReadable = new SecondSMS("But Haris is better!");
        Object obj = new SecondSMS("Awesome object!");

        System.out.println(message.getContent());
        System.out.println(secondReadable.read());
        System.out.println(obj); // adresa

        YourReadable example = new SecondSMS("Hello Guys ITS ME !");
        // ovo radi zato sto SMS implementira YourReadable inteface

        // SecondSMS example2 = example;
        // ovo ne radi jer readable ima tip MyReadable.
        // Iako "readable" sadrzi instancu SMS klase, ona trenutno nije tako prepoznata, vec samo kao "YourReadable"

        System.out.println();
        System.out.println("Printer printer: ");
        System.out.println();
        Printer printer = new Printer();
        printer.print(message);
        printer.print(secondReadable);



    }

} // end of EBook class

class SecondSMS implements YourReadable {
    private String content;

    public SecondSMS(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String read() {
        return this.content;
    }

} // end of SecondSMS class

class Printer {
    public void print(YourReadable readable) {
        System.out.println(readable.read());
    }
}

interface YourReadable {
    public String read();

} // end of YourReadable interface
