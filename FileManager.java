package oopproject;

import java.io.*;
import java.util.*;
public class FileManager {
	public void saveProducts(Collection<Product> list) {
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt"))) {
	                for (Product p : list) {
	                	writer.write(p.getProductId() + "," + p.getProductName() + "," + p.getPrice() + "," + p.getSellingPrice());
	                    writer.newLine();
	                }
	                System.out.println("Products saved successfully.");
	            } catch (IOException e) {
	                System.out.println("Error saving products.");
	            }
	            System.out.println("System: Saving products to database...");
	        }
	  public void loadProducts(Inventory inv) {
	    	try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {

	                String[] parts = line.split(",");
	                int id = Integer.parseInt(parts[0]);
	                String name = parts[1].split("\\(")[0].trim();
	                double price = Double.parseDouble(parts[2]);

	                Product p = new Product(id, name, price, 0); 
	                inv.addProduct(p, 0); 
	            }
	            System.out.println("Products loaded successfully.");
	        } catch (IOException e) {
	            System.out.println("No previous product data found.");
	        }
	    }
        public void saveInventory(Inventory inv) {
	    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.txt"))) {
	            for (Integer id : inv.getAllProductIds()) {
	                writer.write(id + "," + inv.getQuantity(id));
	                writer.newLine();
	            }
	            System.out.println("Inventory saved successfully.");
	        } catch (IOException e) {
	            System.out.println("Error saving inventory.");
	        }
	    }

	    public void loadInventory(Inventory inv) {
	    	 try (BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"))) {
	             String line;
	             while ((line = reader.readLine()) != null) {

	                 String[] parts = line.split(",");
	                 int id = Integer.parseInt(parts[0]);
	                 int qty = Integer.parseInt(parts[1]);

	                 inv.updateStock(id, qty);
	             }
	             System.out.println("Inventory loaded successfully.");
	         } catch (IOException e) {
	             System.out.println("No previous inventory data found.");
	         }
	     }
	  public static void main(String[] args) {
	        FileManager fm = new FileManager();
	        Inventory inventory = new Inventory();
            Product p1 = new Product(501, "Smartwatch", 150.0, 8.0);
	        Product p2 = new Product(502, "Headphones", 50.0, 5.0);
	        inventory.addProduct(p1, 20);
	        inventory.addProduct(p2, 100);
	        Sale s1 = new Sale(1001, "2026-03-20");
	        s1.addItem(501, 2); 
	        fm.saveProducts(inventory.getAllProducts());
	        fm.loadProducts(inventory);
		    fm.loadInventory(inventory);
            System.out.println("--- Inventory Management System ---");
	        System.out.println("Total Sale Value: $" + s1.calculateTotal(inventory));
	        s1.processSale(inventory);
            System.out.println("Remaining Stock (Watches): " + inventory.getQuantity(501));
            fm.saveInventory(inventory);	    
	    }
	}
