/**
 * W2S2 Lab 2: Case Conversion Using ASCII Values
 * 
 * Task: Write a program to convert text between different cases
 * using ASCII values without using built-in case conversion methods
 */

import java.util.Scanner;

public class ASCIICaseConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        
        String upperResult = convertToUpperCase(input);
        String lowerResult = convertToLowerCase(input);
        String titleResult = convertToTitleCase(input);
        
        // Compare with built-in methods
        boolean upperMatch = compareWithBuiltIn(upperResult, input.toUpperCase());
        boolean lowerMatch = compareWithBuiltIn(lowerResult, input.toLowerCase());
        
        System.out.println("\n=== RESULTS ===");
        System.out.printf("%-15s | %-30s | %-10s%n", "Conversion", "Result", "Matches");
        System.out.println("----------------|--------------------------------|----------");
        System.out.printf("%-15s | %-30s | %-10s%n", "Original", input, "N/A");
        System.out.printf("%-15s | %-30s | %-10s%n", "Uppercase", upperResult, upperMatch);
        System.out.printf("%-15s | %-30s | %-10s%n", "Lowercase", lowerResult, lowerMatch);
        System.out.printf("%-15s | %-30s | %-10s%n", "Title Case", titleResult, "N/A");
        
        scanner.close();
    }
    
    public static char convertToUpperCase(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char)(ch - 32);
        }
        return ch;
    }
    
    public static char convertToLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char)(ch + 32);
        }
        return ch;
    }
    
    public static String convertToUpperCase(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(convertToUpperCase(text.charAt(i)));
        }
        return result.toString();
    }
    
    public static String convertToLowerCase(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(convertToLowerCase(text.charAt(i)));
        }
        return result.toString();
    }
    
    public static String convertToTitleCase(String text) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                result.append(ch);
                capitalizeNext = true;
            } else if (capitalizeNext) {
                result.append(convertToUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(convertToLowerCase(ch));
            }
        }
        return result.toString();
    }
    
    public static boolean compareWithBuiltIn(String custom, String builtIn) {
        return custom.equals(builtIn);
    }
}