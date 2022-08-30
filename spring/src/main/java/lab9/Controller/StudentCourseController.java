package lab9.Controller;

import lab9.Entity.Student;
import lab9.Entity.StudentCourse;
import lab9.Entity.StudentCourseContainer;
import lab9.Repository.StudentCourseContainerRepository;
import lab9.Repository.StudentCourseRepository;
import lab9.Service.StudentCourseService;
import lab9.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/course")
public class StudentCourseController {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private StudentCourseContainerRepository studentCourseContainerRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping()
    public Iterable<StudentCourse> getCourse() {
        return studentCourseRepository.findAll();
    }

    @GetMapping("/{id}/students")
    public Set<Student> getCourseStudents(@PathVariable int id) {
        try {
            Optional<StudentCourse> c = this.studentCourseRepository.findById(id);
            return c.get().getStudentsList();
        } catch (Throwable e) {
            return null;
        }
    }

    @GetMapping("/{id}")
    public StudentCourse getCourse(@PathVariable int id) {
        return this.studentCourseRepository.findById(id).get();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<String> putCourse(@RequestBody StudentCourse course) {
        try {

            List<StudentCourseContainer> cc = new ArrayList<StudentCourseContainer>();
            this.studentCourseContainerRepository.findAll().forEach(cc::add);

            StudentCourse s = StudentCourse.createFromRequest(course, cc.get(0));

            this.entityManager.persist(s);
            this.entityManager.flush();
            return new ResponseEntity<String>("", HttpStatus.ACCEPTED);
        } catch (Throwable e) {
            this.entityManager.getTransaction().rollback();
            return new ResponseEntity<String>("", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{id}/fill")
    public ResponseEntity<String> getCourseFill(@PathVariable int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            StudentCourse c = this.studentCourseRepository.findById(id).get();
            double fill = this.studentCourseService.getFill(c) * 100.0;
            int fill_int = (int) fill;
            fill = (double) fill_int / 100.0;

            return new ResponseEntity<String>(
                    String.format("{\"fill\": %s}", String.valueOf(fill).replace(',', '.')),
                    headers, HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<String>("", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }
}
