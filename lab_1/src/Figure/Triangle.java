package Figure;

import Interface.Printable;

import java.util.Arrays;

public class Triangle extends Figure implements Printable {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) throws Exception {
        this.guard(a, b, c);

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateArea() {
        double p = this.calculatePerimeter();
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public void print() {
        System.out.printf("\n\nTrójkąt\n----------\nBoki: %s, %s, %s\nPole: %s\nObwód: %s\n",
                this.a, this.b, this.c,
                this.calculateArea(),
                this.calculatePerimeter()
        );
    }

    private void guard(double a, double b, double c) throws Exception {
        if(a <= 0.0 || b <= 0.0 || c <= 0.0) {
            throw new Exception("Żaden z boków trójkąta nie może być <= 0");
        }

        double[] sides = {a, b, c};
        Arrays.sort(sides);
        if(sides[0] > sides[1] + sides[2]) {
            throw new Exception("Boki nie spełniają zalezności: największy bok mniejszy od dwóch pozostałych");
        }
    }

    public boolean isNormal() {
        return Math.abs(this.a - this.b) < 1E-6 &&  Math.abs(this.b - this.c) < 1E-6;
    }
}
