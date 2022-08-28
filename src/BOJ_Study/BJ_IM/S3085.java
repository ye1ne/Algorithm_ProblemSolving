package BOJ_Study.BJ_IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3085 {
    static int N, maxEat;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maxEat = 0;
        map = new char[N][N];
        for(int i =0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }


        for(int i =0; i<N; i++){
            for(int j=0; j<N; j++){

                if(i!=N-1) {

                    swap(i,j,i+1,j);
                    countAllCases(i, j);
                    countAllCases(i + 1, j);
                    swap(i,j,i+1,j);

                }
                if(j!=N-1) {
                    swap(i,j,i,j+1);
                    countAllCases(i, j);
                    countAllCases(i, j + 1);
                    swap(i,j,i,j+1);
                }
            }
        }
        System.out.println(maxEat);
    }

    private static void swap(int x1,int y1, int x2, int y2){
        char tmp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = tmp;
    }
    private static void countAllCases(int i, int j){
        countMax(i,j,'C');
        countMax(i,j,'P');
        countMax(i,j,'Z');
        countMax(i,j,'Y');
    }

    private static void countMax(int x, int y, char X) {
        int tmpCount = 0;
        for(int i =0; i<N; i++){
            if(map[i][y] == X){
                tmpCount++;
            }else{

                if(tmpCount > maxEat) {
                    maxEat = tmpCount;
                }
                tmpCount = 0;
            }
        }
        if(tmpCount > maxEat) {
            maxEat = tmpCount;
        }
        tmpCount = 0;
        for(int i =0; i<N; i++){
            if(map[x][i] == X){
                tmpCount++;
            }else{
                if(tmpCount > maxEat) {
                    maxEat = tmpCount;
                }
                tmpCount = 0;
            }
        }
        if(tmpCount > maxEat) {
            maxEat = tmpCount;
        }
    }


}
