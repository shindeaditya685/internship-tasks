package tasks.task_1.stub_code;

import java.util.List;
import java.util.ArrayList;

public class Order {
    private int orderId;
    private User user;
    private List<Product> products;
    private OrderStatus status;
    private Payment payment;

    public Order(int orderId, User user) {
        this.orderId = orderId;
        this.user = user;
        this.products = new ArrayList<>();
        this.status = OrderStatus.PENDING;
    }

    // Getters and setters

    public void addProduct(Product product) {
        // Implementation
    }

    public void removeProduct(Product product) {
        // Implementation
    }

    public void updateStatus(OrderStatus status) {
        // Implementation
    }

    public void processPayment(Payment payment) {
        // Implementation
    }
}