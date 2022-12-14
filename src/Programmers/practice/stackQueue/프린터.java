package Programmers.practice.stackQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class 프린터 {
    public static void main(String[] args) {

        int[] p = {1, 1, 9, 1, 1, 1};
        System.out.println(solution(p,0));
    }


    static final int NUMBER = 1, PRIORY=0;

    public static int solution(int[] priorities, int location) {

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i =0; i<priorities.length; i++) queue.add(new int[]{priorities[i],i});

        int count = 0;
        while(!queue.isEmpty()){
            int[] front = queue.poll();

            if(hasBigNumber(queue, front)){
                queue.add(front);
                continue;
            }
            count++;
            if(front[NUMBER] == location) {break;}
        }
        return count;
    }

    private static boolean hasBigNumber(Queue<int[]> queue, int[] front) {

        Queue<int[]> tmpQueue = new ArrayDeque<>(queue);
        while (!tmpQueue.isEmpty()){
            int[] tmp = tmpQueue.poll();
            if(tmp[PRIORY] > front[PRIORY]) return true;
        }
        return false;
    }




}
