package BJ_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2_DP_S11727 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] df = new int[N+1];
        df[0] = df[1] = 1;

        if(N>=2) {
            df[2] = 3;
            for (int i = 3; i <= N; i++)
                df[i] = (df[i - 1] + 2*df[i - 2]) % 10007;
        }
        System.out.println(df[N]%10007);
    }

}
/**
 *         for(int i = 4; i<N; i+=2){
 *              sum += cal((N-i),(i/2));
 *         }
 *         if(N%2 ==0) sum += 1;
 *         if(N == 2) sum = 2;
 *
 *
 */