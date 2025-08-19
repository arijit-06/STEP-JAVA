package W2S2;

import java.util.*;

public class AdvancedStringAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        performAllComparisons(s1, s2);
        System.out.println("Similarity: " + calculateSimilarity(s1, s2) + "%");
        sc.close();
    }

    public static double calculateSimilarity(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++)
            dp[i][0] = i;
        for (int j = 0; j <= str2.length(); j++)
            dp[0][j] = j;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                int cost = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
            }
        }
        int dist = dp[str1.length()][str2.length()];
        int maxLen = Math.max(str1.length(), str2.length());
        return (1 - (double) dist / maxLen) * 100;
    }

    public static void performAllComparisons(String str1, String str2) {
        System.out.println("==: " + (str1 == str2));
        System.out.println("equals: " + str1.equals(str2));
        System.out.println("equalsIgnoreCase: " + str1.equalsIgnoreCase(str2));
        System.out.println("compareTo: " + str1.compareTo(str2));
        System.out.println("compareToIgnoreCase: " + str1.compareToIgnoreCase(str2));
    }
}
