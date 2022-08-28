package baaarkingDogWorkBook.x06_Queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int lastElement = 0;
        Queue<Integer> q= new LinkedList<>();
        String str;

        while(N-->0){
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();

            switch (str){
                case "push":
                    lastElement =Integer.parseInt(st.nextToken());
                    q.add(lastElement);
                    break;
                case "pop":
                    if(q.isEmpty()) bw.write("-1\n");
                    else bw.write(q.remove()+"\n");
                    break;
                case "size":
                    bw.write(q.size()+"\n");
                    break;
                case "empty":
                    if(q.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "front":
                    if(q.isEmpty()) bw.write("-1\n");
                    else bw.write(q.peek()+"\n");
                    break;
                case "back":
                    if(q.isEmpty()) bw.write("-1\n");
                    else{bw.write(lastElement+"\n");}
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
