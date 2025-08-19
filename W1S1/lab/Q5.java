package lab;

import java.util.*;

public class Q5 {
    static String type(char c) {
        if (c >= 'A' && c <= 'Z')
            c = (char) (c + 32);
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                return "Vowel";
            return "Consonant";
        }
        return "Not";
    }

    static int[] countVC(String s) {
        int v = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            String t = type(s.charAt(i));
            if (t.equals("Vowel"))
                v++;
            else if (t.equals("Consonant"))
                c++;
        }
        return new int[] { v, c };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] res = countVC(s);
        System.out.println("Vowels: " + res[0]);
        System.out.println("Consonants: " + res[1]);
        sc.close();
    }
}
