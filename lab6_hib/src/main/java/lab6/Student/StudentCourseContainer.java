package lab6.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentCourseContainer implements Serializable {

    @CSV
    private String name = "container";

    @CSV
    private Map<String, StudentCourse> groups;

    public StudentCourseContainer() {
        this.groups = new HashMap<>();
    }

    @Override
    public String toString() {
        return name;
    }

    public Map<String, StudentCourse> getGroups() {
        return groups;
    }

    public List<String> getGroupsNames() {
        return groups.keySet().stream().toList();
    }

    public void addClass(String name, double capacity) {
        this.groups.put(name, new StudentCourse(name, capacity));
    }

    public void removeClass(String name) {
        this.groups.remove(name);
    }

    public ArrayList<StudentCourse> findEmpty() {
        ArrayList<StudentCourse> tmp = new ArrayList<>();
        this.groups.forEach((s, aClass) -> {
            if (aClass.getStudentsList().size() == 0) {
                tmp.add(aClass);
            }
        });

        return tmp;
    }

    public StudentCourse getClass(String name) {
        return this.groups.get(name);
    }

    public void addClass(StudentCourse _class) {
        this.groups.remove(_class.getGroupName());
        this.groups.put(_class.getGroupName(), _class);
    }

    public void summary() {
        System.out.println("\n ---- Klasy ----");

        this.groups.forEach((_name, _class) -> {
            System.out.printf(" \033[32m>\033[0m Klasa: %s, zapełnienie grupy: %s%%\n",
                    _class.getGroupName(),
                    (_class.getStudentsList().size() / _class.getMaxStudentsCount()) * 100
                    );
        });
    }

    public Student getStudents(String email) {
        for(StudentCourse course: this.groups.values()) {
            for (Student st: course.getStudentsList()) {
                if(st.getEmail().equals(email)) {
                    return st;
                }
            }
        }

        return null;
    }
}
