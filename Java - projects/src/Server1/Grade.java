package Server1;

import java.io.Serializable;
import java.util.Objects;

public class Grade implements Serializable {
    private String subject;
    private int grade;
    private int semester;

    public Grade(String subject, int grade, int semester){
        this.subject = subject;
        this.grade = grade;
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Grade g = (Grade) o;
        return semester == g.semester && grade == g.grade && Objects.equals(subject, g.subject);
    }

    @Override
    public int hashCode(){
        return Objects.hash(semester, grade, subject);
    }
}
