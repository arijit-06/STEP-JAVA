package W2S2;

public class StringPerformanceComparison {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        System.out.println("String concatenation: " + (endTime - startTime));

        startTime = System.nanoTime();
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation: " + (endTime - startTime));

        startTime = System.nanoTime();
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation: " + (endTime - startTime));

        demonstrateStringBuilderMethods();
        compareStringComparisonMethods();
    }

    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++)
            result += "Java " + i + " ";
        return result;
    }

    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++)
            sb.append("Java ").append(i).append(" ");
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++)
            sb.append("Java ").append(i).append(" ");
        return sb.toString();
    }

    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        sb.append(" Java");
        sb.insert(5, " Amazing");
        sb.delete(5, 13);
        sb.deleteCharAt(0);
        sb.reverse();
        sb.replace(0, 5, "Hi");
        sb.setCharAt(0, 'X');
        System.out.println("Final StringBuilder: " + sb);
        System.out.println("Capacity: " + sb.capacity());
        sb.ensureCapacity(100);
        sb.trimToSize();
    }

    public static void compareStringComparisonMethods() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        System.out.println("==: " + (str1 == str2));
        System.out.println("== (new): " + (str1 == str3));
        System.out.println("equals: " + str1.equals(str3));
        System.out.println("equalsIgnoreCase: " + str1.equalsIgnoreCase("hello"));
        System.out.println("compareTo: " + str1.compareTo(str3));
        System.out.println("compareToIgnoreCase: " + str1.compareToIgnoreCase("HELLO"));
    }
}
