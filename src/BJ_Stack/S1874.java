package BJ_Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class S1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        String str = "";
        int num = 0, index = 0;
        boolean isOK = true;
        for(int i =0; i<N; i++){
            str += br.readLine();
        }
        while(num != N){


            if(str.charAt(index)-'0' != stack.peek()){
                stack.push(num++);
                bw.write("+\n");
            }else {
                bw.write(stack.pop() + "\n");
                index++;
                if(stack.peek() != str.charAt(index)-'0'){
                    isOK =false;
                    break;
                }
            }
            continue;

        }
        if(!isOK){
            System.out.println("NO");
            return;
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
