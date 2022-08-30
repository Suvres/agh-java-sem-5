package main.zad76;

public class zad76 {
    public static int zadanie(String[] matrix) {
        if(matrix == null) {
            return 0;
        }

        if(matrix.length == 1) {
            return 0;
        }

        int colDrop = 0;
        for(int i = 0; i < matrix[0].toCharArray().length; i++) {
            for(int j = 1; j < matrix.length; j++) {
                if(matrix[j].toCharArray()[i] < matrix[j - 1].toCharArray()[i]) {
                    colDrop++;
                }
            }
        }

        return colDrop;
    }
}
