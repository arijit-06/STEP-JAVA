// File: StringUtilities.java
// LAB 2: Static Utility Class Creation

public class StringUtilities {
    
    private StringUtilities() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }
    
    public static String reverse(String str) {
        if (str == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    
    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) return 0;
        return str.trim().split("\\s+").length;
    }
    
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    
    public static void main(String[] args) {
        System.out.println("=== String Utilities Demo ===");
        
        String test = "A man a plan a canal Panama";
        System.out.println("Original: " + test);
        System.out.println("Is palindrome: " + isPalindrome(test));
        System.out.println("Reversed: " + reverse(test));
        System.out.println("Word count: " + countWords(test));
        System.out.println("Capitalized: " + capitalize("hello world"));
    }
}