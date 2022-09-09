package leetcode.선형자료구조;

public class A12_121_주식을사고팔기가장좋은시점 {
    public static void main(String[] args) {
        int[] prices = {2,4,1};
        int[][] dp = new int[prices.length][2];
        dp[0] = new int[]{prices[0],prices[0]};
        int MAX = Integer.MIN_VALUE;
        for(int i =1; i< prices.length; i++){
            //직전의 최솟값보다 작으면
            if(prices[i]<dp[i-1][1]) {
                MAX = Math.max(MAX, dp[i-1][0]-dp[i-1][1]);
                dp[i][1] = prices[i];
                dp[i][0] = prices[i];
                continue;
            }
            dp[i][1] = dp[i-1][1];
            dp[i][0] = Math.max(dp[i-1][0],prices[i]);
        }
        MAX = Math.max(MAX, dp[prices.length-1][0]-dp[prices.length-1][1]);

        System.out.println(MAX);
    }
}
