package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G1915 {
    static int n;
    static int m;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        for(int i=0; i<n;i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] =  str.charAt(j) - '0';
                if(i == 0 && map[i][j]==1) dp[i][j] =1;
                if(j == 0 && map[i][j]==1) dp[i][j] =1;

            }
        }
        int result = dp[0][0];
        for( int i=1; i<n;i++){
            for(int j=1; j<m; j++){
                if(map[i][j]!=1) dp[i][j] = 0;
                else dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]) +1;
                if(result <= dp[i][j]) result = dp[i][j];
            }
        }
        System.out.println(result*result);

    }
}
