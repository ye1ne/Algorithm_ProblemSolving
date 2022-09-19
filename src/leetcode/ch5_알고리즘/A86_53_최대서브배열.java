package leetcode.ch5_알고리즘;

import java.util.Arrays;

public class A86_53_최대서브배열 {
    public static void main(String[] args) {

        int[] nums = {1};
        System.out.println(maxSubArray(nums));
    }
    static public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            max = Math.max(dp[i],max);
        }

        return max;
    }

}
