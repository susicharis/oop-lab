package W5_Practice;

import java.util.ArrayList;

public class SMS2 implements Readable{
    private String sender;
    private String content;

    public SMS2(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public String read() {
        return this.sender + " says : " + this.content;
    }

    public String readThis() {
        return this.sender + " says : " + this.content;
    }

    public String toString() {
        return this.sender + " " + this.content;
    }

    public static void main(String[] args) {

        // Interface as an variable type - type of object can be different from its class
        // If class implements interface Readable, its type can be Readable, too.
        SMS2 message = new SMS2("Teacher","Awesome Stuff!");
        Readable message2 = new SMS2("Becko","Amazing guy!");
        Object obj = new SMS("Keco","Also amazing!");

        System.out.println(message.read());

        ArrayList <Readable> numberList = new ArrayList<>();
        numberList.add(new SMS2("Teacher","Welcome back to class!"));
        numberList.add(new SMS2("Student","I dont wanna be here."));

        for (Readable readingThrough : numberList) {
            System.out.println(readingThrough.read());
        }

        // Type-Cast kad "readable2" ne znamo da li je instanca klase SMS2, pa moramo type cast
        SMS2 thisMessage = new SMS2("teacher", "The SMS is Readable!");
        Readable readable = thisMessage;  // Ovo radi jer SMS implementira MyReadable

        Readable readable2 = new SMS2("Hitler","Jews are awesome!");
        SMS2 thisMessage2 = (SMS2) readable2;

        System.out.println(thisMessage2);






    }
}

