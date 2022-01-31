package BJ_DP;

import java.io.*;

public class BJ2_DP_S9095 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] df = new int[10+1];
        df[1] = 1;
        df[2] = 2;
        df[3] = 4;
        for (int i = 4; i <= 10; i++) {
             df[i] = df[i - 1] + df[i - 2] + df[i - 3];
        }
        for(int i=0; i<N;i++){
            sb.append(df[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }

}

