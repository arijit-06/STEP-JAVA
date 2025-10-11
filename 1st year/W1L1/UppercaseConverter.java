/*
Level 1 Practice Program 9: Convert text to uppercase
*/

import java.util.Scanner;

public class UppercaseConverter {
    
    public static String convertToUppercase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32); // Convert to uppercase using ASCII difference
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
        
        String customUppercase = convertToUppercase(text);
        String builtInUppercase = text.toUpperCase();
        
        System.out.println("Original text: " + text);
        System.out.println("Custom uppercase: " + customUppercase);
        System.out.println("Built-in uppercase: " + builtInUppercase);
        System.out.println("Results match: " + compareStrings(customUppercase, builtInUppercase));
        
        scanner.close();
    }
}