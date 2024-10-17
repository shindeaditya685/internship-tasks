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
