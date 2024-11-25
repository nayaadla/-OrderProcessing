
// Program by: Naya Adla

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EcommerceSystem {

    // Product class representing an item in inventory
    static class Product {
        String name;
        double price;
        int stock;

        public Product(String name, double price, int stock) {
            this.name = name;
            this.price = price;
            this.stock = stock;
        }
    }

    // Order class representing an order placed by a customer
    static class Order {
        int orderId;
        HashMap<Product, Integer> items;
        double totalPrice;

        public Order(int orderId) {
            this.orderId = orderId;
            this.items = new HashMap<>();
            this.totalPrice = 0.0;
        }

        public void addItem(Product product, int quantity) {
            items.put(product, quantity);
            totalPrice += product.price * quantity;
        }

        public void displayOrderDetails() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Items Ordered:");
            for (Product product : items.keySet()) {
                int quantity = items.get(product);
                System.out.println("- " + product.name + " (x" + quantity + ") @ $" + product.price + " each");
            }
            System.out.println("Total Price: $" + totalPrice);
        }
    }

    // Main program functionality
    public static void main(String[] args) {
        // Inventory setup
        ArrayList<Product> inventory = new ArrayList<>();
        inventory.add(new Product("Laptop", 999.99, 10));
        inventory.add(new Product("Headphones", 49.99, 50));
        inventory.add(new Product("Mouse", 19.99, 100));
        inventory.add(new Product("Keyboard", 29.99, 75));

        // Orders storage
        ArrayList<Order> orders = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int orderIdCounter = 1;

        while (true) {
            System.out.println("\n--- E-Commerce Order Processing System ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Place an Order");
            System.out.println("3. View Order Details");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // View Inventory
                    System.out.println("\n--- Inventory ---");
                    for (int i = 0; i < inventory.size(); i++) {
                        Product product = inventory.get(i);
                        System.out.println(
                                (i + 1) + ". " + product.name + " - $" + product.price + " (Stock: " + product.stock + ")");
                    }
                    break;

                case 2:
                    // Place an Order
                    Order newOrder = new Order(orderIdCounter++);
                    while (true) {
                        System.out.println("\nEnter the product number to add to your order (0 to finish): ");
                        int productNumber = scanner.nextInt();
                        if (productNumber == 0) {
                            break;
                        }

                        if (productNumber < 1 || productNumber > inventory.size()) {
                            System.out.println("Invalid product number. Please try again.");
                            continue;
                        }

                        Product selectedProduct = inventory.get(productNumber - 1);
                        System.out.println("Enter quantity: ");
                        int quantity = scanner.nextInt();

                        if (quantity > selectedProduct.stock) {
                            System.out.println("Insufficient stock! Available stock: " + selectedProduct.stock);
                        } else {
                            selectedProduct.stock -= quantity;
                            newOrder.addItem(selectedProduct, quantity);
                            System.out.println(quantity + " " + selectedProduct.name + "(s) added to your order.");
                        }
                    }
                    orders.add(newOrder);
                    System.out.println("Order placed successfully!");
                    break;

                case 3:
                    // View Order Details
                    System.out.println("\nEnter Order ID to view details: ");
                    int orderId = scanner.nextInt();
                    boolean found = false;
                    for (Order order : orders) {
                        if (order.orderId == orderId) {
                            order.displayOrderDetails();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Order not found!");
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting the system. Go Hatters!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
