package leetcode.문자열;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class A1_125_vaildPalindrome2 {
    public static void main(String[] args) {
        String s = "race a car";
        s = s.toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for(int i=0; i< s.length(); i++) {
            char tmpChar = s.charAt(i);
            if( (tmpChar >='a' && tmpChar <='z') ||( tmpChar>= '0' && tmpChar<='9') ) deque.push(tmpChar);
        }
        int halfLong = deque.size()%2 == 0 ? deque.size()/2 : deque.size()/2+1;
        for(int i =0; i< halfLong; i++){
            char front = deque.pollFirst();
            if(deque.isEmpty()) break;
            char back = deque.pollLast();
            if(front != back) {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
}
