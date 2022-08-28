package BOJ_Study.BJ_DP;

import java.io.*;

public class BJ2_DP_S11726 {
    static int[] df;
    private static int cal(int num){
        if(df[num] == 0) {
            df[num] = (cal(num - 1) + cal(num - 2))%10007;
        }
        return df[num];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        df = new int[N+1];
        df[0] = df[1] = 1;
        if(N >=2) df[2] = 2;
        System.out.println(cal(N)%10007);
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