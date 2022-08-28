package baaarkingDogWorkBook.x0D_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G15684 {
    static int N,M,H, MIN = 10;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+1][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
         }
        backTracking(0,1,1);
        if(MIN == 10) System.out.println(-1);
        else System.out.println(MIN);
    }

    static void backTracking(int count, int row, int col){
        if(count >3){
            return;
        }
        if(isOk()){
            MIN = Math.min(MIN,count);
            return;
        }

        for(int i=row; i<=H;i++){
            for(int j=1; j<N;j++){
                if(i == row && j <col) continue;
                if(j==N-1) {
                    if (map[i][j] == 0 && map[i][j-1] ==0) {
                        map[i][j] = 1;
                        backTracking(count+1,i,j);
                        map[i][j] = 0;
                    }
                }
                else if(j == 1) {
                    if ( map[i][j] == 0 && map[i][j+1] == 0) {
                        map[i][j] = 1;
                        backTracking(count+1,i,j);
                        map[i][j] = 0;
                    }
                }
                else{
                    if (map[i][j] == 0 && map[i][j+1] == 0 && map[i][j-1] ==0) {
                        map[i][j] = 1;
                        backTracking(count+1,i,j);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    static boolean isOk(){
        for(int i=1; i<N; i++){
            int row = 1;
            int col = i;
            for(int j= 1; j<=H; j++){
                if( col < N && map[row][col] == 1){
                    row++;
                    col++;
                }else if (col-1>=1 && map[row][col-1] ==1){
                    row++;
                    col--;
                }else{
                    row++;
                }
            }
            if(col != i){
                return false;
            }
        }
        return true;
    }

}
