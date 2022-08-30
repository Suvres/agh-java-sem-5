package lab8.Entity;

import javax.persistence.*;
import java.util.*;

@Entity()
@Table
public class StudentCourse{

    @Id
    @GeneratedValue(generator = "student_c_seq")
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name="container_id")
    private StudentCourseContainer container;

    @Column
    private String groupName;

    @OneToMany(mappedBy="index")
    private Set<Student> studentsList;

    @Column
    private double maxStudentsCount;

    @Override
    public String toString() {
        return groupName;
    }

    public StudentCourse() {
        this.studentsList = new HashSet<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(HashSet<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public double getMaxStudentsCount() {
        return maxStudentsCount;
    }

    public void setMaxStudentsCount(double maxStudentsCount) {
        this.maxStudentsCount = maxStudentsCount;
    }

    public int getId() {
        return id;
    }
}
