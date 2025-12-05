package week9.exercise2;

import java.util.Comparator;
import week9.exercise2.OnlineCourse;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        OnlineCourse course = new OnlineCourse("Java Programming");
        course.addStudent("ivan");
        course.addStudent("Stoicho");
        for(OnlineCourse.Student s: course.students){
            System.out.println(s.name + " grades");
            while(true){
                System.out.print("Enter grade(0 to exit): ");
                int grade = Integer.parseInt(input.nextLine());
                if(grade!=0) {
                    s.addGrade(grade);
                }
                else{
                    break;
                }
            }
        }
        course.calculateAttendanceBonus();
        List<OnlineCourse.Student> studs = course.students;
        OnlineCourse.Student.GradingPolicy policy = new OnlineCourse.Student.GradingPolicy();
        studs.sort((a, b) -> {
            double avgA = policy.calculateAverage(a.getGrades());
            double avgB = policy.calculateAverage(b.getGrades());
            return Double.compare(avgB, avgA);
        });

        studs.forEach(s -> {
            double avg = policy.calculateAverage(s.getGrades());
            s.printInfo();
            System.out.println(s.name + " -> Average: " + avg);
            String mark = s.getFinalMark(avg);
            System.out.println("Mark: ");
        });
    }
}
