import java.util.*;

class StudentRecord {
    Node head;
    
    class Node {
        int rollNo;
        Node next;
        
        Node(int r) {
            rollNo = r;
            next = null;
        }
    }
    
    public void insert(int rollNo) {
        Node newNode = new Node(rollNo);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
    public void display() {
        if (head == null) {
            System.out.println("No students found");
            return;
        }
        System.out.print("Students: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.rollNo);
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecord list = new StudentRecord();
        
        while (true) {
            System.out.print("Command (ADD <roll>/SHOW/EXIT): ");
            String cmd = sc.next();
            
            if (cmd.equals("ADD")) {
                int roll = sc.nextInt();
                list.insert(roll);
                System.out.println("Added student: " + roll);
            } else if (cmd.equals("SHOW")) {
                list.display();
            } else if (cmd.equals("EXIT")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
        sc.close();
    }
}