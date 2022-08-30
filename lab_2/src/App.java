import Students.Class;
import Students.ClassContainer;
import Students.Student;
import Students.StudentCondition;

public class App {
    public static void main(String[] args) {
        Class c = new Class("Trojca", 3);
        Student st = new Student("Adam", "Izabela", StudentCondition.CHORY,
                1999, 110, "99877676567", "test@test.pl");

        Student st1 = new Student("Adams", "Izass", StudentCondition.CHORY,
                1999, 140, "99877676567", "test@test.pl");

        Student st2 = new Student("Adam", "Kwejk", StudentCondition.CHORY,
                1999, 90, "99877676567", "test@test.pl");

        c.addStudent(st);
        c.addStudent(st1);
        c.addStudent(st2);
        c.addPoints(st2, 130);
        c.removePoints(st1, 130);

        c.sortByPoints().forEach(Student::print);

        ClassContainer c1 = new ClassContainer();
        c1.addClass("Trojca", 3);

        c1.addClass("Tr", c);

        c.max().print();

        c.searchPartial("Iza").forEach(Student::print);
        c1.summary();
        System.out.println("\n\n\n");
        c.sortByName().forEach(Student::print);

    }
}
