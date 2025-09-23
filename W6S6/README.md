# Week 6 Session 6 (W6S6) - Inheritance Hierarchies

## Overview
This session focuses on complex inheritance hierarchies, combining multilevel and hierarchical inheritance patterns. Students will master advanced inheritance concepts, constructor chaining, method overriding, and polymorphism in sophisticated class structures.

## 📚 Learning Objectives
- Master complex inheritance hierarchies (multilevel + hierarchical)
- Implement sophisticated constructor chaining patterns
- Apply advanced method overriding and polymorphism
- Design real-world systems using inheritance patterns
- Understand inheritance best practices and design principles

## 🛠️ Practice Problems (3 Problems)

### Problem 1: Single Inheritance with extends and super
**File:** `practice/VehicleInheritanceSystem.java`
- Implement comprehensive Vehicle → Car inheritance
- Demonstrate constructor chaining with super()
- Master method overriding and polymorphic behavior
- Apply access modifiers in inheritance context

### Problem 2: Multilevel Inheritance Chain
**File:** `practice/AnimalKingdomHierarchy.java`
- Build Animal → Mammal → Dog inheritance chain
- Implement constructor chaining across multiple levels
- Override methods at different inheritance levels
- Demonstrate IS-A relationships through the chain

### Problem 3: Hierarchical Inheritance with Method Overriding
**File:** `practice/EmployeeManagementHierarchy.java`
- Create Employee base with Developer, Manager, Intern subclasses
- Implement different overriding strategies for same methods
- Use polymorphic arrays for diverse behavior
- Apply template method pattern and final methods

## 🧪 Lab Practice Programs (6 Programs)

### Lab 1: Fruit and Apple Classes
**File:** `lab/BasicInheritanceDemo.java`
- Basic single inheritance with Fruit → Apple
- Protected fields and inheritance access
- Simple method overriding examples

### Lab 2: Phone and SmartPhone Constructors
**File:** `lab/ConstructorChainingDemo.java`
- Constructor chaining with super()
- Multiple constructor patterns
- Trace execution order with print statements

### Lab 3: Bird Flying Behavior
**File:** `lab/PolymorphismDemo.java`
- Method overriding with @Override annotation
- Polymorphic behavior with Bird array
- Different implementations in subclasses

### Lab 4: Color Hierarchy Chain
**File:** `lab/MultilevelInheritanceDemo.java`
- Multilevel inheritance: Color → PrimaryColor → RedColor
- Constructor chaining through all levels
- Progressive property addition at each level

### Lab 5: Musical Instrument Family
**File:** `lab/HierarchicalInheritanceDemo.java`
- Hierarchical inheritance with Instrument base
- Piano, Guitar, Drum extending Instrument
- Common fields with specific additions

### Lab 6: Box and Gift Box Enhancement
**File:** `lab/SuperMethodCallsDemo.java`
- Override methods while using super functionality
- Enhanced behavior preserving original functionality
- Demonstrate super method calls in overrides

## 📝 Assignment Practice - Homework Tasks (6 Tasks)

### Assignment 1: Light and LED Multiple Constructors
**File:** `assignment/ConstructorChainingSystem.java`
- Constructor chaining with this() and super()
- Multiple constructor patterns in inheritance
- Print statements to trace constructor calls

### Assignment 2: Tool Access Levels
**File:** `assignment/AccessModifierSystem.java`
- Access modifiers in inheritance (private, protected, public)
- Test field accessibility from child classes
- Getter methods for private fields

### Assignment 3: Game and Card Game Objects
**File:** `assignment/ObjectMethodOverriding.java`
- Override Object methods (toString, equals, hashCode)
- Call super.toString() in child overrides
- Test object equality and string representation

### Assignment 4: Food Preparation Template
**File:** `assignment/TemplateMethodPattern.java`
- Template method pattern implementation
- Abstract preparation steps with concrete implementations
- Different food types with unique cooking methods

### Assignment 5: Math Operations Inheritance
**File:** `assignment/MathOperationsHierarchy.java`
- Inheritance with method overloading
- BasicMath with overloaded calculate() methods
- AdvancedMath extending with more overloaded methods

### Assignment 6: Weather System Hierarchy
**File:** `assignment/CompleteInheritanceSystem.java`
- Complete inheritance implementation
- Multilevel: Weather → Storm → Thunderstorm
- Hierarchical: Weather → Sunshine
- Constructor chaining and polymorphism testing

## 🛠️ Key Concepts Covered

### Advanced Inheritance Patterns
- Multilevel inheritance (A → B → C)
- Hierarchical inheritance (A → B, A → C, A → D)
- Combining both patterns in complex systems
- Diamond problem awareness and solutions

### Constructor Chaining Mastery
- Complex super() call patterns
- this() calls within inheritance hierarchies
- Parameter passing through multiple levels
- Constructor execution order in deep hierarchies

### Method Overriding Excellence
- @Override annotation best practices
- Calling parent methods with super.method()
- Method hiding vs method overriding
- Final methods and inheritance restrictions

### Polymorphism Applications
- Runtime method resolution in deep hierarchies
- Arrays of base type with multiple subclass levels
- instanceof operator with complex hierarchies
- Type casting and safe downcasting

### Design Principles
- Liskov Substitution Principle
- Open/Closed Principle in inheritance
- Composition vs Inheritance decisions
- Interface segregation in class hierarchies

## 📊 Completion Requirements
- **Practice Problems:** Complete all 3 problems
- **Lab Exercises:** Complete all 6 programs
- **Homework Assignments:** Complete all 6 tasks

## 🚀 Getting Started
1. Navigate to the W6S6 directory
2. Start with Practice Problems for comprehensive inheritance understanding
3. Progress through Lab exercises for specific inheritance patterns
4. Complete Homework assignments for advanced inheritance applications
5. Focus on understanding complex inheritance relationships

## 📁 File Structure
```
W6S6/
├── README.md                           # This file
├── COMPLETION_STATUS.md                # Progress tracking
├── practice/                           # Practice Problems (3)
│   ├── VehicleInheritanceSystem.java
│   ├── AnimalKingdomHierarchy.java
│   └── EmployeeManagementHierarchy.java
├── lab/                               # Lab Exercises (6)
│   ├── BasicInheritanceDemo.java
│   ├── ConstructorChainingDemo.java
│   ├── PolymorphismDemo.java
│   ├── MultilevelInheritanceDemo.java
│   ├── HierarchicalInheritanceDemo.java
│   └── SuperMethodCallsDemo.java
└── assignment/                        # Homework Assignments (6)
    ├── ConstructorChainingSystem.java
    ├── AccessModifierSystem.java
    ├── ObjectMethodOverriding.java
    ├── TemplateMethodPattern.java
    ├── MathOperationsHierarchy.java
    └── CompleteInheritanceSystem.java
```

## 💡 Tips for Success
- Draw inheritance diagrams before coding complex hierarchies
- Always use @Override annotation when overriding methods
- Understand the difference between method overriding and hiding
- Test constructor chaining by adding print statements
- Use meaningful class hierarchies that represent real-world relationships
- Practice polymorphism with arrays of parent references
- Pay attention to access modifier restrictions in deep hierarchies

## 🔗 Related Topics
- **Previous Session (W5S5):** Static Methods & Advanced Design
- **Prerequisites:** Advanced OOP concepts, method overriding, polymorphism
- **Applications:** Framework development, game engines, enterprise systems
- **Next Steps:** Abstract classes, interfaces, advanced design patterns

---
*This final OOP session consolidates all inheritance concepts into sophisticated, real-world applicable class hierarchies.*