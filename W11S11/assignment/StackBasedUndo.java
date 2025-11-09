import java.util.*;

class StackBasedUndo {
    private Stack<String> actions;
    private StringBuilder document;
    
    public StackBasedUndo() {
        actions = new Stack<>();
        document = new StringBuilder();
    }
    
    public void performAction(String action) {
        actions.push(document.toString());
        
        if (action.startsWith("ADD:")) {
            String text = action.substring(4);
            document.append(text);
            System.out.println("Added: " + text);
        } else if (action.equals("CLEAR")) {
            document.setLength(0);
            System.out.println("Document cleared");
        }
    }
    
    public void undo() {
        if (actions.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        
        String previousState = actions.pop();
        document.setLength(0);
        document.append(previousState);
        System.out.println("Undo performed");
    }
    
    public void showDocument() {
        if (document.length() == 0) {
            System.out.println("Document is empty");
        } else {
            System.out.println("Document: " + document.toString());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackBasedUndo editor = new StackBasedUndo();
        
        while (true) {
            System.out.print("Command (ADD:<text>/CLEAR/UNDO/SHOW/EXIT): ");
            String cmd = sc.nextLine();
            
            if (cmd.startsWith("ADD:")) {
                editor.performAction(cmd);
            } else if (cmd.equals("CLEAR")) {
                editor.performAction(cmd);
            } else if (cmd.equals("UNDO")) {
                editor.undo();
            } else if (cmd.equals("SHOW")) {
                editor.showDocument();
            } else if (cmd.equals("EXIT")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
        sc.close();
    }
}