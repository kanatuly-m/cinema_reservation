import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Film");
            System.out.println("2. Add Viewer");
            System.out.println("3. View Films");
            System.out.println("4. View Viewers");
            System.out.println("5. Update Film");
            System.out.println("6. Update Viewer");
            System.out.println("7. Delete Film");
            System.out.println("8. Delete Viewer");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    // Вводим данные о фильме
                    Film film = DatabaseConnection.inputFilmData();
                    // Добавляем фильм в базу данных
                    DatabaseConnection.addFilm(film);
                    break;
                case 2:
                    // Вводим данные о зрителе
                    Viewer viewer = DatabaseConnection.inputViewerData();
                    // Добавляем зрителя в базу данных
                    DatabaseConnection.addViewer(viewer);
                    break;
                case 3:
                    // Просматриваем все фильмы
                    System.out.println("\n--- All Films ---");
                    DatabaseConnection.getFilms();
                    break;
                case 4:
                    // Просматриваем всех зрителей
                    System.out.println("\n--- All Viewers ---");
                    DatabaseConnection.getViewers();
                    break;
                case 5:
                    // Обновляем фильм
                    System.out.print("Enter film ID to update: ");
                    int filmIdToUpdate = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new duration: ");
                    int newDuration = scanner.nextInt();
                    System.out.print("Enter new rating: ");
                    double newRating = scanner.nextDouble();
                    DatabaseConnection.updateFilm(filmIdToUpdate, newTitle, newDuration, newRating);
                    break;
                case 6:
                    // Обновляем зрителя
                    System.out.print("Enter viewer ID to update: ");
                    int viewerIdToUpdate = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    DatabaseConnection.updateViewer(viewerIdToUpdate, newName, newAge);
                    break;
                case 7:
                    // Удаляем фильм
                    System.out.print("Enter film ID to delete: ");
                    int filmIdToDelete = scanner.nextInt();
                    DatabaseConnection.deleteFilm(filmIdToDelete);
                    break;
                case 8:
                    // Удаляем зрителя
                    System.out.print("Enter viewer ID to delete: ");
                    int viewerIdToDelete = scanner.nextInt();
                    DatabaseConnection.deleteViewer(viewerIdToDelete);
                    break;
                case 9:
                    // Выход из программы
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
