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
