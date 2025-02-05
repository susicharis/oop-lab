package Midterm.Exercise_MostlyW4.W5_Practice;

public class InterfacePractice implements Readable {
    private String name;
    private String author;

    public InterfacePractice (String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }

    // Implementacija Interfacea
    public String read() {
        return "Person " + this.name + " is reading " + this.author;
    }

    public String readThis() {
        return "But this person " + this.name + " doesn't like to read " + this.author;
    }

    public static void main(String[] args) {
        InterfacePractice bookOne = new InterfacePractice("Haris","Tvrdjava");
        InterfacePractice bookTwo = new InterfacePractice("Becir","Pinokio");
        Readable bookThree = new InterfacePractice("Tokyo","Tokyo City");
        System.out.println(bookOne.read());
        System.out.println("Warabout this: " + bookThree.readThis());

        NotReading bookFirst = new NotReading("Becko","Mravojed");
        System.out.println(bookFirst.read());

        SMS firstSMS = new SMS("Becko","I am the best professor ever to live!");
        System.out.println(firstSMS.read());

        EBook firstEBook = new EBook("Fetucinijeva Prica",59);
        System.out.println(firstEBook.read());

        firstEBook.increasePage();
        firstEBook.increasePage();
        System.out.println(firstEBook.read());

    }

}

class SMS implements Readable {
    private String sender;
    private String content;

    public SMS(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }
    public String getContent() {
        return content;
    }

    public String read() {
        return "This sender: " + this.sender + ", sent this to me: " + this.content;
    }

    public String readThis() {
        return "This sender again " + this.sender + " sent something to me " + this.content;
    }

}

class NotReading implements Readable {
    private String secondName;
    private String secondAuthor;

    public NotReading(String secondName, String secondAuthor) {
        this.secondName = secondName;
        this.secondAuthor = secondAuthor;
    }

    public String getSecondName() {
        return secondName;
    }
    public String getSecondAuthor() {
        return secondAuthor;
    }

    public String read() {
        return "Person " + this.secondName + " is not reading " + this.secondAuthor;
    }

    public String readThis() {
        return "But this person " + this.secondName + " loves to eat cake but not read " + this.secondAuthor;
    }
}


class EBook implements Readable {
    private String bookName;
    private int pageNumber;

    public EBook(String bookName, int pageNumber) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
    }

    public void increasePage() {
        this.pageNumber++;
    }

    @Override
    public String read() {
        return "I am reading " + this.bookName + ", and I'm on page " + this.pageNumber;
    }

    public String readThis() {
        return "But he doesnt like to read this book: " + this.bookName + ", and he left on page " + this.pageNumber;
    }
}



interface Readable {
    String read();
    String readThis();
}



