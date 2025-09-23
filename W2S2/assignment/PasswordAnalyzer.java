/**
 * W2S2 Assignment 2: Password Strength Analyzer
 * 
 * Task: Write a program to create a password strength analyzer and
 * generator using ASCII values and StringBuilder
 */

import java.util.Scanner;

public class PasswordAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of passwords to analyze: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        
        String[] passwords = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter password " + (i + 1) + ": ");
            passwords[i] = scanner.nextLine();
        }
        
        analyzePasswords(passwords);
        
        System.out.print("\nGenerate strong password? (y/n): ");
        if (scanner.nextLine().toLowerCase().startsWith("y")) {
            System.out.print("Enter desired length: ");
            int length = scanner.nextInt();
            String strongPassword = generateStrongPassword(length);
            System.out.println("Generated password: " + strongPassword);
            
            // Analyze the generated password
            String[] generated = {strongPassword};
            System.out.println("\nAnalysis of generated password:");
            analyzePasswords(generated);
        }
        
        scanner.close();
    }
    
    public static int[] analyzePasswordStrength(String password) {
        int[] counts = new int[4]; // uppercase, lowercase, digits, special
        
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            int ascii = (int) ch;
            
            if (ascii >= 65 && ascii <= 90) {
                counts[0]++; // uppercase
            } else if (ascii >= 97 && ascii <= 122) {
                counts[1]++; // lowercase
            } else if (ascii >= 48 && ascii <= 57) {
                counts[2]++; // digits
            } else {
                counts[3]++; // special characters
            }
        }
        
        return counts;
    }
    
    public static int calculateStrengthScore(String password) {
        int score = 0;
        int[] counts = analyzePasswordStrength(password);
        
        // Length points
        score += Math.max(0, (password.length() - 8) * 2);
        
        // Character variety points
        if (counts[0] > 0) score += 10; // uppercase
        if (counts[1] > 0) score += 10; // lowercase
        if (counts[2] > 0) score += 10; // digits
        if (counts[3] > 0) score += 10; // special
        
        // Deduct for common patterns
        if (hasCommonPatterns(password)) {
            score -= 15;
        }
        
        return Math.max(0, score);
    }
    
    public static boolean hasCommonPatterns(String password) {
        String lower = password.toLowerCase();
        return lower.contains("123") || lower.contains("abc") || 
               lower.contains("qwerty") || lower.contains("password");
    }
    
    public static String getStrengthLevel(int score) {
        if (score >= 51) return "Strong";
        if (score >= 21) return "Medium";
        return "Weak";
    }
    
    public static String generateStrongPassword(int length) {
        StringBuilder password = new StringBuilder();
        
        // Ensure at least one from each category
        password.append((char)(65 + (int)(Math.random() * 26))); // uppercase
        password.append((char)(97 + (int)(Math.random() * 26))); // lowercase
        password.append((char)(48 + (int)(Math.random() * 10))); // digit
        password.append("!@#$%^&*".charAt((int)(Math.random() * 8))); // special
        
        // Fill remaining positions
        String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt((int)(Math.random() * allChars.length())));
        }
        
        // Shuffle the password
        return shuffleString(password.toString());
    }
    
    public static String shuffleString(String str) {
        StringBuilder shuffled = new StringBuilder(str);
        for (int i = 0; i < shuffled.length(); i++) {
            int randomIndex = (int)(Math.random() * shuffled.length());
            char temp = shuffled.charAt(i);
            shuffled.setCharAt(i, shuffled.charAt(randomIndex));
            shuffled.setCharAt(randomIndex, temp);
        }
        return shuffled.toString();
    }
    
    public static void analyzePasswords(String[] passwords) {
        System.out.println("\n=== PASSWORD ANALYSIS RESULTS ===");
        System.out.println("┌─────────────┬────────┬─────┬─────┬──────┬─────────┬───────┬──────────┐");
        System.out.println("│ Password    │ Length │ Upper│ Lower│ Digits│ Special │ Score │ Strength │");
        System.out.println("├─────────────┼────────┼─────┼─────┼──────┼─────────┼───────┼──────────┤");
        
        for (String password : passwords) {
            int[] counts = analyzePasswordStrength(password);
            int score = calculateStrengthScore(password);
            String strength = getStrengthLevel(score);
            
            String displayPassword = password.length() > 11 ? password.substring(0, 8) + "..." : password;
            
            System.out.printf("│ %-11s │ %-6d │ %-4d │ %-4d │ %-5d │ %-7d │ %-5d │ %-8s │%n",
                            displayPassword, password.length(), counts[0], counts[1], 
                            counts[2], counts[3], score, strength);
        }
        
        System.out.println("└─────────────┴────────┴─────┴─────┴──────┴─────────┴───────┴──────────┘");
    }
}