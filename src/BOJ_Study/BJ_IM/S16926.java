package BOJ_Study.BJ_IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S16926 {
    static int N,M,R;
    static int[][] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        int rowSize = N, colSize = M;
        int minLength = Math.min(N,M);
        for(int i = 0; i<minLength/2; i++){
            rotation(i,i,rowSize,colSize,R);
            rowSize-=2;
            colSize-=2;

        }

        for(int i=0; i<N;i++){
            for(int j=0; j<M; j++){
                sb.append(arr[i][j]+"");
                if(j == M-1) sb.append("\n");
                else  sb.append(" ");
            }
        }

        System.out.println(sb);

    }
    static void rotation(int startR, int startC, int rowSize, int colSize, int count){
        while(count-->0){
            int nextNum = 0, replaceNum =0;
            //맨 윗줄 한칸씩 당기기, row 고정
            for(int i=colSize+startC-1; i>=startC; i--){
                nextNum = arr[startR][i];
                arr[startR][i] = replaceNum;
                replaceNum = nextNum;
            }

            //왼쪽 줄 한칸씩 당기기, col 고정
            for(int i=startR+1; i<=startR +rowSize-1; i++){
                nextNum = arr[i][startC];
                arr[i][startC] = replaceNum;
                replaceNum = nextNum;
            }


            //아랫줄 한칸씩 오른쪽으로 당기기
            for(int i= startC+1; i<startC+colSize-1;i++){
                nextNum = arr[startR + rowSize-1][i];
                arr[startR + rowSize-1][i] = replaceNum;
                replaceNum = nextNum;
            }

            //오른쪽즐 한칸씩 윗쪽으로 달리기
            for(int i=rowSize+startR-1; i>=startR; i--){
                nextNum = arr[i][startC+colSize-1];
                arr[i][startC+colSize-1] = replaceNum;
                replaceNum = nextNum;
            }
        }
    }
}
