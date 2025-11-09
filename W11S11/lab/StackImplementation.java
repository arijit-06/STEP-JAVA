import java.util.*;

class StackImplementation {
    private ArrayList<Integer> stack;
    
    public StackImplementation() {
        stack = new ArrayList<>();
    }
    
    public void push(int data) {
        stack.add(data);
        System.out.println("Pushed: " + data);
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack: " + stack);
        }
    }
    
    public static void main(String[] args) {
        StackImplementation stack = new StackImplementation();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        
        System.out.println("Peek: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.display();
        
        System.out.println("Is empty: " + stack.isEmpty());
    }
}