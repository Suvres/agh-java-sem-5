package lab9.Entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class StudentCourseContainer implements Serializable {

    @Id
    @GeneratedValue(generator = "student_c_c_seq")
    @Column
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy="id")
    @LazyCollection(LazyCollectionOption.TRUE)
    private Set<StudentCourse> groups;

    public StudentCourseContainer() {
        this.groups = new HashSet<>();
    }

    public void addGroup(StudentCourse c) {
        this.groups.add(c);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StudentCourse> getGroups() {
        return groups;
    }

    public void setGroups(HashSet<StudentCourse> groups) {
        this.groups = groups;
    }
}
