import java.util.*;

class Customer {
    private String name;
    private String email;
    
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public void showDetails() {
        System.out.println("customer1:Customer -> name=\"" + name + "\", email=\"" + email + "\"");
    }
}

class Order {
    private String orderId;
    private String status;
    
    public Order(String orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }
    
    public void showDetails() {
        System.out.println("order" + orderId.substring(3) + ":Order -> orderId=\"" + orderId + "\", status=\"" + status + "\"");
    }
}

class Product {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public void showDetails() {
        System.out.println("product:Product -> name=\"" + name + "\", price=" + price);
    }
}

public class RuntimeInstances {
    public static void main(String[] args) {
        System.out.println("Object Diagram - Runtime Instances:");
        
        Customer customer1 = new Customer("Amit", "amit@gmail.com");
        Order order1 = new Order("ORD001", "Processing");
        Order order2 = new Order("ORD002", "Shipped");
        Product product1 = new Product("Laptop", 55000);
        Product product2 = new Product("Mobile", 25000);
        Product product3 = new Product("Mouse", 1500);
        
        customer1.showDetails();
        order1.showDetails();
        order2.showDetails();
        product1.showDetails();
        product2.showDetails();
        product3.showDetails();
        
        System.out.println("\nLinks:");
        System.out.println("customer1 -> order1, order2 (association)");
        System.out.println("order1 -> product1, product2 (composition)");
        System.out.println("order2 -> product3 (composition)");
    }
}