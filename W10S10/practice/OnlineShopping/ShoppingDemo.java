public class ShoppingDemo {
    public static void main(String[] args) {
        Customer customer = new Customer("Amit", "amit@gmail.com");
        
        Product laptop = new Product("Laptop", 55000);
        Product mobile = new Product("Mobile", 25000);
        Product mouse = new Product("Mouse", 1500);
        
        Order order1 = new Order("ORD001");
        order1.addProduct(laptop);
        order1.addProduct(mouse);
        
        Order order2 = new Order("ORD002");
        order2.addProduct(mobile);
        
        customer.placeOrder(order1);
        customer.placeOrder(order2);
        
        customer.showCustomerOrders();
    }
}