package baaarkingDogWorkBook.x10_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1915 {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        int MAX = 0;

        for(int i=0;i<N;i++){
            String inputLine = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = inputLine.charAt(j) - '0';
                if(map[i][j] == 1){
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                        MAX = Math.max(MAX,dp[i][j]);
                        continue;
                    }

                    if(map[i][j-1] == 1 && map[i-1][j] ==1 && map[i-1][j-1] == 1){
                        dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1])) +1;
                    } else dp[i][j] = 1;
                    MAX = Math.max(MAX,dp[i][j]);
                }
            }
        }

        System.out.println(MAX*MAX);
    }
}
