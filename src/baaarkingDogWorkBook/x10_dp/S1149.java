package baaarkingDogWorkBook.x10_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1149 {
    static int[] map;
    static int[][] fee;
    static int[][] dp;
    static int N;
    static final int R =0, G=1, B=2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1];
        fee = new int[N+1][3];
        dp = new int[N+1][3];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            fee[i][R] = Integer.parseInt(st.nextToken());
            fee[i][G] = Integer.parseInt(st.nextToken());
            fee[i][B] = Integer.parseInt(st.nextToken());
        }
        dp[1][R] = fee[1][R];
        dp[1][G] = fee[1][G];
        dp[1][B] = fee[1][B];
        for(int i=2; i<=N; i++){
            dp[i][R] = Math.min(dp[i-1][G],dp[i-1][B])+fee[i][R];
            dp[i][G] = Math.min(dp[i-1][R],dp[i-1][B])+fee[i][G];
            dp[i][B] = Math.min(dp[i-1][R],dp[i-1][G])+fee[i][B];
        }
        System.out.println(Math.min(dp[N][R],Math.min(dp[N][G],dp[N][B])));
    }


}
