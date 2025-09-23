/**
 * W2S2 Practice Problem 2: String Manipulation Methods
 * 
 * Task: Create a text processing utility that uses various string manipulation methods.
 * 
 * Learning Objectives:
 * - Use trim(), replace(), replaceAll(), split(), join()
 * - Implement punctuation removal, word capitalization, and word reversal
 * - Count word frequency in text
 * - Process user input effectively
 */

import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== STRING MANIPULATION UTILITY ===");
        
        // TODO: Ask user to enter a sentence with mixed formatting
        System.out.print("Enter a sentence with mixed formatting: ");
        String userInput = scanner.nextLine();
        
        System.out.println("\nOriginal Input: \"" + userInput + "\"");
        System.out.println("Input Length: " + userInput.length());
        
        // TODO: Process the input using the following methods:
        
        // 1. trim() - Remove extra spaces
        String trimmedInput = userInput.trim();
        System.out.println("\n1. After trim(): \"" + trimmedInput + "\"");
        System.out.println("   Length after trimming: " + trimmedInput.length());
        
        // 2. replace() - Replace all spaces with underscores
        String withUnderscores = trimmedInput.replace(" ", "_");
        System.out.println("\n2. Replace spaces with underscores: \"" + withUnderscores + "\"");
        
        // 3. replaceAll() - Remove all digits using regex
        String withoutDigits = trimmedInput.replaceAll("\\d", "");
        System.out.println("\n3. Remove all digits: \"" + withoutDigits + "\"");
        
        // 4. split() - Split sentence into words array
        String[] words = trimmedInput.split("\\s+");
        System.out.println("\n4. Split into words:");
        for (int i = 0; i < words.length; i++) {
            System.out.println("   Word " + (i + 1) + ": \"" + words[i] + "\"");
        }
        
        // 5. join() - Rejoin words with " | " separator
        String joinedWords = String.join(" | ", words);
        System.out.println("\n5. Rejoin with ' | ' separator: \"" + joinedWords + "\"");
        
        // TODO: Create additional processing methods:
        System.out.println("\n=== ADDITIONAL PROCESSING ===");
        
        // Remove all punctuation
        String withoutPunctuation = removePunctuation(trimmedInput);
        System.out.println("Without punctuation: \"" + withoutPunctuation + "\"");
        
        // Capitalize first letter of each word
        String capitalizedWords = capitalizeWords(trimmedInput);
        System.out.println("Capitalized words: \"" + capitalizedWords + "\"");
        
        // Reverse the order of words
        String reversedOrder = reverseWordOrder(trimmedInput);
        System.out.println("Reversed word order: \"" + reversedOrder + "\"");
        
        // Count word frequency
        System.out.println("\nWord Frequency Analysis:");
        countWordFrequency(trimmedInput);
        
        scanner.close();
    }
    
    // TODO: Method to remove punctuation
    public static String removePunctuation(String text) {
        // Remove all punctuation marks but keep spaces and alphanumeric characters
        return text.replaceAll("[^a-zA-Z0-9\\s]", "");
    }
    
    // TODO: Method to capitalize each word
    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                // Capitalize first letter, lowercase the rest
                String capitalizedWord = words[i].substring(0, 1).toUpperCase() + 
                                       words[i].substring(1).toLowerCase();
                result.append(capitalizedWord);
                
                if (i < words.length - 1) {
                    result.append(" ");
                }
            }
        }
        
        return result.toString();
    }
    
    // TODO: Method to reverse word order
    public static String reverseWordOrder(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        // Add words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    // TODO: Method to count word frequency
    public static void countWordFrequency(String text) {
        // Convert to lowercase and remove punctuation for accurate counting
        String cleanText = removePunctuation(text.toLowerCase());
        String[] words = cleanText.split("\\s+");
        
        // Simple frequency counting without HashMap
        String[] uniqueWords = new String[words.length];
        int[] frequencies = new int[words.length];
        int uniqueCount = 0;
        
        for (String word : words) {
            if (word.length() > 0) {
                // Check if word already exists
                boolean found = false;
                for (int i = 0; i < uniqueCount; i++) {
                    if (uniqueWords[i].equals(word)) {
                        frequencies[i]++;
                        found = true;
                        break;
                    }
                }
                
                // If not found, add as new unique word
                if (!found) {
                    uniqueWords[uniqueCount] = word;
                    frequencies[uniqueCount] = 1;
                    uniqueCount++;
                }
            }
        }
        
        // Display frequency table
        System.out.println("┌─────────────────┬───────────┐");
        System.out.println("│      Word       │ Frequency │");
        System.out.println("├─────────────────┼───────────┤");
        
        for (int i = 0; i < uniqueCount; i++) {
            System.out.printf("│ %-15s │ %-9d │%n", uniqueWords[i], frequencies[i]);
        }
        
        System.out.println("└─────────────────┴───────────┘");
        System.out.println("Total unique words: " + uniqueCount);
        System.out.println("Total words: " + words.length);
    }
}