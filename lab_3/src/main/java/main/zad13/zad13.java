package main.zad13;

import main.Exception.Lab3Exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class zad13 {

    public static String zadanie(String s, int k ) throws Lab3Exception {

        if(s == null) {
            throw new Lab3Exception("String jest pusty");
        }

        if(s.length() <= k) {
            return s;
        }

        if(k == 1){
            return String.valueOf(s.charAt(0));
        }

        String candidate = s;
        int distinct_char = 0;
        ArrayList<Character> seen_char = new ArrayList<>();
        String remain_string = "";


        char first_letter = s.charAt(0);
        int sec_letter = 0;

        while (s.charAt(sec_letter) == first_letter) {
            sec_letter++;
        }

        for(int i = 0; i < s.toCharArray().length; i++) {
            if(!seen_char.contains(s.charAt(i))) {
                seen_char.add(s.charAt(i));
                distinct_char++;
            }

            if (distinct_char > k) {
                candidate = s.substring(0, i);
                remain_string = s.substring(sec_letter);
                break;
            }

        }

        String long_s = zadanie(remain_string, k);
        String long_substring = "";

        if(candidate.length() < long_s.length()) {
            long_substring = long_s;
        } else {
            long_substring = candidate;
        }

        return long_substring;
    }
}
