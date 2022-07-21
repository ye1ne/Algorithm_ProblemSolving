package BJ_STR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G1918 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String input,output;
    static Stack<Character> s = new Stack<>();

    public static void main(String[] args) throws IOException {

        int weight = 0;
        output = "";
        input = br.readLine();
        Loop:
        for(int i=0; i<input.length();i++) {
            char c = input.charAt(i);
            if(65<= c && c<= 90) { //문자열이면
                output += c;
                continue;
            }

            if(s.isEmpty()){
                s.push(c);
                continue;
            }
            if(c == ')'){
                while(s.peek() != '('){
                    output += s.pop();
                }
                s.pop();
                continue;
            }

            if(s.peek() == '('){
                s.push(c);
                continue ;
            }

            if(searchLevel(c)<= searchLevel(s.peek())){
                while(!s.isEmpty()){
                    output += s.pop();
                }
                s.push(c);
            }else{
                s.push(c);
            }
        }
        while(!s.isEmpty()){
            output += s.pop();
        }
        System.out.println(output);

    }
    static int searchLevel(char c){
        switch (c){
            case '+': case '-':
                return 0;
            case '*': case '/':
                return 1;
            case '(': case ')':
                return 2;

        }

        return -1;

    }
}
