import java.io.*;
import java.util.*;

class Contact {
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String phone;

    public Contact() {
        // Порожній конструктор
    }

    public Contact(String lastName, String firstName, String middleName, String address, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
    }

    // Геттери та сеттери
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, Адреса: %s, Телефон: %s", lastName, firstName, middleName, address, phone);
    }
}

class PhoneBook {
    private final List<Contact> contacts = new ArrayList<>();

    // Додавання нового контакту
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Редагування існуючого контакту за індексом
    public void editContact(int index, Contact contact) {
        contacts.set(index, contact);
    }

    // Видалення контакту за індексом
    public void deleteContact(int index) {
        contacts.remove(index);
    }

    // Зчитування даних із файлу та додавання їх до бази даних
    public void loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 5) {
                    throw new IOException("Некоректний формат даних у файлі.");
                }
                Contact contact = new Contact(data[0], data[1], data[2], data[3], data[4]);
                contacts.add(contact);
            }
        }
    }

    // Виведення всіх контактів на екран
    public void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    // Пошук контактів за конкретною ознакою
    public List<Contact> searchBy(String parameter, String value) {
        List<Contact> results = new ArrayList<>();
        for (Contact contact : contacts) {
            if ((parameter.equalsIgnoreCase("lastName") && contact.getLastName().equalsIgnoreCase(value)) ||
                    (parameter.equalsIgnoreCase("firstName") && contact.getFirstName().equalsIgnoreCase(value)) ||
                    (parameter.equalsIgnoreCase("phone") && contact.getPhone().equalsIgnoreCase(value))) {
                results.add(contact);
            }
        }
        return results;
    }

    // Сортування контактів за різними полями
    public void sortBy(String parameter) {
        Comparator<Contact> comparator = switch (parameter.toLowerCase()) {
            case "lastname" -> Comparator.comparing(Contact::getLastName);
            case "firstname" -> Comparator.comparing(Contact::getFirstName);
            case "phone" -> Comparator.comparing(Contact::getPhone);
            default -> null;
        };

        if (comparator != null) {
            contacts.sort(comparator);
        } else {
            System.out.println("Некоректний параметр сортування.");
        }
    }
}

public class lab6_2 {
    private static final String FILENAME = "contacts.txt";

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Завантаження контактів із файлу
        try {
            phoneBook.loadFromFile(FILENAME);
        } catch (IOException e) {
            System.err.println("Помилка зчитування файлу: " + e.getMessage());
        }

        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Додати контакт");
            System.out.println("2. Редагувати контакт");
            System.out.println("3. Видалити контакт");
            System.out.println("4. Вивести всі контакти");
            System.out.println("5. Пошук контактів");
            System.out.println("6. Сортувати контакти");
            System.out.println("7. Вийти");
            System.out.print("Виберіть опцію: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Додати контакт:");
                    System.out.print("Прізвище: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Ім'я: ");
                    String firstName = scanner.nextLine();
                    System.out.print("По батькові: ");
                    String middleName = scanner.nextLine();
                    System.out.print("Адреса: ");
                    String address = scanner.nextLine();
                    System.out.print("Телефон: ");
                    String phone = scanner.nextLine();
                    Contact newContact = new Contact(lastName, firstName, middleName, address, phone);
                    phoneBook.addContact(newContact);
                    System.out.println("Контакт додано.");
                    break;
                case "2":
                    System.out.println("Редагувати контакт:");
                    System.out.print("Введіть індекс контакту для редагування: ");
                    int indexToEdit = Integer.parseInt(scanner.nextLine());
                    System.out.print("Прізвище: ");
                    lastName = scanner.nextLine();
                    System.out.print("Ім'я: ");
                    firstName = scanner.nextLine();
                    System.out.print("По батькові: ");
                    middleName = scanner.nextLine();
                    System.out.print("Адреса: ");
                    address = scanner.nextLine();
                    System.out.print("Телефон: ");
                    phone = scanner.nextLine();
                    Contact editedContact = new Contact(lastName, firstName, middleName, address, phone);
                    phoneBook.editContact(indexToEdit, editedContact);
                    System.out.println("Контакт відредаговано.");
                    break;
                case "3":
                    System.out.println("Видалити контакт:");
                    System.out.print("Введіть індекс контакту для видалення: ");
                    int indexToDelete = Integer.parseInt(scanner.nextLine());
                    phoneBook.deleteContact(indexToDelete);
                    System.out.println("Контакт видалено.");
                    break;
                case "4":
                    System.out.println("Всі контакти:");
                    phoneBook.displayContacts();
                    break;
                case "5":
                    System.out.println("Пошук контактів:");
                    System.out.print("Виберіть параметр пошуку (lastName, firstName, phone): ");
                    String parameter = scanner.nextLine();
                    System.out.print("Введіть значення для пошуку: ");
                    String value = scanner.nextLine();
                    List<Contact> results = phoneBook.searchBy(parameter, value);
                    for (Contact contact : results) {
                        System.out.println(contact);
                    }
                    break;
                case "6":
                    System.out.println("Сортувати контакти:");
                    System.out.print("Виберіть параметр сортування (lastName, firstName, phone): ");
                    parameter = scanner.nextLine();
                    phoneBook.sortBy(parameter);
                    System.out.println("Контакти відсортовано.");
                    break;
                case "7":
                    System.out.println("Вихід з програми.");
                    running = false;
                    break;
                default:
                    System.out.println("Некоректна опція. Спробуйте ще раз.");
                    break;
            }
        }
        scanner.close();
    }
}
