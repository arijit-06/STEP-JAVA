import java.util.*;

public class CardDeckSimulator {
    public static String[] initDeck() {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        String[] deck = new String[suits.length * ranks.length];
        int k = 0;
        for (String r : ranks)
            for (String s : suits)
                deck[k++] = r + " of " + s;
        return deck;
    }

    public static void shuffle(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int r = i + (int) (Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }

    public static String[][] distribute(String[] deck, int n, int players) {
        if (n % players != 0)
            return null;
        String[][] res = new String[players][n / players];
        int idx = 0;
        for (int i = 0; i < players; i++)
            for (int j = 0; j < n / players; j++)
                res[i][j] = deck[idx++];
        return res;
    }

    public static void display(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (String c : arr[i])
                System.out.print(c + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        String[] deck = initDeck();
        shuffle(deck);
        String[][] res = distribute(deck, n, p);
        if (res == null)
            System.out.println("Cannot distribute");
        else
            display(res);
        sc.close();
    }
}
