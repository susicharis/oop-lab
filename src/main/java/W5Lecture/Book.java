package W5Lecture;

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
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }




    @Override
    public boolean equals(Object castedObject) {
        if (castedObject == null) return false;

        if (castedObject instanceof Book) {
            Book newBook = (Book) castedObject;

            if (
                    this.author.equals(newBook.getAuthor()) && this.title.equals(newBook.getTitle())
            ) {
                return true;
            }
        } return false;


    }


    public static void main(String[] args) {
        Book book1 = new Book("Haris Susic", "King of the Jungle");
        Book book2 = new Book("Haris Susic", "King of the Jungle");
        Book book3 = new Book("Tarik Topic", "I like beer problems");
//        book2 = new Book("Haris Susic", "King of the Jungle"); // random

        if (book1.getTitle().equals(book2.getTitle())) { // vraca true jer uzimamo String titlea od oba
            System.out.println("The titles are the same!");
        } else
            System.out.println("The titles are not the same!");


        System.out.println();

        // vratiti ce false jer NE POKAZUJU NA ISTU MEMORIJSKU LOKACIJU !!!!!!!
        // kad bi overrideali onda bi uporedilo title i authora !
        if(book1.equals(book2)) {
            System.out.println("The titles are the same!");
        } else
            System.out.println("The titles are not the same!");

        System.out.println();

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        if(!books.contains(book3)) {
            System.out.println(book3.getTitle());
        }
    }







}
