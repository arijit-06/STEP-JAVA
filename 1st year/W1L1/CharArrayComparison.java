/*
Level 1 Practice Program 3: Character array comparison
*/

import java.util.Scanner;

public class CharArrayComparison {
    
    public static char[] getCharacters(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }
    
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter string: ");
        String str = scanner.next();
        
        char[] customArray = getCharacters(str);
        char[] builtInArray = str.toCharArray();
        
        System.out.println("Custom array: " + java.util.Arrays.toString(customArray));
        System.out.println("Built-in array: " + java.util.Arrays.toString(builtInArray));
        System.out.println("Arrays match: " + compareCharArrays(customArray, builtInArray));
        
        scanner.close();
    }
}