package BJ_various;

import java.io.*;
import java.util.StringTokenizer;

public class BJ3_V_S11650 {
    static int[][] A;

    static void swap(int a1, int a2, int index){
        int tmp;
        tmp = A[a1][index];
        A[a1][index] = A[a2][index];
        A[a2][index] = tmp;
    }

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
        for(int i=1;i<N;i++){
            for(int j=0;j<N-i;j++){
                if(A[j][0] > A[j+1][0]) {
                    swap(j,j+1,0);
                    swap(j,j+1,1);
                }
                if(A[j][0] == A[j+1][0]){
                    if(A[j][1] > A[j+1][1]){
                        swap(j,j+1,0);
                        swap(j,j+1,1);
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.flush();
        bw.close();
    }
}
