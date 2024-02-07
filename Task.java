//
// Task 2
//
// Input: Take marks obtained (out of 100) in each subject.
// Calculate Total Marks: Sum up the marks obtained in all subjects.
// Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
// average percentage.
// Grade Calculation: Assign grades based on the average percentage achieved.
// Display Results: Show the total marks, average percentage, and the corresponding grade to the user
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      //  System.out.println("Enter a subject:");
       // String subjectName = scanner.next();
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        int[] subjectMarks = new int[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            subjectMarks[i] = scanner.nextInt();
        }

        int totalMarks = calculateTotalMarks(subjectMarks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
        char grade = calculateGrade(averagePercentage);

        displayResults(totalMarks, averagePercentage, grade);
    }

    public static int calculateTotalMarks(int[] subjectMarks) {
        int totalMarks = 0;
        for (int marks : subjectMarks) {
            totalMarks += marks;
        }
        return totalMarks;
    }

    public static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
