// Viewer.java
public class Viewer {
    private String name;
    private int age;
    private String email;

    public Viewer(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void bookTicket(Film film) {
        System.out.println(name + " booked a ticket for the movie: " + film.getTitle());
    }
}
