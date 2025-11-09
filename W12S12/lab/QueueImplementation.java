import java.util.*;

class QueueImplementation {
    private ArrayList<Integer> queue;
    
    public QueueImplementation() {
        queue = new ArrayList<>();
    }
    
    public void enqueue(int data) {
        queue.add(data);
        System.out.println("Enqueued: " + data);
    }
    
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.remove(0);
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.get(0);
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue: " + queue);
        }
    }
    
    public static void main(String[] args) {
        QueueImplementation queue = new QueueImplementation();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();
        
        System.out.println("Is empty: " + queue.isEmpty());
    }
}