package W2S2;

import java.util.*;

public class StringUtilityApp {
    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== STRING UTILITY APPLICATION ===");
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        performTextAnalysis(text);
        performASCIIOperations(text);
        performPerformanceTest(1000);
        performComparisonAnalysis(new String[] { "Hello", "HELLO" });
        performCustomAlgorithms("madam");
        displayResults();
        sc.close();
    }

    public static void performTextAnalysis(String text) {
        output.append("Length: ").append(text.length()).append("\n");
        int wordCount = text.trim().isEmpty() ? 0 : text.split("\\s+").length;
        output.append("Words: ").append(wordCount).append("\n");
    }

    public static String performTransformations(String text, String[] ops) {
        StringBuilder sb = new StringBuilder(text);
        for (String op : ops) {
            if (op.equals("upper"))
                sb = new StringBuilder(text.toUpperCase());
            if (op.equals("lower"))
                sb = new StringBuilder(text.toLowerCase());
        }
        return sb.toString();
    }

    public static void performASCIIOperations(String text) {
        for (char c : text.toCharArray())
            output.append(c).append(":").append((int) c).append(" ");
        output.append("\n");
    }

    public static void performPerformanceTest(int iterations) {
        long t1 = System.nanoTime();
        String s;
        s = "";
        for (int i = 0; i < iterations; i++)
            s += "a";
        long t2 = System.nanoTime();
        output.append("String: ").append(t2 - t1).append("\n");
        t1 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++)
            sb.append("a");
        t2 = System.nanoTime();
        output.append("StringBuilder: ").append(t2 - t1).append("\n");
        t1 = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++)
            sbf.append("a");
        t2 = System.nanoTime();
        output.append("StringBuffer: ").append(t2 - t1).append("\n");
    }

    public static void performComparisonAnalysis(String[] strings) {
        output.append(strings[0].equals(strings[1])).append("\n");
    }

    public static void performCustomAlgorithms(String text) {
        String rev = new StringBuilder(text).reverse().toString();
        output.append("Palindrome: ").append(text.equals(rev)).append("\n");
    }

    public static void displayResults() {
        System.out.println(output.toString());
    }
}
