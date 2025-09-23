package lab;

import java.util.*;

public class StringLengthCalculator {
    static int strLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int l1 = strLength(s);
        int l2 = s.length();
        System.out.println(l1);
        System.out.println(l2);
        sc.close();
    }
}
