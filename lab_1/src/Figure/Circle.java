package Figure;

import Interface.Printable;

public class Circle extends Figure implements Printable {
    private double d;

    public Circle(double d) throws Exception {
        this.guard(d);
        this.d = d;
    }

    @Override
    public double calculateArea() {
        return Math.PI*(Math.pow(d/2, 2));
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI*d;
    }


    @Override
    public void print() {
        System.out.printf("\n\nKoło\n----------\nŚrednica: %s\nPole: %s\nObwód: %s\n",
                this.d,
                this.calculateArea(),
                this.calculatePerimeter()
        );
    }


    private void guard(double d) throws Exception {
        if(d <= 0) {
            throw new Exception("Srednica nie może być mniejsza niż 0");
        }
    }

}
