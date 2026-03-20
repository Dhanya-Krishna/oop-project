
    import java.util.HashMap;
import java.util.Map;

    public class Inventory {
        private Map<Integer, Integer> stock;
        private Map<Integer, Product> products;

        public Inventory() {
            stock = new HashMap<>();
            products = new HashMap<>();
        }

        public void addProduct(Product p, int qty) {
            products.put(p.getProductId(), p);
            stock.put(p.getProductId(), stock.getOrDefault(p.getProductId(), 0) + qty);
        }

        public boolean checkAvailability(int id, int qty) {
            return stock.containsKey(id) && stock.get(id) >= qty;
        }

        public void updateStock(int id, int qty) {
            if (stock.containsKey(id)) {
                stock.put(id, stock.get(id) + qty);
            }
        }

        public Product getProduct(int id) {
            return products.get(id);
        }

        public int getQuantity(int id) {
            return stock.getOrDefault(id, 0);
        }
    }

