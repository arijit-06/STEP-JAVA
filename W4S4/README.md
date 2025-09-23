# Week 4 Session 4 (W4S4) - Advanced OOP Concepts

## Overview
This session focuses on advanced Object-Oriented Programming concepts including inheritance, polymorphism, method overriding, constructor chaining, and access modifiers. Students will build complex systems that demonstrate real-world applications of OOP principles.

## 📚 Learning Objectives
- Master inheritance relationships and constructor chaining
- Implement method overriding with proper @Override annotation
- Understand access modifiers and their impact on inheritance
- Apply polymorphism in practical scenarios
- Build hierarchical class structures for complex systems

## 🛠️ Practice Problems (4 Problems)

### Problem 1: Single Inheritance with extends and super
**File:** `practice/VirtualPetSimulator.java`
- Implement Vehicle base class with protected fields
- Create Car subclass extending Vehicle
- Demonstrate constructor chaining with super()
- Override methods while calling parent implementations

### Problem 2: Multilevel Inheritance Chain
**File:** `practice/SpaceStationCrew.java`
- Build Animal → Mammal → Dog inheritance chain
- Implement constructor chaining across multiple levels
- Override methods at different inheritance levels
- Demonstrate IS-A relationships through the chain

### Problem 3: Hierarchical Inheritance with Method Overriding
**File:** `practice/MedievalKingdomBuilder.java`
- Create Employee base class with multiple subclasses
- Implement Developer, Manager, Intern extending Employee
- Override methods differently in each subclass
- Use polymorphic arrays for diverse behavior

### Problem 4: Interactive Story Generator
**File:** `practice/InteractiveStoryGenerator.java`
- Combine all inheritance concepts in a story system
- Implement character hierarchies with unique abilities
- Demonstrate polymorphism through character interactions
- Use method overriding for character-specific behaviors

## 🧪 Lab Practice Programs (6 Programs)

### Lab 1: Fruit and Apple Classes
**File:** `class_practice/BookManagement.java`
- Basic single inheritance with Fruit → Apple
- Protected fields and inheritance access
- Test inherited field accessibility

### Lab 2: Phone and SmartPhone Constructors
**File:** `class_practice/SmartDeviceNetwork.java`
- Constructor chaining with super()
- Print statements to trace execution order
- Multiple constructor combinations

### Lab 3: Bird Flying Behavior
**File:** `class_practice/AnimalTypeChecker.java`
- Method overriding with @Override annotation
- Polymorphic behavior with Bird array
- Different implementations in subclasses

### Lab 4: Color Hierarchy Chain
**File:** `class_practice/AudioMixerStudio.java`
- Multilevel inheritance: Color → PrimaryColor → RedColor
- Constructor chaining through all levels
- Progressive property addition

### Lab 5: Musical Instrument Family
**File:** `class_practice/GameControllerConfig.java`
- Hierarchical inheritance with Instrument base
- Piano, Guitar, Drum extending Instrument
- Common fields with specific additions

### Lab 6: Box and Gift Box Enhancement
**File:** `class_practice/ObjectCounter.java`
- Override methods while using super functionality
- Enhanced behavior preserving original functionality
- Demonstrate super method calls in overrides

## 📝 Assignment Practice - Homework Tasks (5 Tasks)

### Assignment 1: Light and LED Multiple Constructors
**File:** `assignment/BankAccountSystem.java`
- Constructor chaining with this() and super()
- Print statements to trace constructor calls
- Multiple constructor patterns

### Assignment 2: Tool Access Levels
**File:** `assignment/FitnessTracker.java`
- Access modifiers in inheritance (private, protected, public)
- Test field accessibility from child classes
- Getter methods for private fields

### Assignment 3: Game and Card Game Objects
**File:** `assignment/FoodDeliveryOrder.java`
- Override Object methods (toString, equals, hashCode)
- Call super.toString() in child overrides
- Test object equality and string representation

### Assignment 4: Food Preparation Template
**File:** `assignment/LibraryBookManagement.java`
- Template method pattern implementation
- Abstract preparation steps with concrete implementations
- Pizza and Soup with different cooking methods

### Assignment 5: Weather System Hierarchy
**File:** `assignment/MovieTicketBooking.java`
- Complete inheritance implementation
- Multilevel and hierarchical inheritance
- Constructor chaining and polymorphism testing

## 🛠️ Key Concepts Covered

### Inheritance Fundamentals
- `extends` keyword usage
- IS-A relationship establishment
- Protected field access in subclasses
- Method inheritance and overriding

### Constructor Chaining
- `super()` calls to parent constructors
- `this()` calls within same class
- Constructor execution order
- Parameter passing through inheritance chain

### Method Overriding
- `@Override` annotation benefits
- Calling parent methods with `super.method()`
- Polymorphic method resolution
- Final methods that cannot be overridden

### Access Modifiers in Inheritance
- Private fields requiring getter/setter access
- Protected fields accessible to subclasses
- Public methods inherited by all subclasses
- Package-private access within same package

### Polymorphism Applications
- Parent references to child objects
- Method calls resolved at runtime
- Arrays of parent type holding different subclasses
- `instanceof` operator for type checking

## 📊 Completion Requirements
- **Practice Problems:** Complete all 4 problems
- **Lab Exercises:** Complete all 6 programs
- **Homework Assignments:** Complete all 5 tasks

## 🚀 Getting Started
1. Navigate to the W4S4 directory
2. Start with Practice Problems for core concepts
3. Progress through Lab exercises for hands-on practice
4. Complete Homework assignments for comprehensive understanding
5. Test all inheritance relationships and polymorphic behavior

## 📁 File Structure
```
W4S4/
├── README.md                           # This file
├── COMPLETION_STATUS.md                # Progress tracking
├── practice/                           # Practice Problems (4)
│   ├── VirtualPetSimulator.java
│   ├── SpaceStationCrew.java
│   ├── MedievalKingdomBuilder.java
│   └── InteractiveStoryGenerator.java
├── class_practice/                     # Lab Exercises (6)
│   ├── BookManagement.java
│   ├── SmartDeviceNetwork.java
│   ├── AnimalTypeChecker.java
│   ├── AudioMixerStudio.java
│   ├── GameControllerConfig.java
│   └── ObjectCounter.java
└── assignment/                         # Homework Assignments (5)
    ├── BankAccountSystem.java
    ├── FitnessTracker.java
    ├── FoodDeliveryOrder.java
    ├── LibraryBookManagement.java
    └── MovieTicketBooking.java
```

## 💡 Tips for Success
- Always use @Override annotation when overriding methods
- Understand the difference between method overriding and overloading
- Test constructor chaining by adding print statements
- Use meaningful class hierarchies that represent real-world relationships
- Practice polymorphism with arrays of parent references
- Pay attention to access modifier restrictions in inheritance

## 🔗 Related Topics
- **Previous Session (W3S3):** OOP Fundamentals
- **Next Session (W5S5):** Static Methods & Advanced Design
- **Prerequisites:** Basic OOP concepts, classes, and objects
- **Applications:** System design, framework development, game programming

---
*This session builds upon OOP fundamentals to create sophisticated inheritance hierarchies and polymorphic systems.*