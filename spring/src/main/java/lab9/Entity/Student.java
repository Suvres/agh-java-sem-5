package lab9.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Student{

    @Id
    @GeneratedValue(generator = "student_seq")
    @Column
    private int index;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private StudentCondition condition;

    @Column(nullable = false)
    private String birthDay;

    @OneToMany(mappedBy="student", cascade={CascadeType.REMOVE})
    private Set<StudentMark> studentMarks;

    public static Student createFromRequest(Student student) {
        Student s = new Student();
        s.birthDay = student.getBirthDay();
        s.email = student.getEmail();
        s.condition = student.getCondition();
        s.firstName = student.getFirstName();
        s.lastName = student.getLastName();
        return s;
    }

    @Override
    public String toString() {
        return String.valueOf(index);
    }

    private String email;

    public Student(){
        this.condition = StudentCondition.NIEOBECNY;
        this.studentMarks = new HashSet<>();
    }

    public Student(
            String firstName,
            String lastName,
            StudentCondition condition,
            String birthDay,
            String email
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.condition = condition;
        this.birthDay = birthDay;
        this.email = email;
        this.studentMarks = new HashSet<>();

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudentCondition getCondition() {
        return condition;
    }

    public void setCondition(StudentCondition condition) {
        this.condition = condition;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<StudentMark> getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(Set<StudentMark> studentMarks) {
        this.studentMarks = studentMarks;
    }
}
