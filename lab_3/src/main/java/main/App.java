package main;

import main.Exception.Lab3Exception;
import main.zad13.zad13;
import main.zad14.zad14;
import main.zad15.zad15;
import main.zad50.Node;
import main.zad50.zad50;
import main.zad51.zad51;
import main.zad56.zad56;
import main.zad70.zad70;
import main.zad74.zad74;
import main.zad76.zad76;
import main.zad79.zad79;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("\n\n");
        // zadanie 13
        try {
            System.out.printf("Zad13 : %s\n", zad13.zadanie("abccbba", 2));
        } catch (Lab3Exception e) {}

        System.out.printf("Zad14 : %.3f\n", zad14.zadanie(10000000));
        System.out.printf("Zad15 : %d\n", zad15.zadanie(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));



        Node d = new Node("3");
        Node e = new Node("2");
        Node f = new Node("4");
        Node g = new Node("5");

        Node b = new Node("+");
        b.left = d;
        b.right = e;

        Node c = new Node("+");
        c.left = f;
        c.right = g;

        Node a = new Node("*");
        a.left = b;
        a.right = c;

        System.out.printf("Zad50 : %d\n", zad50.zadanie(a));

        System.out.println("Karty:");
        int[] s = zad51.zadanie();
        for (int i = 0; i < s.length; i++) {
            System.out.printf("[%d] => %d\n", i, s[i]);
        }
        System.out.println("");
        int[][] matrix = {
                {0,1,1},
                {1,0,1},
                {1,1,0},
        };


        System.out.printf("Zad56 : %s\n", zad56.zadanie(matrix, 4));
        System.out.printf("Zad70 : %s\n", zad70.zadanie(4));
        System.out.printf("Zad74 : %s\n", zad74.zadanie(6, 12));
        System.out.printf("Zad76 : %s\n", zad76.zadanie(new String[]{"cba", "daf", "ghi"}));
        System.out.printf("Zad79 : %s\n", zad79.zadanie(new int[]{10,5,7}));

    }
}
