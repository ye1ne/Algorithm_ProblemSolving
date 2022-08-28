package BOJ_Study.BJ_BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_BS_S2805 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long[] input = new long[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N;i++){
            input[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(input);

        long max = input[N-1];
        long min = 1;
        long mid = input[N-1];
        while(max>=min){
            long count = 0;
            for(int i =0; i<N; i++){
                if(mid<input[i]) count += (input[i]-mid);
            }
            if(count >= M){
                min = mid +1;
            }else if(count <M){
                max = mid -1;
            }
            mid = (max + min)/2;
        }
        System.out.println(max);
    }
}
