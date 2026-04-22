package oopproject;
public class Product {
        private int productId;
        private String productName;
        private double price;
        private double tax;
        public Product() {}
        public Product(int id, String name, double price, double tax) {
            this.productId = id;
            this.productName = name;
            this.price = price;
            this.tax = tax;
        }
        public double getSellingPrice() {
            return price + (price * tax / 100);
        }
        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }
        public int getProductId() {
            return productId;
        }
        @Override
        public String toString() {
            return productName + " (ID: " + productId + ")";
        }
        public String getProductName() {
            return productName;
        }
    }


        
