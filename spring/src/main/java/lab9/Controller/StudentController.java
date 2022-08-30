package lab9.Controller;

import lab9.Entity.Student;
import lab9.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import lab9.Repository.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public Iterable<Student> index() {
        return studentRepository.findAll();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            Student s = this.studentRepository.findById(id).get();
            this.entityManager.remove(s);
            this.entityManager.flush();
            return new ResponseEntity<String>("", HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<String>("", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{id}/grade")
    public ResponseEntity<String> getGrades(@PathVariable int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            Student s = this.studentRepository.findById(id).get();
            double avg = this.studentService.computeMarkAvg(s) * 100;
            int avg_int = (int) avg;
            avg = (double) avg_int / 100.0;

            return new ResponseEntity<String>(
                    String.format("{\"avg\":%s}",
                            String.valueOf(avg).replace(',', '.')
                    ),
                    headers, HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<String>("", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional()
    public ResponseEntity<String> putStudent(@RequestBody Student student) {
        try {
            Student s = Student.createFromRequest(student);
            this.entityManager.persist(s);
            this.entityManager.flush();
            return new ResponseEntity<String>("", HttpStatus.ACCEPTED);
        } catch (Throwable e) {
            return new ResponseEntity<String>("", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
