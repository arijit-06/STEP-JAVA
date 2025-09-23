import java.util.Scanner;

class Counter {
    static int count = 0;
    private int instanceId;
    
    Counter() {
        count++;
        instanceId = count;
        System.out.println("Counter object #" + instanceId + " created");
    }
    
    // Static method to get count
    public static int getCount() {
        return count;
    }
    
    public void displayInstanceInfo() {
        System.out.println("Instance ID: " + instanceId + " | Total Count: " + count);
    }
}

public class ObjectCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== OBJECT COUNTER SYSTEM ===\n");
        
        System.out.println("Initial count: " + Counter.getCount());
        
        // Create several Counter objects
        Counter c1 = new Counter();
        System.out.println("After creating c1: " + Counter.getCount());
        
        Counter c2 = new Counter();
        System.out.println("After creating c2: " + Counter.getCount());
        
        Counter c3 = new Counter();
        System.out.println("After creating c3: " + Counter.getCount());
        
        Counter c4 = new Counter();
        System.out.println("After creating c4: " + Counter.getCount());
        
        Counter c5 = new Counter();
        System.out.println("After creating c5: " + Counter.getCount());
        
        // Display instance information
        System.out.println("\nInstance Information:");
        c1.displayInstanceInfo();
        c2.displayInstanceInfo();
        c3.displayInstanceInfo();
        c4.displayInstanceInfo();
        c5.displayInstanceInfo();
        
        // Final count
        System.out.println("\nTotal objects created: " + Counter.getCount());
        
        sc.close();
    }
}