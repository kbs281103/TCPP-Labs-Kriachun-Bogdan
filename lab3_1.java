import java.util.InputMismatchException;
import java.util.Scanner;

public class lab3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            int n = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.print("Введіть розмір масиву (n): ");
                    n = scanner.nextInt();
                    if (n > 0) {
                        validInput = true;
                    } else {
                        System.out.println("Розмір масиву має бути додатнім числом.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Будь ласка, введіть коректне ціле число.");
                    scanner.next(); // clear the invalid input
                }
            }

            double[] array = new double[n];

            System.out.println("Введіть значення елементів масиву:");
            for (int i = 0; i < n; i++) {
                boolean validElement = false;
                while (!validElement) {
                    try {
                        System.out.print("Елемент " + (i + 1) + ": ");
                        array[i] = scanner.nextDouble();
                        validElement = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Будь ласка, введіть дійсне число.");
                        scanner.next(); // clear the invalid input
                    }
                }
            }

            int minIndex = 0;
            int maxIndex = 0;

            for (int i = 1; i < n; i++) {
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }

            System.out.println("Індекс найбільшого елемента: " + (maxIndex + 1));
            System.out.println("Індекс найменшого елемента: " + (minIndex + 1));

            System.out.print("\nБажаєте продовжити (так/ні)? ");
            String choice = scanner.next();

            if (!choice.equalsIgnoreCase("так")) {
                exit = true;
            }
        }
        scanner.close();
    }
}
