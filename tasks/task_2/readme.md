## Inventory Management System

1. [InventoryManagementSystem.java](InventoryManagementSystem.java) is parent class that contains main function: -  
  * This class contains two methods 'process_orders' and 'restock_items'.
  * 'process_orders' method processes the order. If the currentStock is less than the quantity then it throw a custom called 'InsufficientStockException'.
  * If the 'product' is less than the defined threshold quantity then it gives an alert message.
  * Also, This method checks for if the product is available or not. if is not then it throws "IllegalArgumentException".
  * 'restock_items' method restocks the product's quantity.
```java

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

```

2. [Product.java](Product.java) class has two properties 'name' and 'stockQuantity'.
 * this class uses parametrized constructor to initialize the object.
 * it has two methods 'getName()' and 'getStockQuantity()'. which returns the product name and it's quantity.

```java
package tasks.task_2;

public class Product {
    private String name;
    private int stockQuantity;

    public Product(String name, int stockQuantity) {
        this.name = name;
        this.stockQuantity = stockQuantity;
    }

    public String getName() {
        return name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
```

3. [Order.java](Order.java) class has two properties 'product' and 'quantity'.
 *  this class uses parametrized constructor to initialize the object.
 * it has two methods 'getProduct()' and 'getQuantity()'. which returns the product name and it's quantity.
```java 
 package tasks.task_2;

public class Order {
    private String product;
    private int quantity;

    public Order(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
```

4. [RestockItem.java](RestockItem.java) class has two properties 'product' and 'quantity'.
*  this class uses parametrized constructor to initialize the object.
* it has two methods 'getProduct()' and 'getQuantity()'. which returns the product name and it's quantity.

```java 
package tasks.task_2;

public class RestockItem {
    private String product;
    private int quantity;

    public RestockItem(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

```

5. [InsufficientStockException.java](InsufficientStockException.java) class extends the 'Exception' class to create a custom exception.

```java
package tasks.task_2;

public class InsufficientStockException extends Exception{
    public InsufficientStockException(String message) {
        super(message);
    }
}

```