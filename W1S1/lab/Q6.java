package lab;

import java.util.*;

public class Q6 {
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

    static String[][] charTypes(String s) {
        String[][] arr = new String[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            arr[i][0] = String.valueOf(s.charAt(i));
            arr[i][1] = type(s.charAt(i));
        }
        return arr;
    }

    static void display(String[][] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i][0] + "\t" + arr[i][1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        display(charTypes(s));
        sc.close();
    }
}
