import java.util.Scanner;

public class lab2_2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.print("Введіть ціле число x: ");
            int x = scanner.nextInt();

            int sum = 0;

            // Цикл з параметром (for)
            for (int i = 1; i <= 100; i += 2) {
                if (i < x) {
                    sum += i;
                } else {
                    break;
                }
            }

            System.out.println("Сума всіх непарних чисел менших за x: " + sum);

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
