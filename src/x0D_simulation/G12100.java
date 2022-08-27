package x0D_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G12100 {
    static int N;
    static int[][] map;
    static int[][] tmpMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        tmpMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int tmp = 0; tmp<1024; tmp++) { //4의 5승 가능한 모든 경우의 수
            //tmpMap 에 초기화
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    tmpMap[i][j] = map[i][j];

            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                int dir = brute % 4; //0,1,2,3 각방향에 따라 90도 회전
                brute /= 4;
                tilt(dir);
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, tmpMap[i][j]);
                }
            }
        }
        System.out.println(max);
    }

    static void tilt(int dir){
        while(dir-->0) rotate();
        for(int i=0; i<N; i++){
            int[] tilted  = new int[N]; //맵을 왼쪽으로 기울인 결과를 저장할 변수
            int index = 0; //배열의 어디에 삽인할지 가르키는 변수
            for(int j=0; j<N; j++) {
                if(tmpMap[i][j] == 0) continue;
                if(tilted[index]== 0) tilted[index] = tmpMap[i][j];//삽입할 위치가 비어있을 경우
                else if(tilted[index] == tmpMap[i][j]) tilted[index++] *= 2;
                else tilted[++index] = tmpMap[i][j];
            }

            for(int j=0;j<N; j++) tmpMap[i][j] = tilted[j];

        }
    }

    //4가지 케이스를 한방향으로 고정하고 판을 돌려가면서 함
    static void rotate(){
        int tmp[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                tmp[i][j] = tmpMap[i][j];
        for(int i=0; i<N; i++)
            for (int j = 0; j < N; j++)
                tmpMap[i][j] = tmp[N-1-j][i];
    }
}
