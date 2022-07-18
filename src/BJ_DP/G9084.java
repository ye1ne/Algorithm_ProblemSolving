package BJ_DP;

import java.io.*;
import java.util.StringTokenizer;

public class G9084 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int T,N,M;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-->0){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0; i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            dp = new int[10001];

            for(int i =0; i<N;i++){
                dp[arr[i]]++;
                for(int j = arr[i];j<=M;j++){
                    dp[j] += dp[j-arr[i]];
                }
            }

            bw.write(dp[M]+"");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

}
