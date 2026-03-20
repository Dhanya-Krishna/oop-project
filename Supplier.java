
    import java.util.ArrayList;
import java.util.List;

    public class Supplier {
        private int supplierId;
        private String supplierName;
        private double discountRate;
        private List<Product> suppliedProducts;

        public Supplier() {
            suppliedProducts = new ArrayList<>();
        }

        public Supplier(int id, String name, double discount) {
            this.supplierId = id;
            this.supplierName = name;
            this.discountRate = discount;
            this.suppliedProducts = new ArrayList<>();
        }

        public double calculateDiscount() {
            return discountRate;
        }

        public void addProduct(Product p) {
            suppliedProducts.add(p);
        }
    }

