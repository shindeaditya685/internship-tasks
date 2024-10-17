package tasks.task_1.stub_code;

import java.util.List;
import java.util.ArrayList;


public class User {
    private int userId;
    private String username;
    private String email;
    private String password;
    private List<Order> orders;

    public User(int userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.orders = new ArrayList<>();
    }

    public void createOrder(Order order) {
        // Implementation
    }

    public List<Order> viewOrders() {
        // Implementation
        return null;
    }

    public void manageOrder(Order order) {
        // Implementation
    }
}
