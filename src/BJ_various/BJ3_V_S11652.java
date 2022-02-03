package BJ_various;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BJ3_V_S11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        long tmp = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(A);
        int tmpCount =1;
        int Count = 1;
        long tmpMax = A[0];
        long Max=A[0];
        for (int j = 1; j < N; j++) {
            if(A[j] == A[j-1]) {tmpCount++;}
            else {
                if(Count < tmpCount) {
                    Max = tmpMax;
                    Count = tmpCount;
                }
                tmpMax = A[j];
                tmpCount =1;
            }
        }
        if(Count < tmpCount) {
            Max = tmpMax;
            Count = tmpCount;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Max+"\n");
        bw.flush();
        bw.close();
    }
}



