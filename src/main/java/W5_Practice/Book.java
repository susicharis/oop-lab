package W5_Practice;
import java.util.ArrayList;

public class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }


    @Override
    public boolean equals(Object acceptAnyObject) {
        if (acceptAnyObject == null)
            return false;
        if (acceptAnyObject instanceof Book) {
            Book otherBook = (Book) acceptAnyObject;

            if (
                    this.author.equals(otherBook.getAuthor()) && this.title.equals(otherBook.getTitle())
            ) {
                return true;
            }
        } return false;



    }


    public static void main(String[] args) {
        Book firstBook = new Book("Becir","Tvrdjava");
        Book secondBook = new Book("Haris","Pinokio");
        System.out.println(firstBook);

        // Vraca false zato sto smo uzeli direktno vrijednost Titlea i NIJE ISTO!
        if(firstBook.getTitle().equals(secondBook.getTitle())) {
            System.out.println("They are the same!");
        } else
            System.out.println("Nah nigga");

        // Vraca false opet jer ne pokazuju na istu adresu ! (new Book razlog)
        if (firstBook.equals(secondBook)) {
            System.out.println("They are the same reference!");
        } else
            System.out.println("Again, nah nigga.");


        Book thirdBook = new Book("Tarik","Sud");
        Book fourthBook = thirdBook;

        // fourthBook pointa na thirdBook koji pointa na istu vrijednost !
        if(thirdBook.equals(fourthBook)) {
            System.out.println("Same! Reference!");
        } else
            System.out.println("Not the same!");

        // Override "equals" metoda koju smo modificirali
        System.out.println("Override metoda: \n");
       System.out.println(secondBook.equals(firstBook));



       // contains() Metoda Slide 41
        System.out.println("Contains metoda, klase ArrayList: \n");
        ArrayList<Book> knjizara = new ArrayList<>();
        knjizara.add(firstBook);
        knjizara.add(secondBook);

        if (knjizara.contains(thirdBook)) {
            System.out.println("It does contain all three!");
        } else
            System.out.println("It's missing third book.");





    }






}
