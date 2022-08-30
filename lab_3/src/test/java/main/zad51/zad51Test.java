package main.zad51;

import org.junit.Test;
import static org.junit.Assert.*;

public class zad51Test {
    @Test
    public void testShuffle() {
        int[] test = new int[52];
        for (int i = 0; i < 52; i++) {
            test[i] = i+1;
        }

        assertNotEquals(test, zad51.zadanie());
    }
}
