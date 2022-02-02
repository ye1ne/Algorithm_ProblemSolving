package BJ_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2_DP_S11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum = new int[N+1];
        int max = -1;
        for(int i=1; i<=N; i++){
            for(int j=0; j<i; j++){
                if(A[i]>A[j]  && sum[j] >max){
                    sum[i] = sum[j] + A[i];
                    max = sum[j];
                }
            }
            max = -1;
        }
        max = -1;
        for (int i : sum) max = Math.max(i,max);
        System.out.println(max-100);
    }
}
