/**
 * W2S2 Assignment 6: File Organizer System
 * 
 * Task: Write a program to create a simple text-based file organizer that
 * categorizes and renames files based on their extensions and content analysis
 */

import java.util.Scanner;

public class FileOrganizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of files: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        
        String[] fileNames = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter file " + (i + 1) + ": ");
            fileNames[i] = scanner.nextLine();
        }
        
        String[][] fileInfo = extractFileComponents(fileNames);
        String[] categories = categorizeFiles(fileInfo);
        String[] newNames = generateNewFileNames(fileInfo, categories);
        String[] priorities = analyzeContentPriority(fileInfo);
        
        displayFileOrganizationReport(fileNames, fileInfo, categories, newNames, priorities);
        generateBatchRenameCommands(fileNames, newNames);
        
        scanner.close();
    }
    
    public static String[][] extractFileComponents(String[] fileNames) {
        String[][] fileInfo = new String[fileNames.length][3]; // filename, extension, validation
        
        for (int i = 0; i < fileNames.length; i++) {
            String fileName = fileNames[i];
            int lastDotIndex = fileName.lastIndexOf('.');
            
            if (lastDotIndex != -1 && lastDotIndex < fileName.length() - 1) {
                fileInfo[i][0] = fileName.substring(0, lastDotIndex); // filename
                fileInfo[i][1] = fileName.substring(lastDotIndex + 1).toLowerCase(); // extension
                fileInfo[i][2] = validateFileName(fileName) ? "Valid" : "Invalid"; // validation
            } else {
                fileInfo[i][0] = fileName;
                fileInfo[i][1] = "unknown";
                fileInfo[i][2] = "No Extension";
            }
        }
        
        return fileInfo;
    }
    
    public static boolean validateFileName(String fileName) {
        // Check for invalid characters
        String invalidChars = "<>:\"/\\|?*";
        for (int i = 0; i < invalidChars.length(); i++) {
            if (fileName.indexOf(invalidChars.charAt(i)) != -1) {
                return false;
            }
        }
        return fileName.length() > 0 && fileName.length() <= 255;
    }
    
    public static String[] categorizeFiles(String[][] fileInfo) {
        String[] categories = new String[fileInfo.length];
        
        for (int i = 0; i < fileInfo.length; i++) {
            String extension = fileInfo[i][1];
            
            if (extension.equals("txt") || extension.equals("doc") || extension.equals("docx") || 
                extension.equals("pdf") || extension.equals("rtf")) {
                categories[i] = "Documents";
            } else if (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png") || 
                      extension.equals("gif") || extension.equals("bmp")) {
                categories[i] = "Images";
            } else if (extension.equals("mp3") || extension.equals("wav") || extension.equals("flac") || 
                      extension.equals("aac")) {
                categories[i] = "Audio";
            } else if (extension.equals("mp4") || extension.equals("avi") || extension.equals("mkv") || 
                      extension.equals("mov")) {
                categories[i] = "Video";
            } else if (extension.equals("java") || extension.equals("py") || extension.equals("cpp") || 
                      extension.equals("js") || extension.equals("html")) {
                categories[i] = "Code";
            } else if (extension.equals("zip") || extension.equals("rar") || extension.equals("7z") || 
                      extension.equals("tar")) {
                categories[i] = "Archives";
            } else {
                categories[i] = "Unknown";
            }
        }
        
        return categories;
    }
    
    public static String[] generateNewFileNames(String[][] fileInfo, String[] categories) {
        StringBuilder sb = new StringBuilder();
        String[] newNames = new String[fileInfo.length];
        int[] categoryCounts = new int[10]; // Assume max 10 different categories
        String[] categoryNames = {"Documents", "Images", "Audio", "Video", "Code", "Archives", "Unknown"};
        
        for (int i = 0; i < fileInfo.length; i++) {
            sb.setLength(0);
            
            String category = categories[i];
            int categoryIndex = getCategoryIndex(category, categoryNames);
            categoryCounts[categoryIndex]++;
            
            // Generate new name: Category_001.extension
            sb.append(category).append("_");
            sb.append(String.format("%03d", categoryCounts[categoryIndex]));
            
            if (!fileInfo[i][1].equals("unknown")) {
                sb.append(".").append(fileInfo[i][1]);
            }
            
            newNames[i] = sb.toString();
        }
        
        return newNames;
    }
    
    public static int getCategoryIndex(String category, String[] categoryNames) {
        for (int i = 0; i < categoryNames.length; i++) {
            if (categoryNames[i].equals(category)) {
                return i;
            }
        }
        return categoryNames.length - 1; // Return last index for unknown
    }
    
    public static String[] analyzeContentPriority(String[][] fileInfo) {
        String[] priorities = new String[fileInfo.length];
        
        for (int i = 0; i < fileInfo.length; i++) {
            String fileName = fileInfo[i][0].toLowerCase();
            
            if (fileName.contains("important") || fileName.contains("urgent") || 
                fileName.contains("critical") || fileName.contains("priority")) {
                priorities[i] = "High";
            } else if (fileName.contains("backup") || fileName.contains("temp") || 
                      fileName.contains("draft") || fileName.contains("old")) {
                priorities[i] = "Low";
            } else {
                priorities[i] = "Medium";
            }
        }
        
        return priorities;
    }
    
    public static void displayFileOrganizationReport(String[] originalNames, String[][] fileInfo, 
                                                   String[] categories, String[] newNames, String[] priorities) {
        System.out.println("\n=== FILE ORGANIZATION REPORT ===");
        System.out.println("┌─────────────────────┬─────────────┬───────────┬─────────────────────┬──────────┬──────────┐");
        System.out.println("│ Original Filename   │ Category    │ Extension │ Suggested New Name  │ Priority │ Status   │");
        System.out.println("├─────────────────────┼─────────────┼───────────┼─────────────────────┼──────────┼──────────┤");
        
        int[] categoryCount = new int[7]; // Documents, Images, Audio, Video, Code, Archives, Unknown
        String[] categoryNames = {"Documents", "Images", "Audio", "Video", "Code", "Archives", "Unknown"};
        
        for (int i = 0; i < originalNames.length; i++) {
            String displayOriginal = originalNames[i].length() > 19 ? 
                                   originalNames[i].substring(0, 16) + "..." : originalNames[i];
            String displayNew = newNames[i].length() > 19 ? 
                               newNames[i].substring(0, 16) + "..." : newNames[i];
            
            System.out.printf("│ %-19s │ %-11s │ %-9s │ %-19s │ %-8s │ %-8s │%n",
                            displayOriginal, categories[i], fileInfo[i][1], 
                            displayNew, priorities[i], fileInfo[i][2]);
            
            // Count categories
            for (int j = 0; j < categoryNames.length; j++) {
                if (categories[i].equals(categoryNames[j])) {
                    categoryCount[j]++;
                    break;
                }
            }
        }
        
        System.out.println("└─────────────────────┴─────────────┴───────────┴─────────────────────┴──────────┴──────────┘");
        
        // Category statistics
        System.out.println("\n=== CATEGORY STATISTICS ===");
        for (int i = 0; i < categoryNames.length; i++) {
            if (categoryCount[i] > 0) {
                System.out.println(categoryNames[i] + ": " + categoryCount[i] + " files");
            }
        }
        
        // Files needing attention
        System.out.println("\n=== FILES NEEDING ATTENTION ===");
        boolean hasIssues = false;
        for (int i = 0; i < originalNames.length; i++) {
            if (fileInfo[i][2].equals("Invalid") || categories[i].equals("Unknown")) {
                System.out.println("• " + originalNames[i] + " - " + fileInfo[i][2]);
                hasIssues = true;
            }
        }
        
        if (!hasIssues) {
            System.out.println("No files need attention - all files are properly formatted!");
        }
    }
    
    public static void generateBatchRenameCommands(String[] originalNames, String[] newNames) {
        System.out.println("\n=== BATCH RENAME COMMANDS ===");
        System.out.println("Windows Commands:");
        
        for (int i = 0; i < originalNames.length; i++) {
            System.out.println("ren \"" + originalNames[i] + "\" \"" + newNames[i] + "\"");
        }
        
        System.out.println("\nBefore/After Comparison:");
        System.out.println("┌─────────────────────┬─────────────────────┐");
        System.out.println("│ Before              │ After               │");
        System.out.println("├─────────────────────┼─────────────────────┤");
        
        for (int i = 0; i < originalNames.length; i++) {
            String before = originalNames[i].length() > 19 ? 
                           originalNames[i].substring(0, 16) + "..." : originalNames[i];
            String after = newNames[i].length() > 19 ? 
                          newNames[i].substring(0, 16) + "..." : newNames[i];
            
            System.out.printf("│ %-19s │ %-19s │%n", before, after);
        }
        
        System.out.println("└─────────────────────┴─────────────────────┘");
        
        // Organization improvement calculation
        int improvedFiles = 0;
        for (int i = 0; i < originalNames.length; i++) {
            if (!originalNames[i].equals(newNames[i])) {
                improvedFiles++;
            }
        }
        
        double improvementPercentage = (double) improvedFiles / originalNames.length * 100;
        System.out.printf("\nOrganization improvement: %.1f%% (%d out of %d files)%n", 
                         improvementPercentage, improvedFiles, originalNames.length);
    }
}