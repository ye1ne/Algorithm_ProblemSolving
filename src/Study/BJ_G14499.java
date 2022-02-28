package Study;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_G14499 {
    final static int East = 1;
    final static int West = 2;
    final static int North = 3;
    final static int South = 4;
    static int M, N, x, y, K;
    static int[][] map;
    static int[][] dice;
    static void goEast(){
        int tmp = dice[1][0];
        dice[1][0] = dice[1][1];
        dice[1][1] = dice[1][2];
        dice[1][2] = dice[3][1];
        dice[3][1] = tmp;
    }

    static void goWest(){
        int tmp = dice[1][2];
        dice[1][2] = dice[1][1];
        dice[1][1] = dice[1][0];
        dice[1][0] = dice[3][1];
        dice[3][1] = tmp;
    }

    static void goNorth(){
        int tmp = dice[0][1];
        dice[0][1] = dice[1][1];
        dice[1][1] = dice[2][1];
        dice[2][1] = dice[3][1];
        dice[3][1] = tmp;
    }

    static void goSouth(){
        int tmp = dice[3][1];
        dice[3][1] = dice[2][1];
        dice[2][1] = dice[1][1];
        dice[1][1] = dice[0][1];
        dice[0][1] = tmp;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int [N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        dice = new int [4][3];
        while(K-->0){
            int dirt = Integer.parseInt(st.nextToken());
            switch(dirt){
                case East:
                    if(y+1<M) {
                        goEast();
                        y++;
                    }else continue;
                    break;
                case West:
                    if(y-1>=0) {
                        goWest();
                        y--;
                    }else continue;
                    break;
                case North:
                    if(x-1>=0) {
                        goNorth();
                        x--;
                    }else continue;
                    break;
                case South:
                    if(x+1<N) {
                        goSouth();
                        x++;
                    }else continue;
                    break;
            }
            if(map[x][y] == 0) map[x][y] = dice[3][1];
            else {
                dice[3][1] = map[x][y];
                map[x][y] = 0;
            }

            bw.write(dice[1][1]+"\n");
        }

        bw.flush();
        bw.close();
    }
}
