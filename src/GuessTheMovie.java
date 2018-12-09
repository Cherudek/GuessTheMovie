import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuessTheMovie {

    static String hiddenTitle;
    static String guessedCorrect = "";

    public GuessTheMovie() {
    }

    static int countFilms(File movies) throws FileNotFoundException {
        Scanner scanner = new Scanner(movies);
        int counter = 0;
        while (scanner.hasNextLine()) {
            counter++;
            scanner.nextLine();
        }
        return counter;
    }

    static String randomFilm(File movies, int counter) throws FileNotFoundException {
        Scanner randomFilm = new Scanner(movies);
        System.out.println("I have randomly selected a movie title,");
        System.out.println("Try to guess it!");
        int randomNumber = (int) ((Math.random() * counter) + 1);
        String movieTitle = "";
        for (int i = 0; i < randomNumber; i++) {
            movieTitle = randomFilm.nextLine();
        }
        hiddenTitle = titleToUnderscore(movieTitle);
        return movieTitle;
    }

    static void guessTheFilm(String movie, Boolean hasWon) {
        Scanner scanner = new Scanner(System.in);
        int attempts = movie.length() + 5;
        for (int i = attempts; i > 0; i--) {
            System.out.println("You have " + i + " guess(ess) left!");
            String guess = scanner.next();
            char[] character = guess.toCharArray();
            if (movie.contains(guess)) {
                int index = movie.indexOf(guess);
                System.out.println("[Index: " + index + "]");
                System.out.println("Correct! " + guess + ".");
                guessedCorrect = showCorrectLetter(hiddenTitle, index, character[0]);
                hiddenTitle = guessedCorrect;
                System.out.println(guessedCorrect);
            } else if (!movie.contains(guess)) {
                System.out.println("Incorrect: letter (" + guess + ") is not valid!");
            } else {
                hasWon = true;
                break;
            }
        }
        if (hasWon) {
            System.out.println("CORRECT!...YOU HAVE WON!");
        } else {
            System.out.println("GAME OVER...YOU LOSE!");
            System.out.println("The correct movie title was " + movie);
        }
    }

    static String titleToUnderscore(String title) {
        String hiddenTitle = title.replaceAll("[a-zA-Z]", "_");
        System.out.println(hiddenTitle);
        return hiddenTitle;
    }

    static String showCorrectLetter(String underscoreString, Integer index, Character guessed){
        StringBuilder guessedTitle = new StringBuilder(underscoreString);
        guessedTitle.setCharAt(index, guessed);
        System.out.println(guessedTitle);
        return guessedTitle.toString();
    }
}
