package leetcode.ch5_알고리즘;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A82_455_쿠키부여 {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        findContentChildren(g,s);
    }
    static public int findContentChildren(int[] g, int[] s) {

        PriorityQueue<Integer> cookieQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> childQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int g1: g) childQueue.add(g1);
        for(int s1: s) cookieQueue.add(s1);
        int count = 0;
        while(!cookieQueue.isEmpty()){
            int cookieSize = cookieQueue.poll();
            while(!childQueue.isEmpty()){
                int childGF = childQueue.poll();
                if(childGF <= cookieSize){
                    count++;
                    break;
                }
            }
        }

        return count;

    }
}
