package lab9.Service;

import lab9.Entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService{

    public double computeMarkAvg(Student s) {
        return s.getStudentMarks().stream().mapToDouble(_item -> +_item.getMark())
                .sum() / (double) s.getStudentMarks().size();
    }
}
