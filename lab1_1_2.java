import java.util.Scanner;

public class lab1_1_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зациклюємо програму
        while (true) {
            // Просимо користувача ввести значення x
            System.out.print("Введіть значення x: ");
            double x = scanner.nextDouble();

            double F;

            // Використання операторів if...else
            if (x < -10) {
                F = 3 * Math.pow(x, 3) - Math.pow(x, 2);
            } else if (-10 <= x && x <= 10) {
                F = Math.sqrt(10 - x);
            } else {
                F = 2 * x + 1;
            }

            // Виведення результату
            System.out.println("F(" + x + ") = " + F);

            // Питаємо користувача, чи він хоче продовжити роботу програми
            System.out.print("Бажаєте продовжити (введіть 1) чи закрити (введіть 0)? ");
            int choice = scanner.nextInt();

            // Перевіряємо вибір користувача
            if (choice == 0) {
                System.out.println("Програма завершена.");
                break; // Вихід з циклу
            }
        }

        // Закриваємо Scanner
        scanner.close();
    }
}
