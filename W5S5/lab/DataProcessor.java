// File: DataProcessor.java
// LAB 7: Static Nested Classes

public class DataProcessor {
    
    private String processorName;
    private static int totalProcessors = 0;
    
    public DataProcessor(String name) {
        this.processorName = name;
        totalProcessors++;
    }
    
    // Static nested class
    public static class DataValidator {
        public static boolean isValidEmail(String email) {
            return email != null && email.contains("@") && email.contains(".");
        }
        
        public static boolean isValidPhoneNumber(String phone) {
            return phone != null && phone.matches("\\d{10}");
        }
        
        public static boolean isValidAge(int age) {
            return age >= 0 && age <= 150;
        }
        
        public static void displayValidationResults(String email, String phone, int age) {
            System.out.println("=== Validation Results ===");
            System.out.println("Email (" + email + "): " + (isValidEmail(email) ? "Valid" : "Invalid"));
            System.out.println("Phone (" + phone + "): " + (isValidPhoneNumber(phone) ? "Valid" : "Invalid"));
            System.out.println("Age (" + age + "): " + (isValidAge(age) ? "Valid" : "Invalid"));
        }
    }
    
    // Static nested class for data formatting
    public static class DataFormatter {
        public static String formatName(String firstName, String lastName) {
            return lastName + ", " + firstName;
        }
        
        public static String formatCurrency(double amount) {
            return String.format("$%.2f", amount);
        }
        
        public static String formatPercentage(double value) {
            return String.format("%.1f%%", value * 100);
        }
    }
    
    // Static nested class for calculations
    public static class Calculator {
        public static double calculateAverage(double[] numbers) {
            if (numbers.length == 0) return 0;
            double sum = 0;
            for (double num : numbers) {
                sum += num;
            }
            return sum / numbers.length;
        }
        
        public static double findMax(double[] numbers) {
            if (numbers.length == 0) return 0;
            double max = numbers[0];
            for (double num : numbers) {
                if (num > max) max = num;
            }
            return max;
        }
        
        public static double findMin(double[] numbers) {
            if (numbers.length == 0) return 0;
            double min = numbers[0];
            for (double num : numbers) {
                if (num < min) min = num;
            }
            return min;
        }
    }
    
    public void processData() {
        System.out.println("Processing data with " + processorName);
    }
    
    public static int getTotalProcessors() {
        return totalProcessors;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Static Nested Classes Demo ===");
        
        // Using static nested classes without creating outer class instance
        DataProcessor.DataValidator.displayValidationResults("user@email.com", "1234567890", 25);
        
        System.out.println("\n=== Data Formatting ===");
        System.out.println("Formatted name: " + DataProcessor.DataFormatter.formatName("John", "Doe"));
        System.out.println("Formatted currency: " + DataProcessor.DataFormatter.formatCurrency(1234.56));
        System.out.println("Formatted percentage: " + DataProcessor.DataFormatter.formatPercentage(0.75));
        
        System.out.println("\n=== Calculations ===");
        double[] numbers = {10.5, 20.3, 15.7, 8.9, 25.1};
        System.out.println("Average: " + DataProcessor.Calculator.calculateAverage(numbers));
        System.out.println("Maximum: " + DataProcessor.Calculator.findMax(numbers));
        System.out.println("Minimum: " + DataProcessor.Calculator.findMin(numbers));
        
        // Creating outer class instances
        DataProcessor processor1 = new DataProcessor("Processor-1");
        DataProcessor processor2 = new DataProcessor("Processor-2");
        
        processor1.processData();
        processor2.processData();
        
        System.out.println("Total processors created: " + DataProcessor.getTotalProcessors());
    }
}