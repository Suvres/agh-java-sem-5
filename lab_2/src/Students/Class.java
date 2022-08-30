package Students;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Class {
    private String nazwaGrupy;
    private ArrayList<Student> listaStudentow;
    private double maksymalnieStudentow;

    public Class(String nazwaGrupy, double maksymalnieStudentow) {
        this.maksymalnieStudentow = maksymalnieStudentow;
        this.nazwaGrupy = nazwaGrupy;
        this.listaStudentow = new ArrayList<Student>();
    }

    public String getNazwaGrupy() {
        return nazwaGrupy;
    }

    public void setNazwaGrupy(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }

    public double getMaksymalnieStudentow() {
        return maksymalnieStudentow;
    }

    public void setMaksymalnieStudentow(double maksymalnieStudentow) {
        this.maksymalnieStudentow = maksymalnieStudentow;
    }

    public ArrayList<Student> getListaStudentow() {
        return listaStudentow;
    }

    public void addStudent(Student student) {

        // Powinno się wykorzystać tylko contains, aby sprawdzać po obiektach, a nie po imieniu i nazwisku,
        // gdyż może wystąpić kilku studentów o takich samych danych
        Predicate<Student> st = student1 -> (
                Objects.equals(student1.getImie(), student.getImie())
                && Objects.equals(student1.getNazwisko(), student.getNazwisko())
        );

        ArrayList<Student> tmpthis = (ArrayList<Student>) listaStudentow.stream().filter(st).collect(Collectors.toList());
        if(this.listaStudentow.contains(student) || tmpthis.size() > 1) {
            System.err.println("Podany student istnieje już w grupie");
            return;
        };

        if(this.listaStudentow.size() + 1 > this.maksymalnieStudentow) {
            System.err.println("Nie można dodać studenta, ponieważ przekroczy dozwoloną ilość miejsc");
            return;
        }

        this.listaStudentow.add(student);
    }

    public void addPoints(Student student, double points) {
        if(!this.listaStudentow.contains(student)) {
            System.err.println("Podany student nie widnieje na liście");
            return;
        }

        if(points < 0) {
            System.err.println("Nie można dodać \"ujemnych\" punktów");
            return;
        }

        student.dodajPunkty(points);
    }


    // zapytać o ten podpunkt - niejasna instrukcja
    public void getStudent(Student student) {


        if(student.getIloscPunktow() == 0) {
            listaStudentow.remove(student);
        }


    }

    public void changeCondition(Student student, StudentCondition condition) {
        if(!this.listaStudentow.contains(student)) {
            System.err.println("Podany student nie widnieje na liście");
            return;
        }

       student.setStan(condition);
    }

    public void removePoints(Student student, double Points) {
        if(!this.listaStudentow.contains(student)) {
            System.err.println("Podany student nie widnieje na liście");
            return;
        }

        student.dodajPunkty(-Math.abs(Points));
    }

    public Student search(String nazwisko) {
        Optional<Student> st = this.listaStudentow.stream()
                .filter(student -> (nazwisko.compareTo(student.getNazwisko()) == 0))
                .findFirst();

        if(st.isEmpty()) {
            System.err.println("Brak studenta o szukanym nazwisku");
            return null;
        }

        return st.get();
    }

    public List<Student> searchPartial(String nazwisko){
        return  this.listaStudentow
                .stream().filter(student ->
                        (student.getNazwisko().contains(nazwisko) || student.getImie().contains(nazwisko))
                ).toList();
    }

    public int countByCondition(StudentCondition st) {
        return this.listaStudentow.stream().filter(student -> (student.getStan() == st)).toList().size();
    }

    public void summary() {
        this.listaStudentow.forEach(Student::print);
    }

    public List<Student> sortByName() {
        return this.listaStudentow.stream().sorted(Comparator.comparing(Student::getImie)).toList();
    }

    public List<Student> sortByPoints() {
        return  this.listaStudentow.stream().sorted(
                Comparator.comparingDouble(Student::getIloscPunktow)
        ).toList();
    }

    public Student max() {
        return Collections.max(this.listaStudentow);
    }
}
