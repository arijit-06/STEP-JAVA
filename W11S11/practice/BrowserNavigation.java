import java.util.*;

public class BrowserNavigation {
    public static void main(String[] args) {
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String current = "Home";
        
        while (true) {
            System.out.print("Command (VISIT/BACK/FORWARD/PRINT/EXIT): ");
            String cmd = sc.next();
            
            if (cmd.equals("VISIT")) {
                String page = sc.next();
                backStack.push(current);
                current = page;
                forwardStack.clear();
                System.out.println("Visited: " + page);
            } else if (cmd.equals("BACK")) {
                if (!backStack.isEmpty()) {
                    forwardStack.push(current);
                    current = backStack.pop();
                    System.out.println("Back to: " + current);
                } else {
                    System.out.println("No previous page");
                }
            } else if (cmd.equals("FORWARD")) {
                if (!forwardStack.isEmpty()) {
                    backStack.push(current);
                    current = forwardStack.pop();
                    System.out.println("Forward to: " + current);
                } else {
                    System.out.println("No forward page");
                }
            } else if (cmd.equals("PRINT")) {
                System.out.println("Current Page: " + current);
            } else if (cmd.equals("EXIT")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
        sc.close();
    }
}