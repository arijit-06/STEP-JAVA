# Week 1 Session 1 (W1S1) - String Manipulation in Java

## Overview
This session covers fundamental string operations in Java, including string creation, manipulation, arrays, and advanced text processing techniques. The exercises progress from basic string operations to complex applications like text processors and games.

## 📚 Learning Objectives
- Master different ways to create and manipulate strings in Java
- Understand string comparison methods (`==` vs `.equals()`)
- Work with string arrays and implement custom string methods
- Process user input and format output effectively
- Implement algorithms for text analysis and processing

## 🎯 Practice Problems (4 Problems)

### Problem 1: String Creation and Manipulation
**File:** `practice/StringCreationAndManipulation.java`
- Create strings using 3 different methods (literal, constructor, character array)
- Compare strings using `==` and `.equals()`
- Work with escape sequences for formatted output

### Problem 2: String Input and Processing  
**File:** `practice/StringInputProcessor.java`
- Process user input (name, programming language, experience)
- Extract and manipulate string components
- Format and display processed information

### Problem 3: String Arrays and Methods
**File:** `practice/StringArrayMethods.java`
- Find longest name in an array
- Count names starting with specific letters
- Format names from "First Last" to "Last, First"

### Problem 4: Complete String Application
**File:** `practice/CompleteTextProcessor.java`
- Build a comprehensive text processor
- Clean and validate input text
- Analyze text statistics (words, sentences, characters)
- Sort words alphabetically and enable word search

## 🧪 Lab Practice Programs (10 Programs - Complete Any 6)

### Lab 1: String Length Without Built-in Method
**File:** `lab/StringLengthCalculator.java`
- Calculate string length using character iteration and exception handling
- Compare with built-in `length()` method

### Lab 2: Text Splitting Without Built-in Methods
**File:** `lab/TextSplitter.java`
- Split text into words using `charAt()` method
- Compare results with built-in `split()` method

### Lab 3: Words and Lengths in 2D Array
**File:** `lab/WordLengthTable.java`
- Create 2D array containing words and their lengths
- Display results in tabular format

### Lab 4: Find Shortest and Longest Strings
**File:** `lab/ShortestLongestFinder.java`
- Identify shortest and longest words in text
- Use custom length calculation methods

### Lab 5: Vowel and Consonant Counter
**File:** `lab/VowelConsonantCounter.java`
- Count vowels and consonants in strings
- Handle case conversion using ASCII values

### Lab 6: Character Type Analyzer
**File:** `lab/CharacterClassifier.java`
- Classify each character as vowel, consonant, or non-letter
- Display results in tabular format

### Lab 7: Custom String Trimming
**File:** `lab/StringTrimmer.java`
- Remove leading and trailing spaces using `charAt()`
- Compare with built-in `trim()` method

### Lab 8: Student Voting Eligibility
**File:** `lab/VotingEligibility.java`
- Generate random student ages
- Determine voting eligibility (age ≥ 18)
- Display results in tabular format

### Lab 9: Rock-Paper-Scissors Game
**File:** `lab/RockPaperScissors.java`
- Implement game logic with computer opponent
- Track win statistics and percentages
- Display game results across multiple rounds

### Lab 10: Student Grade Calculator
**File:** `lab/GradeCalculator.java`
- Calculate grades based on Physics, Chemistry, Math scores
- Compute percentages and assign letter grades
- Display comprehensive scorecards

## 📝 Assignment Practice - Homework Tasks (10 Tasks - Complete Any 6)

### Assignment 1: BMI Calculator
**File:** `assignment/BMICalculator.java`
- Calculate Body Mass Index for team members
- Categorize BMI status (underweight, normal, overweight, obese)
- Display comprehensive health reports

### Assignment 2: Unique Character Finder
**File:** `assignment/UniqueCharacterFinder.java`
- Find unique characters in strings using `charAt()`
- Implement custom algorithms without built-in methods

### Assignment 3: First Non-Repeating Character
**File:** `assignment/FirstNonRepeatingChar.java`
- Identify first character that appears only once
- Use frequency arrays with ASCII indexing

### Assignment 4: Character Frequency Counter
**File:** `assignment/CharacterFrequencyCounter.java`
- Count frequency of each character in strings
- Display character-frequency pairs in tabular format

### Assignment 5: Frequency Analysis with Unique Characters
**File:** `assignment/FrequencyWithUniqueChars.java`
- Combine unique character finding with frequency analysis
- Optimize performance using custom algorithms

### Assignment 6: Nested Loop Frequency Analysis
**File:** `assignment/NestedLoopFrequency.java`
- Implement frequency counting using nested loops
- Handle duplicate character elimination

### Assignment 7: Palindrome Checker
**File:** `assignment/PalindromeChecker.java`
- Implement 3 different palindrome checking algorithms:
  - Forward-backward character comparison
  - Recursive approach
  - Character array reversal method

### Assignment 8: Anagram Detector
**File:** `assignment/AnagramDetector.java`
- Check if two strings are anagrams
- Use character frequency comparison
- Handle case sensitivity and spaces

### Assignment 9: Calendar Generator
**File:** `assignment/CalendarGenerator.java`
- Display calendar for any given month and year
- Handle leap years and proper date formatting
- Use Gregorian calendar algorithms

### Assignment 10: Card Deck Simulator
**File:** `assignment/CardDeckSimulator.java`
- Create and initialize 52-card deck
- Implement deck shuffling algorithms
- Distribute cards to multiple players

## 🛠️ Key Concepts Covered

### String Creation Methods
- String literals (`"text"`)
- Constructor method (`new String()`)
- Character arrays (`char[]`)

### String Comparison
- Reference comparison (`==`)
- Content comparison (`.equals()`)
- Case-insensitive comparison (`.equalsIgnoreCase()`)

### Custom String Operations
- Length calculation without built-in methods
- Character-by-character processing
- ASCII value manipulation
- Exception handling for string bounds

### Advanced Algorithms
- Frequency analysis using arrays
- Palindrome detection techniques
- Anagram verification
- Text parsing and tokenization

## 📊 Grading Criteria
- **Practice Problems:** Complete all 4 problems
- **Lab Exercises:** Complete any 6 out of 10 programs
- **Homework Assignments:** Complete any 6 out of 10 tasks

## 🚀 Getting Started
1. Navigate to the W1S1 directory
2. Choose problems based on your learning goals
3. Start with Practice Problems for foundational concepts
4. Progress to Lab exercises for hands-on practice
5. Complete Homework assignments for advanced challenges

## 📁 File Structure
```
W1S1/
├── README.md                           # This file
├── COMPLETION_STATUS.md                # Completion tracking
├── practice/                           # Practice Problems (4)
│   ├── StringCreationAndManipulation.java
│   ├── StringInputProcessor.java
│   ├── StringArrayMethods.java
│   └── CompleteTextProcessor.java
├── lab/                               # Lab Exercises (10)
│   ├── StringLengthCalculator.java
│   ├── TextSplitter.java
│   ├── WordLengthTable.java
│   ├── ShortestLongestFinder.java
│   ├── VowelConsonantCounter.java
│   ├── CharacterClassifier.java
│   ├── StringTrimmer.java
│   ├── VotingEligibility.java
│   ├── RockPaperScissors.java
│   └── GradeCalculator.java
└── assignment/                        # Homework Assignments (10)
    ├── BMICalculator.java
    ├── UniqueCharacterFinder.java
    ├── FirstNonRepeatingChar.java
    ├── CharacterFrequencyCounter.java
    ├── FrequencyWithUniqueChars.java
    ├── NestedLoopFrequency.java
    ├── PalindromeChecker.java
    ├── AnagramDetector.java
    ├── CalendarGenerator.java
    └── CardDeckSimulator.java
```

## 💡 Tips for Success
- Focus on understanding the logic before implementing
- Test your methods with various input cases
- Pay attention to edge cases (empty strings, null values)
- Use meaningful variable names and add comments
- Compare your custom implementations with built-in methods
- Practice debugging techniques for string operations

## 🔗 Related Topics
- **Next Session (W2S2):** Advanced String Methods and StringBuilder
- **Prerequisites:** Basic Java syntax and control structures
- **Applications:** Text processing, data validation, user input handling

---
*This README covers comprehensive string manipulation concepts essential for Java programming fundamentals.*