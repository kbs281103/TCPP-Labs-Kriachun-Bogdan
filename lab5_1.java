import java.util.Scanner;

public class lab5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            // Input a text string
            System.out.print("Введіть текстовий рядок: ");
            String text = scanner.nextLine();

            // Count the number of digits in the text
            int digitCount = 0;
            for (int i = 0; i < text.length(); i++) {
                if (Character.isDigit(text.charAt(i))) {
                    digitCount++;
                }
            }
            System.out.println("Кількість цифр у тексті: " + digitCount);

            // Output words starting with consonants
            System.out.println("Слова, що починаються з приголосних літер:");
            String[] words = text.split("\\s+");  // Split the text into words
            for (String word : words) {
                if (!word.isEmpty()) {
                    char firstChar = word.toLowerCase().charAt(0);
                    if (isConsonant(firstChar)) {
                        System.out.println(word);
                    }
                }
            }

            // Check if the user wants to continue
            System.out.print("Бажаєте продовжити? (Так - 'так' Ні - любий інший символ): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("так")) {
                exit = true;
            }
        } while (!exit);

        scanner.close();
    }

    // Check if a character is a consonant
    private static boolean isConsonant(char c) {
        // Array of vowel characters
        char[] vowels = {'а', 'е', 'і', 'о', 'у', 'я', 'ю', 'є', 'ї'};
        for (char vowel : vowels) {
            if (c == vowel) {
                return false;  // Character is a vowel
            }
        }
        // If the character is not a vowel and is a letter, it is a consonant
        return Character.isLetter(c);
    }
}
