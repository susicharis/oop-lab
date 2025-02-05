package Midterm.Exercise_MostlyW4.W5_Practice;

public class EqualsMethodOverride {
    private String author;
    private String name;

    public EqualsMethodOverride(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object anyObject) {
        if (anyObject == null)
            return false;

        if (anyObject instanceof EqualsMethodOverride) {
            EqualsMethodOverride insideBook = (EqualsMethodOverride) anyObject;

            if (
                    this.author.equals(insideBook.getAuthor()) && this.name.equals(insideBook.getName())
            ) {
                return true;
            }
        } return false;
    }

    public static void main(String[] args) {
        EqualsMethodOverride prvaKnjiga = new EqualsMethodOverride("Becir","Pinokio");
        EqualsMethodOverride drugaKnjiga = new EqualsMethodOverride("Becir", "Pinokio");
        EqualsMethodOverride trecaKnjiga = new EqualsMethodOverride("Haris", "Tvrdjava");

        System.out.println(prvaKnjiga.equals(drugaKnjiga));
        System.out.println(drugaKnjiga.equals(trecaKnjiga));


    }

}
