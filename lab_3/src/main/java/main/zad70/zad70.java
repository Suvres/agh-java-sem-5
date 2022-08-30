package main.zad70;

public class zad70 {
    public static int zadanie(int n) {
        int tmpSum = 0;
        for(char s: String.valueOf(n).toCharArray()) {
            tmpSum += Integer.parseInt(String.valueOf(s));
        }

        return (n * 10) + (10 - tmpSum);
    }
}
