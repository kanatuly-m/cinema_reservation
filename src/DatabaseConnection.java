import java.sql.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/cinema_reservation";
    private static final String USER = "postgres";  // Имя пользователя PostgreSQL
    private static final String PASSWORD = "14012101";  // Новый пароль для postgres

    // Метод для подключения к базе данных
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Метод для добавления фильма
    public static void addFilm(Film film) {
        String sql = "INSERT INTO films (title, duration, rating) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, film.getTitle());
            stmt.setInt(2, film.getDuration());
            stmt.setDouble(3, film.getRating());
            stmt.executeUpdate();
            System.out.println("Film added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для получения всех фильмов
    public static void getFilms() {
        String sql = "SELECT * FROM films";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Film ID: " + rs.getInt("id") + ", Title: " + rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для добавления зрителя
    public static void addViewer(Viewer viewer) {
        String sql = "INSERT INTO viewers (name, age) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, viewer.getName());
            stmt.setInt(2, viewer.getAge());
            stmt.executeUpdate();
            System.out.println("Viewer added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для получения всех зрителей
    public static void getViewers() {
        String sql = "SELECT * FROM viewers";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Viewer ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для ввода данных о фильме через консоль
    public static Film inputFilmData() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter film title: ");
            String title = scanner.nextLine();

            System.out.print("Enter film duration (minutes): ");
            int duration = scanner.nextInt();

            System.out.print("Enter film rating: ");
            while (!scanner.hasNextDouble()) {  // Проверяем, является ли ввод числом
                System.out.println("Invalid input! Please enter a valid rating (e.g., 8.5): ");
                scanner.next();  // Очистка буфера ввода
            }
            double rating = scanner.nextDouble();

            return new Film(title, duration, rating);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format. Please restart and enter the correct values.");
            return null;
        }
    }

    // Метод для ввода данных о зрителе через консоль
    public static Viewer inputViewerData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter viewer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter viewer age: ");
        int age = scanner.nextInt();
        return new Viewer(name, age);
    }

    // Метод для обновления фильма
    public static void updateFilm(int filmId, String newTitle, int newDuration, double newRating) {
        String sql = "UPDATE films SET title = ?, duration = ?, rating = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newTitle);
            stmt.setInt(2, newDuration);
            stmt.setDouble(3, newRating);
            stmt.setInt(4, filmId);
            stmt.executeUpdate();
            System.out.println("Film updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для обновления зрителя
    public static void updateViewer(int viewerId, String newName, int newAge) {
        String sql = "UPDATE viewers SET name = ?, age = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setInt(2, newAge);
            stmt.setInt(3, viewerId);
            stmt.executeUpdate();
            System.out.println("Viewer updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для удаления фильма
    public static void deleteFilm(int filmId) {
        String sql = "DELETE FROM films WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, filmId);
            stmt.executeUpdate();
            System.out.println("Film deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для удаления зрителя
    public static void deleteViewer(int viewerId) {
        String sql = "DELETE FROM viewers WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, viewerId);
            stmt.executeUpdate();
            System.out.println("Viewer deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
