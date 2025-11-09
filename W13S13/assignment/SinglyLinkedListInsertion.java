import java.util.*;

class SinglyLinkedListInsertion {
    Node head;
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        
        if (position < 1) {
            System.out.println("Invalid position. Position should be >= 1");
            return;
        }
        
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        
        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedListInsertion list = new SinglyLinkedListInsertion();
        
        // Initialize with sample data
        list.insertAtPosition(10, 1);
        list.insertAtPosition(20, 2);
        list.insertAtPosition(30, 3);
        list.insertAtPosition(40, 4);
        
        System.out.println("Initial List:");
        list.display();
        
        System.out.print("Enter value to insert: ");
        int value = sc.nextInt();
        System.out.print("Enter position: ");
        int position = sc.nextInt();
        
        list.insertAtPosition(value, position);
        
        System.out.println("Updated List:");
        list.display();
        
        sc.close();
    }
}