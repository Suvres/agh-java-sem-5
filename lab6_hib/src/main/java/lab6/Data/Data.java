package lab6.Data;

import lab6.Services.CoursesSerializable;
import lab6.Services.StudentSerializer;
import lab6.Student.Student;
import lab6.Student.StudentCondition;
import lab6.Student.StudentCourse;
import lab6.Student.StudentCourseContainer;

import java.io.*;

public class Data {
    public static StudentCourseContainer courseContainer = new StudentCourseContainer();


    public static void testInit() {
//        courseContainer.addClass("MES", 16);
//        courseContainer.addClass("PAOIM", 16);
//        courseContainer.addClass("AISD", 16);
//        courseContainer.addClass("OPTYMALIZACJA", 16);
//
//        for(int i = 0; i < 25 ; i++) {
//            courseContainer.addClass("ZZZ_PRZEDMIOT_" + i, 16);
//        }
//
//        Student student = new Student(
//                "user", "User", StudentCondition.OBECNY, "12-12-1999", 401928, "user"
//        );
//
//        StudentCourse c = courseContainer.getClass("MES");
//        c.addMark(student, 4.0);
//        c.addMark(student, 3.0);
//        c.addMark(student, 2.0);
//        c.addMark(student, 5.0);
//        c.addMark(student, 3.0);
//        c.addMark(student, 5.0);
//
//        c.addStudent(student);

//

        courseContainer = CoursesSerializable.read();
        try {
            StudentSerializer.serializeCsv(new Object[]{courseContainer}, new Object[]{});
        } catch (IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }
}
