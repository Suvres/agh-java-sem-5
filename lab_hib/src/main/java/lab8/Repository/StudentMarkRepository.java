package lab8.Repository;

import lab8.Entity.Student;
import lab8.Entity.StudentCourse;
import lab8.Entity.StudentMark;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentMarkRepository extends AbstractRepository {

    public static List<StudentMark> findAll() {
        Session s = getSession();
        String sql = "Select c FROM StudentMark c";

        List<StudentMark> list = s.createQuery(sql).getResultList();
        s.close();

        return list;
    }

    public static List<StudentMark> findByCourse(StudentCourse course) {

        Session s = getSession();
        String sql = "Select c FROM StudentMark c where c.course = :course";

        Query query = s.createQuery(sql);
        query.setParameter("course", course);

        List<StudentMark> list = query.getResultList();
        s.close();

        return list;
    }

    public static List<StudentMark> findByStudent(Student student) {

        Session s = getSession();
        String sql = "Select c FROM StudentMark c where c.student = :s";

        Query query = s.createQuery(sql);
        query.setParameter("s", student);

        List<StudentMark> list = query.getResultList();
        s.close();

        return list;
    }
}
