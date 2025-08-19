import java.util.*;

public class BMI {
    public static String[][] computeBMI(double[][] arr) {
        String[][] result = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double w = arr[i][0];
            double h = arr[i][1] / 100;
            double bmi = w / (h * h);
            String status;
            if (bmi < 18.5)
                status = "Underweight";
            else if (bmi < 24.9)
                status = "Normal";
            else if (bmi < 29.9)
                status = "Overweight";
            else
                status = "Obese";
            result[i][0] = String.valueOf(arr[i][0]);
            result[i][1] = String.valueOf(arr[i][1]);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }
        return result;
    }

    public static void display(String[][] arr) {
        System.out.printf("%-10s%-10s%-10s%-15s\n", "Weight", "Height", "BMI", "Status");
        for (String[] row : arr) {
            System.out.printf("%-10s%-10s%-10s%-15s\n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] arr = new double[10][2];
        for (int i = 0; i < 10; i++) {
            arr[i][0] = sc.nextDouble();
            arr[i][1] = sc.nextDouble();
        }
        String[][] res = computeBMI(arr);
        display(res);
        sc.close();
    }
}
