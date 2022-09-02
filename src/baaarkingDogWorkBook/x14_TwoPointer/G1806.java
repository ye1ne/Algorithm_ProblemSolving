package baaarkingDogWorkBook.x14_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1806 {
    static int N, S, MIN = Integer.MAX_VALUE;
    static int[] A;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        int end =0, total = A[0];

        for(int start = 0; start < N; start++){
            while(end <N && total<=S){
                end++;
                if(end != N) total += A[end];
            }
            if(end == N) break;
            MIN = Math.min(MIN, end-start+1);
            total -= A[start];

        }

        if(Integer.MIN_VALUE == MIN) System.out.println(0);
        else System.out.println(MIN);
    }


}
