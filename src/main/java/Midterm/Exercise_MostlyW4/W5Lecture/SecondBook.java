package Midterm.Exercise_MostlyW4.W5Lecture;
import java.util.ArrayList;

public class SecondBook implements MyReadable{
    private String name;
    private String AuthorName;

    public SecondBook(String name, String AuthorName) {
        this.name = name;
        this.AuthorName = AuthorName;
    }

    public String getName() {
        return name;
    }
    public String getAuthorName() {
        return AuthorName;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAuthorName(String AuthorName)  {
        this.AuthorName = AuthorName;
    }


    public String read() {
        return "Reading my book! ";
    }


} // end of class SecondBook

class SMS implements MyReadable {
    private String content;

    public SMS(String content) {
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





} // end of SMS class

interface MyReadable {
    public String read();
}

class NumList implements MyReadable {
    private ArrayList<MyReadable> readables;

    public NumList() {
        this.readables = new ArrayList<MyReadable>();
    }

    public void add(MyReadable readable) {
        this.readables.add(readable);
    }

    // Ovo kad ispisuje array - umjesto da ima zagrade fino ce ispisati !!
    public String read() {
        String read = "";
        for (MyReadable readable : this.readables) {
            read += readable.read() + "\n";
        }

        this.readables.clear();
        return read;
    }

    public int howManyReadables() {
        return this.readables.size();
    }


}




class MyMainClass {
    public static void main(String[] args) {
        SMS sms = new SMS("Haris");
        SecondBook book = new SecondBook("Haris","Informacije o Raku");

        System.out.println(sms.read());
        System.out.println(book.read());

        NumList harisList = new NumList();
        harisList.add(new SMS("Hey you are good guy!"));

        System.out.println("Haris has " + harisList.howManyReadables() + " messages to read!");
    }
}

