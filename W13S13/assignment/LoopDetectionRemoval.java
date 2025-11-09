class LoopDetectionRemoval {
    Node head;
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public void insert(int data) {
        Node newNode = new Node(data);
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
    
    public void createLoop(int position) {
        if (head == null) return;
        
        Node temp = head;
        Node loopNode = null;
        int count = 1;
        
        while (temp.next != null) {
            if (count == position) {
                loopNode = temp;
            }
            temp = temp.next;
            count++;
        }
        
        if (loopNode != null) {
            temp.next = loopNode;
        }
    }
    
    public boolean detectAndRemoveLoop() {
        if (head == null || head.next == null) {
            return false;
        }
        
        Node slow = head;
        Node fast = head;
        
        // Detect loop using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                System.out.println("Loop detected!");
                removeLoop(slow);
                return true;
            }
        }
        
        System.out.println("No loop found");
        return false;
    }
    
    private void removeLoop(Node loopNode) {
        Node ptr1 = head;
        Node ptr2 = loopNode;
        
        // Find the start of the loop
        while (ptr1.next != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        // Remove the loop
        ptr2.next = null;
        System.out.println("Loop removed successfully!");
    }
    
    public void display() {
        Node temp = head;
        int count = 0;
        
        while (temp != null && count < 20) { // Limit to prevent infinite loop
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
            count++;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        LoopDetectionRemoval list = new LoopDetectionRemoval();
        
        // Create list: 10 → 20 → 30 → 40 → 50
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        
        System.out.println("Original List:");
        list.display();
        
        // Create loop: 50 points back to 30 (position 3)
        list.createLoop(3);
        System.out.println("Loop created: 50 points back to 30");
        
        // Detect and remove loop
        list.detectAndRemoveLoop();
        
        System.out.println("List after loop removal:");
        list.display();
    }
}