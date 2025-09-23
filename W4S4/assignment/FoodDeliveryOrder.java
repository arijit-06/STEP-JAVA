// File: FoodDeliveryOrder.java
// HW PROBLEM 3: Game and Card Game Objects
// Topic: Overriding Object Methods

import java.util.Objects;

public class FoodDeliveryOrder {
    
    // Game class overriding Object methods
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
        
        public void endGame() {
            System.out.println("Game " + title + " ended after " + duration + " minutes");
        }
    }
    
    // CardGame extending Game and overriding methods properly
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
                System.out.println("Dealer is ready to deal cards");
            }
        }
        
        public void dealCards() {
            System.out.println("Dealing " + cardType + " cards to " + playerCount + " players");
        }
        
        public void shuffleDeck() {
            System.out.println("Shuffling the " + deckSize + "-card deck");
        }
        
        @Override
        public void endGame() {
            System.out.println("Collecting all " + cardType + " cards");
            super.endGame();
        }
    }
    
    // BoardGame for comparison
    public static class BoardGame extends Game {
        private String boardType;
        private int pieceCount;
        private boolean requiresDice;
        
        public BoardGame(String title, String genre, int playerCount, int duration,
                        String boardType, int pieceCount, boolean requiresDice) {
            super(title, genre, playerCount, duration);
            this.boardType = boardType;
            this.pieceCount = pieceCount;
            this.requiresDice = requiresDice;
        }
        
        @Override
        public String toString() {
            return super.toString().replace("Game{", "BoardGame{").replace("}", 
                   String.format(", board=%s, pieces=%d, dice=%s}", 
                               boardType, pieceCount, requiresDice ? "required" : "not required"));
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            if (!super.equals(obj)) return false;
            BoardGame boardGame = (BoardGame) obj;
            return pieceCount == boardGame.pieceCount &&
                   requiresDice == boardGame.requiresDice &&
                   Objects.equals(boardType, boardGame.boardType);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), boardType, pieceCount, requiresDice);
        }
        
        @Override
        public void startGame() {
            System.out.println("Setting up " + boardType + " board with " + pieceCount + " pieces");
            super.startGame();
        }
        
        public void setupBoard() {
            System.out.println("Placing " + pieceCount + " pieces on " + boardType + " board");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Testing Object Method Overriding ===");
        
        // Create different game objects
        Game basicGame = new Game("Chess", "Strategy", 2, 60);
        CardGame poker = new CardGame("Texas Hold'em", "Card", 6, 120, 52, "Standard", true);
        CardGame blackjack = new CardGame("Blackjack", "Card", 4, 45, 52, "Standard", true);
        BoardGame monopoly = new BoardGame("Monopoly", "Economic", 4, 180, "Square", 32, true);
        
        System.out.println("\n=== Testing toString() Method ===");
        System.out.println("Basic Game: " + basicGame);
        System.out.println("Poker: " + poker);
        System.out.println("Blackjack: " + blackjack);
        System.out.println("Monopoly: " + monopoly);
        
        System.out.println("\n=== Testing equals() Method ===");
        
        // Test equality between same objects
        CardGame anotherPoker = new CardGame("Texas Hold'em", "Card", 6, 120, 52, "Standard", true);
        System.out.println("poker.equals(anotherPoker): " + poker.equals(anotherPoker));
        System.out.println("poker.equals(blackjack): " + poker.equals(blackjack));
        System.out.println("poker.equals(basicGame): " + poker.equals(basicGame));
        
        // Test with null and different types
        System.out.println("poker.equals(null): " + poker.equals(null));
        System.out.println("poker.equals(\"string\"): " + poker.equals("string"));
        
        System.out.println("\n=== Testing hashCode() Method ===");
        System.out.println("poker.hashCode(): " + poker.hashCode());
        System.out.println("anotherPoker.hashCode(): " + anotherPoker.hashCode());
        System.out.println("blackjack.hashCode(): " + blackjack.hashCode());
        
        // Verify hashCode contract: equal objects have same hashCode
        System.out.println("Equal objects have same hashCode: " + 
                         (poker.equals(anotherPoker) && poker.hashCode() == anotherPoker.hashCode()));
        
        System.out.println("\n=== Testing Method Overriding ===");
        
        // Test overridden startGame() methods
        System.out.println("\n1. Basic Game start:");
        basicGame.startGame();
        
        System.out.println("\n2. Card Game start:");
        poker.startGame();
        poker.dealCards();
        
        System.out.println("\n3. Board Game start:");
        monopoly.startGame();
        monopoly.setupBoard();
        
        System.out.println("\n=== Testing Polymorphic Behavior ===");
        
        // Array of Game references
        Game[] games = {basicGame, poker, blackjack, monopoly};
        
        System.out.println("\nPolymorphic toString() calls:");
        for (Game game : games) {
            System.out.println(game); // Calls appropriate toString() method
        }
        
        System.out.println("\nPolymorphic startGame() calls:");
        for (Game game : games) {
            game.startGame(); // Calls appropriate startGame() method
            System.out.println();
        }
        
        System.out.println("\n=== Testing Object Identity vs Equality ===");
        
        Game game1 = new Game("Chess", "Strategy", 2, 60);
        Game game2 = new Game("Chess", "Strategy", 2, 60);
        Game game3 = game1;
        
        System.out.println("game1 == game2 (reference equality): " + (game1 == game2));
        System.out.println("game1.equals(game2) (content equality): " + game1.equals(game2));
        System.out.println("game1 == game3 (same reference): " + (game1 == game3));
        System.out.println("game1.equals(game3) (same reference): " + game1.equals(game3));
        
        System.out.println("\n=== Demonstrating super.toString() Usage ===");
        
        // Show how CardGame uses super.toString() in its implementation
        System.out.println("CardGame toString() builds upon Game toString():");
        System.out.println("Game part: " + basicGame.toString());
        System.out.println("CardGame full: " + poker.toString());
        
        System.out.println("\n=== Testing Game Functionality ===");
        
        // Test complete game flow
        System.out.println("\nComplete Poker Game Flow:");
        poker.startGame();
        poker.shuffleDeck();
        poker.dealCards();
        poker.endGame();
    }
}