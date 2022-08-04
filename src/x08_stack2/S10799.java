package x08_stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class S10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String tmp = br.readLine();
        for(int i=0; i<tmp.length(); i++){ stack.push(tmp.charAt(i));}
        int right = 0, result = 0;

        OuterLoop:
        while (!stack.isEmpty()){
            char c = stack.pop();
            switch (c){
                case ')':
                    if(stack.peek() == '(') continue;
                    right++;
                    break;
                case '(':
                    result += right;
                    if(stack.size()==0)  continue OuterLoop;
                    while(stack.peek().charValue() == '('){
                        stack.pop();
                        right--;
                        result++;
                        if(stack.size()==0)  continue OuterLoop;
                    }
                    break;
            }

        }
        System.out.println(result);
    }
}
