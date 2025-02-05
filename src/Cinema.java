// Cinema.java
public class Cinema {
    private String cinemaName;
    private String location;
    private int availableSeats;

    public Cinema(String cinemaName, String location, int availableSeats) {
        this.cinemaName = cinemaName;
        this.location = location;
        this.availableSeats = availableSeats;
    }

    // Getter and Setter methods
    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void showAvailableSeats() {
        System.out.println("Available seats in " + cinemaName + ": " + availableSeats);
    }

    public void bookTicket(Viewer viewer) {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println(viewer.getName() + " successfully booked a ticket.");
        } else {
            System.out.println("No available seats.");
        }
    }
}
