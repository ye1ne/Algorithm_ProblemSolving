package leetcode.ch5_알고리즘;

import java.util.Arrays;

public class A68_167_두수의합 {
    public static void main(String[] args) {
        int[] numbers={-1,-1,1,1,1,1,1,1,};
        int target = -2;
        twoSum(numbers,target);
    }
    static public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2=0;
        while(index1<numbers.length ){
            index2 = Arrays.binarySearch(numbers,target-numbers[index1]);
            if(index1 == index2) {
                if(numbers[++index2] == target-numbers[index1]) break;
                continue;
            }
            if(index2 > 0) break;
            index1++;
        }

        return new int[]{index1+1,index2+1};
    }

}
