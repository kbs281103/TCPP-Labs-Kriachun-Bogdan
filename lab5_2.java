import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class lab5_2 {
    public static void main(String[] args) {
        // Вказати шлях до текстового файлу
        String filePath = "C://Users//User//Desktop//ТСПП//file.txt";

        // Створюємо карту для підрахунку кількості голосних літер
        Map<Character, Integer> vowelCountMap = new HashMap<>();
        char[] vowels = {'а', 'е', 'і', 'о', 'у', 'я', 'ю', 'є', 'ї', 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        // Ініціалізуємо карту
        for (char vowel : vowels) {
            vowelCountMap.put(vowel, 0);
        }

        // Читання файлу та підрахунок голосних літер
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char character = (char) ch;
                // Перетворення символу в нижній регістр для перевірки
                character = Character.toLowerCase(character);

                if (vowelCountMap.containsKey(character)) {
                    // Якщо символ є голосною літерою, збільшуємо лічильник
                    vowelCountMap.put(character, vowelCountMap.get(character) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка при читанні файлу: " + e.getMessage());
        }

        // Виведення кількості входжень кожної з голосних літер
        System.out.println("Кількість входжень кожної з голосних літер:");
        for (Map.Entry<Character, Integer> entry : vowelCountMap.entrySet()) {
            System.out.println("Літера " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
