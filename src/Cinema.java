import java.util.*;

public class Cinema {
    private List<Film> films = new ArrayList<>();

    // Method to add a film
    public void addFilm(Film film) {
        films.add(film);
    }

    // Method to filter films by rating
    public List<Film> filterByRating(double minRating) {
        List<Film> filteredFilms = new ArrayList<>();
        for (Film film : films) {
            if (film.getRating() >= minRating) {
                filteredFilms.add(film);
            }
        }
        return filteredFilms;
    }

    // Method to sort films by title
    public List<Film> sortFilmsByTitle() {
        films.sort(Comparator.comparing(Film::getTitle));
        return films;
    }

    // Method to search a film by title
    public Film searchFilmByTitle(String title) {
        for (Film film : films) {
            if (film.getTitle().equals(title)) {
                return film;
            }
        }
        return null;
    }

    // Method to display all films
    public void displayFilms() {
        for (Film film : films) {
            System.out.println(film);
        }
    }
}
