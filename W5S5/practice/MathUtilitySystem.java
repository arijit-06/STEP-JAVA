// File: MathUtilitySystem.java
// PRACTICE PROBLEM 1: Static Utility Classes and Helper Methods
// Topic: Creating comprehensive utility classes with static methods

public class MathUtilitySystem {
    
    // Math Utility Class with static methods only
    public static class MathUtils {
        // Static constants
        public static final double PI = 3.14159265359;
        public static final double E = 2.71828182846;
        public static final double GOLDEN_RATIO = 1.61803398875;
        
        // Private constructor to prevent instantiation
        private MathUtils() {
            throw new UnsupportedOperationException("Utility class cannot be instantiated");
        }
        
        // Basic arithmetic operations
        public static int add(int a, int b) {
            return a + b;
        }
        
        public static double add(double a, double b) {
            return a + b;
        }
        
        public static int multiply(int a, int b) {
            return a * b;
        }
        
        public static double multiply(double a, double b) {
            return a * b;
        }
        
        public static double divide(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }
        
        // Power and root operations
        public static double power(double base, int exponent) {
            if (exponent == 0) return 1;
            if (exponent < 0) return 1.0 / power(base, -exponent);
            
            double result = 1;
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            return result;
        }
        
        public static double sqrt(double number) {
            if (number < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of negative number");
            }
            if (number == 0) return 0;
            
            double guess = number / 2;
            double epsilon = 0.000001;
            
            while (Math.abs(guess * guess - number) > epsilon) {
                guess = (guess + number / guess) / 2;
            }
            return guess;
        }
        
        // Factorial and combinatorics
        public static long factorial(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Factorial not defined for negative numbers");
            }
            if (n <= 1) return 1;
            
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        }
        
        public static long combination(int n, int r) {
            if (r > n || r < 0) {
                throw new IllegalArgumentException("Invalid combination parameters");
            }
            return factorial(n) / (factorial(r) * factorial(n - r));
        }
        
        // Number theory operations
        public static int gcd(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
        
        public static int lcm(int a, int b) {
            return Math.abs(a * b) / gcd(a, b);
        }
        
        public static boolean isPrime(int number) {
            if (number <= 1) return false;
            if (number <= 3) return true;
            if (number % 2 == 0 || number % 3 == 0) return false;
            
            for (int i = 5; i * i <= number; i += 6) {
                if (number % i == 0 || number % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    
    // Statistics Utility Class
    public static class StatUtils {
        private StatUtils() {
            throw new UnsupportedOperationException("Utility class cannot be instantiated");
        }
        
        public static double mean(double[] numbers) {
            if (numbers.length == 0) {
                throw new IllegalArgumentException("Array cannot be empty");
            }
            
            double sum = 0;
            for (double num : numbers) {
                sum += num;
            }
            return sum / numbers.length;
        }
        
        public static double median(double[] numbers) {
            if (numbers.length == 0) {
                throw new IllegalArgumentException("Array cannot be empty");
            }
            
            double[] sorted = numbers.clone();
            // Simple bubble sort for demonstration
            for (int i = 0; i < sorted.length - 1; i++) {
                for (int j = 0; j < sorted.length - i - 1; j++) {
                    if (sorted[j] > sorted[j + 1]) {
                        double temp = sorted[j];
                        sorted[j] = sorted[j + 1];
                        sorted[j + 1] = temp;
                    }
                }
            }
            
            int n = sorted.length;
            if (n % 2 == 0) {
                return (sorted[n/2 - 1] + sorted[n/2]) / 2.0;
            } else {
                return sorted[n/2];
            }
        }
        
        public static double standardDeviation(double[] numbers) {
            double mean = mean(numbers);
            double sumSquaredDiffs = 0;
            
            for (double num : numbers) {
                sumSquaredDiffs += (num - mean) * (num - mean);
            }
            
            return MathUtils.sqrt(sumSquaredDiffs / numbers.length);
        }
        
        public static double[] range(double[] numbers) {
            if (numbers.length == 0) {
                throw new IllegalArgumentException("Array cannot be empty");
            }
            
            double min = numbers[0];
            double max = numbers[0];
            
            for (double num : numbers) {
                if (num < min) min = num;
                if (num > max) max = num;
            }
            
            return new double[]{min, max};
        }
    }
    
    // Geometry Utility Class
    public static class GeometryUtils {
        private GeometryUtils() {
            throw new UnsupportedOperationException("Utility class cannot be instantiated");
        }
        
        public static double circleArea(double radius) {
            if (radius < 0) {
                throw new IllegalArgumentException("Radius cannot be negative");
            }
            return MathUtils.PI * radius * radius;
        }
        
        public static double circleCircumference(double radius) {
            if (radius < 0) {
                throw new IllegalArgumentException("Radius cannot be negative");
            }
            return 2 * MathUtils.PI * radius;
        }
        
        public static double rectangleArea(double length, double width) {
            if (length < 0 || width < 0) {
                throw new IllegalArgumentException("Dimensions cannot be negative");
            }
            return length * width;
        }
        
        public static double triangleArea(double base, double height) {
            if (base < 0 || height < 0) {
                throw new IllegalArgumentException("Dimensions cannot be negative");
            }
            return 0.5 * base * height;
        }
        
        public static double distance(double x1, double y1, double x2, double y2) {
            double dx = x2 - x1;
            double dy = y2 - y1;
            return MathUtils.sqrt(dx * dx + dy * dy);
        }
    }
    
    // Calculator class that uses utility methods
    public static class Calculator {
        private static int calculationCount = 0;
        
        public static void performCalculation(String operation, double... operands) {
            calculationCount++;
            System.out.println("Calculation #" + calculationCount + ": " + operation);
            
            switch (operation.toLowerCase()) {
                case "add":
                    if (operands.length >= 2) {
                        System.out.println("Result: " + MathUtils.add(operands[0], operands[1]));
                    }
                    break;
                case "multiply":
                    if (operands.length >= 2) {
                        System.out.println("Result: " + MathUtils.multiply(operands[0], operands[1]));
                    }
                    break;
                case "power":
                    if (operands.length >= 2) {
                        System.out.println("Result: " + MathUtils.power(operands[0], (int)operands[1]));
                    }
                    break;
                case "sqrt":
                    if (operands.length >= 1) {
                        System.out.println("Result: " + MathUtils.sqrt(operands[0]));
                    }
                    break;
                case "circle_area":
                    if (operands.length >= 1) {
                        System.out.println("Result: " + GeometryUtils.circleArea(operands[0]));
                    }
                    break;
                default:
                    System.out.println("Unknown operation");
            }
        }
        
        public static int getCalculationCount() {
            return calculationCount;
        }
        
        public static void resetCalculationCount() {
            calculationCount = 0;
            System.out.println("Calculation count reset");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Math Utility System Demo ===");
        
        System.out.println("\n=== Testing MathUtils ===");
        
        // Test basic operations
        System.out.println("5 + 3 = " + MathUtils.add(5, 3));
        System.out.println("5.5 + 3.2 = " + MathUtils.add(5.5, 3.2));
        System.out.println("4 * 7 = " + MathUtils.multiply(4, 7));
        System.out.println("10 / 3 = " + MathUtils.divide(10, 3));
        
        // Test power and root operations
        System.out.println("2^8 = " + MathUtils.power(2, 8));
        System.out.println("√16 = " + MathUtils.sqrt(16));
        System.out.println("√2 = " + MathUtils.sqrt(2));
        
        // Test factorial and combinations
        System.out.println("5! = " + MathUtils.factorial(5));
        System.out.println("C(10,3) = " + MathUtils.combination(10, 3));
        
        // Test number theory
        System.out.println("GCD(48, 18) = " + MathUtils.gcd(48, 18));
        System.out.println("LCM(12, 8) = " + MathUtils.lcm(12, 8));
        System.out.println("Is 17 prime? " + MathUtils.isPrime(17));
        System.out.println("Is 15 prime? " + MathUtils.isPrime(15));
        
        System.out.println("\n=== Testing StatUtils ===");
        
        double[] data = {1.5, 2.3, 3.7, 4.1, 5.9, 2.8, 3.4, 4.6, 5.2, 1.9};
        
        System.out.println("Data: " + java.util.Arrays.toString(data));
        System.out.println("Mean: " + StatUtils.mean(data));
        System.out.println("Median: " + StatUtils.median(data));
        System.out.println("Standard Deviation: " + StatUtils.standardDeviation(data));
        
        double[] range = StatUtils.range(data);
        System.out.println("Range: [" + range[0] + ", " + range[1] + "]");
        
        System.out.println("\n=== Testing GeometryUtils ===");
        
        System.out.println("Circle (radius=5) area: " + GeometryUtils.circleArea(5));
        System.out.println("Circle (radius=5) circumference: " + GeometryUtils.circleCircumference(5));
        System.out.println("Rectangle (4x6) area: " + GeometryUtils.rectangleArea(4, 6));
        System.out.println("Triangle (base=8, height=5) area: " + GeometryUtils.triangleArea(8, 5));
        System.out.println("Distance between (0,0) and (3,4): " + GeometryUtils.distance(0, 0, 3, 4));
        
        System.out.println("\n=== Testing Calculator with Static Counter ===");
        
        Calculator.performCalculation("add", 10, 5);
        Calculator.performCalculation("multiply", 7, 8);
        Calculator.performCalculation("power", 2, 10);
        Calculator.performCalculation("sqrt", 25);
        Calculator.performCalculation("circle_area", 3);
        
        System.out.println("Total calculations performed: " + Calculator.getCalculationCount());
        
        Calculator.resetCalculationCount();
        System.out.println("Calculations after reset: " + Calculator.getCalculationCount());
        
        System.out.println("\n=== Testing Static Constants ===");
        
        System.out.println("π = " + MathUtils.PI);
        System.out.println("e = " + MathUtils.E);
        System.out.println("Golden Ratio = " + MathUtils.GOLDEN_RATIO);
        
        System.out.println("\n=== Demonstrating Utility Class Benefits ===");
        
        // No need to create objects - all methods are static
        System.out.println("Area of circle with radius 10: " + GeometryUtils.circleArea(10));
        System.out.println("Factorial of 6: " + MathUtils.factorial(6));
        
        // Try to instantiate utility class (will throw exception)
        try {
            // This would fail: MathUtils math = new MathUtils();
            System.out.println("Utility classes cannot be instantiated (private constructor)");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}