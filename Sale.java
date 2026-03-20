
    import java.util.HashMap;
import java.util.Map;

    public class Sale {
        private int saleId;
        private String saleDate;
        private Map<Integer, Integer> itemsSold;

        public Sale() {
            itemsSold = new HashMap<>();
        }

        public Sale(int id, String date) {
            this.saleId = id;
            this.saleDate = date;
            this.itemsSold = new HashMap<>();
        }

        public void addItem(int id, int qty) {
            itemsSold.put(id, itemsSold.getOrDefault(id, 0) + qty);
        }

        public double calculateTotal(Inventory inv) {
            double total = 0;
            for (Map.Entry<Integer, Integer> entry : itemsSold.entrySet()) {
                Product p = inv.getProduct(entry.getKey());
                if (p != null) {
                    total += p.getSellingPrice() * entry.getValue();
                }
            }
            return total;
        }

        public void processSale(Inventory inv) {
            for (Map.Entry<Integer, Integer> entry : itemsSold.entrySet()) {
                int id = entry.getKey();
                int qty = entry.getValue();
                if (inv.checkAvailability(id, qty)) {
                    inv.updateStock(id, -qty);
                    System.out.println("Sale Processed: " + qty + " units of Product ID " + id);
                } else {
                    System.out.println("Error: Insufficient stock for Product ID " + id);
                }
            }
        }
    }

