package lab6.Student;

import java.io.Serializable;
import java.util.Date;

public class StudentMark implements Serializable {

    @CSV
    public Student student;

    @CSV
    public double mark;

    @CSV
    public Date date;

    public StudentMark() {
        this.date = new Date();
    }

    public StudentMark(Student student, double mark) {
           this.student = student;
           this.mark = mark;
           this.date = new Date();
    }
}
