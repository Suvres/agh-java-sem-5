package main;

import main.student.Class;
import main.student.ClassContainer;
import main.student.Student;
import main.student.StudentCondition;
import main.ui.Gui;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Class c = new Class("Trojca", 3);
        Student st = new Student("Adam", "Izabela", StudentCondition.CHORY,
                "1999", 110, 1, "test@test.pl");

        Student st1 = new Student("Tomasz", "Izass", StudentCondition.CHORY,
                "1999", 140, 2, "test@test.pl");

        Student st2 = new Student("Chada", "Kwejk", StudentCondition.CHORY,
                "1999", 90, 3, "test@test.pl");

        c.addStudent(st);
        c.addStudent(st1);
        c.addStudent(st2);

        ClassContainer cc = new ClassContainer();
        cc.addClass(c);


        Gui.tableStudentsSite(cc);
    }
}
