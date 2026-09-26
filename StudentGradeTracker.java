import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("=================================");
        System.out.println("      STUDENT GRADE TRACKER");
        System.out.println("=================================");

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfStudents; i++) {

            System.out.print("\nEnter student " + (i + 1) + " name: ");
            String name = scanner.nextLine();

            System.out.print("Enter " + name + "'s grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine();

            studentNames.add(name);
            grades.add(grade);
        }

        double total = 0;

        for (double grade : grades) {
            total += grade;
        }

        double average = total / grades.size();

        double highest = grades.get(0);

        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }

        double lowest = grades.get(0);

        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }

        System.out.println("\n=================================");
        System.out.println("          SUMMARY REPORT");
        System.out.println("=================================");

        System.out.printf("%-20s %s%n", "Student Name", "Grade");
        System.out.println("---------------------------------");

        for (int i = 0; i < studentNames.size(); i++) {
            System.out.printf(
                "%-20s %.2f%n",
                studentNames.get(i),
                grades.get(i)
            );
        }

        System.out.println("---------------------------------");
        System.out.printf("Average Grade : %.2f%n", average);
        System.out.printf("Highest Grade : %.2f%n", highest);
        System.out.printf("Lowest Grade  : %.2f%n", lowest);

        System.out.println("=================================");

        scanner.close();
    }
}