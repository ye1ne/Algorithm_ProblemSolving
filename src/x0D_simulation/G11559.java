package x0D_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G11559 {
    static char[][] map = new char[12][6];
    static boolean[][] isVisited;
    static boolean isPuyo;
    static int[] countNum = new int[5];
    static final int R = 0, G = 1, B = 2, P = 3, Y = 4;
    static int count;
    static int result;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0}; //동서남북
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isVisited = new boolean[12][6];
        for(int i=0; i<12; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        do {
            isPuyo = false;
            for(int j=0; j<6; j++){
                for(int i = 10; i>=0; i--){
                    int tmp = i;
                    while(tmp<11&&map[tmp+1][j] == '.'){
                        map[tmp+1][j] = map[tmp][j];
                        map[tmp][j] = '.';
                        tmp++;
                    }
                }
            }
            //터져야하는 뿌요 처리
            count = 0;
            for(int i=0; i<12; i++){
                for(int j=0; j<6; j++){
                    if(!isVisited[i][j] && map[i][j] != '.'){
                        puyo(i,j);
                    }
                }
            }
            if(isPuyo) {
                result++;
            }
            isVisited = new boolean[12][6];
        }while (isPuyo);
        System.out.println(result);
    }
    static void puyo(int row, int col){

        isVisited[row][col] = true;
        char color = map[row][col];

        Queue<Integer[]> q = new LinkedList<>();
        Queue<Integer[]> eraseQ = new LinkedList<>();

        q.add(new Integer[]{row,col});
        eraseQ.add(new Integer[]{row,col});
        while(!q.isEmpty()){
            Integer[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=12 || ny<0 || ny>=6) continue;
                if(isVisited[nx][ny] || map[nx][ny] != color) continue;
                isVisited[nx][ny] = true;
                q.add(new Integer[]{nx,ny});
                eraseQ.add(new Integer[]{nx,ny});
            }
        }

        if(eraseQ.size()>=4){
            isPuyo = true;
            while(!eraseQ.isEmpty()){
                Integer[] cur = eraseQ.poll();
                map[cur[0]][cur[1]] = '.';
            }
        }
    }


}
