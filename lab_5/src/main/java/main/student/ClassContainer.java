package main.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassContainer {
    private Map<String, Class> groups;

    public ClassContainer() {
        this.groups = new HashMap<>();
    }

    public Map<String, Class> getGroups() {
        return groups;
    }

    public void addClass(String name, double capacity) {
        this.groups.put(name, new Class(name, capacity));
    }

    public void removeClass(String name) {
        this.groups.remove(name);
    }

    public ArrayList<Class> findEmpty() {
        ArrayList<Class> tmp = new ArrayList<>();
        this.groups.forEach((s, aClass) -> {
            if (aClass.getStudentsList().size() == 0) {
                tmp.add(aClass);
            }
        });

        return tmp;
    }

    public Class getClass(String name) {
        return this.groups.get(name);
    }

    public void addClass(Class _class) {
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

}
