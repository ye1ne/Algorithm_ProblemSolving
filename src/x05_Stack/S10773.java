package x05_Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class S10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num = 0,result = 0;
        while(K-->0){
            num = Integer.parseInt(br.readLine());
            if(num == 0){
                stack.pop();
            }else{
                stack.push(num);
            }

        }
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }
}
