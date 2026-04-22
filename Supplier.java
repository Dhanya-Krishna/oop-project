package oopproject;
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
        public double calculateDiscount(double amount) {
        	 return amount * discountRate / 100;
        }
        public void addProduct(Product p) {
        	if (p == null) {
                System.out.println("Invalid product.");
                return;
            }
            suppliedProducts.add(p);
        }
        public int getSupplierId() {
            return supplierId;
        }

        public String getSupplierName() {
            return supplierName;
        }

        public List<Product> getSuppliedProducts() {
            return suppliedProducts;
        }
    }


