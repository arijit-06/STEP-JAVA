/**
 * W2S2 Assignment 5: CSV Data Analyzer
 * 
 * Task: Write a program to analyze and format structured data from
 * CSV-like text input using string manipulation methods
 */

import java.util.Scanner;

public class CSVAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter CSV data (type 'END' to finish):");
        StringBuilder csvData = new StringBuilder();
        String line;
        
        while (!(line = scanner.nextLine()).equals("END")) {
            csvData.append(line).append("\n");
        }
        
        String[][] data = parseCSVData(csvData.toString());
        String[][] cleanedData = validateAndCleanData(data);
        
        performDataAnalysis(cleanedData);
        String formattedOutput = formatOutput(cleanedData);
        
        System.out.println("\n=== FORMATTED OUTPUT ===");
        System.out.println(formattedOutput);
        
        generateDataSummaryReport(cleanedData);
        
        scanner.close();
    }
    
    public static String[][] parseCSVData(String csvText) {
        String[] lines = csvText.split("\n");
        String[][] data = new String[lines.length][];
        
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].trim().length() > 0) {
                data[i] = parseCSVLine(lines[i]);
            }
        }
        
        return data;
    }
    
    public static String[] parseCSVLine(String line) {
        String[] tempFields = new String[line.length()];
        int fieldCount = 0;
        StringBuilder currentField = new StringBuilder();
        boolean inQuotes = false;
        
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            
            if (ch == '"') {
                inQuotes = !inQuotes;
            } else if (ch == ',' && !inQuotes) {
                tempFields[fieldCount++] = currentField.toString();
                currentField.setLength(0);
            } else {
                currentField.append(ch);
            }
        }
        
        tempFields[fieldCount++] = currentField.toString();
        
        String[] fields = new String[fieldCount];
        System.arraycopy(tempFields, 0, fields, 0, fieldCount);
        return fields;
    }
    
    public static String[][] validateAndCleanData(String[][] data) {
        if (data == null || data.length == 0) return data;
        
        // Clean each field
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                for (int j = 0; j < data[i].length; j++) {
                    if (data[i][j] != null) {
                        // Remove leading/trailing spaces
                        data[i][j] = data[i][j].trim();
                        
                        // Validate numeric fields (assuming columns 1+ might be numeric)
                        if (j > 0 && isNumeric(data[i][j])) {
                            // Keep as is - valid numeric
                        } else if (j > 0 && data[i][j].isEmpty()) {
                            data[i][j] = "0"; // Default for missing numeric data
                        }
                    }
                }
            }
        }
        
        return data;
    }
    
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        
        boolean hasDecimal = false;
        int start = 0;
        
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            start = 1;
        }
        
        for (int i = start; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                continue;
            } else if (ch == '.' && !hasDecimal) {
                hasDecimal = true;
            } else {
                return false;
            }
        }
        
        return start < str.length();
    }
    
    public static void performDataAnalysis(String[][] data) {
        if (data == null || data.length <= 1) return;
        
        System.out.println("\n=== DATA ANALYSIS ===");
        
        int numColumns = data[0] != null ? data[0].length : 0;
        
        for (int col = 1; col < numColumns; col++) { // Skip first column (assume it's text)
            double sum = 0, min = Double.MAX_VALUE, max = Double.MIN_VALUE;
            int validCount = 0;
            
            for (int row = 1; row < data.length; row++) { // Skip header row
                if (data[row] != null && col < data[row].length && isNumeric(data[row][col])) {
                    double value = Double.parseDouble(data[row][col]);
                    sum += value;
                    min = Math.min(min, value);
                    max = Math.max(max, value);
                    validCount++;
                }
            }
            
            if (validCount > 0) {
                double average = sum / validCount;
                System.out.printf("Column %d - Min: %.2f, Max: %.2f, Average: %.2f%n", 
                                col + 1, min, max, average);
            }
        }
    }
    
    public static String formatOutput(String[][] data) {
        if (data == null || data.length == 0) return "";
        
        StringBuilder formatted = new StringBuilder();
        
        // Calculate column widths
        int[] columnWidths = new int[data[0] != null ? data[0].length : 0];
        for (int col = 0; col < columnWidths.length; col++) {
            for (String[] row : data) {
                if (row != null && col < row.length && row[col] != null) {
                    columnWidths[col] = Math.max(columnWidths[col], row[col].length());
                }
            }
            columnWidths[col] = Math.max(columnWidths[col], 10); // Minimum width
        }
        
        // Create formatted table
        for (int row = 0; row < data.length; row++) {
            if (data[row] != null) {
                formatted.append("│");
                for (int col = 0; col < columnWidths.length; col++) {
                    String value = (col < data[row].length && data[row][col] != null) ? 
                                  data[row][col] : "";
                    formatted.append(String.format(" %-" + columnWidths[col] + "s │", value));
                }
                formatted.append("\n");
                
                // Add separator after header
                if (row == 0) {
                    formatted.append("├");
                    for (int col = 0; col < columnWidths.length; col++) {
                        for (int i = 0; i < columnWidths[col] + 2; i++) {
                            formatted.append("─");
                        }
                        formatted.append(col < columnWidths.length - 1 ? "┼" : "┤");
                    }
                    formatted.append("\n");
                }
            }
        }
        
        return formatted.toString();
    }
    
    public static void generateDataSummaryReport(String[][] data) {
        System.out.println("\n=== DATA SUMMARY REPORT ===");
        
        int totalRecords = data != null ? data.length - 1 : 0; // Exclude header
        int totalColumns = (data != null && data.length > 0 && data[0] != null) ? data[0].length : 0;
        
        // Count missing data
        int missingDataCount = 0;
        int totalCells = 0;
        
        for (int row = 1; row < data.length; row++) { // Skip header
            if (data[row] != null) {
                for (int col = 0; col < totalColumns; col++) {
                    totalCells++;
                    if (col >= data[row].length || data[row][col] == null || data[row][col].trim().isEmpty()) {
                        missingDataCount++;
                    }
                }
            }
        }
        
        double completenessPercentage = totalCells > 0 ? 
            ((double)(totalCells - missingDataCount) / totalCells) * 100 : 0;
        
        System.out.println("Total records processed: " + totalRecords);
        System.out.println("Total columns: " + totalColumns);
        System.out.println("Missing data points: " + missingDataCount);
        System.out.printf("Data completeness: %.2f%%%n", completenessPercentage);
        
        if (missingDataCount > 0) {
            System.out.println("Data quality issues found - consider data cleaning");
        } else {
            System.out.println("Data quality: Excellent - no missing values");
        }
    }
}