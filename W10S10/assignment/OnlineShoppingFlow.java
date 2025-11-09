class Customer {
    private String name;
    
    public Customer(String name) {
        this.name = name;
    }
    
    public void addItemToCart(Cart cart, String item) {
        System.out.println(name + " -> Cart: addItem(" + item + ")");
        cart.addItem(item);
    }
    
    public void makePayment(PaymentService paymentService, double amount) {
        System.out.println(name + " -> PaymentService: makePayment(" + amount + ")");
        paymentService.processPayment(amount);
    }
    
    public void placeOrder(OrderService orderService, String orderId) {
        System.out.println(name + " -> OrderService: confirmOrder(" + orderId + ")");
        orderService.confirmOrder(orderId);
    }
}

class Cart {
    public void addItem(String item) {
        System.out.println("Cart: Item " + item + " added");
        System.out.println("Cart -> Customer: return itemAdded");
    }
}

class PaymentService {
    public void processPayment(double amount) {
        System.out.println("PaymentService: Processing payment of ₹" + amount);
        System.out.println("PaymentService -> Customer: return paymentSuccess");
    }
}

class OrderService {
    public void confirmOrder(String orderId) {
        System.out.println("OrderService: Order " + orderId + " confirmed");
        System.out.println("OrderService -> Customer: return orderConfirmed");
    }
}

public class OnlineShoppingFlow {
    public static void main(String[] args) {
        System.out.println("Sequence Diagram - Online Shopping Flow:");
        
        Customer customer = new Customer("John");
        Cart cart = new Cart();
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService();
        
        customer.addItemToCart(cart, "Laptop");
        customer.makePayment(paymentService, 55000);
        customer.placeOrder(orderService, "ORD001");
    }
}