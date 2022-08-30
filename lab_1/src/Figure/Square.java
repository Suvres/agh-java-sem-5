package Figure;

import Interface.Printable;

public class Square extends Figure implements Printable {
    private double a;

    public Square(double a) throws Exception {
        this.guard(a);
        this.a = a;
    }

    @Override
    public double calculateArea() {
        return a * a;
    }

    @Override
    public double calculatePerimeter() {
        return a * 4;
    }

    @Override
    public void print() {
        System.out.printf("\n\nKwadrat\n----------\nBoki: %s\nPole: %s\nObwód: %s\n",
                this.a,
                this.calculateArea(),
                this.calculatePerimeter()
        );
    }

    private void guard(double a) throws Exception{
        if(a <= 0.0) {
            throw new Exception("Bok kwadratu nie możę być ujemny");
        }
    }

}
