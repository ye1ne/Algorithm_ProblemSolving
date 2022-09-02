package baaarkingDogWorkBook.x17_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class G1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        while(N-->0){
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }
        int result =0 ;
        if(priorityQueue.size() == 1) {
            System.out.println(result);
            return;
        }

        while(!priorityQueue.isEmpty()){
            int compare1 =  priorityQueue.poll();
            int compare2 = priorityQueue.poll();

            result += compare1+compare2;

            if(priorityQueue.isEmpty()) break;
            else priorityQueue.offer(compare1+compare2);
        }
        System.out.println(result);
    }
}
