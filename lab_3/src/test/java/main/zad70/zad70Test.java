package main.zad70;

import org.junit.Test;

import static org.junit.Assert.*;

public class zad70Test {
    @Test
    public void testPerfectNumber() {
        assertEquals(19, zad70.zadanie(1));
        assertEquals(46, zad70.zadanie(4));
    }
}
