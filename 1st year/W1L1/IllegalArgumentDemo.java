/*
Level 1 Practice Program 6: IllegalArgumentException demonstration
*/

import java.util.Scanner;

public class IllegalArgumentDemo {
    
    public static void generateException(String str) {
        System.out.println("Substring: " + str.substring(5, 2)); // start > end, throws exception
    }
    
    public static void handleException(String str) {
        try {
            System.out.println("Substring: " + str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = scanner.next();
        
        System.out.println("\n=== Generating IllegalArgumentException ===");
        try {
            generateException(str);
        } catch (Exception e) {
            System.out.println("Exception in main: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n=== Handling IllegalArgumentException ===");
        handleException(str);
        
        scanner.close();
    }
}