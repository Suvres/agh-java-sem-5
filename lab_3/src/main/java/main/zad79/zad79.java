package main.zad79;

public class zad79 {
    public static boolean zadanie(int[] arr) {
        int decPairs = 0;
        for(int i = 1; i < arr.length; i++ ) {
            if(arr[i] < arr[i - 1]) {
                decPairs += 1;
            }
        }

        return decPairs <= 1;
    }
}
