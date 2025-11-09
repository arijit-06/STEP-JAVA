class DoublyLinkedListDeletion {
    Node head, tail;
    
    class Node {
        int data;
        Node prev, next;
        
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    public void deleteAll(int value) {
        Node current = head;
        
        while (current != null) {
            if (current.data == value) {
                Node nodeToDelete = current;
                current = current.next;
                
                // Update prev pointer
                if (nodeToDelete.prev != null) {
                    nodeToDelete.prev.next = nodeToDelete.next;
                } else {
                    head = nodeToDelete.next;
                }
                
                // Update next pointer
                if (nodeToDelete.next != null) {
                    nodeToDelete.next.prev = nodeToDelete.prev;
                } else {
                    tail = nodeToDelete.prev;
                }
            } else {
                current = current.next;
            }
        }
    }
    
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" ⇄ ");
            temp = temp.next;
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        DoublyLinkedListDeletion list = new DoublyLinkedListDeletion();
        
        // Create list: [10 ⇄ 20 ⇄ 30 ⇄ 20 ⇄ 40]
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(20);
        list.insert(40);
        
        System.out.println("Original List:");
        list.display();
        
        System.out.println("Deleting all occurrences of 20...");
        list.deleteAll(20);
        
        System.out.println("List after deletion:");
        list.display();
    }
}