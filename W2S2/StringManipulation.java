package W2S2;

import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String trimmed = input.trim();
        String replaced = trimmed.replace(" ", "_");
        String noDigits = replaced.replaceAll("\\d", "");
        String[] words = trimmed.split("\\s+");
        String joined = String.join(" | ", words);
        System.out.println("Trimmed: " + trimmed);
        System.out.println("Underscores: " + replaced);
        System.out.println("No digits: " + noDigits);
        System.out.println("Words: " + Arrays.toString(words));
        System.out.println("Joined: " + joined);
        System.out.println("No punctuation: " + removePunctuation(trimmed));
        System.out.println("Capitalized: " + capitalizeWords(trimmed));
        System.out.println("Reversed: " + reverseWordOrder(trimmed));
        countWordFrequency(trimmed);
        scanner.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
                    .append(w.substring(1).toLowerCase())
                    .append(" ");
        }
        return sb.toString().trim();
    }

    public static String reverseWordOrder(String text) {
        String[] words = text.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String w : words)
            map.put(w, map.getOrDefault(w, 0) + 1);
        System.out.println("Word Frequency: " + map);
    }
}
