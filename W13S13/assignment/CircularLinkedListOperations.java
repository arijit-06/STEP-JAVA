class CircularLinkedListOperations {
    Node head, tail;
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
    }
    
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (head == tail) {
            head = tail = null;
        } else {
            tail.next = head.next;
            head = head.next;
        }
    }
    
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = head;
            tail = temp;
        }
    }
    
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node temp = head;
        System.out.print("Circular List = [");
        do {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != head) System.out.print(" → ");
        } while (temp != head);
        System.out.println(" → back to " + head.data + "]");
    }
    
    public static void main(String[] args) {
        CircularLinkedListOperations list = new CircularLinkedListOperations();
        
        System.out.println("Inserting 10, 20, 30:");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.display();
        
        System.out.println("\nDeleting first element:");
        list.deleteAtBeginning();
        list.display();
        
        System.out.println("\nInserting 40 at end:");
        list.insertAtEnd(40);
        list.display();
    }
}