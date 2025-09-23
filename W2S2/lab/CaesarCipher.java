/**
 * W2S2 Lab 4: Caesar Cipher Implementation
 * 
 * Task: Write a program to create a simple encryption and decryption
 * system using ASCII character shifting (Caesar Cipher implementation)
 */

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text to encrypt: ");
        String text = scanner.nextLine();
        
        System.out.print("Enter shift value: ");
        int shift = scanner.nextInt();
        
        String encrypted = encryptText(text, shift);
        String decrypted = decryptText(encrypted, shift);
        
        displayASCIIValues(text, encrypted);
        
        boolean validationResult = validateDecryption(text, decrypted);
        
        System.out.println("\n=== RESULTS ===");
        System.out.println("Original:  " + text);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        System.out.println("Validation: " + (validationResult ? "SUCCESS" : "FAILED"));
        
        scanner.close();
    }
    
    public static String encryptText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int asciiValue = (int) ch;
            
            if (ch >= 'A' && ch <= 'Z') {
                // Handle uppercase letters with wrap-around
                int shifted = ((ch - 'A' + shift) % 26 + 26) % 26 + 'A';
                result.append((char) shifted);
            } else if (ch >= 'a' && ch <= 'z') {
                // Handle lowercase letters with wrap-around
                int shifted = ((ch - 'a' + shift) % 26 + 26) % 26 + 'a';
                result.append((char) shifted);
            } else {
                // Keep non-alphabetic characters unchanged
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    public static String decryptText(String text, int shift) {
        return encryptText(text, -shift);
    }
    
    public static void displayASCIIValues(String original, String encrypted) {
        System.out.println("\n=== ASCII VALUES ===");
        System.out.println("┌─────┬──────────┬─────────┬──────────┬─────────┐");
        System.out.println("│ Pos │ Original │ ASCII   │ Encrypted│ ASCII   │");
        System.out.println("├─────┼──────────┼─────────┼──────────┼─────────┤");
        
        int maxLen = Math.min(original.length(), encrypted.length());
        for (int i = 0; i < maxLen; i++) {
            char origChar = original.charAt(i);
            char encChar = encrypted.charAt(i);
            System.out.printf("│ %-3d │ %-8s │ %-7d │ %-8s │ %-7d │%n", 
                            i, origChar, (int)origChar, encChar, (int)encChar);
        }
        
        System.out.println("└─────┴──────────┴─────────┴──────────┴─────────┘");
    }
    
    public static boolean validateDecryption(String original, String decrypted) {
        return original.equals(decrypted);
    }
}