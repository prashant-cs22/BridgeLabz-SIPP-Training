package streamAPI;

//Top5TrendingMovies.java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Movie {
 private String title;
 private double rating;
 private int releaseYear;

 public Movie(String title, double rating, int releaseYear) {
     this.title = title;
     this.rating = rating;
     this.releaseYear = releaseYear;
 }

 public double getRating() {
     return rating;
 }

 public int getReleaseYear() {
     return releaseYear;
 }

 @Override
 public String toString() {
     return "Movie{" +
            "title='" + title + '\'' +
            ", rating=" + rating +
            ", releaseYear=" + releaseYear +
            '}';
 }
}

public class Top5TrendingMovies {
 public static void main(String[] args) {
     List<Movie> movies = Arrays.asList(
         new Movie("The Shawshank Redemption", 9.3, 1994),
         new Movie("The Godfather", 9.2, 1972),
         new Movie("The Dark Knight", 9.0, 2008),
         new Movie("Pulp Fiction", 8.9, 1994),
         new Movie("Inception", 8.8, 2010),
         new Movie("Fight Club", 8.8, 1999),
         new Movie("Forrest Gump", 8.8, 1994),
         new Movie("The Matrix", 8.7, 1999),
         new Movie("Goodfellas", 8.7, 1990)
     );

     List<Movie> top5Movies = movies.stream()
         .sorted(Comparator.comparingDouble((Movie m) -> m.getRating()).reversed()
             .thenComparingInt((Movie m) -> m.getReleaseYear()).reversed())
         .limit(5)
         .collect(Collectors.toList());

     top5Movies.forEach(System.out::println);
 }
}