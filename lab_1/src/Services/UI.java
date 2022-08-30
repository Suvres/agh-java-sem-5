package Services;

import Figure.*;
import Interface.Printable;

public class UI {
    public static void body() {
        Class c = null;
        Printable figure = null;

        while (true) {
            UI.clear();
            UI.navbar();
            UI.stats(c);
            UI.menu();

            int data = UI.getInput();

            switch (data) {
                case 1:
                    c = FigureSelect.selectFigureWithPrism();
                    break;

                case 2:
                    if(c != null) {
                        figure = FigureSelect.setData(c);
                    } else {
                        UI.error();
                    }
                    break;

                case 3:
                    if(figure != null && ((figure instanceof Figure) || (figure instanceof PrismFigure))){
                        figure.print();
                        int d = UI.getInput();
                    } else {
                        UI.error();
                    }
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("[\033[31m*\033[0m] Błędna opcja wybierze ponownie");
                    try{Thread.sleep(1000);}catch (Exception e){};
            }

        }
    }

    public static int getInput() {
        String read = System.console().readLine();
        try {
            return Integer.parseInt(read);
        } catch (Exception e) {
            return -1;
        }
    }

    public static double getInputDouble() {
        String read = System.console().readLine();
        try {
            return Double.parseDouble(read);
        } catch (Exception e) {
            return -1;
        }
    }



    private static void navbar() {
        System.out.println("\033[44m                                  \033[0m");
        System.out.println("\033[30;44m            Kalkulator            \033[0m");
        System.out.println("\033[44m                                  \033[0m");
    }

    private static void menu() {
        System.out.println("(\033[33m1\033[0m) Wybór figury");
        System.out.println("(\033[33m2\033[0m) Podanie danych");
        System.out.println("(\033[33m3\033[0m) Wyświetlenie");
        System.out.println("(\033[33m4\033[0m) Wyjście z programu");
    }

    private static void stats(Class c) {
        System.out.printf("(\033[32m*\033[0m) Figura: %s \n\n", c != null ? c.getName() : "BRAK");
    }


    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void error() {
        System.out.println("[\033[31m*\033[0m] Niepoprawne dane");
        try{Thread.sleep(1000);}catch (Exception e){
            UI.error(e.getMessage());
        };
    }


    public static void error(String error) {
        System.out.printf("[\033[31m*\033[0m] Błąd: %s", error);
        try{Thread.sleep(1000);}catch (Exception e){
            UI.error(e.getMessage());
        };
    }

}
