/**
 * W2S2 Assignment 4: Mathematical Expression Calculator
 * 
 * Task: Write a program to create a text-based calculator that can parse
 * and evaluate mathematical expressions from strings
 */

import java.util.Scanner;

public class ExpressionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter mathematical expression: ");
        String expression = scanner.nextLine();
        
        if (validateExpression(expression)) {
            double result = evaluateExpression(expression);
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid expression format!");
        }
        
        scanner.close();
    }
    
    public static boolean validateExpression(String expression) {
        int parenthesesCount = 0;
        boolean lastWasOperator = true;
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            int ascii = (int) ch;
            
            if (ch == '(') {
                parenthesesCount++;
                lastWasOperator = true;
            } else if (ch == ')') {
                parenthesesCount--;
                if (parenthesesCount < 0) return false;
                lastWasOperator = false;
            } else if (ascii >= 48 && ascii <= 57) { // digits
                lastWasOperator = false;
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (lastWasOperator && ch != '-') return false;
                lastWasOperator = true;
            } else if (ch != ' ') {
                return false; // invalid character
            }
        }
        
        return parenthesesCount == 0 && !lastWasOperator;
    }
    
    public static double evaluateExpression(String expression) {
        // Remove spaces
        StringBuilder cleaned = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != ' ') {
                cleaned.append(expression.charAt(i));
            }
        }
        
        return evaluateWithParentheses(cleaned.toString());
    }
    
    public static double evaluateWithParentheses(String expression) {
        // Find innermost parentheses
        int lastOpen = -1;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                lastOpen = i;
            } else if (expression.charAt(i) == ')') {
                if (lastOpen != -1) {
                    String innerExpr = expression.substring(lastOpen + 1, i);
                    double innerResult = evaluateSimple(innerExpr);
                    
                    StringBuilder newExpr = new StringBuilder();
                    newExpr.append(expression.substring(0, lastOpen));
                    newExpr.append(innerResult);
                    newExpr.append(expression.substring(i + 1));
                    
                    return evaluateWithParentheses(newExpr.toString());
                }
            }
        }
        
        return evaluateSimple(expression);
    }
    
    public static double evaluateSimple(String expression) {
        double[] numbers = new double[expression.length()];
        char[] operators = new char[expression.length()];
        int numCount = 0;
        int opCount = 0;
        
        // Parse numbers and operators
        StringBuilder currentNumber = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if ((ch >= '0' && ch <= '9') || ch == '.') {
                currentNumber.append(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (currentNumber.length() > 0) {
                    numbers[numCount++] = Double.parseDouble(currentNumber.toString());
                    currentNumber.setLength(0);
                }
                
                // Handle negative numbers
                if (ch == '-' && (i == 0 || expression.charAt(i-1) == '(' || 
                    expression.charAt(i-1) == '+' || expression.charAt(i-1) == '-' ||
                    expression.charAt(i-1) == '*' || expression.charAt(i-1) == '/')) {
                    currentNumber.append(ch);
                } else {
                    operators[opCount++] = ch;
                }
            }
        }
        
        if (currentNumber.length() > 0) {
            numbers[numCount++] = Double.parseDouble(currentNumber.toString());
        }
        
        // Handle multiplication and division first
        for (int i = 0; i < opCount; i++) {
            if (operators[i] == '*' || operators[i] == '/') {
                double result;
                if (operators[i] == '*') {
                    result = numbers[i] * numbers[i + 1];
                } else {
                    result = numbers[i] / numbers[i + 1];
                }
                
                // Replace the two numbers with the result
                numbers[i] = result;
                
                // Shift remaining numbers and operators
                for (int j = i + 1; j < numCount - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                for (int j = i; j < opCount - 1; j++) {
                    operators[j] = operators[j + 1];
                }
                
                numCount--;
                opCount--;
                i--; // Check this position again
            }
        }
        
        // Handle addition and subtraction
        double result = numbers[0];
        for (int i = 0; i < opCount; i++) {
            if (operators[i] == '+') {
                result += numbers[i + 1];
            } else if (operators[i] == '-') {
                result -= numbers[i + 1];
            }
        }
        
        return result;
    }
}