package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class sort2 {
    public static void main(String[] args) {
        int[] numbers ={3, 30, 34, 5, 9};
        String[] str = new String[numbers.length];
        for(int i=0;i< str.length;i++){
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String answer = "";
        if(str[0].equals(0)) answer = "0";
        else {
            for(String s: str) answer += s;
        }
    }
}
