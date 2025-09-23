/**
 * W2S2 Lab 5: Email Address Analyzer
 * 
 * Task: Write a program to extract and analyze different parts of an
 * email address using substring() and indexOf() methods
 */

import java.util.Scanner;

public class EmailAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of email addresses: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        
        String[] emails = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter email " + (i + 1) + ": ");
            emails[i] = scanner.nextLine();
        }
        
        System.out.println("\n=== EMAIL ANALYSIS ===");
        analyzeEmails(emails);
        
        scanner.close();
    }
    
    public static boolean validateEmail(String email) {
        int atIndex = email.indexOf('@');
        int lastAtIndex = email.lastIndexOf('@');
        
        // Check for exactly one '@' symbol
        if (atIndex == -1 || atIndex != lastAtIndex) return false;
        
        // Check for at least one '.' after '@'
        int dotIndex = email.indexOf('.', atIndex);
        if (dotIndex == -1) return false;
        
        // Validate that username and domain are not empty
        if (atIndex == 0 || atIndex == email.length() - 1) return false;
        
        return true;
    }
    
    public static String[] extractComponents(String email) {
        String[] components = new String[4]; // username, domain, domainName, extension
        
        int atIndex = email.indexOf('@');
        if (atIndex == -1) return components;
        
        // Extract username
        components[0] = email.substring(0, atIndex);
        
        // Extract domain
        components[1] = email.substring(atIndex + 1);
        
        // Extract domain name and extension
        int lastDotIndex = components[1].lastIndexOf('.');
        if (lastDotIndex != -1) {
            components[2] = components[1].substring(0, lastDotIndex);
            components[3] = components[1].substring(lastDotIndex + 1);
        }
        
        return components;
    }
    
    public static void analyzeEmails(String[] emails) {
        int validCount = 0;
        int totalUsernameLength = 0;
        String[] domains = new String[emails.length];
        int[] domainCounts = new int[emails.length];
        int uniqueDomains = 0;
        
        System.out.println("┌─────────────────────────┬──────────┬─────────────┬─────────────┬───────────┬─────────┐");
        System.out.println("│ Email                   │ Username │ Domain      │ Domain Name │ Extension │ Valid   │");
        System.out.println("├─────────────────────────┼──────────┼─────────────┼─────────────┼───────────┼─────────┤");
        
        for (String email : emails) {
            boolean isValid = validateEmail(email);
            String[] components = extractComponents(email);
            
            String displayEmail = email.length() > 23 ? email.substring(0, 20) + "..." : email;
            System.out.printf("│ %-23s │ %-8s │ %-11s │ %-11s │ %-9s │ %-7s │%n",
                            displayEmail,
                            components[0] != null ? components[0] : "N/A",
                            components[1] != null ? components[1] : "N/A",
                            components[2] != null ? components[2] : "N/A",
                            components[3] != null ? components[3] : "N/A",
                            isValid ? "Yes" : "No");
            
            if (isValid) {
                validCount++;
                if (components[0] != null) {
                    totalUsernameLength += components[0].length();
                }
                
                // Count domain frequency
                if (components[1] != null) {
                    boolean found = false;
                    for (int i = 0; i < uniqueDomains; i++) {
                        if (domains[i].equals(components[1])) {
                            domainCounts[i]++;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        domains[uniqueDomains] = components[1];
                        domainCounts[uniqueDomains] = 1;
                        uniqueDomains++;
                    }
                }
            }
        }
        
        System.out.println("└─────────────────────────┴──────────┴─────────────┴─────────────┴───────────┴─────────┘");
        
        // Display statistics
        System.out.println("\n=== STATISTICS ===");
        System.out.println("Total emails: " + emails.length);
        System.out.println("Valid emails: " + validCount);
        System.out.println("Invalid emails: " + (emails.length - validCount));
        
        if (validCount > 0) {
            double avgUsernameLength = (double) totalUsernameLength / validCount;
            System.out.printf("Average username length: %.2f%n", avgUsernameLength);
            
            // Find most common domain
            String mostCommonDomain = "";
            int maxCount = 0;
            for (int i = 0; i < uniqueDomains; i++) {
                if (domainCounts[i] > maxCount) {
                    maxCount = domainCounts[i];
                    mostCommonDomain = domains[i];
                }
            }
            System.out.println("Most common domain: " + mostCommonDomain + " (" + maxCount + " occurrences)");
        }
    }
}