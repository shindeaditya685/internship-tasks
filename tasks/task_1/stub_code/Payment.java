package tasks.task_1.stub_code;

public class Payment {
    private int paymentId;
    private Order order;
    private double amount;
    private PaymentStatus status;

    public Payment(int paymentId, Order order, double amount) {
        this.paymentId = paymentId;
        this.order = order;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    // Getters and setters

    public void processPayment() {
        // Implementation
    }
}