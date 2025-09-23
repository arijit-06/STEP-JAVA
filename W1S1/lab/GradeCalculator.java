package lab;

import java.util.*;

public class GradeCalculator {
    static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                scores[i][j] = 10 + (int) (Math.random() * 91);
        return scores;
    }

    static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            stats[i][0] = total;
            stats[i][1] = Math.round((total / 3.0) * 100.0) / 100.0;
            stats[i][2] = Math.round(((total / 300.0) * 100) * 100.0) / 100.0;
        }
        return stats;
    }

    static String[] calculateGrades(double[][] stats) {
        String[] grades = new String[stats.length];
        for (int i = 0; i < stats.length; i++) {
            double per = stats[i][2];
            if (per >= 90) grades[i] = "A";
            else if (per >= 80) grades[i] = "B";
            else if (per >= 70) grades[i] = "C";
            else if (per >= 60) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    static void displayScorecard(int[][] scores, double[][] stats, String[] grades) {
        System.out.printf("%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s\n", 
            "Student", "Physics", "Chem", "Math", "Total", "Avg", "Per%", "Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-8d%-8d%-8d%-8d%-8.0f%-8.2f%-8.2f%-8s\n",
                (i+1), scores[i][0], scores[i][1], scores[i][2],
                stats[i][0], stats[i][1], stats[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] scores = generateScores(n);
        double[][] stats = calculateStats(scores);
        String[] grades = calculateGrades(stats);
        displayScorecard(scores, stats, grades);
        sc.close();
    }
}