/*
LAB PROBLEM 6: Static, Local, and Anonymous Inner Classes
Topic: Inner Class Variants
*/

interface MathOperation {
    int perform(int a, int b);
}

class Calculator {
    
    // Static Nested Class
    static class Operation {
        public static int add(int a, int b) {
            return a + b;
        }
        
        public int multiply(int a, int b) {
            return a * b;
        }
    }
    
    // Method containing local inner class
    public void performSubtraction(int a, int b) {
        System.out.println("\n--- Local Inner Class Demo ---");
        
        // Local Inner Class
        class SubtractionHelper {
            public int subtract() {
                return a - b; // Can access method parameters
            }
            
            public void displayResult() {
                System.out.println("Subtraction: " + a + " - " + b + " = " + subtract());
            }
        }
        
        SubtractionHelper helper = new SubtractionHelper();
        helper.displayResult();
    }
    
    // Method demonstrating anonymous inner class
    public void performMultiplication(int a, int b) {
        System.out.println("\n--- Anonymous Inner Class Demo ---");
        
        // Anonymous Inner Class implementing MathOperation interface
        MathOperation multiplication = new MathOperation() {
            @Override
            public int perform(int x, int y) {
                System.out.println("Performing multiplication in anonymous class");
                return x * y;
            }
        };
        
        int result = multiplication.perform(a, b);
        System.out.println("Multiplication: " + a + " × " + b + " = " + result);
    }
}

public class CalculatorInnerClasses {
    public static void main(String[] args) {
        System.out.println("=== Calculator Inner Classes Demo ===");
        
        Calculator calc = new Calculator();
        
        // Static Nested Class Demo
        System.out.println("\n--- Static Nested Class Demo ---");
        int addResult = Calculator.Operation.add(10, 5);
        System.out.println("Addition (static method): 10 + 5 = " + addResult);
        
        Calculator.Operation op = new Calculator.Operation();
        int mulResult = op.multiply(4, 3);
        System.out.println("Multiplication (instance method): 4 × 3 = " + mulResult);
        
        // Local Inner Class Demo
        calc.performSubtraction(15, 7);
        
        // Anonymous Inner Class Demo
        calc.performMultiplication(6, 8);
        
        // Additional anonymous inner class example
        System.out.println("\n--- Another Anonymous Class Example ---");
        MathOperation division = new MathOperation() {
            @Override
            public int perform(int a, int b) {
                if (b != 0) {
                    return a / b;
                }
                return 0;
            }
        };
        
        System.out.println("Division: 20 ÷ 4 = " + division.perform(20, 4));
        
        System.out.println("\n--- Summary ---");
        System.out.println("Static nested class: Independent of outer instance");
        System.out.println("Local inner class: Defined inside method, accesses local variables");
        System.out.println("Anonymous inner class: One-time implementation of interface/class");
    }
}