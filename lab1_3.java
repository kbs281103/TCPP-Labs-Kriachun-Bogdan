import java.util.Scanner;

public class lab1_3 {

    public static void main(String[] args) {
        // Створюємо сканер для зчитування даних з консолі
        Scanner scanner = new Scanner(System.in);

        // Цикл для введення номерів та виведення інформації
        while (true) {
            System.out.println("Введіть номер у списку групи (від 1 до 10) або символ для завершення:");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();

                // Вивід прізвища та імені одногрупника за номером у списку
                switch (number) {
                    case 1:
                        System.out.println("Одногрупник: Іванов Іван");
                        break;
                    case 2:
                        System.out.println("Одногрупник: Петров Петро");
                        break;
                    case 3:
                        System.out.println("Одногрупник: Сидоров Сидор");
                        break;
                    case 4:
                        System.out.println("Одногрупник: Коваленко Олександр");
                        break;
                    case 5:
                        System.out.println("Одногрупник: Гончаренко Олена");
                        break;
                    case 6:
                        System.out.println("Одногрупник: Ковальчук Наталія");
                        break;
                    case 7:
                        System.out.println("Одногрупник: Мельник Дмитро");
                        break;
                    case 8:
                        System.out.println("Одногрупник: Кузнєцов Олег");
                        break;
                    case 9:
                        System.out.println("Одногрупник: Бондаренко Вікторія");
                        break;
                    case 10:
                        System.out.println("Одногрупник: Чернишенко Юрій");
                        break;
                    default:
                        System.out.println("Некоректний номер у списку групи. Введіть число від 1 до 10.");
                }
            } else {
                // Якщо користувач вводить не ціле число, ми припиняємо цикл
                if (scanner.hasNext()) {
                    String input = scanner.next();
                    System.out.println("Завершення програми.");
                    break;
                }
            }
        }

        // Закриваємо сканер
        scanner.close();
    }
}
