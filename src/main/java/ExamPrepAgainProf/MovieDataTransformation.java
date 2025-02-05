package ExamPrepAgainProf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/*
enum TextFormatter {
    ORDINARY,UPPER_CASE,LOWER_CASE
}
enum NumberFormatter {
    CURRENCY,PERCENTAGE
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldFormat {
    TextFormatter text_format() default TextFormatter.ORDINARY;
    NumberFormatter number_format() default NumberFormatter.CURRENCY;
}

class Movie {
    @FieldFormat
    private Date releaseDate;
    @FieldFormat(text_format = TextFormatter.ORDINARY)
    private String title;
    @FieldFormat(number_format = NumberFormatter.CURRENCY)
    public double boxOffice;
    @FieldFormat(number_format = NumberFormatter.PERCENTAGE)
    private double rating;
    @FieldFormat(text_format = TextFormatter.UPPER_CASE)
    private String genre;
    @FieldFormat(text_format = TextFormatter.UPPER_CASE)
    private String director;
    @FieldFormat(text_format = TextFormatter.LOWER_CASE)
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

        public MovieBuilder setReleaseDate(Date releaseDate){
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
        public Movie build() {
            return new Movie(this);
        }
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

class MovieLoader {
    List<Movie> movieList = new ArrayList<>();

    public MovieLoader(String filename) {
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
                String[] parts = lines.get(i).split(",");

                if(parts[1] == "" || parts[2] == "" || parts[3] == "") {
                    throw new InvalidMovieDataException("Invalid data", new ClassCastException());
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
                                .build()
                );
            }





        } catch(Exception e) {
            System.out.println(e.getMessage());
        }


        return insideList;
    }
}

class ReportWriter {
    public static void generateReport(String outputFileName, List<Movie> movies) {

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

            for (Movie movie : movies) {
                for(int i = 0; i < field.length; i++) {
                    field[i].setAccessible(true);


                    if(field[i].isAnnotationPresent(FieldFormat.class)) {
                        if(field[i].get(movie) instanceof String) {

                            TextFormatter textFormat = field[i].getAnnotation(FieldFormat.class).text_format();

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


                        } else if (field[i].get(movie) instanceof Number && field[i].get(movie) != null) {
                            NumberFormatter numFormat = field[i].getAnnotation(FieldFormat.class).number_format();
                            DecimalFormat df = new DecimalFormat("$#,###.##");

                            switch(numFormat) {
                                case CURRENCY -> writer.write(
                                        field.length - 1 == i ?
                                                df.format(field[i].get(movie)).concat("\n") :
                                                df.format(field[i].get(movie)).concat(";")
                                );

                                case PERCENTAGE -> writer.write(
                                        field.length - 1 == i ?
                                                "%".concat(field[i].get(movie).toString()).concat("\n") :
                                                "%".concat(field[i].get(movie).toString()).concat(";")
                                );
                            }

                        } else if(field[i].get(movie) instanceof Date) {
                            SimpleDateFormat sdf = new SimpleDateFormat();
                            String formattedDate = sdf.format((Date) field[i].get(movie));
                            writer.write(
                                    field.length - 1 == i ?
                                            formattedDate.concat("\n") :
                                            formattedDate.concat(";")
                            );
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
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }



    }
}

class MovieData {
    public static void main(String[] args) {
        MovieLoader movieLoader = new MovieLoader("C:\\Users\\Haris\\Desktop\\movies.csv");
        ReportWriter report = new ReportWriter();
        report.generateReport("C:\\Users\\Haris\\Desktop\\temporary.csv",movieLoader.getMovieList());
    }
}

*/