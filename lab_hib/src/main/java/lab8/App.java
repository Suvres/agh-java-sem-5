package lab8;

import lab8.Entity.StudentCourse;
import lab8.Entity.StudentCourseContainer;
import lab8.Repository.StudentCourseContainerRepository;
import lab8.Repository.StudentCourseRepository;
import org.hibernate.Session;

public class App
{
    public static void addContainer() {
        Session s = StudentCourseContainerRepository.getSession();
        s.beginTransaction();
        System.out.println("> Stwórz nowy kontener");
        String name = System.console().readLine();

        StudentCourseContainer c = new StudentCourseContainer();

        c.setName(name);
        s.save(c);
        s.getTransaction().commit();
        s.close();

        System.out.println("Dodano nowy kontener");
    }


    private static void addCourseToKontener() {
        Session s = StudentCourseContainerRepository.getSession();
        System.out.println("> Dodaj grupę do kontenera");

        System.out.println("> Podaj Kontener");
        String name = System.console().readLine();
        StudentCourseContainer c = StudentCourseContainerRepository.findById(Integer.parseInt(name));


        System.out.println("> Podaj Grupę");
        name = System.console().readLine();
        StudentCourse cc = StudentCourseRepository.findById(Integer.parseInt(name));
        c.addGroup(cc);

        s.beginTransaction();
        s.update(c);
        s.getTransaction().commit();
    }

    public static void addCourse() {
        Session s = StudentCourseRepository.getSession();
        s.beginTransaction();

        System.out.println("> Stwórz nowy Kurs");
        String name = System.console().readLine();
        String count = System.console().readLine();

        StudentCourse c = new StudentCourse();
        c.setGroupName(name);
        c.setMaxStudentsCount(Double.valueOf(count));
        s.save(c);
        s.getTransaction().commit();
        s.close();

        System.out.println("Dodano nowy Kurs o id: " + c.getId());
    }

    public static void main(String[] args) {
        System.out.println("Podaj komendę");
        String com = System.console().readLine();

        switch (com.trim()) {
            case "-sc":
                addContainer();
                break;

            case "-c":
                addCourse();
                break;

            case "-scc":
                addCourseToKontener();
                break;


            default:
                System.out.println("-sc dodaj StudentCourseContainer");
                System.out.println("-c dodaj Kurs");
                System.out.println("-scc dodaj kurs do kontenera");
                System.out.println("-ls Lista Kontenera");
                System.out.println("-lsl Lista kursów");
                break;
        }
    }

}
