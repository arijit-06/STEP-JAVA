// File: GameScoreTracker.java
// ASSIGNMENT 5: Game Score Tracker

public class GameScoreTracker {
    
    public static class Player {
        private String name;
        private int score;
        private static int highScore = 0;
        private static String topPlayer = "";
        
        public Player(String name) {
            this.name = name;
            this.score = 0;
        }
        
        public void addScore(int points) {
            score += points;
            if (score > highScore) {
                highScore = score;
                topPlayer = name;
            }
        }
        
        public static int getHighScore() { return highScore; }
        public static String getTopPlayer() { return topPlayer; }
        
        public void displayScore() {
            System.out.println(name + ": " + score + " points");
        }
        
        public static void displayLeaderboard() {
            System.out.println("High Score: " + highScore + " by " + topPlayer);
        }
    }
    
    public static void main(String[] args) {
        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");
        Player p3 = new Player("Carol");
        
        p1.addScore(150);
        p2.addScore(200);
        p3.addScore(175);
        
        p1.displayScore();
        p2.displayScore();
        p3.displayScore();
        
        Player.displayLeaderboard();
    }
}