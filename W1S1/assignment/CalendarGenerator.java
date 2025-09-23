import java.util.*;

public class CalendarGenerator {
    static String[] months = {"", "January", "February", "March", "April", "May", "June",
                             "July", "August", "September", "October", "November", "December"};
    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    static int getDays(int month, int year) {
        if (month == 2 && isLeap(year)) return 29;
        return days[month];
    }

    static int getFirstDay(int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (1 + x + 31 * m0 / 12) % 7;
    }

    static void displayCalendar(int month, int year) {
        System.out.println("\n" + months[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        
        int firstDay = getFirstDay(month, year);
        int numDays = getDays(month, year);
        
        for (int i = 0; i < firstDay; i++)
            System.out.print("    ");
        
        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        displayCalendar(month, year);
        sc.close();
    }
}