import java.util.Scanner;
import java.util.InputMismatchException;

public class lab4_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Ввести власні дані");
            System.out.println("2. Використати готовий результат");
            System.out.println("3. Вийти з програми");

            option = getIntInput(scanner, "Виберіть опцію (1-3): ");
            switch (option) {
                case 1:
                    processCustomData(scanner);
                    break;
                case 2:
                    processPredefinedData();
                    break;
                case 3:
                    System.out.println("Дякую за використання програми. До побачення!");
                    break;
                default:
                    System.out.println("Некоректний вибір опції. Спробуйте ще раз.");
                    break;
            }
        } while (option != 3);

        scanner.close();
    }

    private static void processCustomData(Scanner scanner) {
        int n = getIntInput(scanner, "Введіть розмір матриці n: ");

        int[][] matrix = new int[n][n];
        System.out.println("Введіть елементи матриці:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = getIntInput(scanner, "Елемент [" + (i + 1) + "][" + (j + 1) + "]: ");
            }
        }

        processMatrix(matrix);
    }

    private static void processPredefinedData() {
        int n = 3; // розмір матриці 3x3

        int[][] predefinedMatrix = {
                {-10, 5, -1},
                {3, 1, 13},
                {-8, 4, 29}
        };

        processMatrix(predefinedMatrix);
    }

    private static void processMatrix(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == n - 1) { // Secondary diagonal condition
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] *= matrix[i][j]; // Square other elements
                }
            }
        }

        System.out.println("Перетворена матриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getIntInput(Scanner scanner, String prompt) {
        int input = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Будь ласка, введіть коректне ціле число.");
                scanner.next(); // clear the invalid input
            }
        }
        return input;
    }
}
