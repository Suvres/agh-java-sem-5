package main.zad74;

import java.util.ArrayList;

public class zad74 {
    public static int zadanie(int n, int x) {
        if(n == 1) {
            return n;
        }
        int tmpVal = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i * j == x ) {
                    tmpVal++;
                }
            }
        }

        return tmpVal;
    }
}
