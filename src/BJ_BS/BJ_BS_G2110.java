package BJ_BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_BS_G2110 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long[] X = new long[N];
        long[] Gap = new long[N-1];

        for(int i=0; i<N; i++){
            X[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(X);

        for(int i=0; i<N-1; i++){
            Gap[i] = X[i+1]-X[i];
        }
        for(int i=0;i<C; i++){

        }
    }
}
