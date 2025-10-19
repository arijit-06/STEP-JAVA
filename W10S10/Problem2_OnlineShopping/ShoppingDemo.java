public class ShoppingDemo {
    public static void main(String[] args) {
        // Step 1 - Create Customer object
        Customer customer = new Customer("Amit", "amit@gmail.com");

        // Step 2 - Create Product objects
        Product laptop = new Product("Laptop", 55000);
        Product mobile = new Product("Mobile", 25000);
        Product mouse = new Product("Mouse", 1500);

        // Step 3 - Create 2 Order objects and add different products to each
        Order order1 = new Order("ORD001");
        order1.addProduct(laptop);
        order1.addProduct(mouse);

        Order order2 = new Order("ORD002");
        order2.addProduct(mobile);

        // Step 4 - Associate orders with customer using placeOrder()
        customer.placeOrder(order1);
        customer.placeOrder(order2);

        // Step 5 - Display all orders and their products using showCustomerOrders()
        customer.showCustomerOrders();
    }
}