package lab;

import java.util.*;

public class RockPaperScissors {
    static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        return choices[(int) (Math.random() * 3)];
    }

    static String findWinner(String user, String comp) {
        if (user.equals(comp)) return "tie";
        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("paper") && comp.equals("rock")) ||
            (user.equals("scissors") && comp.equals("paper")))
            return "user";
        return "computer";
    }

    static String[][] calculateStats(int userWins, int compWins, int ties, int total) {
        String[][] stats = new String[3][3];
        stats[0][0] = "User"; stats[0][1] = String.valueOf(userWins); 
        stats[0][2] = String.format("%.1f%%", (userWins * 100.0) / total);
        stats[1][0] = "Computer"; stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.format("%.1f%%", (compWins * 100.0) / total);
        stats[2][0] = "Ties"; stats[2][1] = String.valueOf(ties);
        stats[2][2] = String.format("%.1f%%", (ties * 100.0) / total);
        return stats;
    }

    static void displayResults(String[][] stats) {
        System.out.printf("%-10s%-10s%-10s\n", "Player", "Wins", "Percentage");
        for (String[] row : stats)
            System.out.printf("%-10s%-10s%-10s\n", row[0], row[1], row[2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        int userWins = 0, compWins = 0, ties = 0;
        
        for (int i = 0; i < games; i++) {
            System.out.print("Enter choice (rock/paper/scissors): ");
            String user = sc.next().toLowerCase();
            String comp = getComputerChoice();
            String winner = findWinner(user, comp);
            
            System.out.println("Computer: " + comp + ", Result: " + winner);
            if (winner.equals("user")) userWins++;
            else if (winner.equals("computer")) compWins++;
            else ties++;
        }
        
        String[][] stats = calculateStats(userWins, compWins, ties, games);
        displayResults(stats);
        sc.close();
    }
}