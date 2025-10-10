/*
Practice Problem 6: Local Inner Class
Problem: "Voting System"
*/

public class VotingSystem {
    
    public void processVote(String voterId, String candidate) {
        System.out.println("\n=== Processing Vote ===");
        System.out.println("Voter ID: " + voterId);
        System.out.println("Candidate: " + candidate);
        
        // Local Inner Class
        class VoteValidator {
            public boolean validate() {
                // Simple validation: voter ID should be 10 characters and start with 'V'
                if (voterId == null || voterId.length() != 10 || !voterId.startsWith("V")) {
                    return false;
                }
                
                // Candidate should not be null or empty
                if (candidate == null || candidate.trim().isEmpty()) {
                    return false;
                }
                
                return true;
            }
            
            public void printResult() {
                if (validate()) {
                    System.out.println("✓ Vote ACCEPTED for " + candidate);
                    System.out.println("  Voter " + voterId + " successfully voted");
                } else {
                    System.out.println("✗ Vote REJECTED");
                    System.out.println("  Invalid voter ID or candidate name");
                }
            }
        }
        
        // Use local inner class
        VoteValidator validator = new VoteValidator();
        validator.printResult();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Voting System Demo ===");
        
        VotingSystem system = new VotingSystem();
        
        // Valid votes
        system.processVote("V123456789", "Alice Johnson");
        system.processVote("V987654321", "Bob Smith");
        
        // Invalid votes
        system.processVote("123456789", "Charlie Brown");  // Invalid ID format
        system.processVote("V111111111", "");              // Empty candidate
        system.processVote("V12345", "David Wilson");      // Short ID
        system.processVote(null, "Eve Davis");             // Null ID
        
        System.out.println("\n=== Voting Summary ===");
        System.out.println("Local inner class VoteValidator used for validation");
        System.out.println("Validation rules: ID must be 10 chars starting with 'V'");
        System.out.println("Candidate name must not be null or empty");
    }
}