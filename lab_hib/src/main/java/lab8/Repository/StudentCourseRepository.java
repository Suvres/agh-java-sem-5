package lab8.Repository;

import lab8.Entity.Rating;
import lab8.Entity.StudentCourse;
import lab8.Entity.StudentCourseContainer;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class StudentCourseRepository extends AbstractRepository {

    public static List<StudentCourse> findAll() {
        Session s = getSession();
        String sql = "Select c FROM StudentCourse c";

        List<StudentCourse> list = s.createQuery(sql).getResultList();
        s.close();

        return list;
    }

    public static StudentCourse findById(int id) {

        Session s = getSession();
        String sql = "Select c FROM StudentCourse c WHERE c.id = :id";

        Query query = s.createQuery(sql);
        query.setParameter("id", id);

        StudentCourse list = (StudentCourse) query.getSingleResult();
        s.close();

        return list;
    }
}
