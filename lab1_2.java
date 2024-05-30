import java.util.InputMismatchException;
import java.util.Scanner;

public class lab1_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            try {
                // Зчитуємо три цілі числа
                System.out.println("Введіть перше ціле число:");
                int num1 = scanner.nextInt();

                System.out.println("Введіть друге ціле число:");
                int num2 = scanner.nextInt();

                System.out.println("Введіть третє ціле число:");
                int num3 = scanner.nextInt();

                // Змінна для збереження найменшого числа
                int min;

                // Порівнюємо перше число з другим і третім
                if (num1 <= num2 && num1 <= num3) {
                    min = num1;
                } else if (num2 <= num1 && num2 <= num3) {
                    min = num2;
                } else {
                    min = num3;
                }

                // Виводимо результат
                System.out.println("Найменше число: " + min);

            } catch (InputMismatchException e) {
                System.out.println("Помилка: введені значення мають бути цілими числами.");
                scanner.next(); // Очищення сканера від некоректного вводу
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
}
