package leetcode.ch5_알고리즘;

public class A87_70_계단오르기 {
    public static void main(String[] args) {
        int n = 3;
        climbStairs(3);
    }

    static public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        if(n<=2) return dp[n];
        for(int i=3 ; i<=n; i++){
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];

    }

}
