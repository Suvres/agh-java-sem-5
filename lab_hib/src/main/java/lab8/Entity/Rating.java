package lab8.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Rating {

    @Id
    @GeneratedValue(generator = "rating_seq")
    @Column
    private int id;

    @Column(nullable = false)
    private int rate;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private StudentCourse course;

    @Column
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public StudentCourse getCourse() {
        return course;
    }

    public void setCourse(StudentCourse course) {
        this.course = course;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
