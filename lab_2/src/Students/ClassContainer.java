package Students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class ClassContainer {
    private Map<String, Class> grupy;

    public ClassContainer() {
        this.grupy = new HashMap<>();
    }

    public Map<String, Class> getGrupy() {
        return grupy;
    }

    // zła nazwa
    public void addClass(String name, double capacity) {
        this.grupy.put(name, new Class(name, capacity));
    }

    public void removeClass(String name) {
        this.grupy.remove(name);
    }

    public ArrayList<Class> findEmpty() {
        ArrayList<Class> tmp = new ArrayList<>();
        this.grupy.forEach((s, aClass) -> {
            if (aClass.getListaStudentow().size() == 0) {
                tmp.add(aClass);
            }
        });

        return tmp;
    }

    public void getClass(String name) {
        this.grupy.get(name);
    }

    public void addClass(String name, Class _class) {
        this.grupy.put(name, _class);
    }

    public void summary() {
        System.out.println("\n ---- Klasy ----");

        this.grupy.forEach((_name, _class) -> {
            System.out.printf(" \033[32m>\033[0m Klasa: %s, zapełnienie grupy: %s%%\n",
                    _class.getNazwaGrupy(),
                    (_class.getListaStudentow().size() / _class.getMaksymalnieStudentow()) * 100
                    );
        });
    }

}
