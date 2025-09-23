/**
 * W2S2 Practice Problem 3: ASCII Codes and Character Conversion
 * 
 * Task: Create a program that demonstrates ASCII character manipulation and conversion.
 * 
 * Learning Objectives:
 * - ASCII character manipulation and conversion
 * - Character type classification (uppercase, lowercase, digit, special)
 * - Case conversion using ASCII arithmetic
 * - Caesar cipher implementation using ASCII shifting
 * - ASCII table display and conversion utilities
 */

import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== ASCII PROCESSOR AND CHARACTER CONVERTER ===");
        
        // TODO: Ask user to enter a string
        System.out.print("Enter a string to process: ");
        String userInput = scanner.nextLine();
        
        System.out.println("\nProcessing string: \"" + userInput + "\"");
        System.out.println("String length: " + userInput.length());
        
        // TODO: For each character in the string:
        System.out.println("\n=== CHARACTER ANALYSIS ===");
        System.out.println("┌─────┬───────┬──────────────────┬───────────┬───────────┬────────────┐");
        System.out.println("│ Pos │ Char  │ ASCII Code       │ Type      │ Upper     │ Lower      │");
        System.out.println("├─────┼───────┼──────────────────┼───────────┼───────────┼────────────┤");
        
        for (int i = 0; i < userInput.length(); i++) {
            char ch = userInput.charAt(i);
            
            // 1. Display the character and its ASCII code
            int asciiCode = (int) ch;
            
            // 2. Determine if it's uppercase, lowercase, digit, or special character
            String charType = classifyCharacter(ch);
            
            // 3. If letter, show both upper and lower case versions with ASCII codes
            String upperInfo = "";
            String lowerInfo = "";
            
            if (Character.isLetter(ch)) {
                char upperChar = Character.toUpperCase(ch);
                char lowerChar = Character.toLowerCase(ch);
                upperInfo = upperChar + "(" + (int)upperChar + ")";
                lowerInfo = lowerChar + "(" + (int)lowerChar + ")";
                
                // 4. Calculate the difference between upper and lower case ASCII values
                int difference = Math.abs((int)upperChar - (int)lowerChar);
                if (difference == 32) {
                    upperInfo += " Δ32";
                    lowerInfo += " Δ32";
                }
            } else {
                upperInfo = "N/A";
                lowerInfo = "N/A";
            }
            
            System.out.printf("│ %-3d │ %-5s │ %-16d │ %-9s │ %-9s │ %-10s │%n", 
                            i, (ch == ' ' ? "SPC" : String.valueOf(ch)), asciiCode, charType, upperInfo, lowerInfo);
        }
        
        System.out.println("└─────┴───────┴──────────────────┴───────────┴───────────┴────────────┘");
        
        // TODO: Create ASCII art using character codes
        System.out.println("\n=== ASCII ART DEMONSTRATION ===");
        createASCIIArt();
        
        // TODO: Implement a simple Caesar cipher using ASCII manipulation
        System.out.println("\n=== CAESAR CIPHER DEMONSTRATION ===");
        System.out.print("Enter shift value for Caesar cipher (1-25): ");
        int shift = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        String encrypted = caesarCipher(userInput, shift);
        String decrypted = caesarCipher(encrypted, -shift);
        
        System.out.println("Original:  \"" + userInput + "\"");
        System.out.println("Encrypted: \"" + encrypted + "\"");
        System.out.println("Decrypted: \"" + decrypted + "\"");
        System.out.println("Decryption matches original: " + userInput.equals(decrypted));
        
        // Additional demonstrations
        System.out.println("\n=== ASCII TABLE SAMPLE ===");
        displayASCIITable(65, 90); // A-Z
        
        System.out.println("\n=== STRING TO ASCII CONVERSION ===");
        int[] asciiArray = stringToASCII(userInput);
        System.out.print("ASCII values: ");
        for (int value : asciiArray) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        String reconstructed = asciiToString(asciiArray);
        System.out.println("Reconstructed string: \"" + reconstructed + "\"");
        System.out.println("Reconstruction successful: " + userInput.equals(reconstructed));
        
        scanner.close();
    }
    
    // TODO: Method to classify character type
    public static String classifyCharacter(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return "Uppercase Letter";
        } else if (ch >= 'a' && ch <= 'z') {
            return "Lowercase Letter";
        } else if (ch >= '0' && ch <= '9') {
            return "Digit";
        } else {
            return "Special Character";
        }
    }
    
    // TODO: Method to convert case using ASCII manipulation
    public static char toggleCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            // Convert upper to lower by adding 32
            return (char)(ch + 32);
        } else if (ch >= 'a' && ch <= 'z') {
            // Convert lower to upper by subtracting 32
            return (char)(ch - 32);
        } else {
            // Return unchanged if not a letter
            return ch;
        }
    }
    
    // TODO: Method to implement Caesar cipher
    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
            if (ch >= 'A' && ch <= 'Z') {
                // Handle uppercase letters
                int shifted = ((ch - 'A' + shift + 26) % 26) + 'A';
                result.append((char)shifted);
            } else if (ch >= 'a' && ch <= 'z') {
                // Handle lowercase letters
                int shifted = ((ch - 'a' + shift + 26) % 26) + 'a';
                result.append((char)shifted);
            } else {
                // Keep non-alphabetic characters unchanged
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    // TODO: Method to create ASCII table for a range
    public static void displayASCIITable(int start, int end) {
        System.out.println("ASCII Table from " + start + " to " + end + ":");
        System.out.println("┌──────┬──────┬──────┬──────┬──────┐");
        System.out.println("│ Code │ Char │ Code │ Char │ Code │");
        System.out.println("├──────┼──────┼──────┼──────┼──────┤");
        
        for (int i = start; i <= end; i += 5) {
            System.out.print("│");
            for (int j = 0; j < 5 && (i + j) <= end; j++) {
                int code = i + j;
                char character = (char)code;
                if (j < 4) {
                    System.out.printf(" %-4d │ %-4s │", code, character);
                } else {
                    System.out.printf(" %-4d │", code);
                }
            }
            System.out.println();
        }
        
        System.out.println("└──────┴──────┴──────┴──────┴──────┘");
    }
    
    // TODO: Method to convert string to ASCII array
    public static int[] stringToASCII(String text) {
        int[] asciiValues = new int[text.length()];
        
        for (int i = 0; i < text.length(); i++) {
            asciiValues[i] = (int)text.charAt(i);
        }
        
        return asciiValues;
    }
    
    // TODO: Method to convert ASCII array back to string
    public static String asciiToString(int[] asciiValues) {
        StringBuilder result = new StringBuilder();
        
        for (int asciiValue : asciiValues) {
            result.append((char)asciiValue);
        }
        
        return result.toString();
    }
    
    // Helper method to create ASCII art
    public static void createASCIIArt() {
        System.out.println("ASCII Art using character codes:");
        System.out.println((char)42 + " " + (char)42 + " " + (char)42 + " JAVA " + (char)42 + " " + (char)42 + " " + (char)42);
        System.out.println((char)124 + " ASCII: " + (int)'J' + " " + (int)'A' + " " + (int)'V' + " " + (int)'A' + " " + (char)124);
        System.out.println((char)42 + " " + (char)42 + " " + (char)42 + " " + (char)42 + " " + (char)42 + " " + (char)42 + " " + (char)42 + " " + (char)42 + " " + (char)42);
    }
}