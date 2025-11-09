import java.util.*;

public class TextEditorUndo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter command (TYPE <word>/UNDO/PRINT/EXIT): ");
            String cmd = sc.next();
            
            if (cmd.equals("TYPE")) {
                String word = sc.next();
                stack.push(word);
                System.out.println("Typed: " + word);
            } else if (cmd.equals("UNDO")) {
                if (!stack.isEmpty()) {
                    String removed = stack.pop();
                    System.out.println("Undone: " + removed);
                } else {
                    System.out.println("Nothing to undo");
                }
            } else if (cmd.equals("PRINT")) {
                if (stack.isEmpty()) {
                    System.out.println("Document is empty");
                } else {
                    System.out.print("Document: ");
                    for (String word : stack) {
                        System.out.print(word + " ");
                    }
                    System.out.println();
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