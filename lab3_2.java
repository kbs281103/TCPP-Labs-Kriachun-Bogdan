import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class lab3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean exit = false;
        while (!exit) {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Ввести масив з клавіатури");
            System.out.println("2. Згенерувати масив випадковим чином");
            System.out.println("3. Вийти з програми");

            int option = getIntInput(scanner, "Виберіть опцію (1-3): ");
            switch (option) {
                case 1:
                    handleManualInput(scanner);
                    break;
                case 2:
                    handleRandomGeneration(scanner, random);
                    break;
                case 3:
                    exit = true;
                    System.out.println("До побачення!");
                    break;
                default:
                    System.out.println("Виберіть коректну опцію!");
            }
        }
        scanner.close();
    }

    private static void handleManualInput(Scanner scanner) {
        int n = getIntInput(scanner, "Введіть розмірність масиву: ");
        int[] array = new int[n];

        System.out.println("Введіть " + n + " цілих чисел:");
        for (int i = 0; i < n; i++) {
            array[i] = getIntInput(scanner, "Елемент " + (i + 1) + ": ");
        }

        processArray(array);
    }

    private static void handleRandomGeneration(Scanner scanner, Random random) {
        int n = getIntInput(scanner, "Введіть розмірність масиву для випадкової генерації: ");

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(201) - 100; // Заповнення від -100 до 100
        }

        processArray(array);
    }

    private static void processArray(int[] array) {
        System.out.println("Масив:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        int maxElement = findMaxElement(array);
        System.out.println("Максимальний елемент масиву: " + maxElement);

        int sumBetweenPositive = findSumBetweenPositive(array);
        System.out.println("Сума елементів масиву, розташованих між першим й другим додатними елементами: " + sumBetweenPositive);
    }

    private static int findMaxElement(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static int findSumBetweenPositive(int[] array) {
        int firstPositiveIndex = -1;
        int secondPositiveIndex = -1;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                if (firstPositiveIndex == -1) {
                    firstPositiveIndex = i;
                } else {
                    secondPositiveIndex = i;
                    break;
                }
            }
        }

        if (firstPositiveIndex != -1 && secondPositiveIndex != -1) {
            for (int i = firstPositiveIndex + 1; i < secondPositiveIndex; i++) {
                sum += array[i];
            }
        } else {
            System.out.println("У масиві немає достатньої кількості додатніх елементів.");
        }

        return sum;
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
