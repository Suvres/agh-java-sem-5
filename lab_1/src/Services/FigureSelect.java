package Services;

import Figure.*;
import Interface.Printable;
import org.jetbrains.annotations.NotNull;

import java.lang.instrument.ClassDefinition;
import java.lang.reflect.Type;
import java.util.Objects;

public class FigureSelect {

    public static Class selectFigureWithPrism() {
        System.out.println("  (\033[33m1\033[0m) Trójkąt");
        System.out.println("  (\033[33m2\033[0m) Kwadrat");
        System.out.println("  (\033[33m3\033[0m) Koło");
        System.out.println("  (\033[33m4\033[0m) Granatosłup");
        int data = UI.getInput();

        while (true) {

            switch (data) {
                case 1:
                case 2:
                case 3:
                    try {
                        return FigureSelect.selectFigure(data);
                    } catch (Exception e) {
                        UI.error(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        Prism t = new Prism(new Circle(1), 1);
                        return t.getClass();
                    } catch (Exception e) {
                        UI.error(e.getMessage());
                    }
                    break;
            }
        }
    }

    private static Class selectFigure(int data) throws Exception {
        switch(data) {
            case 1:
                Triangle t = new Triangle(1, 1, 1);
                return t.getClass();
            case 2:
                Square t1 = new Square(1);
                return t1.getClass();
            case 3:
                Circle t2 = new Circle(1);
                return t2.getClass();
        }

        throw new Exception("Niepoprawny zakres");
    }


    public static Printable setData(@NotNull Class<Printable> c) {
        if(c.getGenericSuperclass() == Figure.class) {
            return FigureSelect.setFigure(c);
        } else if (c.getGenericSuperclass() == PrismFigure.class) {
            return FigureSelect.setPrismFigure(c);
        }

        return null;
    }

    private static Printable setPrismFigure(@NotNull Class<Printable> c) {
        System.out.println("[\033[32m*\033[0m] Wybierz podstawę graniastosłupa");
        System.out.println("    (\033[33m1\033[0m) Trójkąt");
        System.out.println("    (\033[33m2\033[0m) Kwadrat");
        System.out.println("    (\033[33m3\033[0m) Koło");
        int data = UI.getInput();

        while (true) {
            try {
                Class cl = FigureSelect.selectFigure(data);
                Printable fig = FigureSelect.setFigure(cl);

                System.out.println("[\033[32m*\033[0m] Podaj wysokość graniastosłupa >");
                double doubleData = UI.getInputDouble();
                return new Prism(((Figure) fig), doubleData);

            } catch (Exception e) {
                UI.error(e.getMessage());
            }

        }
    }

    public static Printable setFigure(@NotNull Class<Printable> c) {
        if (Objects.equals(c, Square.class)) {
            System.out.println("[\033[32m*\033[0m] Podaj bok kwadratu >");
            double data = UI.getInputDouble();
            try {
                return new Square(data);
            } catch (Exception e){
                UI.error(e.getMessage());
            }
        }

        if (Objects.equals(c, Triangle.class)) {
            System.out.println("[\033[32m*\033[0m] Podaj pierwszy bok trójkątu >");
            double a1 = UI.getInputDouble();

            System.out.println("[\033[32m*\033[0m] Podaj drugi bok trójkątu >");
            double a2 = UI.getInputDouble();

            System.out.println("[\033[32m*\033[0m] Podaj trzeci bok trójkątu >");
            double a3 = UI.getInputDouble();

            try {
                return new Triangle(a1, a2, a3);
            } catch (Exception e){
                UI.error(e.getMessage());
            }
        }

        if (Objects.equals(c, Circle.class)) {
            System.out.println("[\033[32m*\033[0m] Podaj średnicę koła >");
            double a1 = UI.getInputDouble();
            try {
                return new Circle(a1);
            } catch (Exception e){
                UI.error(e.getMessage());
            }
        }

        return null;
    }
}
