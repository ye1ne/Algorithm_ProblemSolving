package Study;

import java.io.*;
import java.util.*;

public class BJ_G23843 {
    static int max ;
    static int N,M;
    static Integer[] input;
    static int[] consent;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        input = new Integer[N]; consent = new int[M];
        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input, Collections.reverseOrder());
        int min = (int)Math.pow(2,15) *10_000;
        int minIndex = -1;
        int max = 0;
        if(N>M) {
            for (int i = 0; i < M; i++) {
                consent[i] = input[i];
                if (min >= consent[i]) {
                    min = consent[i];
                    minIndex = i;
                }
            }
            for (int i = M; i < N; i++) {
                min = consent[minIndex] += input[i];
                for (int j = 0; j < M; j++) {
                    if (min >= consent[j]) {
                        min = consent[j];
                        minIndex = j;
                    }
                }
            }
            for (int j = 0; j < M; j++) {
                if (max <= consent[j]) {
                    max = consent[j];
                }
            }
        }else{
            for (int j = 0; j < N; j++) {
                if (max <= input[j]) {
                    max = input[j];
                }
            }
        }
        System.out.println(max);
    }
}
