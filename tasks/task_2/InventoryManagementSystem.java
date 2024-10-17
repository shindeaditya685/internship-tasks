
package tasks.task_2;

import java.util.*;

public class InventoryManagementSystem {
    private Map<String, Integer> inventory;

     public InventoryManagementSystem() {
         this.inventory = new HashMap<>();
     }

     public List<String> process_orders(List<Product> products, List<Order> orders) throws InsufficientStockException {
         List<String> alerts = new ArrayList<>();

         for (Product product: products) {
             inventory.put(product.getName(), product.getStockQuantity());
         }

         for (Order order: orders) {
             String product = order.getProduct();
             int quantity = order.getQuantity();

             if (!inventory.containsKey(product)) {
                 throw new IllegalArgumentException("Product " + product + " not found in inventory.");
             }

             int currentStock = inventory.get(product);

             if (currentStock < quantity) {
                 throw new InsufficientStockException("Insufficient stock for " + product);
             }

             inventory.put(product, currentStock - quantity);

             if (inventory.get(product) < 10) {
             alerts.add("Alert: " + product + " needs restocking.");
             }
         }
         return alerts;
     }

     public void restock_items(List<RestockItem> restockItems) {
         for (RestockItem item : restockItems) {
             String product = item.getProduct();
             int quantity = item.getQuantity();
             inventory.merge(product, quantity, Integer::sum);
         }
     }


    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        List<Product> products = Arrays.asList(
                new Product("Nike shoes", 60),
                new Product("Iphone 16", 40),
                new Product("HP Laptop", 35),
                new Product("Samsung S23 Ultra", 45)
        );

        List<Order> orders = Arrays.asList(
                new Order("Nike shoes", 40),
                new Order("Iphone 16", 20),
                new Order("HP Laptop", 30)
//                new Order("Unknown Product", 15) // this line of code is used to check whether the product is present or not. If such a product is not available then it throws the IllegalArgumentException
        );

        try {
            List<String> alerts = ims.process_orders(products, orders);
            for (String alert : alerts) {
                System.out.println(alert);
            }
        } catch (InsufficientStockException e) {
            System.out.println("Error processing orders: " + e.getMessage());
        }

        System.out.println("Inventory after processing orders: " + ims.inventory);

        // here, I have restocked the products
        List<RestockItem> restockItems = Arrays.asList(
                new RestockItem("Nike shoes", 10),
                new RestockItem("HP Laptop", 10)
        );

        ims.restock_items(restockItems);
        System.out.println("Inventory after restocking: " + ims.inventory);

    }


}