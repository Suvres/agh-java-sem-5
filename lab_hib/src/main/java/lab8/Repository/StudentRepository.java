package lab8.Repository;

import lab8.Entity.Student;
import org.hibernate.Session;
import java.util.List;

public class StudentRepository extends AbstractRepository {

    public static List<Student> findAll() {
        Session s = getSession();
        String sql = "Select c FROM Student c";

        List<Student> list = s.createQuery(sql).getResultList();
        s.close();

        return list;
    }

}
