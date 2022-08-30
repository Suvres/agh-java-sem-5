package lab8.Repository;

import lab8.Entity.Rating;
import lab8.Entity.StudentCourse;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class RatingRepository extends AbstractRepository {

    public static List<Rating> findAll() {
        Session s = getSession();
        String sql = "SELECT r FROM Rating r";

        List<Rating> list = s.createQuery(sql).getResultList();
        s.close();

        return list;
    }

    public static List<Rating> getRatings(StudentCourse course) {
        Session s = getSession();
        String sql = "SELECT r FROM Rating r WHERE r.course = :course";

        Query q = s.createQuery(sql);
        q.setParameter("course", course);

        List<Rating> list =q.getResultList();
        s.close();

        return list;
    }

    public static List<Rating> getRatingsFromDate(Date date) {
        Session s = getSession();
        String sql = "SELECT r FROM Rating r WHERE r.date >= :date";
        Query q = s.createQuery(sql);
        q.setParameter("date", date);

        List<Rating> list = q.getResultList();
        s.close();

        return list;
    }

    public static List<Rating> getRatingsToDate(Date date) {
        Session s = getSession();
        String sql = "SELECT r FROM Rating r WHERE r.date <= :date";

        Query q = s.createQuery(sql);
        q.setParameter("date", date);

        List<Rating> list = q.getResultList();
        s.close();

        return list;
    }
}
