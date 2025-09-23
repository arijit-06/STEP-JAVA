package lab;

import java.util.*;

public class TextSplitter {
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

    static boolean compare(String[] a, String[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] a = customSplit(s);
        String[] b = s.split(" ");
        System.out.println(compare(a, b));
        sc.close();
    }
}
