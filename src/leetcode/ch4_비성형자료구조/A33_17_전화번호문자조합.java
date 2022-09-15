package leetcode.ch4_비성형자료구조;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A33_17_전화번호문자조합 {
    static List<String> result = new ArrayList<>();
    static int size ;
    public static void main(String[] args) {

        String digits = "";
        size = digits.length();
        StringBuilder sb = new StringBuilder();
        backTracking(0,digits,sb);

        Collections.sort(result);
        System.out.println();
    }
    static void backTracking(int count, String digits,StringBuilder sb){
        if(count ==size){
            result.add(sb.toString());
            return;
        }

        List<String> list = findChar(digits.charAt(count));
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));
            backTracking(count+1,digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    static List<String> findChar(char c) {
        List<String> charArr = new ArrayList<>();
        switch (c) {
            case '2':
                charArr.add("a");
                charArr.add("b");
                charArr.add("c");
                return charArr;
            case '3':
                charArr.add("d");
                charArr.add("e");
                charArr.add("f");
                return charArr;
            case '4':
                charArr.add("g");
                charArr.add("h");
                charArr.add("i");
                return charArr;
            case '5':
                charArr.add("j");
                charArr.add("k");
                charArr.add("l");
                return charArr;
            case '6':
                charArr.add("m");
                charArr.add("n");
                charArr.add("o");
                return charArr;
            case '7':
                charArr.add("p");
                charArr.add("q");
                charArr.add("r");
                charArr.add("s");
                return charArr;
            case '8':
                charArr.add("t");
                charArr.add("u");
                charArr.add("v");
                return charArr;
            case '9':
                charArr.add("w");
                charArr.add("x");
                charArr.add("y");
                charArr.add("z");
                return charArr;
        }
        return charArr;
    }
}
