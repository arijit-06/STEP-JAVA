/*
Level 1 Practice Program 10: Convert text to lowercase
*/

import java.util.Scanner;

public class LowercaseConverter {
    
    public static String convertToLowercase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32); // Convert to lowercase using ASCII difference
            }
            result += ch;
        }
        return result;
    }
    
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String customLowercase = convertToLowercase(text);
        String builtInLowercase = text.toLowerCase();
        
        System.out.println("Original text: " + text);
        System.out.println("Custom lowercase: " + customLowercase);
        System.out.println("Built-in lowercase: " + builtInLowercase);
        System.out.println("Results match: " + compareStrings(customLowercase, builtInLowercase));
        
        scanner.close();
    }
}