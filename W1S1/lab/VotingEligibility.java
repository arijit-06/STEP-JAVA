package lab;

import java.util.*;

public class VotingEligibility {
    static int[] generateAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++)
            ages[i] = 10 + (int) (Math.random() * 90);
        return ages;
    }

    static String[][] checkVoting(int[] ages) {
        String[][] res = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            res[i][0] = String.valueOf(ages[i]);
            res[i][1] = (ages[i] >= 18 && ages[i] > 0) ? "true" : "false";
        }
        return res;
    }

    static void display(String[][] arr) {
        System.out.printf("%-10s%-15s\n", "Age", "Can Vote");
        for (String[] row : arr)
            System.out.printf("%-10s%-15s\n", row[0], row[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] ages = generateAges(n);
        String[][] res = checkVoting(ages);
        display(res);
        sc.close();
    }
}