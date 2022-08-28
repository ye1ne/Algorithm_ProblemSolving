package BOJ_Study.BJ_DP;

import java.io.*;
import java.util.*;

public class BJ2_DP_S11722 {

    static int[] num;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1];
        num[0] =1001;
        for(int i=1; i<=N;i++){
            for(int j=0; j<i; j++) {
                if (num[j]> num[i] && (dp[j]+1) > dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max = -1;
        for (int i : dp) max = Math.max(i,max);
        System.out.println(max);
    }

}
