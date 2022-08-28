package BOJ_Study.BJ_DP;

import java.io.*;

public class BJ2_DP_S2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        if(N >=3) {
            dp[0] = dp[1] = dp[2] = 1;
            for(int i = 3; i<=N; i++){
                for (int j = 0; j<(i-1);j++)
                    dp[i] += dp[j];
            }
            System.out.println(dp[N]);
        }else{
            System.out.println(1);
        }

    }
}
