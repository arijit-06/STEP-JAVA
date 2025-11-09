class DoublyLinkedListSort {
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
    
    public void bubbleSort() {
        if (head == null) return;
        
        boolean swapped;
        Node current;
        
        do {
            swapped = false;
            current = head;
            
            while (current.next != null) {
                if (current.data > current.next.data) {
                    // Swap data
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
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
        DoublyLinkedListSort list = new DoublyLinkedListSort();
        
        // Create unsorted list: [40 ⇄ 10 ⇄ 30 ⇄ 20]
        list.insert(40);
        list.insert(10);
        list.insert(30);
        list.insert(20);
        
        System.out.println("Original List:");
        list.display();
        
        System.out.println("Sorting using Bubble Sort...");
        list.bubbleSort();
        
        System.out.println("Sorted List:");
        list.display();
    }
}