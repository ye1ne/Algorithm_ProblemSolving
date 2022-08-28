package baaarkingDogWorkBook.x06_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i =1; i<=N; i++) q.add(i);
        if(q.size() ==1){
            System.out.println(q.poll());
            return;
        }
        while (N != 1){
            if(q.size() ==1){
                System.out.println(q.poll());
                return;
            }
            q.poll();
            if(q.size() ==1){
                System.out.println(q.poll());
                return;
            }
            q.add(q.poll());
        }

    }
}
