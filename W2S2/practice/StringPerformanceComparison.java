/**
 * W2S2 Practice Problem 4: StringBuilder, StringBuffer, and Performance
 * 
 * Task: Create a performance comparison program that demonstrates the differences between
 * String, StringBuilder, and StringBuffer.
 * 
 * Learning Objectives:
 * - Compare performance between String, StringBuilder, and StringBuffer
 * - Demonstrate StringBuilder methods (append, insert, delete, reverse)
 * - Show thread safety differences between StringBuilder and StringBuffer
 * - Analyze memory efficiency and string pool behavior
 */

public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== STRING PERFORMANCE COMPARISON ===");
        
        // TODO: Implement performance tests for different approaches
        // Test 1: String concatenation performance
        System.out.println("=== PERFORMANCE COMPARISON ===");
        
        int[] testSizes = {100, 1000, 5000};
        
        for (int iterations : testSizes) {
            System.out.println("\n--- Testing with " + iterations + " iterations ---");
            
            // TODO: Test string concatenation with regular String (slow method)
            long startTime = System.nanoTime();
            String result1 = concatenateWithString(iterations);
            long endTime = System.nanoTime();
            long stringTime = endTime - startTime;
            System.out.println("String concatenation time: " + stringTime + " ns (" + (stringTime/1_000_000) + " ms)");
            
            // TODO: Test string concatenation with StringBuilder (fast method)
            startTime = System.nanoTime();
            String result2 = concatenateWithStringBuilder(iterations);
            endTime = System.nanoTime();
            long stringBuilderTime = endTime - startTime;
            System.out.println("StringBuilder time: " + stringBuilderTime + " ns (" + (stringBuilderTime/1_000_000) + " ms)");
            
            // TODO: Test string concatenation with StringBuffer (thread-safe method)
            startTime = System.nanoTime();
            String result3 = concatenateWithStringBuffer(iterations);
            endTime = System.nanoTime();
            long stringBufferTime = endTime - startTime;
            System.out.println("StringBuffer time: " + stringBufferTime + " ns (" + (stringBufferTime/1_000_000) + " ms)");
            
            // Performance comparison
            double sbSpeedup = (double)stringTime / stringBuilderTime;
            double sbufSpeedup = (double)stringTime / stringBufferTime;
            
            System.out.printf("StringBuilder is %.2fx faster than String%n", sbSpeedup);
            System.out.printf("StringBuffer is %.2fx faster than String%n", sbufSpeedup);
            
            // Verify results are identical
            boolean resultsMatch = result1.equals(result2) && result2.equals(result3);
            System.out.println("All results identical: " + resultsMatch);
        }
        
        // TODO: Compare memory usage (approximate)
        System.out.println("\n=== MEMORY USAGE ANALYSIS ===");
        demonstrateMemoryEfficiency();
        
        // TODO: Demonstrate thread safety differences
        System.out.println("\n=== THREAD SAFETY DEMONSTRATION ===");
        demonstrateThreadSafety();
        
        // TODO: Create practical examples showing when to use each approach
        System.out.println("\n=== STRINGBUILDER METHODS DEMONSTRATION ===");
        demonstrateStringBuilderMethods();
        
        System.out.println("\n=== STRING COMPARISON METHODS ===");
        compareStringComparisonMethods();
    }
    
    // TODO: Method using String concatenation (inefficient)
    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java " + i + " ";
        }
        return result;
    }
    
    // TODO: Method using StringBuilder (efficient, not thread-safe)
    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }
    
    // TODO: Method using StringBuffer (efficient, thread-safe)
    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }
    
    // TODO: Method to demonstrate StringBuilder methods
    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        System.out.println("Initial StringBuilder: \"" + sb + "\"");
        System.out.println("Initial capacity: " + sb.capacity());
        System.out.println("Initial length: " + sb.length());
        
        // TODO: Use the following StringBuilder methods:
        
        // 1. append() - Add text to end
        sb.append(" - Java Programming");
        System.out.println("After append(): \"" + sb + "\"");
        
        // 2. insert() - Insert text at specific position
        sb.insert(5, " Beautiful");
        System.out.println("After insert(): \"" + sb + "\"");
        
        // 3. delete() - Remove characters from range
        sb.delete(5, 15); // Remove " Beautiful"
        System.out.println("After delete(): \"" + sb + "\"");
        
        // 4. deleteCharAt() - Remove character at index
        sb.deleteCharAt(sb.length() - 1); // Remove last character
        System.out.println("After deleteCharAt(): \"" + sb + "\"");
        
        // 5. reverse() - Reverse the string
        StringBuilder reversed = new StringBuilder(sb).reverse();
        System.out.println("Reversed: \"" + reversed + "\"");
        
        // 6. replace() - Replace substring
        sb.replace(0, 5, "Hi");
        System.out.println("After replace(): \"" + sb + "\"");
        
        // 7. setCharAt() - Change character at index
        sb.setCharAt(0, 'h');
        System.out.println("After setCharAt(): \"" + sb + "\"");
        
        // 8. capacity() - Show current capacity
        System.out.println("Current capacity: " + sb.capacity());
        
        // 9. ensureCapacity() - Set minimum capacity
        sb.ensureCapacity(100);
        System.out.println("After ensureCapacity(100): " + sb.capacity());
        
        // 10. trimToSize() - Reduce capacity to current length
        sb.trimToSize();
        System.out.println("After trimToSize(): " + sb.capacity());
        System.out.println("Final length: " + sb.length());
    }
    
    // TODO: Method to demonstrate StringBuffer thread safety
    public static void demonstrateThreadSafety() {
        final StringBuilder sbUnsafe = new StringBuilder();
        final StringBuffer sbSafe = new StringBuffer();
        final int numThreads = 10;
        final int operationsPerThread = 100;
        
        System.out.println("Testing thread safety with " + numThreads + " threads, " + 
                          operationsPerThread + " operations each...");
        
        // Test StringBuilder (not thread-safe)
        Thread[] threads1 = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            threads1[i] = new Thread(() -> {
                for (int j = 0; j < operationsPerThread; j++) {
                    sbUnsafe.append("T" + threadId + ":");
                }
            });
        }
        
        long startTime = System.nanoTime();
        for (Thread t : threads1) t.start();
        for (Thread t : threads1) {
            try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        long sbTime = System.nanoTime() - startTime;
        
        // Test StringBuffer (thread-safe)
        Thread[] threads2 = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            threads2[i] = new Thread(() -> {
                for (int j = 0; j < operationsPerThread; j++) {
                    sbSafe.append("T" + threadId + ":");
                }
            });
        }
        
        startTime = System.nanoTime();
        for (Thread t : threads2) t.start();
        for (Thread t : threads2) {
            try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        long sbufTime = System.nanoTime() - startTime;
        
        System.out.println("StringBuilder (unsafe) length: " + sbUnsafe.length());
        System.out.println("StringBuffer (safe) length: " + sbSafe.length());
        System.out.println("Expected length: " + (numThreads * operationsPerThread * 3));
        System.out.println("StringBuilder time: " + (sbTime/1_000_000) + " ms");
        System.out.println("StringBuffer time: " + (sbufTime/1_000_000) + " ms");
        
        boolean sbCorrect = sbUnsafe.length() == (numThreads * operationsPerThread * 3);
        boolean sbufCorrect = sbSafe.length() == (numThreads * operationsPerThread * 3);
        
        System.out.println("StringBuilder result correct: " + sbCorrect);
        System.out.println("StringBuffer result correct: " + sbufCorrect);
    }
    
    // TODO: Method to compare string comparison methods
    public static void compareStringComparisonMethods() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = "hello";
        
        System.out.println("String comparison demonstration:");
        System.out.println("str1 = \"Hello\" (literal)");
        System.out.println("str2 = \"Hello\" (literal)");
        System.out.println("str3 = new String(\"Hello\") (constructor)");
        System.out.println("str4 = \"hello\" (different case)");
        System.out.println();
        
        // TODO: Compare using:
        
        // 1. == operator (reference comparison)
        System.out.println("=== Reference Comparison (==) ===");
        System.out.println("str1 == str2: " + (str1 == str2) + " (same reference - string pool)");
        System.out.println("str1 == str3: " + (str1 == str3) + " (different reference - constructor)");
        
        // 2. equals() method (content comparison)
        System.out.println("\n=== Content Comparison (equals) ===");
        System.out.println("str1.equals(str2): " + str1.equals(str2));
        System.out.println("str1.equals(str3): " + str1.equals(str3));
        System.out.println("str1.equals(str4): " + str1.equals(str4));
        
        // 3. equalsIgnoreCase() method
        System.out.println("\n=== Case-Insensitive Comparison ===");
        System.out.println("str1.equalsIgnoreCase(str4): " + str1.equalsIgnoreCase(str4));
        
        // 4. compareTo() method (lexicographic comparison)
        System.out.println("\n=== Lexicographic Comparison (compareTo) ===");
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2) + " (0 = equal)");
        System.out.println("str1.compareTo(str4): " + str1.compareTo(str4) + " (negative = str1 < str4)");
        System.out.println("str4.compareTo(str1): " + str4.compareTo(str1) + " (positive = str4 > str1)");
        
        // 5. compareToIgnoreCase() method
        System.out.println("\n=== Case-Insensitive Lexicographic Comparison ===");
        System.out.println("str1.compareToIgnoreCase(str4): " + str1.compareToIgnoreCase(str4));
        
        // TODO: Explain the differences and when to use each
        System.out.println("\n=== USAGE GUIDELINES ===");
        System.out.println("• Use == for reference comparison (rarely needed)");
        System.out.println("• Use equals() for content comparison (most common)");
        System.out.println("• Use equalsIgnoreCase() for case-insensitive content comparison");
        System.out.println("• Use compareTo() for sorting and ordering");
        System.out.println("• Use compareToIgnoreCase() for case-insensitive sorting");
    }
    
    // TODO: Method to demonstrate memory efficiency
    public static void demonstrateMemoryEfficiency() {
        System.out.println("Memory efficiency demonstration:");
        
        // String pool behavior
        String literal1 = "Java";
        String literal2 = "Java";
        String constructor = new String("Java");
        String interned = constructor.intern();
        
        System.out.println("String pool behavior:");
        System.out.println("literal1 == literal2: " + (literal1 == literal2) + " (same pool reference)");
        System.out.println("literal1 == constructor: " + (literal1 == constructor) + " (different references)");
        System.out.println("literal1 == interned: " + (literal1 == interned) + " (intern() returns pool reference)");
        
        // StringBuilder capacity management
        System.out.println("\nStringBuilder capacity management:");
        StringBuilder sb = new StringBuilder();
        System.out.println("Initial capacity: " + sb.capacity());
        
        for (int i = 0; i < 20; i++) {
            sb.append("X");
            if (i == 15 || i == 19) {
                System.out.println("After " + (i+1) + " chars - Length: " + sb.length() + ", Capacity: " + sb.capacity());
            }
        }
        
        System.out.println("StringBuilder automatically grows capacity when needed");
        System.out.println("Growth typically doubles the capacity for efficiency");
    }
}