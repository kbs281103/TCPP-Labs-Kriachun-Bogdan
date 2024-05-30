import java.util.InputMismatchException;
import java.util.Scanner;

public class lab1_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            try {
                System.out.println("Введіть ціле значення x:");
                int x = scanner.nextInt();

                System.out.println("Введіть ціле значення z:");
                int z = scanner.nextInt();

                double y = calculateFunction(x, z);

                // Округлення результату до сотих
                y = Math.round(y * 100.0) / 100.0;

                System.out.println("y = " + y);

            } catch (InputMismatchException e) {
                System.out.println("Помилка: введені значення мають бути цілими числами.");
                scanner.next(); // Очищення сканера від некоректного вводу
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            }

            // Запит на продовження або завершення програми
            System.out.println("Бажаєте продовжити? (введіть 'так' для продовження, будь-яке інше значення для завершення):");
            String userResponse = scanner.next();
            if (!userResponse.equalsIgnoreCase("так")) {
                continueProgram = false;
            }
        }

        // Закриваємо сканер
        scanner.close();
        System.out.println("Програма завершена.");
    }

    public static double calculateFunction(int x, int z) {
        double expression = (1 - 2 * x) / (double) (z + 3);

        if (expression <= 0) {
            throw new IllegalArgumentException("Вираз (1 - 2 * x) / (z + 3) повинен бути більший за нуль.");
        }

        double logValue = Math.log10(expression);

        if (logValue < 0) {
            throw new IllegalArgumentException("Значення логарифму повинно бути невід'ємним.");
        }

        return Math.sqrt(logValue);
    }
}
