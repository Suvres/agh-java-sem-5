package lab9.Service;

import lab9.Entity.StudentCourse;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {
    public double getFill(StudentCourse c) {
        return (double) c.getStudentsList().size() / c.getMaxStudentsCount();
    }
}
