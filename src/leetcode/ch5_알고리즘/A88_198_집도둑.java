package leetcode.ch5_알고리즘;

public class A88_198_집도둑 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
    }
    static public int rob(int[] nums) {
        if(nums.length ==0 )return 0;
        if(nums.length ==2) return Math.max(nums[0],nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for(int i=0; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }

        return dp[nums.length-1];
    }
}
