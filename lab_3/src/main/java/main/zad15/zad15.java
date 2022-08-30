package main.zad15;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.random;

public class zad15 {
    public static int zadanie(int[] zad) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i: zad) {
            l.add(i);
        }
        Collections.shuffle(l);
        return l.get(0);
    }
}
