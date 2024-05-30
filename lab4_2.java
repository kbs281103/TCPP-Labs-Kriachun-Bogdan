import java.util.Random;
import java.util.Scanner;

public class lab4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continueProgram = true;

        while (continueProgram) {
            // Read the size of the matrix
            System.out.print("Введіть розмір матриці n: ");
            int n = scanner.nextInt();

            // Create a square matrix of real numbers
            double[][] matrix = new double[n][n];
            System.out.println("Генерація матриці з випадковими дійсними числами:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Generate real numbers in the range [-100, 100]
                    matrix[i][j] = -100 + random.nextDouble() * 200;
                    System.out.printf("%.2f ", matrix[i][j]);
                }
                System.out.println();
            }

            // Find the minimum element below the main diagonal
            double minElement = Double.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (matrix[i][j] < minElement) {
                        minElement = matrix[i][j];
                    }
                }
            }

            // Round the minimum value to 2 decimal places
            double roundedMinElement = Math.round(minElement * 100.0) / 100.0;

            // Output the minimum element
            System.out.println("Мінімальний елемент нижче головної діагоналі: " + roundedMinElement);

            // Ask the user if they want to continue the program
            System.out.print("Бажаєте продовжити програму? (так/ні): ");
            String userResponse = scanner.next();

            // Set continueProgram to true or false based on user response
            if (userResponse.equalsIgnoreCase("ні")) {
                continueProgram = false;
            }
        }

        scanner.close();
    }
}
