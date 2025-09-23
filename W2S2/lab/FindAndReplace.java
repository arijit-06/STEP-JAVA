/**
 * W2S2 Lab 1: Find and Replace Without Built-in Methods
 * 
 * Task: Write a program to find and replace all occurrences of a
 * substring in a text without using the replace() method
 */

import java.util.Scanner;

public class FindAndReplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter main text: ");
        String mainText = scanner.nextLine();
        
        System.out.print("Enter substring to find: ");
        String findText = scanner.nextLine();
        
        System.out.print("Enter replacement text: ");
        String replaceText = scanner.nextLine();
        
        // Find all occurrences
        int[] positions = findAllOccurrences(mainText, findText);
        
        // Replace manually
        String manualResult = replaceManually(mainText, findText, replaceText, positions);
        
        // Compare with built-in method
        String builtInResult = mainText.replace(findText, replaceText);
        boolean matches = compareResults(manualResult, builtInResult);
        
        System.out.println("\nOriginal: " + mainText);
        System.out.println("Manual result: " + manualResult);
        System.out.println("Built-in result: " + builtInResult);
        System.out.println("Results match: " + matches);
        
        scanner.close();
    }
    
    public static int[] findAllOccurrences(String text, String substring) {
        int[] tempPositions = new int[text.length()];
        int count = 0;
        int index = 0;
        
        while ((index = text.indexOf(substring, index)) != -1) {
            tempPositions[count++] = index;
            index += substring.length();
        }
        
        int[] positions = new int[count];
        System.arraycopy(tempPositions, 0, positions, 0, count);
        return positions;
    }
    
    public static String replaceManually(String text, String find, String replace, int[] positions) {
        if (positions.length == 0) return text;
        
        StringBuilder result = new StringBuilder();
        int lastIndex = 0;
        
        for (int pos : positions) {
            // Add text before the match
            for (int i = lastIndex; i < pos; i++) {
                result.append(text.charAt(i));
            }
            // Add replacement text
            result.append(replace);
            lastIndex = pos + find.length();
        }
        
        // Add remaining text
        for (int i = lastIndex; i < text.length(); i++) {
            result.append(text.charAt(i));
        }
        
        return result.toString();
    }
    
    public static boolean compareResults(String manual, String builtIn) {
        return manual.equals(builtIn);
    }
}