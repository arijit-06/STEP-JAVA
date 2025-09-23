// File: FitnessTracker.java
// HW PROBLEM 2: Tool Access Levels
// Topic: Access Modifiers in Inheritance

public class FitnessTracker {
    
    // Tool class with different access level fields
    public static class Tool {
        private String serialNumber;      // Private - only accessible within Tool class
        protected String brand;           // Protected - accessible to subclasses
        public String name;              // Public - accessible everywhere
        String category;                 // Package-private - accessible within same package
        
        private double price;            // Private field requiring getter
        protected int warrantyYears;     // Protected field for inheritance
        public boolean isAvailable;     // Public field for direct access
        
        public Tool(String name, String brand, String category, String serialNumber, 
                   double price, int warrantyYears) {
            this.name = name;
            this.brand = brand;
            this.category = category;
            this.serialNumber = serialNumber;
            this.price = price;
            this.warrantyYears = warrantyYears;
            this.isAvailable = true;
            System.out.println("Tool created: " + name);
        }
        
        // Getter for private field
        public String getSerialNumber() {
            return serialNumber;
        }
        
        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }
        
        // Getter for private price
        public double getPrice() {
            return price;
        }
        
        public void setPrice(double price) {
            this.price = price;
        }
        
        // Protected method accessible to subclasses
        protected void performMaintenance() {
            System.out.println("Performing maintenance on " + name);
        }
        
        // Public method accessible everywhere
        public void displayInfo() {
            System.out.println("Tool: " + name + " by " + brand);
            System.out.println("Category: " + category + ", Available: " + isAvailable);
        }
        
        // Private method only accessible within Tool class
        private void updateInventory() {
            System.out.println("Updating inventory for " + name);
        }
        
        // Public method that calls private method
        public void processTransaction() {
            updateInventory();
            System.out.println("Transaction processed for " + name);
        }
    }
    
    // Hammer class extending Tool
    public static class Hammer extends Tool {
        private double weight;
        private String handleMaterial;
        
        public Hammer(String name, String brand, double weight, String handleMaterial, 
                     String serialNumber, double price, int warrantyYears) {
            super(name, brand, "Hand Tool", serialNumber, price, warrantyYears);
            this.weight = weight;
            this.handleMaterial = handleMaterial;
            System.out.println("Hammer created with " + handleMaterial + " handle");
        }
        
        public void testFieldAccess() {
            System.out.println("\n=== Testing Field Access in Hammer Class ===");
            
            // Public field - directly accessible
            System.out.println("✓ Public field 'name': " + name);
            System.out.println("✓ Public field 'isAvailable': " + isAvailable);
            
            // Protected field - accessible to subclasses
            System.out.println("✓ Protected field 'brand': " + brand);
            System.out.println("✓ Protected field 'warrantyYears': " + warrantyYears);
            
            // Package-private field - accessible within same package
            System.out.println("✓ Package-private field 'category': " + category);
            
            // Private field - NOT directly accessible, need getter
            // System.out.println("✗ Private field 'serialNumber': " + serialNumber); // This would cause error
            System.out.println("✓ Private field via getter 'serialNumber': " + getSerialNumber());
            
            // Private field - NOT directly accessible, need getter
            // System.out.println("✗ Private field 'price': " + price); // This would cause error
            System.out.println("✓ Private field via getter 'price': $" + getPrice());
        }
        
        public void testMethodAccess() {
            System.out.println("\n=== Testing Method Access in Hammer Class ===");
            
            // Public method - accessible
            System.out.println("✓ Calling public method displayInfo():");
            displayInfo();
            
            // Protected method - accessible to subclasses
            System.out.println("✓ Calling protected method performMaintenance():");
            performMaintenance();
            
            // Private method - NOT directly accessible
            // updateInventory(); // This would cause compilation error
            System.out.println("✓ Private method accessible through public method:");
            processTransaction();
        }
        
        @Override
        protected void performMaintenance() {
            super.performMaintenance();
            System.out.println("Checking hammer head tightness");
            System.out.println("Inspecting " + handleMaterial + " handle for cracks");
        }
        
        public void swing() {
            System.out.println("Swinging " + weight + "lb hammer with " + handleMaterial + " handle");
        }
        
        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Weight: " + weight + "lbs, Handle: " + handleMaterial);
            System.out.println("Warranty: " + warrantyYears + " years");
        }
    }
    
    // Demonstration class to test access from outside the inheritance hierarchy
    public static class ToolUser {
        public void testExternalAccess(Tool tool, Hammer hammer) {
            System.out.println("\n=== Testing External Access (ToolUser class) ===");
            
            // Public fields and methods - accessible
            System.out.println("✓ Public field 'name': " + tool.name);
            System.out.println("✓ Public field 'isAvailable': " + tool.isAvailable);
            System.out.println("✓ Calling public method displayInfo():");
            tool.displayInfo();
            
            // Package-private field - accessible within same package
            System.out.println("✓ Package-private field 'category': " + tool.category);
            
            // Protected fields - NOT accessible from unrelated class
            // System.out.println("✗ Protected field 'brand': " + tool.brand); // Would cause error
            System.out.println("✗ Protected field 'brand' not directly accessible from external class");
            
            // Private fields - NOT accessible, need getters
            System.out.println("✓ Private field via getter 'serialNumber': " + tool.getSerialNumber());
            System.out.println("✓ Private field via getter 'price': $" + tool.getPrice());
            
            // Protected methods - NOT accessible from unrelated class
            // tool.performMaintenance(); // Would cause compilation error
            System.out.println("✗ Protected method 'performMaintenance()' not accessible from external class");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Access Modifiers in Inheritance Demo ===");
        
        // Create Tool and Hammer objects
        Tool genericTool = new Tool("Screwdriver", "Stanley", "Hand Tool", 
                                   "ST001", 15.99, 2);
        
        Hammer hammer = new Hammer("Claw Hammer", "DeWalt", 1.5, "Fiberglass", 
                                  "DW001", 29.99, 3);
        
        System.out.println("\n=== Testing Access Within Inheritance Hierarchy ===");
        
        // Test field access from within subclass
        hammer.testFieldAccess();
        
        // Test method access from within subclass
        hammer.testMethodAccess();
        
        System.out.println("\n=== Testing Overridden Methods ===");
        hammer.displayInfo();
        hammer.performMaintenance();
        
        System.out.println("\n=== Testing External Access ===");
        ToolUser user = new ToolUser();
        user.testExternalAccess(genericTool, hammer);
        
        System.out.println("\n=== Access Modifier Summary ===");
        System.out.println("✓ PUBLIC: Accessible everywhere");
        System.out.println("✓ PROTECTED: Accessible within package and subclasses");
        System.out.println("✓ PACKAGE-PRIVATE: Accessible within same package");
        System.out.println("✓ PRIVATE: Only accessible within same class (use getters/setters)");
        
        System.out.println("\n=== Demonstrating Proper Encapsulation ===");
        
        // Show how private fields are properly encapsulated
        System.out.println("Original price: $" + hammer.getPrice());
        hammer.setPrice(34.99);
        System.out.println("Updated price: $" + hammer.getPrice());
        
        // Show direct access to public fields
        hammer.isAvailable = false;
        System.out.println("Tool availability changed to: " + hammer.isAvailable);
        
        // Show that we can access protected fields through inheritance
        System.out.println("Warranty years (protected field): " + hammer.warrantyYears);
    }
}