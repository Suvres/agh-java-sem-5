package lab6.Services;

import lab6.Student.StudentCourseContainer;

import java.io.*;

public class CoursesSerializable {

    public static void save(StudentCourseContainer cont) {
        FileOutputStream fileOut =
                null;
        try {
            fileOut = new FileOutputStream("./course.ser");

            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(cont);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static StudentCourseContainer read() {

        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream("./course.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            StudentCourseContainer cc = (StudentCourseContainer) in.readObject();
            in.close();
            fileIn.close();

            return cc;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
