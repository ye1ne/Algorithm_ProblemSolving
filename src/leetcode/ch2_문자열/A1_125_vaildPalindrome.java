package leetcode.ch2_문자열;

import java.util.Stack;

public class A1_125_vaildPalindrome {
    public static void main(String[] args) {
        String s = "0P";
        s = s.toLowerCase();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i< s.length(); i++) {
            char tmpChar = s.charAt(i);
            if( (tmpChar >='a' && tmpChar <='z') ||( tmpChar>= '0' && tmpChar<='9') ) stack.push(s.charAt(i));
        }
        for(int i=0; i< s.length(); i++) {
            char tmpChar = s.charAt(i);
            if( (tmpChar >='a' && tmpChar <='z') ||( tmpChar>= '0' && tmpChar<='9')) {
                if(tmpChar != stack.pop()){
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }
}
