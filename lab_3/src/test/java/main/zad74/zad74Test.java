package main.zad74;

import org.junit.Test;

import static org.junit.Assert.*;

public class zad74Test {
    @Test
    public void testZadanie(){
        assertEquals(4, zad74.zadanie(6, 12));
        assertEquals(1, zad74.zadanie(1, 12));
    }
}
