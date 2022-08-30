package main.zad79;

import org.junit.Test;

import static org.junit.Assert.*;

public class zad79Test {
    @Test
    public void testZadanie(){
        assertTrue(zad79.zadanie(new int[]{10,5,7}));
        assertFalse(zad79.zadanie(new int[]{10,5,1}));
    }
}
