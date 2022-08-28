package BOJ_Study.BJ_various;

import java.io.*;
import java.util.*;

public class BJ3_V_S11650_2 {
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        A = new int[N][2];

        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1],o2[1]);
                return Integer.compare(o1[0],o2[0]);
            }
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i<N;i++){
            bw.write(A[i][0]+" "+A[i][1]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
