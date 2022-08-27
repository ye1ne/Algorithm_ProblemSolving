package x0D_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G15683 {
    static int N,M;
    static int[][] map;
    static int[][] countMap;

    static final int wall = 6;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0}; //동남서북
    static List<Integer[]> cctv = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        countMap = new int[N][M];

        int result = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] !=0 && map[i][j] != wall) cctv.add(new Integer[]{i,j});
                if(map[i][j] == 0) result++;
            }
        }
        for(int tmp=0; tmp< (int)Math.pow(4, cctv.size());tmp++){
            for(int i =0; i< N; i++) {
                for (int j = 0; j < M; j++) {
                    countMap[i][j] = map[i][j];
                }
            }
            int brute = tmp;
            for(int i=0; i<cctv.size(); i++){
                int dir = brute%4;
                brute /= 4;
                int x = cctv.get(i)[0];
                int y = cctv.get(i)[1];
                if(map[x][y] == 1){
                    update(x,y,dir);
                }else if (map[x][y] == 2){
                    update(x,y,dir);
                    update(x,y,dir+2);
                }else if (map[x][y] == 3){
                    update(x,y,dir);
                    update(x,y,dir+3);
                } else if (map[x][y] == 4){
                    update(x,y,dir);
                    update(x,y,dir+2);
                    update(x,y,dir+3);
                }else if (map[x][y] == 5){
                    update(x,y,dir);
                    update(x,y,dir+1);
                    update(x,y,dir+2);
                    update(x,y,dir+3);
                }
            }
            int val = 0;
            for(int i=0; i<N; i++) {
                for (int j = 0; j < M; j++) {
                    if(countMap[i][j] == 0) val++;
               }
            }
            result = Math.min(result, val);
        }
        System.out.println(result);

    }

    //벽을 만날때까지 지나가는 모든 빈칸을 7로 바꿈
    static void update(int x,int y, int dir){
        dir%=4;
        while(true){
            x += dx[dir];
            y += dy[dir];
            if(x<0 || x>=N || y<0 || y>=M) return;
            if(countMap[x][y] == wall) return;
            if(countMap[x][y] != 0) continue; //cctv면 일단 넘어감
            countMap[x][y] = 7; //빈칸을 7로

        }
    }

}
