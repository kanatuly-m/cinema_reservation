public class VIPViewer extends Viewer {
    private double discount;

    // Constructor
    public VIPViewer(String name, int age, double discount) {
        super(name, age);
        this.discount = discount;
    }

    // Overridden method
    @Override
    public void watchFilm(Film film) {
        System.out.println(getName() + " (VIP) is watching " + film.getTitle() + " with a " + discount + "% discount!");
    }
}
