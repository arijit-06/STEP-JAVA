# Week 3 Session 3 (W3S3) - Object-Oriented Programming Fundamentals

## Overview
This session introduces core Object-Oriented Programming (OOP) concepts in Java, focusing on classes, objects, encapsulation, and real-world problem modeling. Students will learn to design and implement class hierarchies, understand static vs instance members, and build practical applications using OOP principles.

## 📚 Learning Objectives
- Master class definition and object creation in Java
- Understand encapsulation and data hiding principles
- Differentiate between static and instance members
- Implement constructors and method overloading
- Design object relationships and interactions
- Build real-world applications using OOP concepts

## 🎯 Practice Problems (6 Problems)

### Problem 1: Understanding Classes and Objects - Real World Analogy
**File:** `practice/Car.java`
- Create a Car class with attributes (brand, model, year, color, isRunning)
- Implement constructor and instance methods (startEngine, stopEngine, displayInfo, getAge)
- Demonstrate object creation and state management
- Show real-world analogy to physical cars

### Problem 2: Class Definition and Object Creation
**File:** `practice/Student.java`
- Design Student class with proper encapsulation (private variables)
- Implement default and parameterized constructors
- Create getter/setter methods for all attributes
- Add business logic methods (calculateLetterGrade, displayStudent)
- Demonstrate different object creation approaches

### Problem 3: Instance vs Static (Class) Members
**File:** `practice/BankAccount.java`
- Implement static variables (bankName, totalAccounts, interestRate)
- Create instance variables (accountNumber, accountHolder, balance)
- Demonstrate static vs instance method usage
- Show shared vs unique data across objects

### Problem 4: OOP Benefits - Reusability and Extensibility
**File:** `practice/Vehicle.java`
- Create base Vehicle class with common attributes and methods
- Demonstrate code reusability across different vehicle types
- Implement polymorphic behavior with Vehicle array
- Show extensibility benefits of OOP design

### Problem 5: Multiple Classes and Object Interaction
**File:** `practice/LibrarySystem.java`
- Design Book and Library classes with object relationships
- Implement object interaction methods (Library contains Books)
- Create search and inventory management functionality
- Demonstrate composition and aggregation concepts

### Problem 6: Complete OOP Application
**File:** `practice/EmployeeManagementSystem.java`
- Build comprehensive system with Employee and Department classes
- Implement static and instance members appropriately
- Create interactive menu system with full CRUD operations
- Demonstrate all OOP principles in a real-world application

## 🧪 Lab Practice Problems (6 Programs)

### Lab 1: Bank Account Management System
**File:** `lab/BankAccountManager.java`
- Create BankAccount class with private instance variables
- Implement automatic account number generation using static counter
- Add transaction methods with proper validation
- Demonstrate static vs instance variable differences using arrays

### Lab 2: Library Book Management System
**File:** `lab/LibraryBookManager.java`
- Design Book and Member classes with object relationships
- Implement book borrowing and returning functionality
- Create static methods for ID generation and statistics
- Show object interaction through borrowing system

### Lab 3: Employee Payroll System with Method Overloading
**File:** `lab/EmployeePayrollSystem.java`
- Create Employee class with multiple constructor overloads
- Implement overloaded calculateSalary methods for different employee types
- Add overloaded calculateTax methods with different rates
- Demonstrate method overloading with comprehensive payroll features

### Lab 4: Vehicle Rental System
**File:** `lab/VehicleRentalSystem.java`
- Design Vehicle class with static and instance members
- Implement rental calculation and availability management
- Create static methods for company-wide statistics
- Show shared static data vs unique instance data

### Lab 5: Product Inventory System
**File:** `lab/ProductInventorySystem.java`
- Create Product class with inventory management features
- Implement static methods for inventory analysis
- Add stock management with validation
- Generate comprehensive inventory reports

### Lab 6: School Management System
**File:** `lab/SchoolManagementSystem.java`
- Design Student, Teacher, and Subject classes
- Implement grade assignment and calculation systems
- Create static methods for school-wide statistics
- Demonstrate complex object interactions

## 📝 Assignment Practice - Real-World Applications (8 Assignments)

### Assignment 1: Personal Finance Manager
**File:** `assignment/PersonalFinanceManager.java`
- Create PersonalAccount class with income/expense tracking
- Implement static variables for bank-wide data
- Add transaction methods with descriptions
- Generate comprehensive financial reports

### Assignment 2: Online Shopping Cart System
**File:** `assignment/OnlineShoppingCart.java`
- Design Product and ShoppingCart classes
- Implement cart operations (add, remove, calculate total)
- Create menu-driven shopping interface
- Demonstrate object relationships and interactions

### Assignment 3: Hotel Reservation System
**File:** `assignment/HotelReservationSystem.java`
- Create Room, Guest, and Booking classes
- Implement complete reservation workflow
- Add static methods for hotel statistics
- Generate occupancy and revenue reports

### Assignment 4: Student Grade Management System
**File:** `assignment/StudentGradeManager.java`
- Design Student and Subject classes
- Implement GPA calculation and grade categorization
- Create static methods for class-wide analysis
- Generate comprehensive academic reports

### Assignment 5: Library Management with Fine Calculation
**File:** `assignment/LibraryManagementSystem.java`
- Create Book and Member classes with fine calculation
- Implement different member types with varying privileges
- Add automatic fine calculation for overdue books
- Generate library usage and financial reports

### Assignment 6: Employee Payroll and Attendance System
**File:** `assignment/EmployeePayrollAttendance.java`
- Design Employee and Department classes
- Implement attendance tracking and payroll calculation
- Create different employee types with unique salary calculations
- Generate HR reports and statistics

### Assignment 7: Vehicle Fleet Management System
**File:** `assignment/VehicleFleetManager.java`
- Create base Vehicle class with specific vehicle types
- Implement Driver class and vehicle assignment
- Add maintenance scheduling and cost tracking
- Generate fleet utilization and cost analysis

### Assignment 8: Hospital Patient Management System
**File:** `assignment/HospitalPatientManager.java`
- Design Patient, Doctor, and Appointment classes
- Implement appointment scheduling and billing
- Create different appointment types with varying rates
- Generate hospital statistics and revenue reports

## 🛠️ Key Concepts Covered

### Class Design Principles
- Proper encapsulation with private variables
- Public methods for controlled access
- Constructor design (default and parameterized)
- Method overloading for flexibility

### Static vs Instance Members
- Static variables for shared data
- Instance variables for object-specific data
- Static methods for utility functions
- Instance methods for object behavior

### Object Relationships
- Composition (has-a relationship)
- Aggregation (uses-a relationship)
- Object interaction through method calls
- Array of objects for collections

### Real-World Modeling
- Identifying classes from problem domains
- Defining appropriate attributes and methods
- Implementing business logic and validation
- Creating user-friendly interfaces

## 📊 Completion Requirements
- **Practice Problems:** Complete all 6 problems
- **Lab Exercises:** Complete all 6 programs  
- **Assignments:** Complete all 8 assignments
- **Total Programs:** 20 programs

## 🚀 Getting Started
1. Navigate to the W3S3 directory
2. Start with Practice Problems to understand basic OOP concepts
3. Progress to Lab exercises for hands-on implementation
4. Complete all Assignments for comprehensive real-world applications
5. Use COMPLETION_STATUS.md to track your progress

## 📁 File Structure
```
W3S3/
├── README.md                           # This file
├── COMPLETION_STATUS.md                # Progress tracking
├── practice/                           # Practice Problems (6)
│   ├── Car.java
│   ├── Student.java
│   ├── BankAccount.java
│   ├── Vehicle.java
│   ├── LibrarySystem.java
│   └── EmployeeManagementSystem.java
├── lab/                               # Lab Exercises (6)
│   ├── BankAccountManager.java
│   ├── LibraryBookManager.java
│   ├── EmployeePayrollSystem.java
│   ├── VehicleRentalSystem.java
│   ├── ProductInventorySystem.java
│   └── SchoolManagementSystem.java
└── assignment/                        # Assignments (8)
    ├── PersonalFinanceManager.java
    ├── OnlineShoppingCart.java
    ├── HotelReservationSystem.java
    ├── StudentGradeManager.java
    ├── LibraryManagementSystem.java
    ├── EmployeePayrollAttendance.java
    ├── VehicleFleetManager.java
    └── HospitalPatientManager.java
```

## 💡 Tips for Success
- Focus on proper class design before implementation
- Use meaningful class and method names
- Implement proper encapsulation with private variables
- Test object interactions thoroughly
- Practice identifying real-world objects and their relationships
- Use static members appropriately for shared data
- Implement comprehensive error handling and validation

## 🔗 Related Topics
- **Previous Session (W2S2):** Advanced String Methods and StringBuilder
- **Next Session (W4S4):** Advanced OOP Concepts (Inheritance & Polymorphism)
- **Prerequisites:** Basic Java syntax, control structures, and string manipulation
- **Applications:** Software design, system architecture, enterprise applications

## 🎯 Learning Outcomes
After completing W3S3, you will be able to:
- ✅ Design and implement well-structured classes
- ✅ Create objects and manage their lifecycle
- ✅ Apply encapsulation principles effectively
- ✅ Use static and instance members appropriately
- ✅ Model real-world problems using OOP concepts
- ✅ Build interactive applications with multiple classes
- ✅ Implement object relationships and interactions
- ✅ Apply OOP principles to solve complex problems

---
*This session provides the foundation for advanced OOP concepts and prepares students for inheritance, polymorphism, and design patterns in subsequent sessions.*