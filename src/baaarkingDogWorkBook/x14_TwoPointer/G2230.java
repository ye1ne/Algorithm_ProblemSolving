package baaarkingDogWorkBook.x14_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2230 {
    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];

        for(int i=0; i<N; i++) A[i] = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        int end=0, MIN = Integer.MAX_VALUE;

        OuterLoop:
        for(int start=0; start<N; start++){
            while(end<N && (A[end]-A[start] < M)) end++;
            if(end == N) break OuterLoop;
            MIN = Math.min(MIN,A[end]-A[start]);
        }

        System.out.println(MIN);
    }
}
