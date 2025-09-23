// File: EmployeeManagementHierarchy.java
// PRACTICE PROBLEM 3: Hierarchical Inheritance with Method Overriding

public class EmployeeManagementHierarchy {
    
    public static class Employee {
        protected String employeeId;
        protected String name;
        protected double baseSalary;
        protected String department;
        
        public Employee(String employeeId, String name, double baseSalary, String department) {
            this.employeeId = employeeId;
            this.name = name;
            this.baseSalary = baseSalary;
            this.department = department;
            System.out.println("Employee created: " + name);
        }
        
        public double calculateSalary() {
            return baseSalary;
        }
        
        public String getJobDescription() {
            return "General Employee";
        }
        
        public void performWork() {
            System.out.println("Employee is working");
        }
        
        public final String getEmployeeId() {
            return employeeId;
        }
        
        public void displayInfo() {
            System.out.println(name + " (" + employeeId + ") - " + getJobDescription() + 
                             " - Salary: $" + calculateSalary());
        }
    }
    
    public static class Developer extends Employee {
        private String[] programmingLanguages;
        private String experienceLevel;
        
        public Developer(String employeeId, String name, double baseSalary, 
                        String[] languages, String experience) {
            super(employeeId, name, baseSalary, "Engineering");
            this.programmingLanguages = languages;
            this.experienceLevel = experience;
        }
        
        @Override
        public double calculateSalary() {
            double bonus = experienceLevel.equals("Senior") ? 20000 : 
                          experienceLevel.equals("Mid") ? 10000 : 5000;
            return baseSalary + bonus;
        }
        
        @Override
        public String getJobDescription() {
            return "Software Developer (" + experienceLevel + ")";
        }
        
        @Override
        public void performWork() {
            System.out.println("Developer is coding in " + String.join(", ", programmingLanguages));
        }
        
        public void codeReview() {
            System.out.println("Developer is reviewing code");
        }
    }
    
    public static class Manager extends Employee {
        private int teamSize;
        private String managementLevel;
        
        public Manager(String employeeId, String name, double baseSalary, 
                      int teamSize, String level) {
            super(employeeId, name, baseSalary, "Management");
            this.teamSize = teamSize;
            this.managementLevel = level;
        }
        
        @Override
        public double calculateSalary() {
            double teamBonus = teamSize * 2000;
            double levelBonus = managementLevel.equals("Senior") ? 25000 : 15000;
            return baseSalary + teamBonus + levelBonus;
        }
        
        @Override
        public String getJobDescription() {
            return managementLevel + " Manager";
        }
        
        @Override
        public void performWork() {
            System.out.println("Manager is coordinating " + teamSize + " team members");
        }
        
        public void conductMeeting() {
            System.out.println("Manager is conducting team meeting");
        }
    }
    
    public static class Intern extends Employee {
        private String university;
        private int duration;
        
        public Intern(String employeeId, String name, String university, int duration) {
            super(employeeId, name, 1500, "Internship");
            this.university = university;
            this.duration = duration;
        }
        
        @Override
        public double calculateSalary() {
            return baseSalary; // Fixed stipend
        }
        
        @Override
        public String getJobDescription() {
            return "Intern from " + university;
        }
        
        @Override
        public void performWork() {
            System.out.println("Intern is learning and assisting");
        }
        
        public void attendTraining() {
            System.out.println("Intern is attending training session");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Employee Management Hierarchy ===");
        
        Employee[] employees = {
            new Developer("DEV001", "Alice", 80000, new String[]{"Java", "Python"}, "Senior"),
            new Manager("MGR001", "Bob", 90000, 5, "Senior"),
            new Intern("INT001", "Carol", "MIT", 6),
            new Developer("DEV002", "David", 70000, new String[]{"JavaScript", "React"}, "Mid")
        };
        
        System.out.println("\n=== Employee Information ===");
        for (Employee emp : employees) {
            emp.displayInfo();
        }
        
        System.out.println("\n=== Polymorphic Work Performance ===");
        for (Employee emp : employees) {
            emp.performWork();
        }
        
        System.out.println("\n=== Type-specific Methods ===");
        for (Employee emp : employees) {
            if (emp instanceof Developer) {
                ((Developer) emp).codeReview();
            } else if (emp instanceof Manager) {
                ((Manager) emp).conductMeeting();
            } else if (emp instanceof Intern) {
                ((Intern) emp).attendTraining();
            }
        }
    }
}