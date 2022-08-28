package baaarkingDogWorkBook.x07_Deque;

import java.io.*;
import java.util.*;

public class S10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        while(N-->0){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str){
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    bw.write(((deque.size()==0) ? "-1" : deque.removeFirst()) + "\n");
                    break;
                case "pop_back":
                    bw.write(((deque.size()==0) ? "-1" : deque.removeLast()) + "\n");
                    break;
                case "size":
                    bw.write(deque.size()+"\n");
                    break;
                case "empty":
                    bw.write(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    bw.write(((deque.size()==0) ? "-1" : deque.peekFirst()) + "\n");
                    break;
                case "back":
                    bw.write(((deque.size()==0) ? "-1" : deque.peekLast()) + "\n");
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
