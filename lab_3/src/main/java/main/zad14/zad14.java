package main.zad14;

import static java.lang.Math.pow;
import static java.lang.Math.random;

public class zad14 {
    public static double zadanie(int Nmax)
    {
        double piCount = 0;
        double circle_d = 4;
        for(int i = 0; i < Nmax; i++) {
            double x_rand = random() * circle_d / 2;
            double y_rand = random() * circle_d / 2;

            if(pow(x_rand, 2) + pow(y_rand, 2) < circle_d) {
                piCount++;
            }
        }

        return (double)((int)(4 * piCount / Nmax * 1000))/1000;

    }
}
