// File: FileSystemUtils.java
// ASSIGNMENT 8: File System Utilities

public class FileSystemUtils {
    
    private FileSystemUtils() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    public static class FileInfo {
        private String name;
        private long size;
        private String type;
        
        public FileInfo(String name, long size) {
            this.name = name;
            this.size = size;
            this.type = getFileType(name);
        }
        
        private static String getFileType(String filename) {
            int lastDot = filename.lastIndexOf('.');
            return lastDot > 0 ? filename.substring(lastDot + 1) : "unknown";
        }
        
        public void displayInfo() {
            System.out.println(name + " (" + formatSize(size) + ") - " + type.toUpperCase());
        }
        
        public String getName() { return name; }
        public String getType() { return type; }
        public long getSize() { return size; }
    }
    
    public static String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        else if (bytes < 1024 * 1024) return (bytes / 1024) + " KB";
        else return (bytes / (1024 * 1024)) + " MB";
    }
    
    public static void analyzeFiles(FileInfo[] files) {
        System.out.println("=== File Analysis ===");
        long totalSize = 0;
        int[] typeCounts = new int[4]; // txt, jpg, pdf, other
        
        for (FileInfo file : files) {
            totalSize += file.getSize();
            switch (file.getType().toLowerCase()) {
                case "txt": typeCounts[0]++; break;
                case "jpg": case "jpeg": typeCounts[1]++; break;
                case "pdf": typeCounts[2]++; break;
                default: typeCounts[3]++; break;
            }
        }
        
        System.out.println("Total files: " + files.length);
        System.out.println("Total size: " + formatSize(totalSize));
        System.out.println("Text files: " + typeCounts[0]);
        System.out.println("Image files: " + typeCounts[1]);
        System.out.println("PDF files: " + typeCounts[2]);
        System.out.println("Other files: " + typeCounts[3]);
    }
    
    public static void main(String[] args) {
        FileInfo[] files = {
            new FileInfo("document.txt", 1024),
            new FileInfo("photo.jpg", 2048000),
            new FileInfo("report.pdf", 512000),
            new FileInfo("data.csv", 256000),
            new FileInfo("image.png", 1024000)
        };
        
        System.out.println("=== File List ===");
        for (FileInfo file : files) {
            file.displayInfo();
        }
        
        System.out.println();
        analyzeFiles(files);
    }
}