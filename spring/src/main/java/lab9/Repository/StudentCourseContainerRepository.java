package lab9.Repository;

import lab9.Entity.StudentCourse;
import lab9.Entity.StudentCourseContainer;
import org.springframework.data.repository.CrudRepository;

public interface StudentCourseContainerRepository extends CrudRepository<StudentCourseContainer, Integer> {

}
