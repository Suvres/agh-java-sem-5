package lab8.Repository;

import lab8.Entity.Rating;
import lab8.Entity.Student;
import lab8.Entity.StudentCourse;
import lab8.Entity.StudentCourseContainer;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentCourseContainerRepository extends AbstractRepository {

    public static List<StudentCourseContainer> findAll() {
        Session s = getSession();
        String sql = "Select c FROM StudentCourseContainer c";

        List<StudentCourseContainer> list = s.createQuery(sql).getResultList();
        s.close();

        return list;
    }

    public static StudentCourseContainer findById(int id) {
        Session s = getSession();
        String sql = "Select c FROM StudentCourseContainer c WHERE c.id = :id";

        Query query = s.createQuery(sql);
        query.setParameter("id", id);

        StudentCourseContainer list = (StudentCourseContainer) query.getSingleResult();
        s.close();

        return list;
    }
}
