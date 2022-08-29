package BOJ_Study.BJ_IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2740 {
    static int N,M,K;
    static int[][] arr1, arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr1 = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M;j++){
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr2 = new int[M][K];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K;j++){
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                int tmp = 0;
                for(int k =0; k<M; k++){
                    tmp += arr1[i][k] * arr2[k][j];
                }
                System.out.print(tmp);
                if(j == K-1){
                    System.out.println();
                }else{
                    System.out.print(" ");
                }
            }
        }
    }
}
