import java.util.*;

public class PrintQueueSystem {
    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Command (ADD <doc>/PRINT/EXIT): ");
            String cmd = sc.next();
            
            if (cmd.equals("ADD")) {
                String document = sc.next();
                printQueue.offer(document);
                System.out.println("Added to queue: " + document);
            } else if (cmd.equals("PRINT")) {
                if (!printQueue.isEmpty()) {
                    String document = printQueue.poll();
                    System.out.println("Printing " + document);
                } else {
                    System.out.println("No jobs left!");
                }
            } else if (cmd.equals("EXIT")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
        sc.close();
    }
}