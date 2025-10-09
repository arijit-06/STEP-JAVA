/*
Problem 4: clone(), Shallow vs Deep Copy
Problem: "Course Registration System"
*/

class ContactInfo implements Cloneable {
    private String email;
    private String phone;
    
    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString() {
        return "ContactInfo{email='" + email + "', phone='" + phone + "'}";
    }
    
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
}

class Student implements Cloneable {
    private String id;
    private String name;
    private ContactInfo contact;
    
    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
    
    // TODO: Implement shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy
    }
    
    // TODO: Implement deep copy
    public Student deepClone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.contact = (ContactInfo) this.contact.clone(); // Deep copy of ContactInfo
        return cloned;
    }
    
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', contact=" + contact + "}";
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    public ContactInfo getContact() { return contact; }
    public void setContact(ContactInfo contact) { this.contact = contact; }
}

public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("=== Course Registration System - Cloning Demo ===");
        
        // 1. Register student, clone (shallow and deep), change contact, observe results
        ContactInfo originalContact = new ContactInfo("john@email.com", "123-456-7890");
        Student originalStudent = new Student("S001", "John Doe", originalContact);
        
        System.out.println("\n--- Original Student ---");
        System.out.println("Original: " + originalStudent);
        
        // Shallow Clone
        System.out.println("\n--- Shallow Clone Test ---");
        Student shallowClone = (Student) originalStudent.clone();
        System.out.println("Shallow Clone: " + shallowClone);
        
        // Modify contact in original student
        originalStudent.getContact().setEmail("john.updated@email.com");
        originalStudent.getContact().setPhone("987-654-3210");
        
        System.out.println("\nAfter modifying original student's contact:");
        System.out.println("Original: " + originalStudent);
        System.out.println("Shallow Clone: " + shallowClone);
        System.out.println("Contact objects are same: " + (originalStudent.getContact() == shallowClone.getContact()));
        
        // Deep Clone
        System.out.println("\n--- Deep Clone Test ---");
        ContactInfo newContact = new ContactInfo("jane@email.com", "555-123-4567");
        Student student2 = new Student("S002", "Jane Smith", newContact);
        
        Student deepClone = student2.deepClone();
        System.out.println("Original Student2: " + student2);
        System.out.println("Deep Clone: " + deepClone);
        
        // Modify contact in original student2
        student2.getContact().setEmail("jane.updated@email.com");
        student2.getContact().setPhone("555-999-8888");
        
        System.out.println("\nAfter modifying original student2's contact:");
        System.out.println("Original Student2: " + student2);
        System.out.println("Deep Clone: " + deepClone);
        System.out.println("Contact objects are same: " + (student2.getContact() == deepClone.getContact()));
        
        System.out.println("\n=== Key Differences ===");
        System.out.println("Shallow Copy: Copies object references (shared objects)");
        System.out.println("Deep Copy: Creates new instances of referenced objects");
    }
}