package BJ_BS;

import java.io.*;
import java.util.*;

public class BJ_BS_S1654 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] input = new long[K];
        for(int i =0; i<K; i++){
            input[i]= Long.parseLong(br.readLine());
        }
        Arrays.sort(input);

        long max = input[K-1];
        long min = 1;
        long length = 0;
        while(min <= max){
            length = (min+max)/2;
            long count =0;
            for(int i =0; i<K;i++){
                count += (input[i]/length);
            }
            if(count <N){
                max = length-1;
            }else if(count >=N){
                min = length+1;
            }
        }
        System.out.println(max);
    }
}
