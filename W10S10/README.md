# W10S10 - UML Diagrams and Object-Oriented Design

## 📚 Session Overview

This session focuses on UML (Unified Modeling Language) diagrams and their Java implementations, covering system design, object relationships, and behavioral modeling.

## 🎯 Learning Objectives

By the end of this session, you will be able to:

- ✅ Understand and implement Class Diagrams in Java
- ✅ Create Object Diagrams showing runtime instances
- ✅ Model Sequence Diagrams for method interactions
- ✅ Design Use Case Diagrams for functional requirements
- ✅ Build Activity Diagrams for workflow processes
- ✅ Implement State Diagrams for object lifecycles
- ✅ Apply composition vs association relationships
- ✅ Translate UML designs to working Java code

## 📖 Topics Covered

### 🏗️ Structural Diagrams
- **Class Diagrams:** System structure and relationships
- **Object Diagrams:** Runtime instances and links
- **Composition vs Association:** Ownership relationships

### 🔄 Behavioral Diagrams
- **Sequence Diagrams:** Method interaction over time
- **Use Case Diagrams:** Functional system overview
- **Activity Diagrams:** Workflow and process modeling
- **State Diagrams:** Object lifecycle management

### 🎯 Design Patterns
- **Aggregation:** Has-a relationships
- **Composition:** Part-of relationships
- **Association:** Uses-a relationships
- **Multiplicity:** One-to-many mappings

## 🚀 Problem Categories

### Practice Problems (3 Problems)
1. **LibraryManagement** - Class diagram with composition/association
2. **OnlineShopping** - Object diagram with runtime instances
3. **ATMTransaction** - Sequence diagram with method interactions

### Lab Problems (Any 4 of 6)
1. **LibrarySystem** - Class diagram structure
2. **StudentTeacher** - Object diagram instances
3. **OnlineOrder** - Sequence diagram flow
4. **ATMSystem** - Use case diagram
5. **StudentRegistration** - Activity diagram workflow
6. **OrderLifecycle** - State diagram transitions

### Assignment Problems (Any 4 of 6)
1. **BankAccountSystem** - Class diagram with relationships
2. **RuntimeInstances** - Object diagram implementation
3. **OnlineShoppingFlow** - Sequence diagram modeling
4. **HospitalManagement** - Use case diagram design
5. **UniversityRegistration** - Activity diagram process
6. **TicketLifecycle** - State diagram implementation

## 📁 File Structure

```
W10S10/
├── README.md
├── COMPLETION_STATUS.md
├── practice/
│   ├── LibraryManagement/
│   │   ├── Book.java
│   │   ├── Library.java
│   │   ├── Member.java
│   │   └── LibraryDemo.java
│   ├── OnlineShopping/
│   │   ├── Product.java
│   │   ├── Order.java
│   │   ├── Customer.java
│   │   └── ShoppingDemo.java
│   └── ATMTransaction/
│       ├── BankAccount.java
│       ├── ATM.java
│       ├── Customer.java
│       └── ATMDemo.java
├── lab/
│   ├── LibrarySystem.java
│   ├── StudentTeacher.java
│   ├── OnlineOrder.java
│   ├── ATMSystem.java
│   ├── StudentRegistration.java
│   └── OrderLifecycle.java
└── assignment/
    ├── BankAccountSystem.java
    ├── RuntimeInstances.java
    ├── OnlineShoppingFlow.java
    ├── HospitalManagement.java
    ├── UniversityRegistration.java
    └── TicketLifecycle.java
```

## 🎯 Key UML Concepts

### Class Diagram Elements
- **Classes:** Attributes, methods, visibility
- **Relationships:** Association, aggregation, composition
- **Multiplicity:** 1..1, 1..*, 0..* notations
- **Inheritance:** Generalization relationships

### Object Diagram Features
- **Instance representation:** object:Class notation
- **Attribute values:** Runtime data display
- **Links:** Actual connections between objects
- **Snapshot view:** System state at specific time

### Sequence Diagram Components
- **Lifelines:** Participant objects
- **Messages:** Method calls and returns
- **Activation boxes:** Method execution time
- **Time ordering:** Top-to-bottom flow

## 💡 Implementation Tips

### Design Principles
- **Single Responsibility:** Each class has one purpose
- **Encapsulation:** Private attributes, public methods
- **Composition over Inheritance:** Prefer has-a over is-a
- **Loose Coupling:** Minimize dependencies

### Relationship Mapping
- **Association:** Independent objects with references
- **Aggregation:** Whole-part with independent lifecycle
- **Composition:** Whole-part with dependent lifecycle
- **Inheritance:** Is-a relationships with extends

## 📊 Completion Requirements

- **Practice:** Complete all 3 problems (12 files total)
- **Lab:** Complete any 4 out of 6 problems
- **Assignment:** Complete any 4 out of 6 problems
- **Total:** 11 programs minimum

## 🎓 Real-World Applications

- **Software Architecture:** System design and documentation
- **Database Design:** Entity-relationship modeling
- **Business Process:** Workflow automation
- **System Analysis:** Requirements gathering and modeling
- **Team Communication:** Visual system representation

---

**Master UML modeling and system design! 🏗️**