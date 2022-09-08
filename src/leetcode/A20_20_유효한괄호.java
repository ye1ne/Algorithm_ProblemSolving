package leetcode;

import java.util.Stack;

public class A20_20_유효한괄호 {
    public static void main(String[] args) {
        String s = "]";

        Stack<Character> stack = new Stack<>();

        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            char c2;
            switch (c){
                case '[': case '{': case'(':
                    stack.push(c);
                    break;
                case ']':
                    c2 = stack.pop();
                    if(c2 != '[') return;
                    break;
                case '}':
                    c2 = stack.pop();
                    if(c2 != '{') return;
                    break;
                case ')':
                    c2 = stack.pop();
                    if(c2 != '(') return;
                    break;
            }
        }

    }
}
