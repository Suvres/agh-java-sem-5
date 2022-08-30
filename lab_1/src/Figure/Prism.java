package Figure;

import Interface.Printable;

public class Prism extends PrismFigure implements Printable {

    private Figure figure;
    private double h;

    public Prism(Figure figure, double h) throws Exception {
        this.guard(figure, h);
        this.figure = figure;
        this.h = h;
    }

    @Override
    public double calculateArea() {
        return (2*this.figure.calculateArea())+(this.figure.calculatePerimeter()*this.h);
    }

    public double calculateVolume() {
        return this.figure.calculateArea() * this.h;
    }

    @Override
    public void print() {
        System.out.printf("\n\nGraniastosłup\n----------\nPodstawa: %s\nPole: %s\nObjętość: %s",
                this.figure.getClass().getName(),
                this.calculateArea(),
                this.calculateVolume()
        );
    }


    private void guard(Figure figure, double h) throws Exception {
        if(h <= 0) {
            throw new Exception("Wysokość nie może być ujemna");
        }

        if(figure instanceof Triangle && !((Triangle) figure).isNormal()) {
            throw new Exception("Trójkąt nie jest równoboczny");
        }
    }

}
