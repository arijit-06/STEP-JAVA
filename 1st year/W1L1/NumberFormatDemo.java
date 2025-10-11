/*
Level 1 Practice Program 7: NumberFormatException demonstration
*/

import java.util.Scanner;

public class NumberFormatDemo {
    
    public static void generateException(String text) {
        int number = Integer.parseInt(text); // This will throw NumberFormatException for non-numeric text
        System.out.println("Parsed number: " + number);
    }
    
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text to parse as number: ");
        String text = scanner.next();
        
        System.out.println("\n=== Generating NumberFormatException ===");
        try {
            generateException(text);
        } catch (Exception e) {
            System.out.println("Exception in main: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n=== Handling NumberFormatException ===");
        handleException(text);
        
        scanner.close();
    }
}