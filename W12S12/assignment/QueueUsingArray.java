class QueueUsingArray {
    private int[] queue;
    private int front, rear, size, capacity;
    
    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        queue[rear] = data;
        size++;
        System.out.println("Enqueued: " + data);
    }
    
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int data = queue[front];
        front++;
        size--;
        return data;
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue: [");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i]);
            if (i < rear) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(5);
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();
        
        System.out.println("Peek: " + queue.peek());
        System.out.println("Is full: " + queue.isFull());
    }
}