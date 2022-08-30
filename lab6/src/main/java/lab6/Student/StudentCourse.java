package lab6.Student;

import lab6.PropertyFactory.StudentMarksFactoryModel;

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentCourse implements Serializable {

    @CSV
    private String groupName;

    @CSV
    private ArrayList<Student> studentsList;

    @CSV
    private double maxStudentsCount;

    @CSV
    private ArrayList<StudentMark> studentMarks;


    @Override
    public String toString() {
        return groupName;
    }


    public StudentCourse(){
        this.studentsList = new ArrayList<Student>();
        this.studentMarks = new ArrayList<StudentMark>();
    };

    public StudentCourse(String nazwaGrupy, double maksymalnieStudentow) {
        this.maxStudentsCount = maksymalnieStudentow;
        this.groupName = nazwaGrupy;
        this.studentsList = new ArrayList<Student>();
        this.studentMarks = new ArrayList<StudentMark>();
    }

    public String[] __toArray() {
        return new String[]{ this.groupName, String.valueOf(this.studentsList.size()), String.valueOf(this.maxStudentsCount)};
    }

    public String getGroupName() {
        return groupName;
    }

    public List<StudentMark> getStudentsMarks() {
        return studentMarks;
    }
    public List<StudentMark> getStudentsMarks(Student student) {
        return studentMarks.stream().filter(_student -> _student.student == student).toList();
    }
    public List<StudentMarksFactoryModel> getStudentsMarksModels(Student student) {

        List<StudentMark> list = studentMarks.stream().filter(_student -> _student.student == student).toList();
        List<StudentMarksFactoryModel> modelL = new ArrayList<>();

        for (StudentMark m: list) {
            modelL.add(StudentMarksFactoryModel.createFromMark(m));
        }

        return modelL;
    }

    public void addMark(Student student, double mark) {
        this.studentMarks.add(new StudentMark(student, mark));
    }



    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public double getMaxStudentsCount() {
        return maxStudentsCount;
    }

    public void setMaxStudentsCount(double maxStudentsCount) {
        this.maxStudentsCount = maxStudentsCount;
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public void addStudent(Student student) {

        // Powinno się wykorzystać tylko contains, aby sprawdzać po obiektach, a nie po imieniu i nazwisku,
        // gdyż może wystąpić kilku studentów o takich samych danych
        Predicate<Student> st = student1 -> (
                Objects.equals(student1.getFirstName(), student.getFirstName())
                && Objects.equals(student1.getLastName(), student.getLastName())
        );

        ArrayList<Student> tmpthis = (ArrayList<Student>) studentsList.stream().filter(st).collect(Collectors.toList());
        if(this.studentsList.contains(student) || tmpthis.size() > 1) {
            System.err.println("Podany student istnieje już w grupie");
            return;
        };

        if(this.studentsList.size() + 1 > this.maxStudentsCount) {
            System.err.println("Nie można dodać studenta, ponieważ przekroczy dozwoloną ilość miejsc");
            return;
        }

        this.studentsList.add(student);
    }

    public void addPoints(Student student, double points) {
        if(!this.studentsList.contains(student)) {
            System.err.println("Podany student nie widnieje na liście");
            return;
        }

        if(points < 0) {
            System.err.println("Nie można dodać \"ujemnych\" punktów");
            return;
        }
    }

    public Student getStudent(int indeks) {
        return this.studentsList.stream().filter(student -> {
            return student.getIndex() == indeks;
        }).findFirst().get();
    }

    public void removeStudent(Student student) {
        this.studentsList.remove(student);
    }


    public void changeCondition(Student student, StudentCondition condition) {
        if(!this.studentsList.contains(student)) {
            System.err.println("Podany student nie widnieje na liście");
            return;
        }

       student.setCondition(condition);
    }

    public void removePoints(Student student, double Points) {
        if(!this.studentsList.contains(student)) {
            System.err.println("Podany student nie widnieje na liście");
            return;
        }
    }

    public Student search(String nazwisko) {
        Optional<Student> st = this.studentsList.stream()
                .filter(student -> (nazwisko.compareTo(student.getLastName()) == 0))
                .findFirst();

        if(st.isEmpty()) {
            System.err.println("Brak studenta o szukanym nazwisku");
            return null;
        }

        return st.get();
    }

    public List<Student> searchPartial(String nazwisko){
        return  this.studentsList
                .stream().filter(student ->
                        (student.getLastName().contains(nazwisko) || student.getFirstName().contains(nazwisko))
                ).toList();
    }

    public int countByCondition(StudentCondition st) {
        return this.studentsList.stream().filter(student -> (student.getCondition() == st)).toList().size();
    }

    public void summary() {
        this.studentsList.forEach(Student::print);
    }

    public void sortByName() {
        List<Student> arr = this.studentsList.stream().sorted(Comparator.comparing(Student::getFirstName)).toList();
        this.studentsList = new ArrayList<>();
        this.studentsList.addAll(arr);
    }

    public Student max() {
        return Collections.max(this.studentsList);
    }

}
