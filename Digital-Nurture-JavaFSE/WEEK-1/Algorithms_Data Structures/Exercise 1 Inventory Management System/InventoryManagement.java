import java.util.*;

public class InventoryManagement {
    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;

        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        void display() {
            System.out.println(productId + " - " + productName + " - Qty: " + quantity + " - " + price);
        }
    }

    static class Inventory {
        HashMap<Integer, Product> products = new HashMap<>();

        void addProduct(Product product) {
            if (products.containsKey(product.productId)) {
                System.out.println("Product ID already exists.");
            } else {
                products.put(product.productId, product);
                System.out.println("Product added.");
            }
        }

        void updateProduct(int id, String name, int quantity, double price) {
            if (products.containsKey(id)) {
                products.put(id, new Product(id, name, quantity, price));
                System.out.println("Product updated.");
            } else {
                System.out.println("Product not found.");
            }
        }

        void deleteProduct(int id) {
            if (products.containsKey(id)) {
                products.remove(id);
                System.out.println("Product deleted.");
            } else {
                System.out.println("Product not found.");
            }
        }

        void displayAll() {
            if (products.isEmpty()) {
                System.out.println("Inventory is empty.");
                return;
            }
            for (Product p : products.values()) {
                p.display();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\n1. Add Product\n2. Update Product\n3. Delete Product\n4. View All Products\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Product Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();
                System.out.print("Enter Price: ");
                double price = sc.nextDouble();
                inventory.addProduct(new Product(id, name, qty, price));
            } else if (choice == 2) {
                System.out.print("Enter Product ID to update: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();
                System.out.print("Enter New Quantity: ");
                int qty = sc.nextInt();
                System.out.print("Enter New Price: ");
                double price = sc.nextDouble();
                inventory.updateProduct(id, name, qty, price);
            } else if (choice == 3) {
                System.out.print("Enter Product ID to delete: ");
                int id = sc.nextInt();
                inventory.deleteProduct(id);
            } else if (choice == 4) {
                inventory.displayAll();
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
 
    }
}
