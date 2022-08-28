package baaarkingDogWorkBook.x08_stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S2504 {
    static Stack<Character> stack = new Stack<>();
    static int tmpNum = 1, totalNum =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();

        for(int i=0; i<tmp.length(); i++){
            char c = tmp.charAt(i);
            switch (c){
                case '(':
                    tmpNum *= 2;
                    stack.push('(');
                    break;
                case '[':
                    tmpNum *= 3;
                    stack.push('[');
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek().charValue()!='(') {
                        System.out.println(0);
                        return;
                    }
                    if(tmp.charAt(i-1) == '(') totalNum += tmpNum;
                    stack.pop();
                    tmpNum /= 2;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek().charValue()!='[') {
                        System.out.println(0);
                        return;
                    }
                    if(tmp.charAt(i-1) == '[') totalNum += tmpNum;
                    stack.pop();
                    tmpNum /= 3;
                    break;

            }
        }
        if(stack.isEmpty()) System.out.println(totalNum);
        else System.out.println(0);

    }

}
