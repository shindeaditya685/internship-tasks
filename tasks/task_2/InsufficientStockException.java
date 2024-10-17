package tasks.task_2;

public class InsufficientStockException extends Exception{
    public InsufficientStockException(String message) {
        super(message);
    }
}
