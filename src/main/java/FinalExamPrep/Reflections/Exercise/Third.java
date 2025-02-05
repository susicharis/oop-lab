package FinalExamPrep.Reflections.Exercise;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class Book {
    String title;
    String author;
    int ISBN;
    List<Double> ratings;

    public Book(String title, String author, int ISBN, Double[] ratings) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.ratings = Arrays.asList(ratings);
    }

    public void printDetails() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN:" + this.ISBN );
        for(double d : ratings) {
            System.out.println("Rating: " + d);
        }
    }

}

class RatingAnalyzer {
    List<Double> ratings;

    public RatingAnalyzer(Double[] ratings) {
        this.ratings = Arrays.asList(ratings);
    }

    public double calculateAverageRating() {
        double sum = 0;
        for(double n : ratings) {
            sum += n;
        } return sum / ratings.size();
    }

    public void printRatingSummary() {
        System.out.println("Average Rating: " + calculateAverageRating());
    }
}

class Start3 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Double[] rating = {10.0,9.8,7.6};
        Book book = new Book("Ivica i Marica","Branko Copic",98,rating);
        RatingAnalyzer ra = new RatingAnalyzer(rating);

        // Book Fields
        Field[] bookField = book.getClass().getDeclaredFields();
        for(Field bf : bookField) {
            bf.setAccessible(true);
            System.out.println("Field name: " + bf.getName() + ", Field Value: " + bf.get(book));
        }

        // Book Method
        Method[] bookMethod = book.getClass().getDeclaredMethods();
        for(Method bm : bookMethod) {
            bm.setAccessible(true);
            if(bm.getName().startsWith("calculate") || bm.getName().startsWith("print")) {
                if(bm.getReturnType() != void.class) {
                    System.out.println("Method: " + bm.getName() + " non-void return type: " + bm.invoke(ra));
                } else {
                    System.out.println("Method: " + bm.getName() + " void return type: " + bm.invoke(book));
                }
            }
        }


        // RatingAnalyzer Fields
        Field[] raField = ra.getClass().getDeclaredFields();
        for(Field raf : raField) {
            raf.setAccessible(true);
            System.out.println("Field name: " + raf.getName() + ", Field Value: " + raf.get(ra));
        }

        // RatingAnalyzer Method
        Method[] raMethod = ra.getClass().getDeclaredMethods();
        for(Method ram : raMethod) {
            ram.setAccessible(true);
            if(ram.getName().startsWith("calculate") || ram.getName().startsWith("print")) {
                if(ram.getReturnType() != void.class) {
                    System.out.println("Method: " + ram.getName() + ", non-void type: " + ram.invoke(ra));
                } else {
                    System.out.println("Method: " + ram.getName() + " void type.");
                }
            }
        }

    }
}
