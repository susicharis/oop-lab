package W5_Practice;
import java.util.ArrayList;
import java.util.Random;

public class numberList implements Readable {
    private ArrayList<Readable> readables;

    public numberList() {
        this.readables = new ArrayList<Readable>();
    }

    public void add(Readable readable2) {
        this.readables.add(readable2);
    }

    public String toString() {
        String read = "";
        for(Readable formatting : this.readables) {
            read += formatting.read();
        } return read;
    }

    public String read() {
        return "Reading";
    }



    public int howManyReadables() {
        return this.readables.size();
    }

    public static void main(String[] args) {
        numberList joeList = new numberList();
        joeList.add(new SMS2("Matthew","Im back home!"));
        joeList.add(new SMS2("Matthew","Order us some food!"));

        System.out.println(joeList);
        System.out.println(joeList.read());
        System.out.println("Joe has to read " + joeList.howManyReadables() + " messages");

        System.out.println("Interface as method return value: \n");
        CD firstCD = new CD("Eminem",2001);
        System.out.println(firstCD.getBarCode());

        Factory factory = new Factory();
        System.out.println(factory.produceNew());
    }

}


interface Item {
    public String getBarCode();
}

class CD implements Item {
    private String title;
    private int year;

    public CD(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String toString() {
        return "CD [Title: " + this.title + ", Year: " + this.year + "]";
    }

    @Override
    public String getBarCode() {
        return "CD";
    }
}

class BookNL implements Item {
    private String title;
    private int year;

    public BookNL(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String toString() {
        return "Book [Title: " + this.title + ", Year: " + this.year + "]";
    }

    public String getBarCode() {
        return "Book!";
    }
}
// Slide 59 - Interface as Method Return Value
class Factory {



    public Item produceNew() {
        Random random = new Random();
        int num = random.nextInt(4);

        if (num == 0) {
            return new CD("Pink Floyd",1973);
        }
        if (num == 1) {
            return new CD("Eminem",1999);
        }
        if (num == 2) {
            return new BookNL("Nibbles",2015);
        }
        else
            return new BookNL("Kent Beck", 1911);
    }
}