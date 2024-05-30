import java.util.Scanner;

public class lab2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueLoop = true;

        while (continueLoop) {
            int x, y, z;
            double t = 0.0;
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Введіть цілі значення x, y, z:");

                System.out.print("x: ");
                x = scanner.nextInt();
                System.out.print("y: ");
                y = scanner.nextInt();
                System.out.print("z: ");
                z = scanner.nextInt();

                // Перевірка значень
                double denominator = z - 2 * y;
                if (denominator == 0) {
                    System.out.println("Для заданих значень у та z у обчислюваному виразі виконується ділення на 0. Задайте інші значення.");
                    continue;
                }

                double underRoot = 3 * (x / denominator);
                if (underRoot < 0) {
                    System.out.println("Для заданих значень x, y та z вираз під коренем негативний. Задайте інші значення.");
                    continue;
                }

                // Обчислення функції
                double sqrtPart = Math.sqrt(underRoot);
                double sinPart = Math.sin(x * x);
                double yzPart = y * z;

                t = sqrtPart - yzPart + sinPart;

                // Заокруглення значення t
                t = Math.round(t);

                // Якщо всі перевірки пройдені, встановлюємо validInput в true
                validInput = true;
            }

            // Вивід результату
            System.out.println("Значення функції t: " + t);

            // Перевірка чи користувач хоче продовжувати
            System.out.println("Продовжити? (Так/Ні)");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("Так")) {
                continueLoop = false;
            }
        }
        scanner.close();
    }
}
