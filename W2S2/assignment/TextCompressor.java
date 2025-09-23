/**
 * W2S2 Assignment 3: Text Compression Algorithm
 * 
 * Task: Write a program to implement a text-based data compression
 * algorithm using character frequency and StringBuilder
 */

import java.util.Scanner;

public class TextCompressor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text to compress: ");
        String text = scanner.nextLine();
        
        char[] characters = new char[text.length()];
        int[] frequencies = new int[text.length()];
        int uniqueCount = countCharacterFrequency(text, characters, frequencies);
        
        String[][] mapping = createCompressionCodes(characters, frequencies, uniqueCount);
        
        String compressed = compressText(text, mapping);
        String decompressed = decompressText(compressed, mapping);
        
        displayCompressionAnalysis(text, compressed, decompressed, characters, frequencies, uniqueCount, mapping);
        
        scanner.close();
    }
    
    public static int countCharacterFrequency(String text, char[] characters, int[] frequencies) {
        int uniqueCount = 0;
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean found = false;
            
            for (int j = 0; j < uniqueCount; j++) {
                if (characters[j] == ch) {
                    frequencies[j]++;
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                characters[uniqueCount] = ch;
                frequencies[uniqueCount] = 1;
                uniqueCount++;
            }
        }
        
        return uniqueCount;
    }
    
    public static String[][] createCompressionCodes(char[] characters, int[] frequencies, int uniqueCount) {
        // Sort by frequency (bubble sort)
        for (int i = 0; i < uniqueCount - 1; i++) {
            for (int j = 0; j < uniqueCount - i - 1; j++) {
                if (frequencies[j] < frequencies[j + 1]) {
                    // Swap frequencies
                    int tempFreq = frequencies[j];
                    frequencies[j] = frequencies[j + 1];
                    frequencies[j + 1] = tempFreq;
                    
                    // Swap characters
                    char tempChar = characters[j];
                    characters[j] = characters[j + 1];
                    characters[j + 1] = tempChar;
                }
            }
        }
        
        // Create mapping table
        String[][] mapping = new String[uniqueCount][2];
        for (int i = 0; i < uniqueCount; i++) {
            mapping[i][0] = String.valueOf(characters[i]);
            
            // Assign shorter codes to more frequent characters
            if (i < 10) {
                mapping[i][1] = String.valueOf(i);
            } else {
                mapping[i][1] = "(" + (i - 10) + ")";
            }
        }
        
        return mapping;
    }
    
    public static String compressText(String text, String[][] mapping) {
        StringBuilder compressed = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            for (String[] map : mapping) {
                if (map[0].charAt(0) == ch) {
                    compressed.append(map[1]);
                    break;
                }
            }
        }
        
        return compressed.toString();
    }
    
    public static String decompressText(String compressed, String[][] mapping) {
        StringBuilder decompressed = new StringBuilder();
        int i = 0;
        
        while (i < compressed.length()) {
            boolean found = false;
            
            // Try to match codes
            for (String[] map : mapping) {
                String code = map[1];
                if (i + code.length() <= compressed.length() && 
                    compressed.substring(i, i + code.length()).equals(code)) {
                    decompressed.append(map[0]);
                    i += code.length();
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                i++; // Skip unrecognized character
            }
        }
        
        return decompressed.toString();
    }
    
    public static void displayCompressionAnalysis(String original, String compressed, String decompressed,
                                                char[] characters, int[] frequencies, int uniqueCount, String[][] mapping) {
        System.out.println("\n=== COMPRESSION ANALYSIS ===");
        
        // Character frequency table
        System.out.println("Character Frequency Table:");
        System.out.println("┌──────────┬───────────┬──────────┐");
        System.out.println("│ Character│ Frequency │ Code     │");
        System.out.println("├──────────┼───────────┼──────────┤");
        
        for (int i = 0; i < uniqueCount; i++) {
            String charDisplay = characters[i] == ' ' ? "SPACE" : String.valueOf(characters[i]);
            System.out.printf("│ %-8s │ %-9d │ %-8s │%n", charDisplay, frequencies[i], mapping[i][1]);
        }
        
        System.out.println("└──────────┴───────────┴──────────┘");
        
        // Compression results
        System.out.println("\nCompression Results:");
        System.out.println("Original text:    \"" + original + "\"");
        System.out.println("Compressed text:  \"" + compressed + "\"");
        System.out.println("Decompressed text:\"" + decompressed + "\"");
        
        // Calculate compression ratio
        double compressionRatio = (double) compressed.length() / original.length() * 100;
        double spaceSaved = 100 - compressionRatio;
        
        System.out.println("\nCompression Statistics:");
        System.out.println("Original size:    " + original.length() + " characters");
        System.out.println("Compressed size:  " + compressed.length() + " characters");
        System.out.printf("Compression ratio: %.2f%%%n", compressionRatio);
        System.out.printf("Space saved:      %.2f%%%n", spaceSaved);
        
        // Validation
        boolean successful = original.equals(decompressed);
        System.out.println("Decompression successful: " + successful);
        
        if (!successful) {
            System.out.println("ERROR: Decompression failed!");
        }
    }
}