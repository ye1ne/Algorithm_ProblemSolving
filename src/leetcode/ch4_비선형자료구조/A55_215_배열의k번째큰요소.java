package leetcode.ch4_비선형자료구조;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A55_215_배열의k번째큰요소 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<nums.length; i++) priorityQueue.add(nums[i]);
        while(k-->1) priorityQueue.poll();

        System.out.println(priorityQueue.poll());
    }
}
