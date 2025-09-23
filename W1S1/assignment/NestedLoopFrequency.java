import java.util.*;

public class NestedLoopFrequency {
    public static String[] nestedLoopFrequency(String s) {
        char[] chars = s.toCharArray();
        int[] freq = new int[chars.length];
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                freq[i] = 1;
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        freq[i]++;
                        chars[j] = '0';
                    }
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < chars.length; i++)
            if (chars[i] != '0') count++;
        
        String[] res = new String[count];
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                res[idx++] = chars[i] + ":" + freq[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] res = nestedLoopFrequency(s);
        System.out.println("Character:Frequency");
        for (String r : res)
            System.out.println(r);
        sc.close();
    }
}