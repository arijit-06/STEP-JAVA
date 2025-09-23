import java.util.*;

public class CharacterFrequencyCounter {
    public static String[][] charFrequency(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i)]++;
        
        int count = 0;
        for (int i = 0; i < 256; i++)
            if (freq[i] > 0) count++;
        
        String[][] res = new String[count][2];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq[c] > 0) {
                res[idx][0] = String.valueOf(c);
                res[idx][1] = String.valueOf(freq[c]);
                freq[c] = 0;
                idx++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[][] res = charFrequency(s);
        System.out.printf("%-10s%-10s\n", "Character", "Frequency");
        for (String[] row : res)
            System.out.printf("%-10s%-10s\n", row[0], row[1]);
        sc.close();
    }
}