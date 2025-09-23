/**
 * W2S2 Practice Problem 5: Advanced String Comparison and Analysis
 * 
 * Task: Create a comprehensive string analysis tool that uses various comparison methods and
 * performance optimizations.
 * 
 * Learning Objectives:
 * - Perform comprehensive string comparison analysis
 * - Implement similarity percentage calculation using algorithms
 * - Demonstrate string intern() method and memory usage
 * - Optimize string operations for performance
 */

import java.util.Scanner;

public class AdvancedStringAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ADVANCED STRING ANALYZER ===");
        
        // TODO: Ask user for two strings to compare
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();
        
        System.out.println("\n=== STRING COMPARISON ANALYSIS ===");
        System.out.println("String 1: \"" + str1 + "\"");
        System.out.println("String 2: \"" + str2 + "\"");
        
        // TODO: Perform comprehensive comparison analysis:
        performAllComparisons(str1, str2);
        
        // Calculate similarity percentage
        double similarity = calculateSimilarity(str1, str2);
        System.out.println("\nSimilarity percentage: " + String.format("%.2f", similarity) + "%");
        
        // TODO: Performance analysis of different string operations
        System.out.println("\n=== PERFORMANCE ANALYSIS ===");
        String[] testStrings = {str1, str2, str1 + str2, str2 + str1};
        analyzeMemoryUsage(testStrings);
        
        // Demonstrate optimized string processing
        System.out.println("\n=== OPTIMIZED STRING PROCESSING ===");
        String[] inputs = {str1, str2, "additional", "test", "strings"};
        String optimizedResult = optimizedStringProcessing(inputs);
        System.out.println("Optimized processing result: \"" + optimizedResult + "\"");
        
        // Demonstrate intern() method
        System.out.println("\n=== STRING INTERN DEMONSTRATION ===");
        demonstrateStringIntern();
        
        scanner.close();
    }
    
    // TODO: Method to calculate string similarity percentage
    public static double calculateSimilarity(String str1, String str2) {
        if (str1 == null || str2 == null) return 0.0;
        if (str1.equals(str2)) return 100.0;
        
        // Use Levenshtein distance algorithm
        int maxLength = Math.max(str1.length(), str2.length());
        if (maxLength == 0) return 100.0;
        
        int distance = levenshteinDistance(str1, str2);
        return ((double)(maxLength - distance) / maxLength) * 100.0;
    }
    
    // Helper method to calculate Levenshtein distance
    private static int levenshteinDistance(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        
        // Create a matrix to store distances
        int[][] matrix = new int[len1 + 1][len2 + 1];
        
        // Initialize first row and column
        for (int i = 0; i <= len1; i++) {
            matrix[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            matrix[0][j] = j;
        }
        
        // Fill the matrix
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int cost = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;
                
                matrix[i][j] = Math.min(
                    Math.min(matrix[i - 1][j] + 1,      // deletion
                             matrix[i][j - 1] + 1),     // insertion
                    matrix[i - 1][j - 1] + cost         // substitution
                );
            }
        }
        
        return matrix[len1][len2];
    }
    
    // TODO: Method to perform all comparison types
    public static void performAllComparisons(String str1, String str2) {
        System.out.println("┌─────────────────────────────────┬─────────┬─────────────────────────┐");
        System.out.println("│ Comparison Method               │ Result  │ Description             │");
        System.out.println("├─────────────────────────────────┼─────────┼─────────────────────────┤");
        
        // 1. Reference equality (==)
        boolean refEqual = (str1 == str2);
        System.out.printf("│ Reference equality (==)         │ %-7s │ Same memory reference   │%n", refEqual);
        
        // 2. Content equality (equals)
        boolean contentEqual = str1.equals(str2);
        System.out.printf("│ Content equality (equals)       │ %-7s │ Same content            │%n", contentEqual);
        
        // 3. Case-insensitive equality (equalsIgnoreCase)
        boolean caseInsensitiveEqual = str1.equalsIgnoreCase(str2);
        System.out.printf("│ Case-insensitive equality       │ %-7s │ Same content, any case  │%n", caseInsensitiveEqual);
        
        // 4. Lexicographic comparison (compareTo)
        int lexCompare = str1.compareTo(str2);
        String lexResult = (lexCompare == 0) ? "Equal" : (lexCompare < 0) ? "Less" : "Greater";
        System.out.printf("│ Lexicographic comparison        │ %-7s │ Dictionary order        │%n", lexResult);
        
        // 5. Case-insensitive lexicographic comparison
        int caseInsensitiveLex = str1.compareToIgnoreCase(str2);
        String caseInsensitiveLexResult = (caseInsensitiveLex == 0) ? "Equal" : (caseInsensitiveLex < 0) ? "Less" : "Greater";
        System.out.printf("│ Case-insensitive lexicographic  │ %-7s │ Dictionary, ignore case │%n", caseInsensitiveLexResult);
        
        System.out.println("└─────────────────────────────────┴─────────┴─────────────────────────┘");
        
        // Additional analysis
        System.out.println("\nDetailed Analysis:");
        System.out.println("• Length comparison: " + str1.length() + " vs " + str2.length());
        System.out.println("• Hash code comparison: " + str1.hashCode() + " vs " + str2.hashCode());
        System.out.println("• Contains relationship: \"" + str1 + "\" contains \"" + str2 + "\": " + str1.contains(str2));
        System.out.println("• Reverse contains: \"" + str2 + "\" contains \"" + str1 + "\": " + str2.contains(str1));
    }
    
    // TODO: Method to analyze string memory usage
    public static void analyzeMemoryUsage(String... strings) {
        System.out.println("Memory usage analysis (approximate):");
        System.out.println("┌─────────────────────────────────┬────────┬─────────────────┐");
        System.out.println("│ String                          │ Length │ Est. Memory (B) │");
        System.out.println("├─────────────────────────────────┼────────┼─────────────────┤");
        
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            int length = str.length();
            // Approximate memory: object overhead (12-16 bytes) + char array (2 bytes per char) + length field (4 bytes)
            int estimatedMemory = 16 + (length * 2) + 4;
            
            String displayStr = str.length() > 25 ? str.substring(0, 25) + "..." : str;
            System.out.printf("│ %-31s │ %-6d │ %-15d │%n", "\"" + displayStr + "\"", length, estimatedMemory);
        }
        
        System.out.println("└─────────────────────────────────┴────────┴─────────────────┘");
        System.out.println("Note: Actual memory usage may vary based on JVM implementation");
    }
    
    // TODO: Method to optimize string operations
    public static String optimizedStringProcessing(String[] inputs) {
        // Use StringBuilder for efficient processing
        StringBuilder result = new StringBuilder();
        
        // Calculate total capacity needed to avoid resizing
        int totalLength = 0;
        for (String input : inputs) {
            totalLength += input.length() + 3; // +3 for separator " | "
        }
        
        // Initialize StringBuilder with appropriate capacity
        result = new StringBuilder(totalLength);
        
        // Process strings efficiently
        for (int i = 0; i < inputs.length; i++) {
            // Convert to title case
            String processed = toTitleCase(inputs[i]);
            result.append(processed);
            
            if (i < inputs.length - 1) {
                result.append(" | ");
            }
        }
        
        return result.toString();
    }
    
    // Helper method for title case conversion
    private static String toTitleCase(String input) {
        if (input == null || input.isEmpty()) return input;
        
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            
            if (Character.isWhitespace(ch)) {
                result.append(ch);
                capitalizeNext = true;
            } else if (capitalizeNext) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }
        
        return result.toString();
    }
    
    // TODO: Method to demonstrate intern() method
    public static void demonstrateStringIntern() {
        System.out.println("String intern() method demonstration:");
        
        // Create strings in different ways
        String literal = "Hello World";
        String constructor = new String("Hello World");
        String concatenated = "Hello" + " " + "World";
        String interned = constructor.intern();
        
        System.out.println("String creation methods:");
        System.out.println("literal = \"Hello World\"");
        System.out.println("constructor = new String(\"Hello World\")");
        System.out.println("concatenated = \"Hello\" + \" \" + \"World\"");
        System.out.println("interned = constructor.intern()");
        
        System.out.println("\nReference comparisons:");
        System.out.println("literal == constructor: " + (literal == constructor));
        System.out.println("literal == concatenated: " + (literal == concatenated));
        System.out.println("literal == interned: " + (literal == interned));
        System.out.println("constructor == interned: " + (constructor == interned));
        
        System.out.println("\nContent comparisons:");
        System.out.println("literal.equals(constructor): " + literal.equals(constructor));
        System.out.println("literal.equals(concatenated): " + literal.equals(concatenated));
        System.out.println("literal.equals(interned): " + literal.equals(interned));
        
        System.out.println("\nString pool behavior:");
        System.out.println("• String literals are automatically interned");
        System.out.println("• new String() creates a new object outside the pool");
        System.out.println("• intern() returns the pooled version of the string");
        System.out.println("• Use intern() to save memory when dealing with many duplicate strings");
        
        // Performance test with intern()
        System.out.println("\nPerformance test with intern():");
        long startTime = System.nanoTime();
        
        String[] testStrings = new String[1000];
        for (int i = 0; i < 1000; i++) {
            testStrings[i] = new String("Test String " + (i % 10)).intern();
        }
        
        long endTime = System.nanoTime();
        System.out.println("Time to create 1000 interned strings: " + (endTime - startTime) + " ns");
        
        // Count unique references
        int uniqueReferences = 0;
        for (int i = 0; i < testStrings.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (testStrings[i] == testStrings[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) uniqueReferences++;
        }
        
        System.out.println("Unique string references created: " + uniqueReferences + " out of 1000");
        System.out.println("Memory saved by interning: " + (1000 - uniqueReferences) + " string objects");
    }
}