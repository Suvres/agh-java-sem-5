package main.zad51;

import static java.lang.Math.random;

public class zad51 {
    private static int math_rand(int k) {
        return (int) (random() * (k - 2) + 1);
    }

    public static int[] zadanie() {
        int[] cards = new int[52];

        for(int i = 0; i < 52; i++) {
            cards[i] = i+1;
        }

        System.out.println(cards[51]);

        for (int i = 0; i < cards.length; i++) {
            int new_pos = i + math_rand(52 - i - 1);

            int temp = cards[new_pos];
            cards[new_pos] = cards[i];
            cards[i] = temp;
        }

        return cards;
    }
}
