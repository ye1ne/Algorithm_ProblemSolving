package BOJ_Study.BJ_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ2_DP_S2579 {

    public static void main(String[] args) throws IOException {
        final int One = 0;
        final int Two = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stair = new int[N];
        int[][] dp = new int[N][2];
        for(int i=0;  i<N; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }
        dp[0][One] = stair[0];
        if(N!=1) {
            dp[1][Two] = stair[1];
            dp[1][One] = dp[0][One] + stair[1];
        }
        for(int i=2; i<N;i++){
            dp[i][Two] = Math.max(dp[i-2][Two],dp[i-2][One])+stair[i];
            dp[i][One] = dp[i-1][Two] + stair[i];

        }
        System.out.println(Math.max(dp[N-1][One],dp[N-1][Two]));
    }

}

