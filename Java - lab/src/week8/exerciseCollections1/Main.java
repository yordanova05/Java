package week8.exerciseCollections1;
import java.util.*;
import java.util.Scanner;
import java.util.Collection;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("N: ");
        int n = input.nextInt();
        input.nextLine();
        List<Student> studentsLinkedList = new LinkedList<Student>();

        while(n>0){
            System.out.println("Name Grade Age");
            String name = input.nextLine();
            int grade = input.nextInt();
            input.nextLine();
            int age = input.nextInt();
            input.nextLine();
            Student student = new Student(name,grade,age);

            studentsLinkedList.add(student);
            n--;
        }

        Deque<Student> studentsDeque = new LinkedList<Student>();

        for(Student s: studentsLinkedList){
            if ( s.grade < 5 && s.grade >=2){
                studentsDeque.addFirst(s);
            }
            else if (s.grade >= 5 && s.grade<=6){
                studentsDeque.addLast(s);
            }
            else{
                throw new Exception("Invalid grade!");
            }
        }

        List<Student> tempList = new ArrayList<>(studentsDeque);

        tempList.sort((a,b)-> Integer.compare(a.getAge(),b.getAge()));
        for (Student s: tempList){
            System.out.println(s.toString());
        }

        Student max = studentsDeque.getFirst();
        for(Student s: studentsDeque){
            if (max.grade < s.grade ){
                max = s;
            }
        }
        System.out.println("Highest grade: ");
        System.out.println(max.toString());
    }
}
