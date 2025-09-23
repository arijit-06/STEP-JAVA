# Week 2 Session 2 (W2S2) - Advanced String Methods and StringBuilder

## Overview
This session covers advanced string operations in Java, including built-in string methods, ASCII manipulation, StringBuilder/StringBuffer for performance optimization, and comprehensive string analysis techniques. The exercises progress from basic method usage to complex text processing applications.

## 📚 Learning Objectives
- Master built-in string methods for text analysis and manipulation
- Understand ASCII character codes and manipulation techniques
- Learn StringBuilder and StringBuffer for efficient string operations
- Implement performance comparisons between different string approaches
- Create advanced string comparison and analysis tools
- Build comprehensive string utility applications

## 🎯 Practice Problems (6 Problems - Complete Any 4)

### Problem 1: Built-In String Methods - Basic Operations
**File:** `practice/StringBuiltInMethods.java`
- Demonstrate common string methods for text analysis
- Use charAt(), substring(), indexOf(), contains(), startsWith(), endsWith()
- Implement custom vowel counting and character occurrence methods
- Format output in organized manner

### Problem 2: String Manipulation Methods
**File:** `practice/StringManipulation.java`
- Create text processing utility with various manipulation methods
- Use trim(), replace(), replaceAll(), split(), join()
- Implement punctuation removal, word capitalization, and word reversal
- Count word frequency in text

### Problem 3: ASCII Codes and Character Conversion
**File:** `practice/ASCIIProcessor.java`
- Demonstrate ASCII character manipulation and conversion
- Display characters with their ASCII codes
- Classify character types (uppercase, lowercase, digit, special)
- Implement Caesar cipher using ASCII manipulation
- Create ASCII table display and conversion utilities

### Problem 4: StringBuilder, StringBuffer, and Performance
**File:** `practice/StringPerformanceComparison.java`
- Compare performance between String, StringBuilder, and StringBuffer
- Demonstrate StringBuilder methods (append, insert, delete, reverse)
- Show thread safety differences between StringBuilder and StringBuffer
- Analyze memory efficiency and string pool behavior

### Problem 5: Advanced String Comparison and Analysis
**File:** `practice/AdvancedStringAnalyzer.java`
- Perform comprehensive string comparison analysis
- Implement similarity percentage calculation using algorithms
- Demonstrate string intern() method and memory usage
- Optimize string operations for performance

### Problem 6: Complete String Utility Application
**File:** `practice/StringUtilityApp.java`
- Create menu-driven comprehensive string utility application
- Combine text analysis, transformations, ASCII operations
- Include performance testing and comparison analysis
- Implement custom string algorithms (palindrome, anagram, pattern matching)

## 🧪 Lab Practice Programs (6 Programs - Complete Any 6)

### Lab 1: Find and Replace Without Built-in Methods
**File:** `lab/FindAndReplace.java`
- Find and replace substring occurrences without using replace() method
- Use indexOf() in loops to find all occurrences
- Build new string character by character using charAt()
- Compare results with built-in replace() method

### Lab 2: Case Conversion Using ASCII Values
**File:** `lab/ASCIICaseConverter.java`
- Convert text between different cases using ASCII values
- Implement uppercase/lowercase conversion without built-in methods
- Create title case conversion for proper formatting
- Compare performance with built-in methods

### Lab 3: String Performance Analysis
**File:** `lab/StringPerformanceAnalyzer.java`
- Analyze performance of String vs StringBuilder vs StringBuffer
- Measure time and memory efficiency for large string operations
- Display results in tabular format with recommendations
- Test with different iteration counts

### Lab 4: Caesar Cipher Implementation
**File:** `lab/CaesarCipher.java`
- Create encryption/decryption system using ASCII shifting
- Handle wrap-around for alphabetic characters
- Display ASCII values before and after transformation
- Validate decryption returns original text

### Lab 5: Email Address Analyzer
**File:** `lab/EmailAnalyzer.java`
- Extract and analyze email address components
- Validate email format using string methods
- Extract username, domain, and extension parts
- Generate statistics on email patterns

### Lab 6: Text Formatter with StringBuilder
**File:** `lab/TextFormatter.java`
- Create text justification system with specified width
- Split text into words without using split() method
- Implement left-justify and center-align formatting
- Compare performance with String concatenation

## 📝 Assignment Practice - Homework Tasks (6 Tasks - Complete All 6)

### Assignment 1: Spell Checker with String Distance
**File:** `assignment/SpellChecker.java`
- Implement spell checker using string distance calculation
- Split sentences into words without split() method
- Calculate character differences between words
- Suggest corrections from dictionary with distance scoring

### Assignment 2: Password Strength Analyzer
**File:** `assignment/PasswordAnalyzer.java`
- Analyze password strength using ASCII values
- Count different character types and calculate strength scores
- Generate strong passwords using StringBuilder
- Display comprehensive analysis in tabular format

### Assignment 3: Text Compression Algorithm
**File:** `assignment/TextCompressor.java`
- Implement character frequency-based compression
- Create compression codes for frequent characters
- Use StringBuilder for efficient string building
- Calculate compression ratios and validate decompression

### Assignment 4: Mathematical Expression Calculator
**File:** `assignment/ExpressionCalculator.java`
- Parse and evaluate mathematical expressions from strings
- Validate expression format and handle operator precedence
- Process parentheses and show step-by-step calculations
- Use StringBuilder for efficient result building

### Assignment 5: CSV Data Analyzer
**File:** `assignment/CSVAnalyzer.java`
- Parse CSV-like data without using split() method
- Validate and clean data with type conversions
- Perform statistical analysis on numeric columns
- Format output using StringBuilder with proper alignment

### Assignment 6: File Organizer System
**File:** `assignment/FileOrganizer.java`
- Categorize files based on extensions and content analysis
- Extract filename components without split() method
- Generate new naming conventions using StringBuilder
- Create comprehensive organization reports with statistics

## 🛠️ Key Concepts Covered

### Built-in String Methods
- **Analysis Methods:** `length()`, `charAt()`, `indexOf()`, `lastIndexOf()`
- **Comparison Methods:** `equals()`, `equalsIgnoreCase()`, `compareTo()`, `compareToIgnoreCase()`
- **Content Methods:** `contains()`, `startsWith()`, `endsWith()`, `isEmpty()`
- **Extraction Methods:** `substring()`, `toCharArray()`, `split()`
- **Transformation Methods:** `trim()`, `replace()`, `replaceAll()`, `toUpperCase()`, `toLowerCase()`

### ASCII Character Manipulation
- Character to ASCII conversion using `(int)` casting
- ASCII to character conversion using `(char)` casting
- Character type classification using ASCII ranges
- Case conversion using ASCII arithmetic (±32)
- Character shifting for encryption algorithms

### StringBuilder and StringBuffer
- **Performance Benefits:** Mutable string operations
- **Key Methods:** `append()`, `insert()`, `delete()`, `reverse()`, `replace()`
- **Capacity Management:** `capacity()`, `ensureCapacity()`, `trimToSize()`
- **Thread Safety:** StringBuffer (synchronized) vs StringBuilder (not synchronized)
- **Memory Efficiency:** Avoiding string concatenation overhead

### Advanced String Algorithms
- **String Distance:** Levenshtein distance, character difference counting
- **Pattern Matching:** Custom search algorithms, regular expression alternatives
- **Text Analysis:** Frequency analysis, statistical calculations
- **Compression:** Character frequency-based encoding
- **Parsing:** Expression evaluation, CSV processing

## 📊 Grading Criteria
- **Practice Problems:** Complete any 4 out of 6 problems
- **Lab Exercises:** Complete any 6 out of 6 programs
- **Homework Assignments:** Complete all 6 tasks

## 🚀 Getting Started
1. Navigate to the W2S2 directory
2. Review the practice problems to understand core concepts
3. Complete lab exercises for hands-on experience
4. Tackle homework assignments for comprehensive mastery
5. Focus on performance optimization and efficient algorithms

## 📁 File Structure
```
W2S2/
├── README.md                           # This file
├── COMPLETION_STATUS.md                # Completion tracking
├── practice/                           # Practice Problems (6)
│   ├── StringBuiltInMethods.java
│   ├── StringManipulation.java
│   ├── ASCIIProcessor.java
│   ├── StringPerformanceComparison.java
│   ├── AdvancedStringAnalyzer.java
│   └── StringUtilityApp.java
├── lab/                               # Lab Exercises (6)
│   ├── FindAndReplace.java
│   ├── ASCIICaseConverter.java
│   ├── StringPerformanceAnalyzer.java
│   ├── CaesarCipher.java
│   ├── EmailAnalyzer.java
│   └── TextFormatter.java
└── assignment/                        # Homework Assignments (6)
    ├── SpellChecker.java
    ├── PasswordAnalyzer.java
    ├── TextCompressor.java
    ├── ExpressionCalculator.java
    ├── CSVAnalyzer.java
    └── FileOrganizer.java
```

## 💡 Tips for Success
- **Performance Focus:** Always consider efficiency when choosing between String, StringBuilder, and StringBuffer
- **ASCII Mastery:** Understand ASCII ranges for different character types
- **Method Selection:** Choose appropriate built-in methods for specific tasks
- **Memory Awareness:** Be conscious of string immutability and memory usage
- **Algorithm Design:** Implement custom algorithms when built-in methods aren't suitable
- **Testing Strategy:** Test with edge cases, large inputs, and performance benchmarks

## 🔗 Related Topics
- **Previous Session (W1S1):** Basic String Manipulation and Arrays
- **Next Session:** Object-Oriented Programming with Strings
- **Prerequisites:** Basic Java syntax, loops, arrays, and W1S1 concepts
- **Applications:** Text processing, data parsing, performance optimization

## 🎯 Performance Benchmarks
- **String Concatenation:** Avoid for multiple operations (O(n²) complexity)
- **StringBuilder:** Preferred for multiple string modifications (O(n) complexity)
- **StringBuffer:** Use only when thread safety is required
- **Memory Usage:** StringBuilder typically uses 16-character initial capacity

## 🔍 Common Pitfalls to Avoid
- Using String concatenation in loops
- Ignoring case sensitivity in comparisons
- Not handling null or empty strings
- Forgetting ASCII range boundaries
- Not considering thread safety requirements
- Inefficient substring operations

---
*This README covers advanced string manipulation concepts essential for efficient Java text processing and performance optimization.*