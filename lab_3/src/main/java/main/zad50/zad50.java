package main.zad50;

import java.util.regex.Pattern;


public class zad50 {
    public static int zadanie(Node node) {
        Pattern pattern = Pattern.compile("\\d");

        if(pattern.matcher(node.val).matches()) {
            return Integer.parseInt(node.val);
        }

        switch (node.val) {
            case "+":
                return (zadanie(node.left) + zadanie(node.right));
            case "-":
                return (zadanie(node.left) - zadanie(node.right));
            case "/":
                return (zadanie(node.left) / zadanie(node.right));
            case "*":
                return (zadanie(node.left) * zadanie(node.right));
        }

        return 0;
    }
}
