import java.io.File;
import java.io.FileNotFoundException;

public class Game {

    public static void main(String[] args) throws FileNotFoundException {
        File movies = new File("movies.txt");
        Boolean hasWon = false;
        int numberOfFilms = GuessTheMovie.countFilms(movies);
        String movie = GuessTheMovie.randomFilm(movies, numberOfFilms);
        GuessTheMovie.guessTheFilm(movie, hasWon);
    }
}
