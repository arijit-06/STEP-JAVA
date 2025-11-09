class TaskManager {
    Node head, tail;
    
    class Node {
        String taskName;
        int time;
        Node next;
        
        Node(String taskName, int time) {
            this.taskName = taskName;
            this.time = time;
            this.next = null;
        }
    }
    
    public void addTask(String taskName, int time) {
        Node newNode = new Node(taskName, time);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public void executeRoundRobin() {
        if (head == null) {
            System.out.println("No tasks to execute");
            return;
        }
        
        System.out.println("Execution order:");
        Node current = head;
        
        while (head != null) {
            System.out.print(current.taskName + " ");
            current.time--;
            
            if (current.time == 0) {
                System.out.print("(Completed) ");
                removeTask(current);
                if (head == null) break;
                current = head;
            } else {
                current = current.next;
            }
            
            System.out.print("→ ");
        }
        System.out.println("All Completed");
    }
    
    private void removeTask(Node taskToRemove) {
        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != taskToRemove) {
                temp = temp.next;
            }
            temp.next = taskToRemove.next;
            
            if (taskToRemove == head) {
                head = taskToRemove.next;
                tail.next = head;
            } else if (taskToRemove == tail) {
                tail = temp;
            }
        }
    }
    
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks");
            return;
        }
        
        Node temp = head;
        System.out.print("Tasks = [");
        do {
            System.out.print(temp.taskName + "(" + temp.time + "s)");
            temp = temp.next;
            if (temp != head) System.out.print(", ");
        } while (temp != head);
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        
        // Add tasks: T1(3s), T2(2s), T3(4s)
        tm.addTask("T1", 3);
        tm.addTask("T2", 2);
        tm.addTask("T3", 4);
        
        System.out.println("Initial tasks:");
        tm.displayTasks();
        
        System.out.println("\nExecuting round-robin scheduling:");
        tm.executeRoundRobin();
    }
}