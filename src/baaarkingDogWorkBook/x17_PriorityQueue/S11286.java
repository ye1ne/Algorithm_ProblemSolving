package baaarkingDogWorkBook.x17_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        while(N-->0){
            int tmpNum = Integer.parseInt(br.readLine());
            if(tmpNum == 0){
                if(priorityQueue.isEmpty()) {
                    sb.append(0+"\n");
                    continue;
                }
                int[] tmp = priorityQueue.poll();
                sb.append(tmp[0]*tmp[1] +"\n");

            }else {
                int absNum = Math.abs(tmpNum);
                int flag = tmpNum<0 ? -1 : 1;
                priorityQueue.offer(new int[]{absNum,flag});
            }
        }
        System.out.println(sb);
    }
}
