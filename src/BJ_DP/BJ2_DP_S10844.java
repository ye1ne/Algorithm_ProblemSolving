package BJ_DP;

import java.io.*;

public class BJ2_DP_S10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] bp = new int[N+1];
        bp[1] = 9;
        for(int i =2; i<=N; i++){
            bp[i] = (int)(bp[i-1]*2 - Math.pow(2,i-2));
        }
        System.out.println(bp[N]);
    }
}
