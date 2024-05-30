import java.util.Scanner;

public class lab1_1_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зациклюємо програму
        while (true) {
            // Просимо користувача ввести значення x
            System.out.print("Введіть значення x: ");
            double x = scanner.nextDouble();

            // Обчислюємо F(x) за допомогою тернарного оператора
            double F = (x < -10) ? (3 * Math.pow(x, 3) - Math.pow(x, 2)) :
                    (-10 <= x && x <= 10) ? Math.sqrt(10 - x) :
                            (2 * x + 1);

            // Закруглюємо результат до десятих, якщо він є дробом
            if (F % 1 != 0) {
                F = Math.round(F * 10.0) / 10.0;
            }

            // Виводимо результат
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
