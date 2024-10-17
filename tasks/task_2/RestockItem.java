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
