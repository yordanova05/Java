package week10.model;

public class Document {
    public enum Type {
        SUCCESS,
        SPECIAL
    }

    private String name;
    private double grade;
    private double income;
    private String faculty;
    private Type type;

    public Document(String name, double grade, double income, String faculty, Type type) {
        this.name = name;
        this.grade = grade;
        this.income = income;
        this.faculty = faculty;
        this.type = type;
    }

    public String getName() { return name; }
    public double getGrade() { return grade; }
    public double getIncome() { return income; }
    public Type getType() { return type; }

    @Override
    public String toString() {
        return name + " | success=" + grade + " | income=" + income + " | type=" + type;
    }
}

