package week8.exerciseCollections1;

public class Student {
    public String name;
    public int grade;
    public int age;

    public Student(){

    }
    public Student(String name, int grade, int age){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getGrade(){
        return grade;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    @Override
    public String toString(){
        return "Name: " + name + " grade: " + grade + " age: " + age;
    }
}
