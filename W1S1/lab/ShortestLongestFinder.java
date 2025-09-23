package lab;

import java.util.*;

public class ShortestLongestFinder {
    static int strLength(String s) {
        int c = 0;
        try {
            while (true) {
                s.charAt(c);
                c++;
            }
        } catch (Exception e) {
        }
        return c;
    }

    static String[] customSplit(String s) {
        int len = strLength(s), spaces = 1;
        for (int i = 0; i < len; i++)
            if (s.charAt(i) == ' ')
                spaces++;
        int[] idx = new int[spaces + 1];
        int k = 1;
        for (int i = 0; i < len; i++)
            if (s.charAt(i) == ' ')
                idx[k++] = i;
        idx[spaces] = len;
        String[] words = new String[spaces];
        int start = 0;
        for (int i = 0; i < spaces; i++) {
            int end = idx[i + 1];
            String w = "";
            for (int j = start; j < end; j++)
                if (s.charAt(j) != ' ')
                    w += s.charAt(j);
            words[i] = w;
            start = end;
        }
        return words;
    }

    static String[][] wordLengthTable(String[] words) {
        String[][] res = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            res[i][0] = words[i];
            res[i][1] = String.valueOf(strLength(words[i]));
        }
        return res;
    }

    static int[] findMinMax(String[][] arr) {
        int min = Integer.parseInt(arr[0][1]), max = min;
        int minI = 0, maxI = 0;
        for (int i = 1; i < arr.length; i++) {
            int l = Integer.parseInt(arr[i][1]);
            if (l < min) {
                min = l;
                minI = i;
            }
            if (l > max) {
                max = l;
                maxI = i;
            }
        }
        return new int[] { minI, maxI };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = customSplit(s);
        String[][] arr = wordLengthTable(words);
        int[] idx = findMinMax(arr);
        System.out.println("Shortest: " + arr[idx[0]][0]);
        System.out.println("Longest: " + arr[idx[1]][0]);
        sc.close();
    }
}
