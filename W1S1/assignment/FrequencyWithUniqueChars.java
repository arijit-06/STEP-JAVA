import java.util.*;

public class FrequencyWithUniqueChars {
    public static char[] uniqueChars(String s) {
        char[] temp = new char[s.length()];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == c) {
                    found = true;
                    break;
                }
            }
            if (!found) temp[idx++] = c;
        }
        return Arrays.copyOf(temp, idx);
    }

    public static String[][] frequencyWithUnique(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i)]++;
        
        char[] unique = uniqueChars(s);
        String[][] res = new String[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            res[i][0] = String.valueOf(unique[i]);
            res[i][1] = String.valueOf(freq[unique[i]]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[][] res = frequencyWithUnique(s);
        System.out.printf("%-10s%-10s\n", "Character", "Frequency");
        for (String[] row : res)
            System.out.printf("%-10s%-10s\n", row[0], row[1]);
        sc.close();
    }
}