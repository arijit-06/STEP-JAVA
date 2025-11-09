# W13S13 - Data Structures: Linked Lists

## 📚 Session Overview

This session focuses on implementing and manipulating various types of linked lists in Java, covering fundamental data structure concepts and algorithms.

## 🎯 Learning Objectives

By the end of this session, you will be able to:

- ✅ Implement Singly Linked Lists with insertion, deletion, and traversal
- ✅ Detect and remove loops in linked lists using Floyd's algorithm
- ✅ Work with Doubly Linked Lists and bidirectional navigation
- ✅ Implement sorting algorithms on linked lists
- ✅ Create and manipulate Circular Linked Lists
- ✅ Apply linked lists to real-world scenarios (task management, playlists)
- ✅ Use two-pointer techniques for efficient list operations

## 📖 Topics Covered

### 🔗 Singly Linked List
- Node structure and memory allocation
- Insertion at any position
- Loop detection and removal (Floyd's Cycle Detection)
- List reversal and middle element finding

### ⇄ Doubly Linked List
- Bidirectional navigation
- Deletion of all occurrences
- Bubble sort implementation
- Memory management with prev/next pointers

### 🔄 Circular Linked List
- Circular structure maintenance
- Beginning and end operations
- Round-robin task scheduling
- Continuous traversal patterns

## 🚀 Problem Categories

### Practice Problems (Any 3 of 5)
1. **StudentRecord** - Basic insertion and traversal
2. **Playlist** - Insertion and deletion operations
3. **ReverseLinkedList** - Iterative list reversal
4. **MiddleNodeFinder** - Two-pointer technique
5. **PhotoViewer** - Doubly linked list navigation

### Assignment Problems (All 6)
1. **SinglyLinkedListInsertion** - Position-based insertion
2. **LoopDetectionRemoval** - Floyd's cycle detection
3. **DoublyLinkedListDeletion** - Delete all occurrences
4. **DoublyLinkedListSort** - Bubble sort implementation
5. **CircularLinkedListOperations** - Complete CRUD operations
6. **TaskManager** - Round-robin scheduling system

## 📁 File Structure

```
W13S13/
├── README.md
├── COMPLETION_STATUS.md
├── practice/
│   ├── StudentRecord.java
│   ├── Playlist.java
│   ├── ReverseLinkedList.java
│   ├── MiddleNodeFinder.java
│   └── PhotoViewer.java
└── assignment/
    ├── SinglyLinkedListInsertion.java
    ├── LoopDetectionRemoval.java
    ├── DoublyLinkedListDeletion.java
    ├── DoublyLinkedListSort.java
    ├── CircularLinkedListOperations.java
    └── TaskManager.java
```

## 🎯 Key Algorithms & Techniques

### Floyd's Cycle Detection Algorithm
- Use slow and fast pointers
- Detect loops in O(n) time, O(1) space
- Find loop starting point

### Two-Pointer Technique
- Find middle element in single traversal
- Efficient list operations
- Memory-optimized algorithms

### Bubble Sort on Linked Lists
- Compare adjacent nodes
- Swap data fields when needed
- Multiple passes until sorted

### Circular List Management
- Maintain head and tail references
- Preserve circular property during operations
- Handle edge cases (empty list, single node)

## 💡 Implementation Tips

### Memory Management
- Always update both prev and next pointers in doubly linked lists
- Handle null pointer exceptions gracefully
- Free memory by setting references to null

### Edge Cases
- Empty lists
- Single node operations
- Invalid positions
- Circular reference maintenance

### Performance Considerations
- O(1) insertion/deletion at known positions
- O(n) search operations
- Space-efficient compared to arrays
- Dynamic memory allocation

## 🔧 Testing Strategies

### Input Validation
- Test with empty lists
- Verify boundary conditions
- Check invalid position handling
- Test circular property maintenance

### Algorithm Verification
- Trace through loop detection steps
- Verify sorting correctness
- Check bidirectional navigation
- Validate task scheduling order

## 📊 Completion Requirements

- **Practice:** Complete any 3 out of 5 problems
- **Assignment:** Complete all 6 problems
- **Total:** 9 programs minimum

## 🎓 Real-World Applications

- **Music Playlists:** Dynamic song management
- **Task Scheduling:** Round-robin algorithms
- **Browser History:** Forward/backward navigation
- **Undo/Redo Systems:** Command pattern implementation
- **Memory Management:** Operating system applications

---

**Focus on understanding pointer manipulation and memory management concepts! 🔗**