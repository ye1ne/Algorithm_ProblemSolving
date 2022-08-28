package BOJ_Study.BJ_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2_DP_G11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Arr = new int[N+1];
        int[] reArr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=N; i++) {
            Arr[i] = reArr[N-i+1] = Integer.parseInt(st.nextToken());
        }

        int[] Dp = new int[N+1];
        int[] reDp = new int[N+1];
        int[] tmpDp = new int[N+1];
        for(int i=1; i<=N;i++){
            for(int j=0; j<i; j++) {
                if (Arr[j]< Arr[i] && (Dp[j]+1) > Dp[i]){
                    Dp[i] = Dp[j]+1;
                }
            }
            for(int j=0; j<i; j++) {
                if (reArr[j]< reArr[i] && (reDp[j]+1) > reDp[i]){
                    reDp[i] = reDp[j]+1;
                }
            }
            tmpDp[i] = Dp[i] + reDp[N-i] -1;
        }

        for(int i =1; i<=N; i++){
            tmpDp[i] = Dp[i] + reDp[N+1-i]-1;
        }
        int max = -1;
        for(int i: tmpDp) max = Math.max(i,max);
        System.out.println(max);
    }

}
