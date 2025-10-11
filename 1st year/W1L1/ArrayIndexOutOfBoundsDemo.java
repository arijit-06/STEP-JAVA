/*
Level 1 Practice Program 8: ArrayIndexOutOfBoundsException demonstration
*/

import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    
    public static void generateException(String[] names) {
        System.out.println("Name at index 10: " + names[10]); // This will throw exception
    }
    
    public static void handleException(String[] names) {
        try {
            System.out.println("Name at index 10: " + names[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of names: ");
        int size = scanner.nextInt();
        String[] names = new String[size];
        
        System.out.println("Enter " + size + " names:");
        for (int i = 0; i < size; i++) {
            names[i] = scanner.next();
        }
        
        System.out.println("Array length: " + names.length);
        
        System.out.println("\n=== Generating ArrayIndexOutOfBoundsException ===");
        try {
            generateException(names);
        } catch (Exception e) {
            System.out.println("Exception in main: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n=== Handling ArrayIndexOutOfBoundsException ===");
        handleException(names);
        
        scanner.close();
    }
}