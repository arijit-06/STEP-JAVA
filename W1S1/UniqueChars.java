import java.util.*;

public class UniqueChars {
    public static int length(String s) {
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

    public static char[] uniqueChars(String s) {
        int n = length(s);
        char[] temp = new char[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == c) {
                    found = true;
                    break;
                }
            }
            if (!found)
                temp[idx++] = c;
        }
        return Arrays.copyOf(temp, idx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] res = uniqueChars(s);
        for (char c : res)
            System.out.print(c + " ");
        sc.close();
    }
}
