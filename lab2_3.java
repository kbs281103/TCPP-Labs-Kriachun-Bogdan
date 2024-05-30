public class lab2_3 {
    public static void main(String[] args) {
        // Ініціалізація змінної для загальної суми
        int totalSum = 0;

        // Зовнішній цикл: від 1 до 30
        for (int i = 1; i <= 30; i++) {
            // Внутрішній цикл: від 1 до значення i
            for (int j = 1; j <= i; j++) {
                // Обчислення виразу (1 + i^2 + j^2)
                int value = 1 + (i * i) + (j * j);

                // Додавання обчисленого значення до загальної суми
                totalSum += value;
            }
        }

        // Вивід результату
        System.out.println("Загальна сума: " + totalSum);
    }
}
