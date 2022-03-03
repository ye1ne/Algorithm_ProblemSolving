package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1912 {
    static int max ;
    static int N;
    static int[] input;
    static int[] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[N]; input = new int[N];
        for(int i=0;i<N;i++){
            if(i == 0){
                input[i] = Integer.parseInt(st.nextToken());
                max = input[0];
            }else {
                input[i] = Integer.parseInt(st.nextToken());
                input[i]= Math.max(input[i-1]+input[i],input[i]);
                if(input[i]>=max) max = input[i];
            }
        }

        System.out.println(max);
    }
}
