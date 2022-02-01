package BJ_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2_DP_S11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        dp[0] = 0;
        for(int i=1; i<N;i++){
            for(int j=0; j<i; j++) {
                if (num[i])
            }
        }



    }
}
