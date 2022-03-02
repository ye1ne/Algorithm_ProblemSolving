package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G14925 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] =  Integer.parseInt(st.nextToken());
                if(i == 0 && map[i][j]==0) dp[i][j] =1;
                if(j == 0 && map[i][j]==0) dp[i][j] =1;

            }
        }
        int result = dp[0][0];
        for( int i=1; i<N;i++){
            for(int j=1; j<M; j++){
                if(map[i][j]!=0) dp[i][j] = 0;
                else dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]) +1;
                if(result <= dp[i][j]) result = dp[i][j];
            }
        }
        System.out.println(result);

    }
}
