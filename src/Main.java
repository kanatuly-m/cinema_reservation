public class Main {
    public static void main(String[] args) {
        Film film1 = new Film("Inception", 148, 8.8);
        Viewer viewer1 = new Viewer("John Doe", 25, "johndoe@example.com");
        Cinema cinema = new Cinema("CinemaCity", "New York", 10);

        film1.displayFilmDetails();
        cinema.showAvailableSeats();

        viewer1.bookTicket(film1);
        cinema.bookTicket(viewer1);я
        cinema.showAvailableSeats();
    }
}
