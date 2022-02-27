package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5569 {
    static int W;
    static int H;
    static int[][][][] dp;
    final static int Max = 100_000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dp = new int[W+1][H+1][2][2];

        for(int i=2; i<=W; i++) dp[i][1][0][0] = 1;
        for(int i=2; i<=H; i++) dp[1][i][1][0] = 1;
        for(int i=2; i<=W; i++){
            for(int j=2; j<=H; j++){
                dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1])%Max;
                dp[i][j][0][1] = dp[i-1][j][1][0];
                dp[i][j][1][0] = (dp[i][j-1][1][0] + dp[i][j-1][1][1]) % Max;
                dp[i][j][1][1] = dp[i][j-1][0][0];
            }
        }
        int result = 0;
        for(int i=0;i<2; i++){
            for(int j=0;j<2; j++){
                result += dp[W][H][i][j];
            }
        }
        System.out.println(result%Max);
    }
}
