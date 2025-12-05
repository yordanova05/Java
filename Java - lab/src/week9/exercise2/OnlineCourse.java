package week9.exercise2;

import java.util.List;
import java.util.*;

public class OnlineCourse {
    private String title;
    List<Student> students = new ArrayList<>();

    public OnlineCourse(String title ){
        this.title = title;
    }
    public OnlineCourse(){}

    public Student addStudent(String name) {
        Student student = new Student(name);
        students.add(student);
        return student;
    }

    public void calculateAttendanceBonus(){
        class AttendanceBonusCalculator{
            Student student;
            void applyBonus(){
                if(student.attendedLectures > 0.80){
                    if(!student.grades.isEmpty()){
                        int lastIndex = student.grades.size() - 1;
                        int lastGrade = student.grades.get(lastIndex);
                        int newGrade = Math.min(lastGrade + 1, 6); // максимум 6
                        student.grades.set(lastIndex, newGrade);
                    } else {
                        student.grades.add(6);
                    }
                    System.out.println(student.name + " получи бонус за присъствия!");
                }
            }
        }
        for(Student s: students){
            AttendanceBonusCalculator bonusCalculator = new AttendanceBonusCalculator();
            bonusCalculator.applyBonus();
        }
    }
    public class Student{
        protected String name;
        private List<Integer> grades = new ArrayList<>();
        private int attendedLectures;

        public Student(String name){
            this.name = name;
            attendedLectures = 0;
        }
        public List<Integer> getGrades() {
            return grades;
        }

        public void addGrade(int grade){
            if(grade >= 2 && grade <=6){
                grades.add(grade);
                System.out.println("Grade added successfully!");
            }
            else{
                System.out.println("Grade incorrect!!");
            }
        }
        public void attendLecture(){
                attendedLectures++;
                System.out.println("Lecture added successfully!");
        }
        public void printInfo(){
            System.out.print("Student <" + name + "> , grades ");
            grades.forEach(System.out::print);
            System.out.println(" ,attended " + attendedLectures + " lectures ");
        }
        public static class GradingPolicy{
            public static double calculateAverage(List<Integer> grades){
                return grades.stream().mapToInt(Integer::intValue).average().orElse(0);
            }
        }
        public static String getFinalMark(double average){
            if( average >=5.50){
                return "Excellent";
            }
            else if( average >= 4.50){
                return "Good";
            }
            else if(average >=3.50){
                return "Average";
            }
            else if( average >= 2.00){
                return "Poor";
            }
            else{
                return "Error!";
            }
        }
    }
}
