// ASSIGNMENT 2: Online Learning Platform - Method Overriding
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Course {
    protected String title;
    protected String instructor;
    protected LocalDate enrollmentDate;
    protected double progress;
    
    public Course(String title, String instructor) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = LocalDate.now();
        this.progress = 0.0;
    }
    
    public void displayProgress() {
        System.out.println("📚 Course: " + title);
        System.out.println("👨‍🏫 Instructor: " + instructor);
        System.out.println("📅 Enrolled: " + enrollmentDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println("📊 Progress: " + String.format("%.1f", progress) + "%");
    }
    
    public void updateProgress(double newProgress) {
        this.progress = Math.min(100.0, newProgress);
    }
}

class VideoCourse extends Course {
    private double watchTime;
    private double totalDuration;
    private int videosCompleted;
    private int totalVideos;
    
    public VideoCourse(String title, String instructor, double totalDuration, int totalVideos) {
        super(title, instructor);
        this.totalDuration = totalDuration;
        this.totalVideos = totalVideos;
        this.watchTime = 0.0;
        this.videosCompleted = 0;
    }
    
    @Override
    public void displayProgress() {
        progress = (watchTime / totalDuration) * 100;
        System.out.println("🎥 Video Course: " + title);
        System.out.println("👨‍🏫 Instructor: " + instructor);
        System.out.println("📅 Enrolled: " + enrollmentDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println("⏱️ Watch Time: " + String.format("%.1f", watchTime) + "/" + totalDuration + " hours");
        System.out.println("📹 Videos Completed: " + videosCompleted + "/" + totalVideos);
        System.out.println("📊 Completion: " + String.format("%.1f", progress) + "%");
    }
    
    public void watchVideo(double duration) {
        watchTime += duration;
        videosCompleted++;
        System.out.println("▶️ Watched video for " + duration + " hours");
    }
}

class InteractiveCourse extends Course {
    private int quizScore;
    private int totalQuizzes;
    private int projectsCompleted;
    private int totalProjects;
    
    public InteractiveCourse(String title, String instructor, int totalQuizzes, int totalProjects) {
        super(title, instructor);
        this.totalQuizzes = totalQuizzes;
        this.totalProjects = totalProjects;
        this.quizScore = 0;
        this.projectsCompleted = 0;
    }
    
    @Override
    public void displayProgress() {
        double quizProgress = totalQuizzes > 0 ? (quizScore / (double)(totalQuizzes * 100)) * 100 : 0;
        double projectProgress = totalProjects > 0 ? (projectsCompleted / (double)totalProjects) * 100 : 0;
        progress = (quizProgress + projectProgress) / 2;
        
        System.out.println("🎯 Interactive Course: " + title);
        System.out.println("👨‍🏫 Instructor: " + instructor);
        System.out.println("📅 Enrolled: " + enrollmentDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println("📝 Quiz Score: " + quizScore + "/" + (totalQuizzes * 100) + " points");
        System.out.println("🛠️ Projects Completed: " + projectsCompleted + "/" + totalProjects);
        System.out.println("📊 Overall Progress: " + String.format("%.1f", progress) + "%");
    }
    
    public void completeQuiz(int score) {
        quizScore += score;
        System.out.println("✅ Quiz completed with score: " + score + "/100");
    }
    
    public void completeProject() {
        projectsCompleted++;
        System.out.println("🎉 Project completed! Total: " + projectsCompleted);
    }
}

class ReadingCourse extends Course {
    private int pagesRead;
    private int totalPages;
    private int notesCount;
    
    public ReadingCourse(String title, String instructor, int totalPages) {
        super(title, instructor);
        this.totalPages = totalPages;
        this.pagesRead = 0;
        this.notesCount = 0;
    }
    
    @Override
    public void displayProgress() {
        progress = totalPages > 0 ? (pagesRead / (double)totalPages) * 100 : 0;
        System.out.println("📖 Reading Course: " + title);
        System.out.println("👨‍🏫 Instructor: " + instructor);
        System.out.println("📅 Enrolled: " + enrollmentDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println("📄 Pages Read: " + pagesRead + "/" + totalPages);
        System.out.println("📝 Notes Taken: " + notesCount);
        System.out.println("📊 Reading Progress: " + String.format("%.1f", progress) + "%");
    }
    
    public void readPages(int pages) {
        pagesRead += pages;
        System.out.println("📚 Read " + pages + " pages");
    }
    
    public void takeNotes() {
        notesCount++;
        System.out.println("✍️ Notes taken! Total notes: " + notesCount);
    }
}

class CertificationCourse extends Course {
    private int examAttempts;
    private int bestScore;
    private boolean certified;
    private int passingScore;
    
    public CertificationCourse(String title, String instructor, int passingScore) {
        super(title, instructor);
        this.passingScore = passingScore;
        this.examAttempts = 0;
        this.bestScore = 0;
        this.certified = false;
    }
    
    @Override
    public void displayProgress() {
        progress = certified ? 100.0 : (bestScore / (double)passingScore) * 100;
        System.out.println("🏆 Certification Course: " + title);
        System.out.println("👨‍🏫 Instructor: " + instructor);
        System.out.println("📅 Enrolled: " + enrollmentDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println("📝 Exam Attempts: " + examAttempts);
        System.out.println("🎯 Best Score: " + bestScore + "/" + passingScore + " (Passing: " + passingScore + ")");
        System.out.println("🏅 Certification Status: " + (certified ? "CERTIFIED ✅" : "In Progress"));
        System.out.println("📊 Progress: " + String.format("%.1f", progress) + "%");
    }
    
    public void takeExam(int score) {
        examAttempts++;
        bestScore = Math.max(bestScore, score);
        if (score >= passingScore) {
            certified = true;
            System.out.println("🎉 CONGRATULATIONS! You passed with score: " + score + " - CERTIFIED!");
        } else {
            System.out.println("📝 Exam attempt " + examAttempts + " - Score: " + score + " (Need " + passingScore + " to pass)");
        }
    }
}

public class OnlineLearningPlatform {
    public static void main(String[] args) {
        Course[] myCourses = {
            new VideoCourse("Java Programming Masterclass", "Dr. Smith", 40.0, 120),
            new InteractiveCourse("Web Development Bootcamp", "Sarah Johnson", 15, 8),
            new ReadingCourse("Data Structures & Algorithms", "Prof. Wilson", 450),
            new CertificationCourse("AWS Cloud Practitioner", "Mike Chen", 700)
        };
        
        System.out.println("=== Online Learning Platform ===\n");
        
        // Simulate some progress
        ((VideoCourse)myCourses[0]).watchVideo(5.5);
        ((InteractiveCourse)myCourses[1]).completeQuiz(85);
        ((InteractiveCourse)myCourses[1]).completeProject();
        ((ReadingCourse)myCourses[2]).readPages(120);
        ((ReadingCourse)myCourses[2]).takeNotes();
        ((CertificationCourse)myCourses[3]).takeExam(650);
        ((CertificationCourse)myCourses[3]).takeExam(720);
        
        System.out.println("\n=== Course Progress Dashboard ===");
        for (Course course : myCourses) {
            course.displayProgress();
            System.out.println();
        }
    }
}