// Film.java
public class Film {
    private String title;
    private int duration; // in minutes
    private double rating;

    public Film(String title, int duration, double rating) {
        this.title = title;
        this.duration = duration;
        this.rating = rating;
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void displayFilmDetails() {
        System.out.println("Title: " + title + ", Duration: " + duration + " minutes, Rating: " + rating);
    }
}
