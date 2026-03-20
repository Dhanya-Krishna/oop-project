import java.util.List;

public class FileManager {

    public void saveProducts(List<Product> list) {
        System.out.println("System: Saving products to database...");
    }

    public void loadProducts() {
        System.out.println("System: Loading products from database...");
    }

    public void saveInventory(Inventory inv) {
        System.out.println("System: Saving inventory status...");
    }

    public void loadInventory() {
        System.out.println("System: Loading inventory status...");
    }

    // Main method integrated into the FileManager class
    public static void main(String[] args) {
        FileManager fm = new FileManager();
        Inventory inventory = new Inventory();

        // 1. Setup Products
        Product p1 = new Product(501, "Smartwatch", 150.0, 8.0);
        Product p2 = new Product(502, "Headphones", 50.0, 5.0);

        // 2. Add Stock to Inventory
        inventory.addProduct(p1, 20);
        inventory.addProduct(p2, 100);

        // 3. Create a Sale
        Sale s1 = new Sale(1001, "2026-03-20");
        s1.addItem(501, 2); // Customer buys 2 watches

        // 4. Process and Display Results
        System.out.println("--- Inventory Management System ---");
        System.out.println("Total Sale Value: $" + s1.calculateTotal(inventory));
        s1.processSale(inventory);

        System.out.println("Remaining Stock (Watches): " + inventory.getQuantity(501));

        // 5. Use File Management tasks
        fm.saveInventory(inventory);
    }
}