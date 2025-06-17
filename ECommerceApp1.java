import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("Product: %-15s Price: $%.2f", name, price);
    }
}

public class ECommerceApp1 {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>(Arrays.asList(
            new Product("Laptop", 1200.0),
            new Product("Smartphone", 800.0),
            new Product("Headphones", 300.0),
            new Product("Keyboard", 100.0),
            new Product("Mouse", 50.0)
        ));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== E-Commerce Menu =====");
            System.out.println("1. Display all products (Price High to Low)");
            System.out.println("2. Search products by name");
            System.out.println("3. Add a new product");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n=== All Products (Sorted by Price: High to Low) ===");
                    List<Product> sortedProducts = productList.stream()
                        .sorted(Comparator.comparing(Product::getPrice).reversed())
                        .collect(Collectors.toList());
                    displayProducts(sortedProducts);
                    break;

                case "2":
                    System.out.print("Enter product name to search: ");
                    String searchTerm = scanner.nextLine().toLowerCase();
                    List<Product> filteredList = productList.stream()
                        .filter(p -> p.getName().toLowerCase().contains(searchTerm))
                        .sorted(Comparator.comparing(Product::getPrice).reversed())
                        .collect(Collectors.toList());
                    System.out.println("\n=== Search Results ===");
                    displayProducts(filteredList);
                    break;

                case "3":
                    System.out.print("Enter new product name: ");
                    String newName = scanner.nextLine();

                    double newPrice = 0;
                    boolean validPrice = false;
                    while (!validPrice) {
                        System.out.print("Enter new product price: ");
                        String priceInput = scanner.nextLine();
                        try {
                            newPrice = Double.parseDouble(priceInput);
                            if (newPrice < 0) {
                                System.out.println("Price cannot be negative. Try again.");
                            } else {
                                validPrice = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid price format. Please enter a valid number.");
                        }
                    }

                    productList.add(new Product(newName, newPrice));
                    System.out.println("Product added successfully!");
                    break;

                case "4":
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option! Please enter 1, 2, 3, or 4.");
            }
        }
        scanner.close();
    }

    public static void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            products.forEach(System.out::println);
        }
    }
}
