/**
 * W2S2 Lab 3: String Performance Analysis
 * 
 * Task: Write a program to analyze and compare the performance of
 * String concatenation vs StringBuilder vs StringBuffer for building large strings
 */

import java.util.Scanner;

public class StringPerformanceAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of iterations: ");
        int iterations = scanner.nextInt();
        
        System.out.println("\n=== PERFORMANCE ANALYSIS ===");
        
        // String concatenation
        long stringTime = performStringConcatenation(iterations);
        
        // StringBuilder
        long stringBuilderTime = performStringBuilder(iterations);
        
        // StringBuffer
        long stringBufferTime = performStringBuffer(iterations);
        
        displayPerformanceComparison(iterations, stringTime, stringBuilderTime, stringBufferTime);
        
        scanner.close();
    }
    
    public static long performStringConcatenation(int iterations) {
        long startTime = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Test" + i + " ";
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    
    public static long performStringBuilder(int iterations) {
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Test").append(i).append(" ");
        }
        String result = sb.toString();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    
    public static long performStringBuffer(int iterations) {
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Test").append(i).append(" ");
        }
        String result = sb.toString();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    
    public static void displayPerformanceComparison(int iterations, long stringTime, long sbTime, long sbufTime) {
        System.out.println("┌─────────────────┬─────────────┬──────────────────┐");
        System.out.println("│ Method          │ Time (ms)   │ Memory Efficiency│");
        System.out.println("├─────────────────┼─────────────┼──────────────────┤");
        System.out.printf("│ String          │ %-11d │ Poor             │%n", stringTime);
        System.out.printf("│ StringBuilder   │ %-11d │ Excellent        │%n", sbTime);
        System.out.printf("│ StringBuffer    │ %-11d │ Good             │%n", sbufTime);
        System.out.println("└─────────────────┴─────────────┴──────────────────┘");
        
        System.out.println("\nPerformance Analysis:");
        if (sbTime > 0) {
            System.out.println("StringBuilder is " + (stringTime / sbTime) + "x faster than String");
        }
        if (sbufTime > 0) {
            System.out.println("StringBuffer is " + (stringTime / sbufTime) + "x faster than String");
        }
        
        System.out.println("\nRecommendations:");
        System.out.println("• Use StringBuilder for single-threaded applications");
        System.out.println("• Use StringBuffer for multi-threaded applications");
        System.out.println("• Avoid String concatenation in loops");
    }
}