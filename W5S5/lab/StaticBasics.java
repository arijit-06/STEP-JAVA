// File: StaticBasics.java
// LAB 1: Basic Static Methods and Variables

public class StaticBasics {
    
    public static class Calculator {
        private static int operationCount = 0;
        
        public static int add(int a, int b) {
            operationCount++;
            return a + b;
        }
        
        public static int multiply(int a, int b) {
            operationCount++;
            return a * b;
        }
        
        public static double divide(double a, double b) {
            operationCount++;
            return b != 0 ? a / b : 0;
        }
        
        public static int getOperationCount() {
            return operationCount;
        }
        
        public static void resetCounter() {
            operationCount = 0;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Static Methods Demo ===");
        
        System.out.println("5 + 3 = " + Calculator.add(5, 3));
        System.out.println("4 * 7 = " + Calculator.multiply(4, 7));
        System.out.println("10 / 2 = " + Calculator.divide(10, 2));
        
        System.out.println("Operations performed: " + Calculator.getOperationCount());
        
        Calculator.resetCounter();
        System.out.println("After reset: " + Calculator.getOperationCount());
    }
}