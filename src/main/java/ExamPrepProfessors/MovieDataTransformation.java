package ExamPrepProfessors;


import java.io.*;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

enum TextFormatter2 {
    ORDINARY,UPPER_CASE,LOWER_CASE
}
enum NumberFormatter2 {
    CURRENCY,PERCENTAGE
}

@interface FieldFormat2 {
    TextFormatter2 text_format() default TextFormatter2.ORDINARY;
    NumberFormatter2 number_format() default NumberFormatter2.CURRENCY;
}

class Movie {
    @FieldFormat2
    private Date releaseDate;

    @FieldFormat2(text_format = TextFormatter2.ORDINARY)
    private String title;

    @FieldFormat2(number_format = NumberFormatter2.CURRENCY)
    private double boxOffice;

    @FieldFormat2(number_format = NumberFormatter2.PERCENTAGE)
    private double rating;

    @FieldFormat2(text_format = TextFormatter2.UPPER_CASE)
    private String genre;

    @FieldFormat2(text_format = TextFormatter2.UPPER_CASE)
    private String director;

    @FieldFormat2(text_format = TextFormatter2.LOWER_CASE)
    private String langauge;

    public Movie(MovieBuilder builder) {
        this.releaseDate = builder.releaseDate;
        this.title = builder.title;
        this.boxOffice = builder.boxOffice;
        this.rating = builder.rating;
        this.genre = builder.genre;
        this.director = builder.director;
        this.langauge = builder.langauge;
    }


    static class MovieBuilder {
        private Date releaseDate;
        private String title;
        private double boxOffice;
        private double rating;
        private String genre;
        private String director;
        private String langauge;

        public MovieBuilder setReleaseDate(Date releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }
        public MovieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
        public MovieBuilder setBoxOffice(double boxOffice) {
            this.boxOffice = boxOffice;
            return this;
        }
        public MovieBuilder setRating(double rating) {
            this.rating = rating;
            return this;
        }
        public MovieBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }
        public MovieBuilder setDirector(String director) {
            this.director = director;
            return this;
        }
        public MovieBuilder setLangauge(String langauge) {
            this.langauge = langauge;
            return this;
        }
        public Movie getResults() {
            return new Movie(this);
        }
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
    public String getTitle() {
        return title;
    }
    public double getBoxOffice() {
        return boxOffice;
    }
    public double getRating() {
        return rating;
    }
    public String getGenre() {
        return genre;
    }
    public String getDirector() {
        return director;
    }
    public String getLangauge() {
        return langauge;
    }
}


class InvalidMovieDataException extends RuntimeException {
    public InvalidMovieDataException(String message) {
        super(message);
    }
    public InvalidMovieDataException(String message, Throwable cause) {
        super(message,cause);
    }
}

class MovieLeader {
    List<Movie> movieList = new ArrayList<>();

    public MovieLeader(String filename) {
        this.movieList = loadMovies(filename);
    }

    public List<Movie> getMovieList() {
        return this.movieList;
    }

    public List<Movie> loadMovies(String fileName) {
        List<Movie> insideList = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<String> lines = reader.lines().collect(Collectors.toList());

            for(int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");           // [1] , [2] , [3]

                if(parts[1] == "" || parts[2] == "" || parts[3] == "") {
                    throw new InvalidMovieDataException("Invalid data",new ClassCastException());
                }


                insideList.add(
                        new Movie.MovieBuilder()
                                .setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse(parts[0]))
                                .setTitle(parts[1])
                                .setBoxOffice(Double.parseDouble(parts[2]))
                                .setRating(Double.parseDouble(parts[3]))
                                .setGenre(parts[4])
                                .setDirector(parts[5])
                                .setLangauge(parts[6])
                                .getResults()
                );
            }

        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        return insideList;
    }
}


class ReportWriter2 {
    public static void generateReport(String outputFileName,List<Movie> movies) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            Class clazz = Movie.class;
            Field[] field = clazz.getDeclaredFields();

            for(int i = 0; i < field.length; i++) {
                writer.write(
                        field.length - 1 == i ?
                                field[i].getName().toUpperCase().concat("\n") :
                                field[i].getName().toUpperCase().concat(";")
                );
            }

            for(Movie movie: movies) {
                for(int i = 0; i < field.length; i++) {
                    field[i].setAccessible(true);

                    if(field[i].isAnnotationPresent(FieldFormat2.class)) {
                        if(field[i].get(movie) instanceof String) {
                            TextFormatter2 textFormat = field[i].getAnnotation(FieldFormat2.class).text_format();

                            switch(textFormat) {

                                case LOWER_CASE -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(movie).toString().toLowerCase().concat("\n") :
                                                field[i].get(movie).toString().toLowerCase().concat(";")
                                );

                                case UPPER_CASE -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(movie).toString().toUpperCase().concat("\n") :
                                                field[i].get(movie).toString().toUpperCase().concat(";")
                                );

                                case ORDINARY -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(movie).toString().concat("\n") :
                                                field[i].get(movie).toString().concat(";")
                                );

                            }



                        } else {
                            if(field[i].get(movie) instanceof Number && field[i].get(movie) != null) {
                                NumberFormatter2 numFormat = field[i].getAnnotation(FieldFormat2.class).number_format();

                                if(numFormat == NumberFormatter2.CURRENCY) {
                                    DecimalFormat df = new DecimalFormat("$#,###.##");
                                    writer.write(
                                        field.length - 1 == i ?
                                                df.format(field[i].get(movie)).concat("\n") :
                                                df.format(field[i].get(movie)).concat(";")
                                    );
                                } else if(numFormat == NumberFormatter2.PERCENTAGE) {
                                    writer.write(
                                            field.length - 1 == i ?
                                            "%".concat(field[i].get(movie).toString()).concat("\n") :
                                            "%".concat(field[i].get(movie).toString()).concat(";")
                                    );
                                }

                            }
                        }



                    } else {
                        writer.write(
                                field.length - 1 == i ?
                                        field[i].get(movie).toString().concat("\n") :
                                        field[i].get(movie).toString().concat(";")
                        );
                    }




                }
            }



        writer.close();

        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}

class MovieDataTransformation {
    public static void main(String[] args) {
        MovieLeader ml = new MovieLeader("C:\\Users\\Haris\\Desktop\\movies.csv");
        ReportWriter2 rw2 = new ReportWriter2();
        rw2.generateReport("C:\\Users\\Haris\\Desktop\\temporary.csv",ml.getMovieList());
    }
}