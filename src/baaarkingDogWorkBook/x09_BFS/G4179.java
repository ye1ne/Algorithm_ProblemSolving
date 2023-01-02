package baaarkingDogWorkBook.x09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4179 {

    static final char WALL = '#', SPACE = '.', JI_HOON = 'J', FIRE = 'F';
    static final String IMPOSSIBLE = "IMPOSSIBLE";
    public static void main(String[] args) throws IOException {
        //지훈이의 위치와 불이 붙은 위치를 감안해서 탈출할 수 있는지, 얼마나 빨리 탈출할 수 있는지 결정
        //한칸씩 수평 똦는 수직으로 이동

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];

        char[][][] fireMap = new char[1001][R][C];
        Queue<int[]> fireQueue = new ArrayDeque<>();

        for(int row = 0; row <R; row++){
            String tmp = br.readLine();
            for(int col = 0; col < R; col++){
                map[row][col] = tmp.charAt(col);
                if(map[row][col] == FIRE){
                    fireQueue.add(new int[]{row,col,0});
                }
            }
        }

        fireMap[0] = map;

        createMapByTime(fireMap, fireQueue);

        System.out.println();
    }

    static final int[] dr = {1,-1,0,0};
    static final int[] dc = {0,0,1,-1};
    private static void createMapByTime(char[][][] fireMap, Queue<int[]> fireQueue) {
        while(!fireQueue.isEmpty()){
            int[] tmp = fireQueue.poll();
            int row = tmp[0];
            int col = tmp[1];
            int time = tmp[2];
            fireMap[time][row][col] = FIRE;
            fireMap[time+1] = copyArray(fireMap[time]);

            for(int i=0; i<4; i++){
                if(row+dr[i] >= 0 && row+dr[i] <fireMap[0].length
                        && col+dc[i] >=0 && col+dc[i] < fireMap[0][0].length) {
                    if (fireMap[time + 1][row + dr[i]][col + dc[i]] == '.'
                            || fireMap[time + 1][row + dr[i]][col + dc[i]] == 'J') {
                        fireQueue.add(new int[]{row + dr[i], col + dc[i],time + 1});
                    }
                }
            }
        }
    }
    private static char[][] copyArray(char[][] arr1){
        char[][] tmp = new char[arr1.length][arr1[0].length];
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[0].length; j++){
                tmp[i][j] = arr1[i][j];
            }
        }
        return tmp;
    }

}
