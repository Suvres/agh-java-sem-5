package main.zad14;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class zad14Test {

    @Test
    public void testPi()
    {
        assertEquals( 3.14, zad14.zadanie(10000000), 0.01);
        assertNotEquals( 3.14, zad14.zadanie(10), 0.001);
    }
}
