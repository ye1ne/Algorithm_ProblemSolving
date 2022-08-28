package BOJ_Study.BJ_BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ_BS_S12852 {
    static int N;
    static int[] dp;
    static String[] dpStr;
    static int Max_num = (int)Math.pow(10,6) +1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dpStr = new String[N+1];
        dp[1] = 0; dpStr[1] = "1";
        if(N>=2) {
            dp[2] = 1;
            dpStr[2] = "2"+" "+dpStr[1];
        }
        if(N>=3) {
            dp[3] = 1;
            dpStr[3] = "3"+" "+dpStr[1];
        }

        int tmp1,tmp2,tmp3;
        for(int i=4; i<=N; i++){
            tmp1 = tmp2 = tmp3 = Max_num;
            if(i%3 == 0) tmp1 = dp[i/3] +1;
            if(i%2 == 0) tmp2 = dp[i/2] +1;
            tmp3 = dp[i-1] +1;
            dp[i] = Math.min(Math.min(tmp1, tmp2),tmp3);
            if(dp[i] == tmp1) dpStr[i] = i+" "+dpStr[i/3];
            else if(dp[i] == tmp2) dpStr[i] =  i+" "+dpStr[i/2];
            else dpStr[i] =  i+" "+dpStr[i-1];
        }
        System.out.println(dp[N]);
        System.out.println(dpStr[N]);
    }
}
