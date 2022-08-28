package baaarkingDogWorkBook.x0D_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G14503 {
    static int N, M, r,c,d, totalClean;
    static int[][] map;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1}; //북쪽으로 동쪽으로 남쪽으로 서쪽으로 한칸갈떄 사용
    static final int WALL = 1;
    static boolean[][] isClean;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isClean = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        totalClean = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int row = r, col = c, dir = d;

        OuterLoop:
        while (true) {
            //1번. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if(!isClean[row][col]) {
                isClean[row][col] = true;
                totalClean++;
            }
            //3번. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            for(int i=0; i<4; i++){
                //일단 좌회전해서
                dir--; if(dir == -1) dir = 3;
                int nextRow = row + dr[dir];
                int nextCol = col + dc[dir];

                //청소가능한지 확인해서 가능하면
                if(!isOutBound(nextRow,nextCol) && !isClean[nextRow][nextCol] && map[nextRow][nextCol] != WALL){
                    //앞으로 한칸전진
                    row = nextRow; col = nextCol;
                    //다음턴으로 감
                    continue OuterLoop;
                }
                //청소불가능하면 그냥계속 간다
            }
            //2번. 주변4칸다 청소 불가능하면
            //뒤에 방향
            int backDir = (dir +2) %4;
            int backRow = row + dr[backDir];
            int backCol = col + dc[backDir];
            if( !isOutBound(backRow,backCol) && map[backRow][backCol] != WALL){
                row = backRow;
                col = backCol;
            }else break OuterLoop;

        }

        System.out.println(totalClean);
    }

    static boolean isOutBound(int row, int col){
        if(row>=0 && row <N && col>=0 && col<M) return false;
        return true;
    }
}
