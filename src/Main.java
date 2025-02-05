import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        // Creating films
        Film film1 = new Film("Inception", 148, 8.8);
        Film film2 = new Film("Interstellar", 169, 8.6);
        Film film3 = new Film("The Matrix", 136, 8.7);

        // Creating viewers
        Viewer viewer1 = new Viewer("John Doe", 25);
        VIPViewer vipViewer = new VIPViewer("Jane Smith", 30, 20);

        // Creating cinema and adding films
        Cinema cinema = new Cinema();
        cinema.addFilm(film1);
        cinema.addFilm(film2);
        cinema.addFilm(film3);

        // Display all films
        System.out.println("All films:");
        cinema.displayFilms();

        // Filtering films by rating
        System.out.println("\nFilms with rating above 8.7:");
        List<Film> filteredFilms = cinema.filterByRating(8.7);
        for (Film film : filteredFilms) {
            System.out.println(film);
        }

        // Searching for a film by title
        System.out.println("\nSearching for 'Inception':");
        Film searchedFilm = cinema.searchFilmByTitle("Inception");
        if (searchedFilm != null) {
            System.out.println("Found: " + searchedFilm);
        } else {
            System.out.println("Film not found.");
        }

        // Sorting films by title
        System.out.println("\nSorted films by title:");
        cinema.sortFilmsByTitle();
        cinema.displayFilms();

        // Viewers watching films
        System.out.println("\nWatching films:");
        viewer1.watchFilm(film1);
        vipViewer.watchFilm(film2);
    }
}
