import java.io.*;
import java.util.*;

abstract class TramStop2 {
    // Поля трамвайної зупинки
    private String name;
    private List<Integer> routeNumbers;

    public TramStop2(String name, List<Integer> routeNumbers) {
        this.name = name;
        this.routeNumbers = new ArrayList<>(routeNumbers);
    }

    // Геттери та абстрактний метод `getName()`
    public abstract String getName();

    public List<Integer> getRouteNumbers() {
        return new ArrayList<>(routeNumbers);
    }

    @Override
    public String toString() {
        return String.format("Назва зупинки: %s, Номери маршрутів: %s", name, routeNumbers);
    }
}


class Hour2 extends TramStop {
    // Поля години
    private final int passengerCount;
    private final String comment;

    public Hour2(String name, List<Integer> routeNumbers, int passengerCount, String comment) {
        super(name, routeNumbers);
        this.passengerCount = passengerCount;
        this.comment = comment;
    }

    // Геттери
    public int getPassengerCount() {
        return passengerCount;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return String.format("%s, Кількість пасажирів: %d, Коментар: %s", super.toString(), passengerCount, comment);
    }

    // Реалізація методів індивідуального завдання
    public int calculateTotalPassengers(List<Hour2> hours) {
        int total = 0;
        for (Hour2 hour : hours) {
            total += hour.getPassengerCount();
        }
        return total;
    }

    public Hour2 findHourWithLeastPassengers(List<Hour2> hours) {
        Hour2 minHour = null;
        for (Hour2 hour : hours) {
            if (minHour == null || hour.getPassengerCount() < minHour.getPassengerCount()) {
                minHour = hour;
            }
        }
        return minHour;
    }

    public Hour2 findLongestComment(List<Hour2> hours) {
        Hour2 longestCommentHour = null;
        for (Hour2 hour : hours) {
            if (longestCommentHour == null || hour.getComment().length() > longestCommentHour.getComment().length()) {
                longestCommentHour = hour;
            }
        }
        return longestCommentHour;
    }
}

class TramStopDatabase2 {
    private final List<Hour2> hours = new ArrayList<>();

    // Додавання нового запису
    public void addRecord(Hour2 hour) {
        hours.add(hour);
    }

    // Редагування існуючого запису
    public void editRecord(int index, Hour2 newHour) {
        if (index >= 0 && index < hours.size()) {
            hours.set(index, newHour);
        } else {
            System.out.println("Некоректний індекс.");
        }
    }

    // Видалення запису за індексом
    public void deleteRecord(int index) {
        if (index >= 0 && index < hours.size()) {
            hours.remove(index);
        } else {
            System.out.println("Некоректний індекс.");
        }
    }

    // Виведення інформації з файла на екран
    public void displayData() {
        for (Hour2 hour : hours) {
            System.out.println(hour);
        }
    }

    // Обчислення загальної кількості пасажирів
    public int calculateTotalPassengers() {
        int total = 0;
        for (Hour2 hour : hours) {
            total += hour.getPassengerCount();
        }
        return total;
    }

    // Пошук години з найменшою кількістю пасажирів
    public Hour2 findHourWithLeastPassengers() {
        Hour2 minHour = null;
        for (Hour2 hour : hours) {
            if (minHour == null || hour.getPassengerCount() < minHour.getPassengerCount()) {
                minHour = hour;
            }
        }
        return minHour;
    }

    // Пошук найдовшого коментаря
    public Hour2 findLongestComment() {
        Hour2 longestCommentHour = null;
        for (Hour2 hour : hours) {
            if (longestCommentHour == null || hour.getComment().length() > longestCommentHour.getComment().length()) {
                longestCommentHour = hour;
            }
        }
        return longestCommentHour;
    }

    // Виведення інформації про результати завдання
    public void displayResults() {
        System.out.printf("Загальна кількість пасажирів: %d%n", calculateTotalPassengers());
        Hour2 minHour = findHourWithLeastPassengers();
        if (minHour != null) {
            System.out.printf("Година з найменшою кількістю пасажирів: %s (Кількість пасажирів: %d)%n",
                    minHour.getName(), minHour.getPassengerCount());
        }
        Hour2 longestCommentHour = findLongestComment();
        if (longestCommentHour != null) {
            System.out.printf("Найдовший коментар: %s%n", longestCommentHour.getComment());
        }
    }

    // Винесений метод для заповнення даних з користувача
    private Hour2 getHourDataFromUser(Scanner scanner, boolean isEdit) {
        System.out.print("Назва зупинки: ");
        String name = scanner.nextLine();
        System.out.print("Номери маршрутів (через кому): ");
        List<Integer> routeNumbers = new ArrayList<>();
        for (String route : scanner.nextLine().split(",")) {
            routeNumbers.add(Integer.parseInt(route.trim()));
        }
        System.out.print("Кількість пасажирів: ");
        int passengerCount = Integer.parseInt(scanner.nextLine());
        System.out.print("Коментар: ");
        String comment = scanner.nextLine();

        return new Hour2(name, routeNumbers, passengerCount, comment);
    }
}

public class lab7_2  {
    private static final String FILENAME = "tram_data.txt";

    public static void main(String[] args) {
        TramStopDatabase2 database = new TramStopDatabase2();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Завантаження даних із файлу
        loadFromFile(database);

        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Додати запис");
            System.out.println("2. Редагувати запис");
            System.out.println("3. Видалити запис");
            System.out.println("4. Вивести дані");
            System.out.println("5. Вивести результати обчислень");
            System.out.println("6. Вийти");
            System.out.print("Виберіть опцію: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addRecord(database, scanner);
                    break;
                case "2":
                    editRecord(database, scanner);
                    break;
                case "3":
                    deleteRecord(database, scanner);
                    break;
                case "4":
                    database.displayData();
                    break;
                case "5":
                    database.displayResults();
                    break;
                case "6":
                    System.out.println("Вихід з програми.");
                    running = false;
                    break;
                default:
                    System.out.println("Некоректна опція. Спробуйте ще раз.");
                    break;
            }
        }

        scanner.close();
    }

    // Завантаження даних із файлу
    private static void loadFromFile(TramStopDatabase2 database) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Очікується формат: Назва зупинки,Номери маршрутів (через кому),Кількість пасажирів,Коментар
                String[] data = line.split(",");
                if (data.length == 4) {
                    String name = data[0];
                    List<Integer> routeNumbers = new ArrayList<>();
                    for (String route : data[1].split(";")) {
                        routeNumbers.add(Integer.parseInt(route.trim()));
                    }
                    int passengerCount = Integer.parseInt(data[2].trim());
                    String comment = data[3];

                    Hour2 hour = new Hour2(name, routeNumbers, passengerCount, comment);
                    database.addRecord(hour);
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка завантаження даних з файлу: " + e.getMessage());
        }
    }

    private static Hour2 getHourDataFromUser(Scanner scanner, boolean isEdit) {
        System.out.print("Назва зупинки: ");
        String name = scanner.nextLine();
        System.out.print("Номери маршрутів (через кому): ");
        List<Integer> routeNumbers = new ArrayList<>();
        for (String route : scanner.nextLine().split(",")) {
            routeNumbers.add(Integer.parseInt(route.trim()));
        }
        System.out.print("Кількість пасажирів: ");
        int passengerCount = Integer.parseInt(scanner.nextLine());
        System.out.print("Коментар: ");
        String comment = scanner.nextLine();

        // Додайте return, який повертає об'єкт Hour
        return new Hour2(name, routeNumbers, passengerCount, comment);
    }

    // Додавання нового запису
    private static void addRecord(TramStopDatabase2 database, Scanner scanner) {
        Hour2 newHour = getHourDataFromUser(scanner, false);
        database.addRecord(newHour);
        System.out.println("Новий запис додано.");
    }

    // Редагування існуючого запису
    private static void editRecord(TramStopDatabase2 database, Scanner scanner) {
        System.out.println("Редагувати запис:");
        System.out.print("Введіть індекс запису для редагування: ");
        int index = Integer.parseInt(scanner.nextLine());
        Hour2 newHour = getHourDataFromUser(scanner, true);
        database.editRecord(index, newHour);
        System.out.println("Запис редаговано.");
    }

    // Видалення запису за індексом
    private static void deleteRecord(TramStopDatabase2 database, Scanner scanner) {
        System.out.println("Видалити запис:");
        System.out.print("Введіть індекс запису для видалення: ");
        int index = Integer.parseInt(scanner.nextLine());
        database.deleteRecord(index);
        System.out.println("Запис видалено.");
    }
}
