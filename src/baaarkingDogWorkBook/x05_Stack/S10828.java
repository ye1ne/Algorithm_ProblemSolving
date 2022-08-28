package baaarkingDogWorkBook.x05_Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class S10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        String str;

        while(N-->0){
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();

            switch (str){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        bw.write("-1\n");
                        break;
                    }
                    bw.write(stack.pop() + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        bw.write("1\n");
                    }else{
                        bw.write("0\n");
                    }
                    break;
                case "top":
                    if(stack.isEmpty()){
                        bw.write("-1\n");
                        break;
                    }
                    bw.write(stack.peek() + "\n");
                    break;
                default:
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
