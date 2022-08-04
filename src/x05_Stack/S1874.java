package x05_Stack;

import java.io.*;
import java.util.Stack;

public class S1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] list = new int[N];


        boolean isOK = true;
        for(int i =0; i<N; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        sb.append("+\n");
        stack.push(1);
        int num = 2, index = 0, count=0;
        while(count != N){
            if(num>N+1 || index>N){
                isOK = false;
                break;
            }

            if(stack.isEmpty()){
                stack.push(num++);
                sb.append("+\n");
            }else if( list[index] == stack.peek().intValue()){
                stack.pop();
                index++; count++;
                sb.append("-\n");
            }else {
                stack.push(num++);
                sb.append("+\n");
            }

        }
        if(!isOK){
            System.out.println("NO");
            return;
        }
        System.out.println(sb);
        br.close();

    }
}
