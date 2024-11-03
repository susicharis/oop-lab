package W5Lecture;
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


class MyMainClass {
    public static void main(String[] args) {
        SMS sms = new SMS("Haris");
        SecondBook book = new SecondBook("Haris","Informacije o Raku");

        System.out.println(sms.read());
        System.out.println(book.read());
    }
}