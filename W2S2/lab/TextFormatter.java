/**
 * W2S2 Lab 6: Text Formatter with StringBuilder
 * 
 * Task: Write a program to create a text formatter that justifies text to a
 * specified width using StringBuilder for efficient string manipulation
 */

import java.util.Scanner;

public class TextFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text to format: ");
        String text = scanner.nextLine();
        
        System.out.print("Enter desired line width: ");
        int width = scanner.nextInt();
        
        String[] words = splitIntoWords(text);
        
        String justified = justifyText(words, width);
        String centered = centerAlignText(words, width);
        
        long[] performanceResults = comparePerformance(words, width);
        
        displayResults(text, justified, centered, performanceResults);
        
        scanner.close();
    }
    
    public static String[] splitIntoWords(String text) {
        // Split without using split() method
        String[] tempWords = new String[text.length()];
        int wordCount = 0;
        StringBuilder currentWord = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
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
    
    public static String justifyText(String[] words, int width) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentLine = new StringBuilder();
        int currentLength = 0;
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if (currentLength + word.length() + (currentLine.length() > 0 ? 1 : 0) <= width) {
                if (currentLine.length() > 0) {
                    currentLine.append(" ");
                    currentLength++;
                }
                currentLine.append(word);
                currentLength += word.length();
            } else {
                // Justify current line
                result.append(justifyLine(currentLine.toString(), width));
                result.append("\n");
                
                // Start new line
                currentLine.setLength(0);
                currentLine.append(word);
                currentLength = word.length();
            }
        }
        
        // Add last line (left-aligned only)
        if (currentLine.length() > 0) {
            result.append(currentLine.toString());
        }
        
        return result.toString();
    }
    
    public static String justifyLine(String line, int width) {
        String[] words = splitIntoWords(line);
        if (words.length == 1) return line; // Single word, no justification needed
        
        int totalWordLength = 0;
        for (String word : words) {
            totalWordLength += word.length();
        }
        
        int totalSpaces = width - totalWordLength;
        int gaps = words.length - 1;
        int spacesPerGap = totalSpaces / gaps;
        int extraSpaces = totalSpaces % gaps;
        
        StringBuilder justified = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            justified.append(words[i]);
            if (i < words.length - 1) {
                for (int j = 0; j < spacesPerGap; j++) {
                    justified.append(" ");
                }
                if (i < extraSpaces) {
                    justified.append(" ");
                }
            }
        }
        
        return justified.toString();
    }
    
    public static String centerAlignText(String[] words, int width) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentLine = new StringBuilder();
        int currentLength = 0;
        
        for (String word : words) {
            if (currentLength + word.length() + (currentLine.length() > 0 ? 1 : 0) <= width) {
                if (currentLine.length() > 0) {
                    currentLine.append(" ");
                    currentLength++;
                }
                currentLine.append(word);
                currentLength += word.length();
            } else {
                // Center current line
                result.append(centerLine(currentLine.toString(), width));
                result.append("\n");
                
                // Start new line
                currentLine.setLength(0);
                currentLine.append(word);
                currentLength = word.length();
            }
        }
        
        if (currentLine.length() > 0) {
            result.append(centerLine(currentLine.toString(), width));
        }
        
        return result.toString();
    }
    
    public static String centerLine(String line, int width) {
        int padding = (width - line.length()) / 2;
        StringBuilder centered = new StringBuilder();
        
        for (int i = 0; i < padding; i++) {
            centered.append(" ");
        }
        centered.append(line);
        
        return centered.toString();
    }
    
    public static long[] comparePerformance(String[] words, int width) {
        // Test StringBuilder approach
        long startTime = System.nanoTime();
        justifyText(words, width);
        long sbTime = System.nanoTime() - startTime;
        
        // Test String concatenation approach
        startTime = System.nanoTime();
        justifyWithStringConcatenation(words, width);
        long stringTime = System.nanoTime() - startTime;
        
        return new long[]{sbTime, stringTime};
    }
    
    public static String justifyWithStringConcatenation(String[] words, int width) {
        String result = "";
        String currentLine = "";
        int currentLength = 0;
        
        for (String word : words) {
            if (currentLength + word.length() + (currentLine.length() > 0 ? 1 : 0) <= width) {
                if (currentLine.length() > 0) {
                    currentLine += " ";
                    currentLength++;
                }
                currentLine += word;
                currentLength += word.length();
            } else {
                result += currentLine + "\n";
                currentLine = word;
                currentLength = word.length();
            }
        }
        
        if (currentLine.length() > 0) {
            result += currentLine;
        }
        
        return result;
    }
    
    public static void displayResults(String original, String justified, String centered, long[] performance) {
        System.out.println("\n=== ORIGINAL TEXT ===");
        System.out.println(original);
        
        System.out.println("\n=== LEFT-JUSTIFIED TEXT ===");
        String[] justifiedLines = justified.split("\n");
        for (int i = 0; i < justifiedLines.length; i++) {
            System.out.printf("%2d: %s (%d chars)%n", i + 1, justifiedLines[i], justifiedLines[i].length());
        }
        
        System.out.println("\n=== CENTER-ALIGNED TEXT ===");
        String[] centeredLines = centered.split("\n");
        for (int i = 0; i < centeredLines.length; i++) {
            System.out.printf("%2d: %s (%d chars)%n", i + 1, centeredLines[i], centeredLines[i].length());
        }
        
        System.out.println("\n=== PERFORMANCE ANALYSIS ===");
        System.out.println("StringBuilder time: " + performance[0] + " ns");
        System.out.println("String concatenation time: " + performance[1] + " ns");
        if (performance[0] > 0) {
            System.out.println("StringBuilder is " + (performance[1] / performance[0]) + "x faster");
        }
    }
}