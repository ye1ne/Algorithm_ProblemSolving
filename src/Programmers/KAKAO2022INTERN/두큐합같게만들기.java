package Programmers.KAKAO2022INTERN;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
//
//        int[] queue1 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 10 };
//        int[] queue2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
//

        System.out.println( solution(queue1,queue2));
    }

    static public int solution(int[] queue1, int[] queue2) {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        long size1 = calculateTotal(q1);
        long size2 = calculateTotal(q2);
        if((size1+size2)%2 != 0) return -1;
        MAX_SIZE = q1.size()*4;

        int count = 0;
        while(MAX_SIZE-->0) {
            if(size1 == size2){
                return count;
            }
            if(q1.isEmpty() || q2.isEmpty()){
                return -1;
            }

            if(size1>size2){
                int tmp = q1.poll();
                size2 +=tmp;
                size1 -=tmp;
                q2.add(tmp);
                count++;
            }else if(size1<size2){
                int tmp = q2.poll();
                size1 +=tmp;
                size2 -=tmp;
                q1.add(tmp);
                count++;
            }
        }


        return -1;
    }
    static int MAX_SIZE, MIN = Integer.MAX_VALUE;


    static long calculateTotal(Queue<Integer> queue){
        long sum = 0;
        long size = queue.size();
        while(size-->0){
            int num =queue.poll();
            sum += num;
            queue.add(num);
        }
        return sum;
    }
}
