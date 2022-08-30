package main.zad76;

import org.junit.Test;

import static org.junit.Assert.*;

public class zad76Test {
    @Test
    public void testZadanie(){
        assertEquals(0, zad76.zadanie(new String[]{"abcs"}));
        assertEquals(1, zad76.zadanie(new String[]{"cba", "daf", "ghi"}));
        assertEquals(0, zad76.zadanie(null));
    }
}
