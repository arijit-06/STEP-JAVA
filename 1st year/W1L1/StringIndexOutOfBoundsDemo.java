/*
Level 1 Practice Program 5: StringIndexOutOfBoundsException demonstration
*/

import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    
    public static void generateException(String str) {
        System.out.println("Character at index 100: " + str.charAt(100)); // This will throw exception
    }
    
    public static void handleException(String str) {
        try {
            System.out.println("Character at index 100: " + str.charAt(100));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = scanner.next();
        
        System.out.println("String length: " + str.length());
        
        System.out.println("\n=== Generating StringIndexOutOfBoundsException ===");
        try {
            generateException(str);
        } catch (Exception e) {
            System.out.println("Exception in main: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n=== Handling StringIndexOutOfBoundsException ===");
        handleException(str);
        
        scanner.close();
    }
}