/**
 * W2S2 Practice Problem 6: Complete String Utility Application
 * 
 * Task: Create a comprehensive string utility application that combines all learned concepts
 * including built-in methods, ASCII manipulation, and performance optimization.
 */

import java.util.Scanner;

public class StringUtilityApp {
    private static StringBuilder output = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== STRING UTILITY APPLICATION ===");
        
        while (true) {
            System.out.println("\n1. Text Analysis");
            System.out.println("2. String Transformation");
            System.out.println("3. ASCII Operations");
            System.out.println("4. Performance Testing");
            System.out.println("5. String Comparison Analysis");
            System.out.println("6. Custom String Algorithms");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter text to analyze: ");
                    performTextAnalysis(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter text to transform: ");
                    String text = scanner.nextLine();
                    String[] ops = {"trim", "upper", "reverse"};
                    System.out.println("Result: " + performTransformations(text, ops));
                    break;
                case 3:
                    System.out.print("Enter text for ASCII operations: ");
                    performASCIIOperations(scanner.nextLine());
                    break;
                case 4:
                    performPerformanceTest(1000);
                    break;
                case 5:
                    System.out.print("Enter strings separated by comma: ");
                    String[] strings = scanner.nextLine().split(",");
                    performComparisonAnalysis(strings);
                    break;
                case 6:
                    System.out.print("Enter text for algorithm testing: ");
                    performCustomAlgorithms(scanner.nextLine());
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
            }
        }
    }
    
    public static void performTextAnalysis(String text) {
        output.setLength(0);
        output.append("=== TEXT ANALYSIS ===\n");
        output.append("Length: ").append(text.length()).append("\n");
        output.append("Words: ").append(text.trim().split("\\s+").length).append("\n");
        output.append("Sentences: ").append(text.split("[.!?]+").length).append("\n");
        
        int vowels = 0;
        for (char c : text.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) vowels++;
        }
        output.append("Vowels: ").append(vowels).append("\n");
        System.out.println(output.toString());
    }
    
    public static String performTransformations(String text, String[] operations) {
        StringBuilder result = new StringBuilder(text);
        for (String op : operations) {
            switch (op) {
                case "trim": result = new StringBuilder(result.toString().trim()); break;
                case "upper": result = new StringBuilder(result.toString().toUpperCase()); break;
                case "reverse": result.reverse(); break;
            }
        }
        return result.toString();
    }
    
    public static void performASCIIOperations(String text) {
        System.out.println("=== ASCII OPERATIONS ===");
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            System.out.println("'" + c + "' -> ASCII: " + (int)c);
        }
    }
    
    public static void performPerformanceTest(int iterations) {
        System.out.println("=== PERFORMANCE TEST ===");
        
        long start = System.nanoTime();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "test";
        }
        long stringTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("test");
        }
        long sbTime = System.nanoTime() - start;
        
        System.out.println("String: " + stringTime/1000000 + "ms");
        System.out.println("StringBuilder: " + sbTime/1000000 + "ms");
        System.out.println("StringBuilder is " + (stringTime/sbTime) + "x faster");
    }
    
    public static void performComparisonAnalysis(String[] strings) {
        System.out.println("=== COMPARISON ANALYSIS ===");
        for (int i = 0; i < strings.length - 1; i++) {
            String s1 = strings[i].trim();
            String s2 = strings[i + 1].trim();
            System.out.println("\"" + s1 + "\" vs \"" + s2 + "\":");
            System.out.println("  equals: " + s1.equals(s2));
            System.out.println("  compareTo: " + s1.compareTo(s2));
        }
    }
    
    public static void performCustomAlgorithms(String text) {
        System.out.println("=== CUSTOM ALGORITHMS ===");
        System.out.println("Palindrome: " + isPalindrome(text));
        System.out.println("Reverse: " + reverse(text));
    }
    
    private static boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = clean.length();
        for (int i = 0; i < len / 2; i++) {
            if (clean.charAt(i) != clean.charAt(len - 1 - i)) return false;
        }
        return true;
    }
    
    private static String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }
    
    public static void displayResults() {
        System.out.println(output.toString());
    }
}