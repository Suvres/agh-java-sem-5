package main.zad15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class zad15Test {

    @Test
    public void testPi()
    {
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            l.add(i);
        }
        assertTrue( l.contains(zad15.zadanie(new int[]{1,2,3,4,5,6,7,8,9})));
    }
}
