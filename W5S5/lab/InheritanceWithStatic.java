// File: InheritanceWithStatic.java
// LAB 8: Static Method Inheritance

public class InheritanceWithStatic {
    
    public static class Parent {
        protected static String className = "Parent";
        protected static int instanceCount = 0;
        
        public static void displayInfo() {
            System.out.println("This is the Parent class");
            System.out.println("Class name: " + className);
        }
        
        public static void incrementCount() {
            instanceCount++;
            System.out.println("Parent count incremented: " + instanceCount);
        }
        
        public static int getCount() {
            return instanceCount;
        }
        
        // This method will be hidden (not overridden) in child class
        public static void staticMethod() {
            System.out.println("Parent static method called");
        }
    }
    
    public static class Child extends Parent {
        // This hides the parent's className, doesn't override it
        protected static String className = "Child";
        
        // This hides the parent's displayInfo method
        public static void displayInfo() {
            System.out.println("This is the Child class");
            System.out.println("Class name: " + className);
        }
        
        // This hides the parent's staticMethod
        public static void staticMethod() {
            System.out.println("Child static method called");
        }
        
        // Child-specific static method
        public static void childSpecificMethod() {
            System.out.println("This method exists only in Child class");
        }
    }
    
    public static class GrandChild extends Child {
        protected static String className = "GrandChild";
        
        public static void displayInfo() {
            System.out.println("This is the GrandChild class");
            System.out.println("Class name: " + className);
        }
        
        // Accessing parent class static methods
        public static void callParentMethods() {
            System.out.println("Calling parent class methods:");
            Parent.displayInfo();
            Child.displayInfo();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Static Method Inheritance Demo ===");
        
        System.out.println("\n1. Direct method calls:");
        Parent.displayInfo();
        Child.displayInfo();
        GrandChild.displayInfo();
        
        System.out.println("\n2. Method hiding demonstration:");
        Parent.staticMethod();
        Child.staticMethod();
        
        System.out.println("\n3. Static variable hiding:");
        System.out.println("Parent className: " + Parent.className);
        System.out.println("Child className: " + Child.className);
        System.out.println("GrandChild className: " + GrandChild.className);
        
        System.out.println("\n4. Inherited static methods:");
        Parent.incrementCount();
        Child.incrementCount(); // Calls Parent's method
        GrandChild.incrementCount(); // Also calls Parent's method
        
        System.out.println("Final count: " + Parent.getCount());
        System.out.println("Count via Child: " + Child.getCount());
        System.out.println("Count via GrandChild: " + GrandChild.getCount());
        
        System.out.println("\n5. Reference type vs actual class:");
        Parent parentRef = new Child();
        // Static methods are resolved based on reference type, not object type
        // This would call Parent.staticMethod(), not Child.staticMethod()
        
        System.out.println("\n6. Accessing methods through inheritance chain:");
        GrandChild.callParentMethods();
        
        System.out.println("\n7. Child-specific method:");
        Child.childSpecificMethod();
        // GrandChild.childSpecificMethod(); // This also works due to inheritance
        
        System.out.println("\n=== Key Points ===");
        System.out.println("• Static methods are hidden, not overridden");
        System.out.println("• Method resolution is based on reference type");
        System.out.println("• Static variables are also hidden in subclasses");
        System.out.println("• Inherited static methods share the same implementation");
    }
}