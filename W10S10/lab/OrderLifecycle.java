enum OrderState {
    NEW, PROCESSING, SHIPPED, DELIVERED, CANCELLED
}

class Order {
    private String orderId;
    private OrderState state;
    
    public Order(String orderId) {
        this.orderId = orderId;
        this.state = OrderState.NEW;
        System.out.println("Order " + orderId + " created in NEW state");
    }
    
    public void processOrder() {
        if (state == OrderState.NEW) {
            state = OrderState.PROCESSING;
            System.out.println("Order " + orderId + " moved to PROCESSING");
        } else {
            System.out.println("Cannot process order in " + state + " state");
        }
    }
    
    public void shipOrder() {
        if (state == OrderState.PROCESSING) {
            state = OrderState.SHIPPED;
            System.out.println("Order " + orderId + " moved to SHIPPED");
        } else {
            System.out.println("Cannot ship order in " + state + " state");
        }
    }
    
    public void deliverOrder() {
        if (state == OrderState.SHIPPED) {
            state = OrderState.DELIVERED;
            System.out.println("Order " + orderId + " moved to DELIVERED");
        } else {
            System.out.println("Cannot deliver order in " + state + " state");
        }
    }
    
    public void cancelOrder() {
        if (state != OrderState.DELIVERED) {
            state = OrderState.CANCELLED;
            System.out.println("Order " + orderId + " moved to CANCELLED");
        } else {
            System.out.println("Cannot cancel delivered order");
        }
    }
    
    public void showState() {
        System.out.println("Order " + orderId + " is in " + state + " state");
    }
}

public class OrderLifecycle {
    public static void main(String[] args) {
        Order order = new Order("ORD001");
        
        order.processOrder();
        order.shipOrder();
        order.deliverOrder();
        order.showState();
        
        Order order2 = new Order("ORD002");
        order2.processOrder();
        order2.cancelOrder();
        order2.showState();
    }
}