class Student {
    private String name;
    private boolean formFilled = false;
    private boolean documentsUploaded = false;
    private boolean feesValid = false;
    private boolean feesPaid = false;
    private boolean confirmed = false;
    
    public Student(String name) {
        this.name = name;
    }
    
    public void fillForm() {
        System.out.println("[Start] " + name + " fills registration form");
        formFilled = true;
    }
    
    public void uploadDocuments() {
        if (formFilled) {
            System.out.println(name + " uploads documents");
            documentsUploaded = true;
            validateDocuments();
        }
    }
    
    private void validateDocuments() {
        System.out.println("[Decision] Validating documents...");
        boolean valid = true; // Assume valid for demo
        if (valid) {
            System.out.println("Documents are valid - proceed to payment");
            feesValid = true;
        } else {
            System.out.println("Invalid documents - return to upload");
        }
    }
    
    public void payFees() {
        if (feesValid) {
            System.out.println(name + " pays registration fees");
            feesPaid = true;
        }
    }
    
    public void getConfirmation() {
        if (feesPaid) {
            System.out.println(name + " receives confirmation");
            confirmed = true;
            System.out.println("[End] Registration process completed");
        }
    }
    
    public void showWorkflow() {
        System.out.println("\nActivity Diagram Workflow:");
        System.out.println("1. Fill Form -> 2. Upload Documents -> 3. Validate -> 4. Pay Fees -> 5. Get Confirmation");
    }
}

public class UniversityRegistration {
    public static void main(String[] args) {
        System.out.println("Activity Diagram - University Registration Process:");
        
        Student student = new Student("Raj");
        student.showWorkflow();
        
        student.fillForm();
        student.uploadDocuments();
        student.payFees();
        student.getConfirmation();
    }
}