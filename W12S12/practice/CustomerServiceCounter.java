import java.util.*;

public class CustomerServiceCounter {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Command (ARRIVE <name>/SERVE/STATUS/EXIT): ");
            String cmd = sc.next();
            
            if (cmd.equals("ARRIVE")) {
                String name = sc.next();
                queue.offer(name);
                System.out.println(name + " joined the queue");
            } else if (cmd.equals("SERVE")) {
                if (!queue.isEmpty()) {
                    String customer = queue.poll();
                    System.out.println("Serving " + customer);
                } else {
                    System.out.println("No customers waiting");
                }
            } else if (cmd.equals("STATUS")) {
                if (queue.isEmpty()) {
                    System.out.println("No customers waiting");
                } else {
                    System.out.println("Waiting: " + queue);
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