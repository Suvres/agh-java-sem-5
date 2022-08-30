package main.zad56;

import org.junit.Test;

import static org.junit.Assert.*;

public class zad56Test {
    @Test
    public void testMatrix(){
        int[][] matrix = {
                {0,1,1,1},
                {1,0,1,1},
                {1,1,0,1},
                {1,1,1,0}
        };

        assertTrue(zad56.zadanie(matrix,4));
        assertFalse(zad56.zadanie(matrix, 3));
    }
}
