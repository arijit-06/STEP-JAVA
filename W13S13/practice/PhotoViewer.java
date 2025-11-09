class PhotoViewer {
    class Node {
        String photo;
        Node next, prev;
        
        Node(String p) { 
            photo = p; 
        }
    }
    
    Node head, tail, current;
    
    public void addPhoto(String p) {
        Node newNode = new Node(p);
        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    public void nextPhoto() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Next → " + current.photo);
        } else {
            System.out.println("No next photo");
        }
    }
    
    public void prevPhoto() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Prev ← " + current.photo);
        } else {
            System.out.println("No previous photo");
        }
    }
    
    public void showCurrent() {
        if (current != null) {
            System.out.println("Current: " + current.photo);
        } else {
            System.out.println("No photos");
        }
    }
    
    public static void main(String[] args) {
        PhotoViewer viewer = new PhotoViewer();
        viewer.addPhoto("Pic1");
        viewer.addPhoto("Pic2");
        viewer.addPhoto("Pic3");
        
        viewer.showCurrent();
        viewer.nextPhoto();
        viewer.prevPhoto();
    }
}