import java.util.Scanner;

public class lab2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Обчислення функції y = lg(x) на інтервалі [a, b] з кроком dx.");
            System.out.print("Введіть значення a: ");
            double a = scanner.nextDouble();

            System.out.print("Введіть значення b: ");
            double b = scanner.nextDouble();

            System.out.print("Введіть крок dx: ");
            double dx = scanner.nextDouble();

            System.out.println("\nРезультати обчислення функції y = lg(x)");
            System.out.println("x\t\ty = lg(x)");
            System.out.println("---------\t------------");

            for (double x = a; x <= b; x += dx) {
                if (x > 0) {
                    double y = Math.log10(x);
                    System.out.printf("%.2f\t\t%.5f\n", x, y);
                } else {
                    System.out.printf("%.2f\t\tN/A (логарифмування з недопустимим значенням x)\n", x);
                }
            }

            System.out.print("\nБажаєте продовжити (так/ні)? ");
            String choice = scanner.next();

            if (!choice.equalsIgnoreCase("так")) {
                exit = true;
            }
        }
    }
}
