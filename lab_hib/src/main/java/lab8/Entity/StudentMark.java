package lab8.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class StudentMark implements Serializable {

    @Id
    @GeneratedValue(generator = "student_mark_seq")
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @Column
    private double mark;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name="course_id")
    private StudentCourse course;

    public StudentMark(){}

    public static StudentMark createStudentMark(Student student, double mark) {
        StudentMark self = new StudentMark();
        self.student = student;
        self.mark = mark;
        self.date = new Date();
        return self;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public StudentCourse getCourse() {
        return course;
    }

    public void setCourse(StudentCourse course) {
        this.course = course;
    }
}
