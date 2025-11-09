import java.util.*;

class CustomerServiceSimulation {
    private Queue<Customer> waitingQueue;
    private int customerCount;
    
    class Customer {
        String name;
        int arrivalTime;
        
        Customer(String name, int arrivalTime) {
            this.name = name;
            this.arrivalTime = arrivalTime;
        }
        
        @Override
        public String toString() {
            return name + "(T" + arrivalTime + ")";
        }
    }
    
    public CustomerServiceSimulation() {
        waitingQueue = new LinkedList<>();
        customerCount = 0;
    }
    
    public void customerArrives(String name) {
        Customer customer = new Customer(name, ++customerCount);
        waitingQueue.offer(customer);
        System.out.println(customer + " joined the queue");
        displayQueue();
    }
    
    public void serveCustomer() {
        if (waitingQueue.isEmpty()) {
            System.out.println("No customers to serve");
            return;
        }
        
        Customer served = waitingQueue.poll();
        System.out.println("Serving " + served);
        displayQueue();
    }
    
    public void displayQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Waiting customers: " + waitingQueue);
        }
        System.out.println("Queue size: " + waitingQueue.size());
        System.out.println("---");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerServiceSimulation service = new CustomerServiceSimulation();
        
        while (true) {
            System.out.print("Command (ARRIVE <name>/SERVE/STATUS/EXIT): ");
            String cmd = sc.next();
            
            if (cmd.equals("ARRIVE")) {
                String name = sc.next();
                service.customerArrives(name);
            } else if (cmd.equals("SERVE")) {
                service.serveCustomer();
            } else if (cmd.equals("STATUS")) {
                service.displayQueue();
            } else if (cmd.equals("EXIT")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
        sc.close();
    }
}