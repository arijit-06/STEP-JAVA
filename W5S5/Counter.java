public class Counter {
    // Static fields - shared across all instances
    private static int totalCounters = 0;
    private static int globalCount = 0;
    
    // Instance field - individual to each object
    private int instanceCount;
    private String counterName;
    
    // Static initialization block
    static {
        System.out.println("Counter class loaded - initializing static fields");
        totalCounters = 0;
        globalCount = 0;
    }
    
    // Constructor
    public Counter(String counterName) {
        this.counterName = counterName;
        this.instanceCount = 0;
        totalCounters++; // Increment static field
        System.out.println("Counter '" + counterName + "' created. Total counters: " + totalCounters);
    }
    
    // Default constructor
    public Counter() {
        this("Counter-" + (totalCounters + 1));
    }
    
    // Static methods - can only access static members directly
    public static int getTotalCounters() {
        return totalCounters;
    }
    
    public static void resetGlobalCount() {
        globalCount = 0;
        System.out.println("Global count reset to 0");
    }
    
    public static int getGlobalCount() {
        return globalCount;
    }
    
    public static void displayStaticInfo() {
        System.out.println("=== Static Information ===");
        System.out.println("Total Counters Created: " + totalCounters);
        System.out.println("Global Count: " + globalCount);
        // System.out.println(instanceCount); // This would cause compile error
    }
    
    // Instance methods - can access both static and instance members
    public void increment() {
        instanceCount++;
        globalCount++; // Accessing static field from instance method
        System.out.println(counterName + " incremented. Instance: " + instanceCount + 
                         ", Global: " + globalCount);
    }
    
    public void decrement() {
        if (instanceCount > 0) {
            instanceCount--;
        }
        if (globalCount > 0) {
            globalCount--; // Accessing static field from instance method
        }
        System.out.println(counterName + " decremented. Instance: " + instanceCount + 
                         ", Global: " + globalCount);
    }
    
    public void reset() {
        instanceCount = 0;
        System.out.println(counterName + " instance count reset to 0");
    }
    
    public int getValue() {
        return instanceCount;
    }
    
    public void displayInfo() {
        System.out.println("=== " + counterName + " Info ===");
        System.out.println("Instance Count: " + instanceCount);
        System.out.println("Global Count: " + globalCount); // Instance method accessing static field
        System.out.println("Total Counters: " + totalCounters); // Instance method accessing static field
    }
    
    // Method demonstrating static vs instance access
    public void demonstrateAccess() {
        // Instance method can access both static and instance members
        System.out.println("From instance method:");
        System.out.println("  Instance field (instanceCount): " + instanceCount);
        System.out.println("  Static field (globalCount): " + globalCount);
        System.out.println("  Static field (totalCounters): " + totalCounters);
        
        // Can call static methods from instance method
        System.out.println("  Calling static method getTotalCounters(): " + getTotalCounters());
    }
    
    // Static method that takes Counter parameter to access instance members
    public static void compareCounters(Counter c1, Counter c2) {
        System.out.println("Comparing " + c1.counterName + " and " + c2.counterName);
        System.out.println(c1.counterName + " count: " + c1.instanceCount);
        System.out.println(c2.counterName + " count: " + c2.instanceCount);
        System.out.println("Global count: " + globalCount);
    }
    
    public String getCounterName() {
        return counterName;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Counter Static Keyword Demo ===\n");
        
        // Display initial static state
        Counter.displayStaticInfo();
        System.out.println();
        
        // Create first counter
        Counter counter1 = new Counter("Primary");
        counter1.displayInfo();
        System.out.println();
        
        // Create second counter
        Counter counter2 = new Counter("Secondary");
        counter2.displayInfo();
        System.out.println();
        
        // Demonstrate static vs instance behavior
        System.out.println("=== Incrementing Counters ===");
        counter1.increment();
        counter1.increment();
        counter2.increment();
        
        System.out.println("\nAfter increments:");
        counter1.displayInfo();
        counter2.displayInfo();
        System.out.println();
        
        // Show that static fields are shared
        System.out.println("=== Static Field Sharing ===");
        System.out.println("Global count from counter1: " + counter1.getGlobalCount());
        System.out.println("Global count from counter2: " + counter2.getGlobalCount());
        System.out.println("Global count from class: " + Counter.getGlobalCount());
        System.out.println();
        
        // Demonstrate static method access
        System.out.println("=== Static Method Access ===");
        Counter.displayStaticInfo();
        Counter.compareCounters(counter1, counter2);
        System.out.println();
        
        // Reset operations
        System.out.println("=== Reset Operations ===");
        counter1.reset(); // Resets only instance count
        Counter.resetGlobalCount(); // Resets static global count
        
        counter1.displayInfo();
        counter2.displayInfo();
        System.out.println();
        
        // Create more counters to show totalCounters increment
        System.out.println("=== Creating More Counters ===");
        Counter counter3 = new Counter("Tertiary");
        Counter counter4 = new Counter(); // Uses default name
        
        Counter.displayStaticInfo();
        System.out.println();
        
        // Demonstrate access patterns
        System.out.println("=== Access Pattern Demonstration ===");
        counter3.demonstrateAccess();
    }
}