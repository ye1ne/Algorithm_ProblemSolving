package leetcode.ch3_선형자료구조;

import java.util.Arrays;

public class A10_561_배열파티션1 {
    public static void main(String[] args) {
        int[] nums = {6,2,6,5,1,2};

        Arrays.sort(nums);

        int sum = 0;
        for(int i=0; i<nums.length; i+=2){
            sum+= Math.min(nums[i],nums[i+1] );
        }
        System.out.println(sum);
    }


}
