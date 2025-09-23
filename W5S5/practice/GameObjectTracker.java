// File: GameObjectTracker.java
// PRACTICE PROBLEM 3: Static Counters and Object Tracking

public class GameObjectTracker {
    
    public static class GameObject {
        protected String name;
        protected int x, y;
        protected static int totalObjects = 0;
        protected static int activeObjects = 0;
        
        public GameObject(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
            totalObjects++;
            activeObjects++;
            System.out.println("GameObject created: " + name);
        }
        
        public void destroy() {
            activeObjects--;
            System.out.println("GameObject destroyed: " + name);
        }
        
        public static int getTotalObjects() { return totalObjects; }
        public static int getActiveObjects() { return activeObjects; }
        
        public static void displayStats() {
            System.out.println("Total objects created: " + totalObjects);
            System.out.println("Active objects: " + activeObjects);
            System.out.println("Destroyed objects: " + (totalObjects - activeObjects));
        }
    }
    
    public static class Player extends GameObject {
        private int health;
        private static int playerCount = 0;
        
        public Player(String name, int x, int y, int health) {
            super(name, x, y);
            this.health = health;
            playerCount++;
        }
        
        @Override
        public void destroy() {
            super.destroy();
            playerCount--;
        }
        
        public static int getPlayerCount() { return playerCount; }
    }
    
    public static class Enemy extends GameObject {
        private int damage;
        private static int enemyCount = 0;
        
        public Enemy(String name, int x, int y, int damage) {
            super(name, x, y);
            this.damage = damage;
            enemyCount++;
        }
        
        @Override
        public void destroy() {
            super.destroy();
            enemyCount--;
        }
        
        public static int getEnemyCount() { return enemyCount; }
    }
    
    public static class GameManager {
        public static void generateReport() {
            System.out.println("\n=== Game Statistics ===");
            GameObject.displayStats();
            System.out.println("Players: " + Player.getPlayerCount());
            System.out.println("Enemies: " + Enemy.getEnemyCount());
        }
        
        public static void resetGame() {
            System.out.println("\nResetting game...");
            // Note: In real implementation, you'd reset static counters
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Game Object Tracking Demo ===");
        
        Player player1 = new Player("Hero", 0, 0, 100);
        Player player2 = new Player("Warrior", 10, 10, 120);
        
        Enemy enemy1 = new Enemy("Goblin", 5, 5, 20);
        Enemy enemy2 = new Enemy("Orc", 15, 15, 35);
        Enemy enemy3 = new Enemy("Dragon", 20, 20, 100);
        
        GameManager.generateReport();
        
        System.out.println("\n=== Destroying some objects ===");
        enemy1.destroy();
        enemy2.destroy();
        
        GameManager.generateReport();
    }
}