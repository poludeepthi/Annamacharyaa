import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    private HashMap<String, String> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Add a contact
    public void addContact(String name, String phoneNumber) {
        phoneBook.put(name, phoneNumber);
        System.out.println("Contact added: " + name + " - " + phoneNumber);
    }

    // Search for a contact
    public void searchContact(String name) {
        if (phoneBook.containsKey(name)) {
            System.out.println(name + "'s number is: " + phoneBook.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Delete a contact
    public void deleteContact(String name) {
        if (phoneBook.remove(name) != null) {
            System.out.println("Contact deleted: " + name);
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Display all contacts
    public void displayAllContacts() {
        if (phoneBook.isEmpty()) {
            System.out.println("Phone book is empty.");
        } else {
            System.out.println("Phone Book:");
            for (String name : phoneBook.keySet()) {
                System.out.println(name + ": " + phoneBook.get(name));
            }
        }
    }

    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    myPhoneBook.addContact(name, phone);
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    name = scanner.nextLine();
                    myPhoneBook.searchContact(name);
                    break;
                case 3:
                    System.out.print("Enter name to delete: ");
                    name = scanner.nextLine();
                    myPhoneBook.deleteContact(name);
                    break;
                case 4:
                    myPhoneBook.displayAllContacts();
                    break;
                case 5:
                    System.out.println("Exiting Phone Book. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
