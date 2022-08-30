package main.zad13;

import main.Exception.Lab3Exception;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class zad13Test {

    @Test(expected = Lab3Exception.class)
    public void testLetters() throws Lab3Exception {
        assertEquals("a", zad13.zadanie("abca", 1));
        assertEquals("abca", zad13.zadanie("abca", 5));
        assertEquals("bcb", zad13.zadanie("abcba", 2));
        zad13.zadanie(null, 1);
    }
}
