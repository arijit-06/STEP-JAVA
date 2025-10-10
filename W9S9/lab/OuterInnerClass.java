/*
LAB PROBLEM 5: Member Inner Class
Topic: Inner Class – Member Inner Class
*/

class Outer {
    private String message = "Hello from Outer Class!";
    private int outerValue = 100;
    
    // Member Inner Class (Non-static)
    class Inner {
        private String innerMessage = "Hello from Inner Class!";
        
        public void display() {
            System.out.println("=== Inner Class Display Method ===");
            System.out.println("Outer message: " + message); // Direct access to outer field
            System.out.println("Outer value: " + outerValue);
            System.out.println("Inner message: " + innerMessage);
            System.out.println("Accessing outer class from inner: " + Outer.this.message);
        }
        
        public void modifyOuter() {
            message = "Modified by Inner Class";
            outerValue = 200;
        }
    }
    
    public void showOuterData() {
        System.out.println("Current outer message: " + message);
        System.out.println("Current outer value: " + outerValue);
    }
}

public class OuterInnerClass {
    public static void main(String[] args) {
        System.out.println("=== Member Inner Class Demo ===");
        
        // Create outer class instance
        Outer outerObj = new Outer();
        
        System.out.println("\n--- Before Inner Class Access ---");
        outerObj.showOuterData();
        
        // Create inner class instance using outer instance
        Outer.Inner innerObj = outerObj.new Inner();
        
        System.out.println("\n--- Inner Class Operations ---");
        innerObj.display();
        
        System.out.println("\n--- Modifying Outer from Inner ---");
        innerObj.modifyOuter();
        outerObj.showOuterData();
        
        System.out.println("\n--- Creating Another Inner Instance ---");
        Outer.Inner anotherInner = outerObj.new Inner();
        anotherInner.display();
    }
}