package BOJ_Study.BJ_DP;

import java.io.*;
public class BJ2_DP_S11057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        for(int i =0; i<10;i++) dp[1][i] = 1;
        int tmp = 0;
        for(int digit = 2; digit<=N; digit++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j <= i; j++) {
                    tmp += dp[digit-1][j];
                }
                dp[digit][i] = tmp%10007;
                tmp = 0;
            }
        }
         for(int i=0; i<10; i++) tmp += dp[N][i];
        System.out.println(tmp%10007);
    }
}
