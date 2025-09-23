// File: AccessModifierSystem.java
// ASSIGNMENT 2: Tool Access Levels

public class AccessModifierSystem {
    
    public static class Tool {
        private String serialNumber;
        protected String brand;
        public String name;
        String category;
        
        private double price;
        protected int warrantyYears;
        public boolean isAvailable;
        
        public Tool(String name, String brand, String category, String serialNumber, 
                   double price, int warrantyYears) {
            this.name = name;
            this.brand = brand;
            this.category = category;
            this.serialNumber = serialNumber;
            this.price = price;
            this.warrantyYears = warrantyYears;
            this.isAvailable = true;
        }
        
        public String getSerialNumber() { return serialNumber; }
        public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }
        
        protected void performMaintenance() {
            System.out.println("Performing maintenance on " + name);
        }
        
        public void displayInfo() {
            System.out.println("Tool: " + name + " by " + brand + " - $" + price);
        }
        
        private void updateInventory() {
            System.out.println("Updating inventory for " + name);
        }
        
        public void processTransaction() {
            updateInventory();
            System.out.println("Transaction processed for " + name);
        }
    }
    
    public static class Hammer extends Tool {
        private double weight;
        private String handleMaterial;
        
        public Hammer(String name, String brand, double weight, String handleMaterial, 
                     String serialNumber, double price, int warrantyYears) {
            super(name, brand, "Hand Tool", serialNumber, price, warrantyYears);
            this.weight = weight;
            this.handleMaterial = handleMaterial;
        }
        
        public void testFieldAccess() {
            System.out.println("=== Testing Field Access in Hammer ===");
            System.out.println("✓ Public field 'name': " + name);
            System.out.println("✓ Protected field 'brand': " + brand);
            System.out.println("✓ Package-private field 'category': " + category);
            System.out.println("✓ Private field via getter 'serialNumber': " + getSerialNumber());
            System.out.println("✓ Private field via getter 'price': $" + getPrice());
        }
        
        public void testMethodAccess() {
            System.out.println("=== Testing Method Access in Hammer ===");
            displayInfo();
            performMaintenance();
            processTransaction();
        }
        
        @Override
        protected void performMaintenance() {
            super.performMaintenance();
            System.out.println("Checking hammer head and " + handleMaterial + " handle");
        }
        
        public void swing() {
            System.out.println("Swinging " + weight + "lb hammer");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Access Modifier System Demo ===");
        
        Hammer hammer = new Hammer("Claw Hammer", "DeWalt", 1.5, "Fiberglass", 
                                  "DW001", 29.99, 3);
        
        hammer.testFieldAccess();
        System.out.println();
        hammer.testMethodAccess();
        
        System.out.println("\n=== External Access Test ===");
        System.out.println("Public field access: " + hammer.name);
        System.out.println("Public method access:");
        hammer.displayInfo();
        hammer.swing();
    }
}