/**
 * W2S2 Practice Problem 1: Built-In String Methods - Basic Operations
 * 
 * Task: Create a program that demonstrates common String methods for text analysis and
 * manipulation.
 * 
 * Learning Objectives:
 * - Master built-in string methods for text analysis
 * - Use charAt(), substring(), indexOf(), contains(), startsWith(), endsWith()
 * - Implement custom vowel counting and character occurrence methods
 * - Format output in organized manner
 */

public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";
        
        System.out.println("=== STRING BUILT-IN METHODS DEMONSTRATION ===");
        System.out.println("Original Text: \"" + sampleText + "\"");
        System.out.println();
        
        // TODO: Use built-in methods to perform the following operations:
        // 1. Display original string length including spaces
        System.out.println("1. Original string length: " + sampleText.length());
        
        // 2. Remove leading and trailing spaces, show new length
        String trimmedText = sampleText.trim();
        System.out.println("2. After trimming: \"" + trimmedText + "\" (Length: " + trimmedText.length() + ")");
        
        // 3. Find and display the character at index 5
        System.out.println("3. Character at index 5: '" + trimmedText.charAt(5) + "'");
        
        // 4. Extract substring "Programming" from the text
        int startIndex = trimmedText.indexOf("Programming");
        String programming = trimmedText.substring(startIndex, startIndex + "Programming".length());
        System.out.println("4. Extracted substring: \"" + programming + "\"");
        
        // 5. Find the index of the word "Fun"
        int funIndex = trimmedText.indexOf("Fun");
        System.out.println("5. Index of 'Fun': " + funIndex);
        
        // 6. Check if the string contains "Java" (case-sensitive)
        boolean containsJava = trimmedText.contains("Java");
        System.out.println("6. Contains 'Java': " + containsJava);
        
        // 7. Check if the string starts with "Java" (after trimming)
        boolean startsWithJava = trimmedText.startsWith("Java");
        System.out.println("7. Starts with 'Java': " + startsWithJava);
        
        // 8. Check if the string ends with an exclamation mark
        boolean endsWithExclamation = trimmedText.endsWith("!");
        System.out.println("8. Ends with '!': " + endsWithExclamation);
        
        // 9. Convert the entire string to uppercase
        String upperCase = trimmedText.toUpperCase();
        System.out.println("9. Uppercase: \"" + upperCase + "\"");
        
        // 10. Convert the entire string to lowercase
        String lowerCase = trimmedText.toLowerCase();
        System.out.println("10. Lowercase: \"" + lowerCase + "\"");
        
        System.out.println();
        
        // TODO: Create a method that counts vowels using charAt()
        int vowelCount = countVowels(trimmedText);
        System.out.println("Vowel count in text: " + vowelCount);
        
        // TODO: Create a method that finds all occurrences of a character
        System.out.println("\nFinding all occurrences of 'a':");
        findAllOccurrences(trimmedText, 'a');
        
        // TODO: Display all results in a formatted manner
        System.out.println("\n=== COMPREHENSIVE ANALYSIS ===");
        displayFormattedResults(sampleText, trimmedText);
    }
    
    // TODO: Method to count vowels in a string
    public static int countVowels(String text) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
    
    // TODO: Method to find all positions of a character
    public static void findAllOccurrences(String text, char target) {
        System.out.print("Positions of '" + target + "': ");
        boolean found = false;
        
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target || text.charAt(i) == Character.toUpperCase(target)) {
                System.out.print(i + " ");
                found = true;
            }
        }
        
        if (!found) {
            System.out.print("Not found");
        }
        System.out.println();
    }
    
    // Helper method to display formatted results
    public static void displayFormattedResults(String original, String trimmed) {
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│                    STRING ANALYSIS REPORT                  │");
        System.out.println("├─────────────────────────────────────────────────────────────┤");
        System.out.printf("│ Original Length:     %-35d │%n", original.length());
        System.out.printf("│ Trimmed Length:      %-35d │%n", trimmed.length());
        System.out.printf("│ Vowel Count:         %-35d │%n", countVowels(trimmed));
        System.out.printf("│ Word Count:          %-35d │%n", trimmed.split("\\s+").length);
        System.out.printf("│ Contains 'Java':     %-35s │%n", trimmed.contains("Java"));
        System.out.printf("│ Starts with 'Java':  %-35s │%n", trimmed.startsWith("Java"));
        System.out.printf("│ Ends with '!':       %-35s │%n", trimmed.endsWith("!"));
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }
}