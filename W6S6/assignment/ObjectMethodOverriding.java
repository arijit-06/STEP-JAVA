// File: ObjectMethodOverriding.java
// ASSIGNMENT 3: Game and Card Game Objects

import java.util.Objects;

public class ObjectMethodOverriding {
    
    public static class Game {
        protected String title;
        protected String genre;
        protected int playerCount;
        protected int duration;
        
        public Game(String title, String genre, int playerCount, int duration) {
            this.title = title;
            this.genre = genre;
            this.playerCount = playerCount;
            this.duration = duration;
        }
        
        @Override
        public String toString() {
            return String.format("Game{title='%s', genre='%s', players=%d, duration=%d min}",
                               title, genre, playerCount, duration);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Game game = (Game) obj;
            return playerCount == game.playerCount &&
                   duration == game.duration &&
                   Objects.equals(title, game.title) &&
                   Objects.equals(genre, game.genre);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(title, genre, playerCount, duration);
        }
        
        public void startGame() {
            System.out.println("Starting " + title + " for " + playerCount + " players");
        }
    }
    
    public static class CardGame extends Game {
        private int deckSize;
        private String cardType;
        private boolean requiresDealer;
        
        public CardGame(String title, String genre, int playerCount, int duration,
                       int deckSize, String cardType, boolean requiresDealer) {
            super(title, genre, playerCount, duration);
            this.deckSize = deckSize;
            this.cardType = cardType;
            this.requiresDealer = requiresDealer;
        }
        
        @Override
        public String toString() {
            return super.toString().replace("Game{", "CardGame{").replace("}", 
                   String.format(", deck=%d %s cards, dealer=%s}", 
                               deckSize, cardType, requiresDealer ? "required" : "not required"));
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            if (!super.equals(obj)) return false;
            CardGame cardGame = (CardGame) obj;
            return deckSize == cardGame.deckSize &&
                   requiresDealer == cardGame.requiresDealer &&
                   Objects.equals(cardType, cardGame.cardType);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), deckSize, cardType, requiresDealer);
        }
        
        @Override
        public void startGame() {
            System.out.println("Shuffling " + deckSize + " " + cardType + " cards...");
            super.startGame();
            if (requiresDealer) {
                System.out.println("Dealer is ready");
            }
        }
        
        public void dealCards() {
            System.out.println("Dealing " + cardType + " cards to " + playerCount + " players");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Object Method Overriding Demo ===");
        
        Game basicGame = new Game("Chess", "Strategy", 2, 60);
        CardGame poker = new CardGame("Texas Hold'em", "Card", 6, 120, 52, "Standard", true);
        CardGame anotherPoker = new CardGame("Texas Hold'em", "Card", 6, 120, 52, "Standard", true);
        
        System.out.println("\n=== toString() Method ===");
        System.out.println("Basic Game: " + basicGame);
        System.out.println("Poker: " + poker);
        
        System.out.println("\n=== equals() Method ===");
        System.out.println("poker.equals(anotherPoker): " + poker.equals(anotherPoker));
        System.out.println("poker.equals(basicGame): " + poker.equals(basicGame));
        
        System.out.println("\n=== hashCode() Method ===");
        System.out.println("poker.hashCode(): " + poker.hashCode());
        System.out.println("anotherPoker.hashCode(): " + anotherPoker.hashCode());
        System.out.println("Equal objects have same hashCode: " + 
                         (poker.equals(anotherPoker) && poker.hashCode() == anotherPoker.hashCode()));
        
        System.out.println("\n=== Polymorphic Method Calls ===");
        Game[] games = {basicGame, poker};
        for (Game game : games) {
            System.out.println(game);
            game.startGame();
            System.out.println();
        }
    }
}