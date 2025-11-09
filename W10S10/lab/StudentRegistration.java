class Student {
    private String name;
    private boolean formFilled = false;
    private boolean documentsUploaded = false;
    private boolean feesPaid = false;
    private boolean confirmed = false;
    
    public Student(String name) {
        this.name = name;
    }
    
    public void fillForm() {
        System.out.println(name + " fills registration form");
        formFilled = true;
    }
    
    public void uploadDocuments() {
        if (formFilled) {
            System.out.println(name + " uploads documents");
            documentsUploaded = true;
        } else {
            System.out.println("Please fill form first");
        }
    }
    
    public void payFees() {
        if (documentsUploaded) {
            System.out.println(name + " pays registration fees");
            feesPaid = true;
        } else {
            System.out.println("Please upload documents first");
        }
    }
    
    public void getConfirmation() {
        if (feesPaid) {
            System.out.println(name + " receives registration confirmation");
            confirmed = true;
        } else {
            System.out.println("Please complete payment first");
        }
    }
    
    public void showStatus() {
        System.out.println("Registration Status for " + name + ": " + 
                         (confirmed ? "Completed" : "In Progress"));
    }
}

public class StudentRegistration {
    public static void main(String[] args) {
        Student student = new Student("Raj");
        
        student.fillForm();
        student.uploadDocuments();
        student.payFees();
        student.getConfirmation();
        student.showStatus();
    }
}