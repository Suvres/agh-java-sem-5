package lab9.Repository;

import lab9.Entity.Student;
import lab9.Entity.StudentCourse;
import org.springframework.data.repository.CrudRepository;

public interface StudentCourseRepository extends CrudRepository<StudentCourse, Integer> {

}
