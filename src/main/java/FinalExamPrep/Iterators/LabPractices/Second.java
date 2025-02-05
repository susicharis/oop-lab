package FinalExamPrep.Iterators.LabPractices;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Movie {
    String title;
    String director;
    String releaseYear;
    double rating;

    public Movie(String title, String director, String releaseYear, double rating) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public double getRating() {
        return this.rating;
    }

    @Override
    public String toString() {
        return "Title : " + this.title + ", Director : " + this.director + ", Release Year : " + this.releaseYear + ", Rating: " + this.rating;
    }
}

class RatingFilterIterator implements Iterator<Movie> {
    List<Movie> movies;
    double minRating;
    int currentIndex = 0;

    public RatingFilterIterator(List<Movie> movies, double minRating) {
        this.movies = movies;
        this.minRating = minRating;
    }

    @Override
    public boolean hasNext() {
        int tempIndex = currentIndex;
        while (tempIndex < movies.size()) {
            if (movies.get(tempIndex).getRating() >= minRating) {
                return true;
            }
            tempIndex++;
        }
        return false;
    }

    @Override
    public Movie next() {
        while (currentIndex < movies.size()) {
            Movie movie = movies.get(currentIndex++);
            if (movie.getRating() >= minRating) {
                return movie;
            }
        }
        return movies.get(currentIndex++);
    }
}

class Main08 {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Spiderman I", "Robert Downey Jr", "2004", 2.5));
        movies.add(new Movie("Spiderman II", "Robert Downey Jr", "2008", 2.9));
        movies.add(new Movie("Iron Man I", "Clark Kent", "2013", 4.1));
        movies.add(new Movie("Iron Man I", "Clark Kent", "2013", 2.9));

        RatingFilterIterator iterator = new RatingFilterIterator(movies, 2.6);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


