class Customer {
    private String name;
    
    public Customer(String name) {
        this.name = name;
    }
    
    public void placeOrder(OrderService orderService, String item) {
        System.out.println(name + " places order for " + item);
        orderService.processOrder(item);
    }
}

class OrderService {
    public void processOrder(String item) {
        System.out.println("OrderService processing: " + item);
        PaymentGateway payment = new PaymentGateway();
        payment.processPayment();
        
        InventoryService inventory = new InventoryService();
        inventory.updateStock(item);
    }
}

class PaymentGateway {
    public void processPayment() {
        System.out.println("PaymentGateway: Payment processed successfully");
    }
}

class InventoryService {
    public void updateStock(String item) {
        System.out.println("InventoryService: Stock updated for " + item);
    }
}

public class OnlineOrder {
    public static void main(String[] args) {
        Customer customer = new Customer("John");
        OrderService orderService = new OrderService();
        
        customer.placeOrder(orderService, "Laptop");
    }
}