# Week 9 Session 9 (W9S9) - Object Class Methods and Inner Classes

## Overview
This session covers advanced Java concepts including Object class methods (toString, equals, hashCode, getClass, clone) and all types of inner classes (member, static nested, local, anonymous). Students will master professional Java development patterns and object-oriented design principles.

## 📚 Learning Objectives
- Master Object class method overriding and implementation
- Understand equals() and hashCode() contract and relationship
- Apply getClass() for runtime type checking and reflection
- Implement object cloning strategies (shallow vs deep copy)
- Create and use member inner classes for tight coupling
- Implement static nested classes for utility and organization
- Apply local inner classes for method-specific functionality
- Master anonymous inner classes for interface implementations

## 🎯 Practice Problems (6 Problems)

### Problem 1: Object Modeling & toString()
**File:** `practice/VehicleRental.java`
- Implement Vehicle class with proper toString() method
- Create vehicle rental system with object representation
- Demonstrate readable object output and getter methods

### Problem 2: equals(), ==, and hashCode()
**File:** `practice/EmployeeAuth.java`
- Override equals() and hashCode() for Employee class
- Compare reference equality (==) vs content equality (.equals())
- Test with HashSet to demonstrate duplicate handling

### Problem 3: getClass() Method Usage
**File:** `practice/PaymentGateway.java`
- Create payment hierarchy with runtime type checking
- Use getClass() for dynamic type identification
- Process polymorphic arrays with type-specific behavior

### Problem 4: clone(), Shallow vs Deep Copy
**File:** `practice/Registration.java`
- Implement Cloneable interface for Student and ContactInfo
- Demonstrate shallow cloning vs deep cloning differences
- Show impact of modifications on original vs cloned objects

### Problem 5: Member Inner Class
**File:** `practice/HospitalManagement.java`
- Create Hospital class with Department inner class
- Access outer class fields from inner class methods
- Demonstrate tight coupling between outer and inner classes

### Problem 6: Local Inner Class
**File:** `practice/VotingSystem.java`
- Implement local inner class for vote validation
- Access method parameters from local inner class
- Apply validation logic within method scope

## 🧪 Lab Problems (6 Problems)

### Lab 1: Comparing Objects Using equals() and ==
**File:** `lab/BookComparison.java`
- Create Book class with proper equals() implementation
- Demonstrate difference between == and .equals()
- Compare reference vs content equality with examples

### Lab 2: toString() and getClass() Usage
**File:** `lab/CarToString.java`
- Override toString() for meaningful object representation
- Use getClass() to obtain runtime class information
- Display both object details and class metadata

### Lab 3: hashCode() and equals() Contract
**File:** `lab/StudentHashCode.java`
- Implement consistent equals() and hashCode() methods
- Store objects in HashSet to verify duplicate prevention
- Demonstrate Objects.hash() utility usage

### Lab 4: Cloning an Object
**File:** `lab/PersonCloning.java`
- Create Person class with Address composition
- Implement both shallow and deep cloning strategies
- Compare effects of modifications on different clone types

### Lab 5: Member Inner Class
**File:** `lab/OuterInnerClass.java`
- Define non-static inner class with outer field access
- Create inner class instances using outer class reference
- Modify outer class state from inner class methods

### Lab 6: Static, Local, and Anonymous Inner Classes
**File:** `lab/CalculatorInnerClasses.java`
- Implement static nested class for utility operations
- Create local inner class within method scope
- Use anonymous inner class for interface implementation

## 📋 Assignment Problems (7 Problems)

### Assignment 1: Vehicle Rental System
**File:** `assignment/VehicleRental.java`
- Complete vehicle rental management system
- Implement toString() for vehicle representation
- Create comprehensive rental tracking functionality

### Assignment 2: Employee Authentication System
**File:** `assignment/EmployeeAuth.java`
- Build employee authentication with equals/hashCode
- Implement secure employee comparison and storage
- Create HashSet-based employee management system

### Assignment 3: Payment Gateway System
**File:** `assignment/PaymentGateway.java`
- Develop payment processing with getClass() usage
- Implement runtime type checking for payment methods
- Create flexible payment gateway architecture

### Assignment 4: Course Registration System
**File:** `assignment/Registration.java`
- Build student registration with object cloning
- Implement both shallow and deep copy strategies
- Manage student data with proper cloning techniques

### Assignment 5: Hospital Management System
**File:** `assignment/HospitalManagement.java`
- Create hospital system with member inner classes
- Implement department management within hospital context
- Demonstrate inner class access to outer class data

### Assignment 6: App Configuration System
**File:** `assignment/AppConfigurator.java`
- Implement static nested class for configuration
- Create network configuration management
- Demonstrate static nested class independence

### Assignment 7: Notification Service System
**File:** `assignment/NotificationService.java`
- Build notification system with anonymous inner classes
- Implement dynamic notification strategies
- Create flexible alert and messaging system

## 🛠️ Key Concepts Covered

### Object Class Methods
- **toString():** Custom string representation of objects
- **equals():** Logical equality comparison between objects
- **hashCode():** Hash code generation for hash-based collections
- **getClass():** Runtime type information and reflection
- **clone():** Object copying with shallow and deep strategies

### Inner Class Types
- **Member Inner Class:** Non-static inner class with outer instance access
- **Static Nested Class:** Static inner class independent of outer instance
- **Local Inner Class:** Class defined within method scope
- **Anonymous Inner Class:** Unnamed class for interface/class implementation

### Advanced Concepts
- **equals() and hashCode() Contract:** Consistent implementation rules
- **Cloneable Interface:** Object copying mechanism
- **Runtime Type Checking:** Dynamic type identification
- **Encapsulation Patterns:** Inner class access control
- **Interface Implementation:** Anonymous class usage

## 📊 Completion Requirements
- **Practice Problems:** Complete all 6 problems for foundational understanding
- **Lab Problems:** Complete all 6 problems for hands-on experience
- **Assignment Problems:** Complete all 7 problems for comprehensive mastery
- **Total:** 19 problems covering all Object methods and inner class concepts
- **Time Goal:** Aim to complete within 4-5 hours

## 🚀 Getting Started
1. Navigate to the W9S9 directory
2. Start with Practice Problems for concept introduction
3. Progress to Lab Problems for detailed implementation
4. Complete Assignment Problems for real-world applications
5. Test each implementation with various scenarios

## 📁 File Structure
```
W9S9/
├── README.md                           # This file
├── COMPLETION_STATUS.md                # Progress tracking
├── practice/                           # Practice Problems (6)
│   ├── VehicleRental.java             # Object Modeling & toString()
│   ├── EmployeeAuth.java              # equals(), ==, hashCode()
│   ├── PaymentGateway.java            # getClass() Usage
│   ├── Registration.java              # Cloning Strategies
│   ├── HospitalManagement.java        # Member Inner Class
│   └── VotingSystem.java              # Local Inner Class
├── lab/                               # Lab Problems (6)
│   ├── BookComparison.java            # equals() vs == Comparison
│   ├── CarToString.java               # toString() & getClass()
│   ├── StudentHashCode.java           # hashCode() Contract
│   ├── PersonCloning.java             # Object Cloning
│   ├── OuterInnerClass.java           # Member Inner Class
│   └── CalculatorInnerClasses.java    # All Inner Class Types
└── assignment/                        # Assignment Problems (7)
    ├── VehicleRental.java             # Vehicle Rental System
    ├── EmployeeAuth.java              # Employee Authentication
    ├── PaymentGateway.java            # Payment Gateway
    ├── Registration.java              # Registration System
    ├── HospitalManagement.java        # Hospital Management
    ├── AppConfigurator.java           # App Configuration
    └── NotificationService.java       # Notification Service
```

## 💡 Tips for Success
- Understand the equals() and hashCode() contract thoroughly
- Practice different cloning scenarios to grasp shallow vs deep copy
- Experiment with inner class access patterns and restrictions
- Focus on real-world applications of these advanced concepts
- Test object behavior in collections like HashSet and HashMap
- Pay attention to memory implications of different approaches

## 🔗 Related Topics
- **Prerequisites:** Complete OOP mastery (W3S3-W8S8)
- **Applications:** Framework development, design patterns, enterprise applications
- **Advanced Topics:** Reflection API, serialization, advanced design patterns

---
*This README covers essential advanced Java concepts crucial for professional software development and enterprise application design.*