package main.zad56;

public class zad56 {
    public static boolean zadanie(int[][] matrix, int k) {
        int maxVal = 0;
        for(int[] i: matrix) {
            int val = 0;
            for (int s: i) {
                val += s;
            }

            maxVal = Math.max(maxVal, val);
        }

        return k > maxVal;
    }
}
