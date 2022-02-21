package BJ_DC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_DC_S11728_2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb =new StringBuilder();
        int startA = 0;
        int startB = 0;
        int pointerA = startA;
        int pointerB = startB;
        while(pointerA <N && pointerB <M){
            if(A[pointerA]<B[pointerB]){
                sb.append(A[pointerA]+" ");
                pointerA++;
            }else{
                sb.append(B[pointerB]+" ");
                pointerB++;
            }
        }
        if(pointerA == N){
            for(int i = pointerB; i<M ;i++){
                sb.append(B[i]+" ");
            }
        }else if(pointerB == M){
            for(int i = pointerA; i<N ;i++){
                sb.append(A[i]+" ");
            }
        }
        System.out.println(sb.toString());
    }
}
