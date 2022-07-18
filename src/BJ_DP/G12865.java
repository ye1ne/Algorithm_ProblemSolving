package BJ_DP;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G12865 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,K;
    static int[][] items;
    static int[] dp;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        items = new int[N][2];
        dp = new int[K+1];
        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
            if(dp[items[i][0]] <items[i][1])
                dp[items[i][0]] =items[i][1];
        }

        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for(int i =0; i<=K; i++){
            for(int j = i; j<=K;j++){
                int tmp = dp[i] + dp[j-i];
                if(tmp >= dp[j])
                    dp[j] = tmp;
            }
        }
        bw.write(dp[K]+"");
        bw.newLine();

        bw.flush();
        bw.close();
    }
}
