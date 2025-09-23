package lab;

import java.util.*;

public class WordLengthTable {
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
        int len = strLength(s);
        int spaces = 1;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] w = customSplit(s);
        String[][] table = wordLengthTable(w);
        for (int i = 0; i < table.length; i++)
            System.out.println(table[i][0] + "\t" + Integer.parseInt(table[i][1]));
        sc.close();
    }
}
