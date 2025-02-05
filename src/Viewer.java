public class Viewer {
    private String name;
    private int age;

    // Constructor
    public Viewer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
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

    // Method to watch a film
    public void watchFilm(Film film) {
        System.out.println(name + " is watching " + film.getTitle());
    }
}
