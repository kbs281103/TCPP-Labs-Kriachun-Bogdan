import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Клас для зберігання інформації про книгу
class Book {
    private final String author;
    private final String title;
    private final String publisher;
    private final int year;

    public Book(String author, String title, String publisher, int year) throws InvalidDataException {
        if (year < 0) {
            throw new InvalidDataException("Рік видання не може бути негативним.");
        }
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    // Геттери
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s, %d)", author, title, publisher, year);
    }
}

// Виняток для некоректних даних
class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}

// Клас для керування базою даних книг
class BookManager {
    private final List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    // Додати книгу
    public void addBook(Book book) {
        books.add(book);
    }

    // Отримати книги з програмування
    public List<Book> getBooksOnProgramming() {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains("програмування"))
                .sorted(Comparator.comparingInt(Book::getYear).reversed())
                .collect(Collectors.toList());
    }

    // Вивід книг з програмування
    public void printBooksOnProgramming() {
        List<Book> programmingBooks = getBooksOnProgramming();
        System.out.println("Книги з програмування в порядку спадання років видання:");
        for (Book book : programmingBooks) {
            System.out.println(book);
        }
    }
}

// Головний клас для запуску програми
public class lab6_1 {
    public static void main(String[] args) {
        // Створення екземпляра BookManager
        BookManager manager = new BookManager();

        // Створення книги за допомогою вводу з консолі
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Введіть дані для книги " + (i + 1) + ":");
                System.out.print("Автор: ");
                String author = scanner.nextLine();
                System.out.print("Назва книги: ");
                String title = scanner.nextLine();
                System.out.print("Видавництво: ");
                String publisher = scanner.nextLine();

                int year = 0;
                boolean validYear = false;
                while (!validYear) {
                    System.out.print("Рік видання: ");
                    try {
                        year = Integer.parseInt(scanner.nextLine());
                        if (year < 0) {
                            throw new InvalidDataException("Рік видання не може бути негативним.");
                        }
                        validYear = true;
                    } catch (NumberFormatException e) {
                        System.err.println("Будь ласка, введіть коректне число для року видання.");
                    } catch (InvalidDataException e) {
                        System.err.println("Некоректний рік видання: " + e.getMessage());
                    }
                }

                // Додавання книги
                manager.addBook(new Book(author, title, publisher, year));
            }
        } catch (InvalidDataException e) {
            System.err.println("Некоректні дані: " + e.getMessage());
            return;
        }

        // Вивід книг з програмування
        manager.printBooksOnProgramming();
    }
}
