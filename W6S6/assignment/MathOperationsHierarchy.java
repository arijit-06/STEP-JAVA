// File: MathOperationsHierarchy.java
// ASSIGNMENT 5: Math Operations Inheritance

public class MathOperationsHierarchy {
    
    public static class BasicMath {
        // Overloaded calculate methods with different parameters
        public double calculate(double a, double b) {
            return a + b; // Default: addition
        }
        
        public double calculate(double a, double b, String operation) {
            switch (operation.toLowerCase()) {
                case "add": return a + b;
                case "subtract": return a - b;
                case "multiply": return a * b;
                case "divide": return b != 0 ? a / b : 0;
                default: return 0;
            }
        }
        
        public double calculate(double[] numbers) {
            double sum = 0;
            for (double num : numbers) {
                sum += num;
            }
            return sum; // Sum of array
        }
        
        public double calculate(double base, int exponent) {
            double result = 1;
            for (int i = 0; i < Math.abs(exponent); i++) {
                result *= base;
            }
            return exponent < 0 ? 1.0 / result : result; // Power calculation
        }
        
        public void displayOperation(String operation, double result) {
            System.out.println(operation + " = " + result);
        }
    }
    
    public static class AdvancedMath extends BasicMath {
        // Inherit all overloaded methods from BasicMath
        // Add new overloaded methods
        
        public double calculate(double a, double b, double c) {
            return (a + b + c) / 3; // Average of three numbers
        }
        
        public double calculate(double a, double b, double c, String operation) {
            switch (operation.toLowerCase()) {
                case "average": return (a + b + c) / 3;
                case "sum": return a + b + c;
                case "product": return a * b * c;
                default: return 0;
            }
        }
        
        public double calculate(double radius, boolean isCircleArea) {
            if (isCircleArea) {
                return Math.PI * radius * radius; // Circle area
            } else {
                return 2 * Math.PI * radius; // Circle circumference
            }
        }
        
        public double calculate(double a, double b, double c, double d) {
            return Math.sqrt(a*a + b*b + c*c + d*d); // 4D vector magnitude
        }
        
        // Override parent method to add more operations
        @Override
        public double calculate(double a, double b, String operation) {
            switch (operation.toLowerCase()) {
                case "power": return Math.pow(a, b);
                case "root": return Math.pow(a, 1.0/b);
                case "log": return Math.log(a) / Math.log(b); // log base b of a
                case "max": return Math.max(a, b);
                case "min": return Math.min(a, b);
                default: return super.calculate(a, b, operation); // Call parent for basic operations
            }
        }
        
        // New method for statistical calculations
        public double calculate(double[] numbers, String statistic) {
            switch (statistic.toLowerCase()) {
                case "mean":
                    return calculate(numbers) / numbers.length; // Reuse inherited method
                case "max":
                    double max = numbers[0];
                    for (double num : numbers) {
                        if (num > max) max = num;
                    }
                    return max;
                case "min":
                    double min = numbers[0];
                    for (double num : numbers) {
                        if (num < min) min = num;
                    }
                    return min;
                case "range":
                    return calculate(numbers, "max") - calculate(numbers, "min");
                default:
                    return 0;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Math Operations Inheritance Demo ===");
        
        BasicMath basicMath = new BasicMath();
        AdvancedMath advancedMath = new AdvancedMath();
        
        System.out.println("\n=== BasicMath Operations ===");
        basicMath.displayOperation("5 + 3", basicMath.calculate(5, 3));
        basicMath.displayOperation("10 - 4", basicMath.calculate(10, 4, "subtract"));
        basicMath.displayOperation("2^8", basicMath.calculate(2, 8));
        basicMath.displayOperation("Sum of [1,2,3,4,5]", basicMath.calculate(new double[]{1,2,3,4,5}));
        
        System.out.println("\n=== AdvancedMath Operations (Inherited + New) ===");
        // Using inherited methods
        advancedMath.displayOperation("7 + 8", advancedMath.calculate(7, 8));
        advancedMath.displayOperation("Sum of [2,4,6,8]", advancedMath.calculate(new double[]{2,4,6,8}));
        
        // Using overridden methods
        advancedMath.displayOperation("2^10", advancedMath.calculate(2, 10, "power"));
        advancedMath.displayOperation("Max(15, 23)", advancedMath.calculate(15, 23, "max"));
        
        // Using new overloaded methods
        advancedMath.displayOperation("Average of 10, 20, 30", advancedMath.calculate(10, 20, 30));
        advancedMath.displayOperation("Circle area (r=5)", advancedMath.calculate(5, true));
        advancedMath.displayOperation("Circle circumference (r=5)", advancedMath.calculate(5, false));
        advancedMath.displayOperation("4D vector magnitude", advancedMath.calculate(3, 4, 5, 6));
        
        // Using statistical methods
        double[] data = {10, 20, 30, 40, 50};
        advancedMath.displayOperation("Mean of data", advancedMath.calculate(data, "mean"));
        advancedMath.displayOperation("Max of data", advancedMath.calculate(data, "max"));
        advancedMath.displayOperation("Range of data", advancedMath.calculate(data, "range"));
        
        System.out.println("\n=== Polymorphism Test ===");
        BasicMath polymorphicMath = new AdvancedMath();
        polymorphicMath.displayOperation("Polymorphic power 3^4", polymorphicMath.calculate(3, 4, "power"));
        
        System.out.println("\n=== Method Overloading Summary ===");
        System.out.println("BasicMath has 4 overloaded calculate() methods");
        System.out.println("AdvancedMath inherits all 4 + adds 5 more = 9 total");
        System.out.println("AdvancedMath also overrides 1 method for enhanced functionality");
    }
}