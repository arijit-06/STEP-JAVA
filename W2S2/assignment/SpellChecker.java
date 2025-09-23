/**
 * W2S2 Assignment 1: Spell Checker with String Distance
 * 
 * Task: Write a program to implement a simple spell checker that finds
 * and suggests corrections for misspelled words using string distance calculation
 */

import java.util.Scanner;

public class SpellChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] dictionary = {"java", "programming", "computer", "science", "algorithm", 
                              "data", "structure", "string", "method", "class", "object"};
        
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        
        String[] words = splitSentence(sentence);
        
        System.out.println("\n=== SPELL CHECK RESULTS ===");
        System.out.println("┌─────────────────┬─────────────────┬─────────┬──────────────┐");
        System.out.println("│ Original Word   │ Suggestion      │ Distance│ Status       │");
        System.out.println("├─────────────────┼─────────────────┼─────────┼──────────────┤");
        
        for (String word : words) {
            String cleanWord = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() > 0) {
                String suggestion = findClosestMatch(cleanWord, dictionary);
                int distance = calculateDistance(cleanWord, suggestion);
                String status = isWordCorrect(cleanWord, dictionary) ? "Correct" : "Misspelled";
                
                System.out.printf("│ %-15s │ %-15s │ %-7d │ %-12s │%n", 
                                cleanWord, suggestion, distance, status);
            }
        }
        
        System.out.println("└─────────────────┴─────────────────┴─────────┴──────────────┘");
        
        scanner.close();
    }
    
    public static String[] splitSentence(String sentence) {
        String[] tempWords = new String[sentence.length()];
        int wordCount = 0;
        StringBuilder currentWord = new StringBuilder();
        
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ' || ch == '.' || ch == ',' || ch == '!' || ch == '?') {
                if (currentWord.length() > 0) {
                    tempWords[wordCount++] = currentWord.toString();
                    currentWord.setLength(0);
                }
            } else {
                currentWord.append(ch);
            }
        }
        
        if (currentWord.length() > 0) {
            tempWords[wordCount++] = currentWord.toString();
        }
        
        String[] words = new String[wordCount];
        System.arraycopy(tempWords, 0, words, 0, wordCount);
        return words;
    }
    
    public static int calculateDistance(String word1, String word2) {
        if (word1.length() == word2.length()) {
            int differences = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    differences++;
                }
            }
            return differences;
        } else {
            return Math.abs(word1.length() - word2.length()) + 
                   Math.min(word1.length(), word2.length());
        }
    }
    
    public static String findClosestMatch(String word, String[] dictionary) {
        String closest = dictionary[0];
        int minDistance = calculateDistance(word, closest);
        
        for (int i = 1; i < dictionary.length; i++) {
            int distance = calculateDistance(word, dictionary[i]);
            if (distance < minDistance) {
                minDistance = distance;
                closest = dictionary[i];
            }
        }
        
        return minDistance <= 2 ? closest : word;
    }
    
    public static boolean isWordCorrect(String word, String[] dictionary) {
        for (String dictWord : dictionary) {
            if (word.equals(dictWord)) {
                return true;
            }
        }
        return false;
    }
}