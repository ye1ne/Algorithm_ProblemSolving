package BOJ_guidance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1920 {
    static int N;
    static int[] A;
    static int number;
    static boolean checker;
    public static void find(int start, int end){
        int pointer = (start + end)/2;
        if(A[start] == number ||A[end] == number) {
            checker = true;
            return;
        }
        if(start >= end-1){
            return;
        }
        if(A[pointer] == number) {
            checker = true;
        }else if(A[pointer] < number){
            find(pointer,end);
        }else  if(A[pointer] >number){
            find(start,pointer);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-->0){
            number = Integer.parseInt(st.nextToken());
            checker =false;
            find(0,N-1);
            if(checker){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
