package main.zad50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class zad50Test {

    @Test
    public void testNodeSum()
    {

        Node f = new Node("/");
        f.left = new Node("6");
        f.right = new Node("6");

        Node b = new Node("+");
        b.left = new Node("3");
        b.right = new Node("2");

        Node c = new Node("-");
        c.left = f;
        c.right = new Node("5");;

        Node a = new Node("*");
        a.left = b;
        a.right = c;

        assertEquals(-20, zad50.zadanie(a));
        Node n = new Node("s");
        assertEquals(0, zad50.zadanie(n));
    }
}
