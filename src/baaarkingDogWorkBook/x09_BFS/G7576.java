package baaarkingDogWorkBook.x09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G7576 {

    static int[][] map;
    static boolean[][] isVisited;
    static class Index{
        int x, y, time;

        public Index(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int M,N, totalTomato=0,  ripeTomato=0 ,MIN_TIME=0;
    static Queue<Index>  q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.add(new Index(i,j,0));
                    totalTomato++; ripeTomato++;
                }else if(map[i][j] == 0){
                    totalTomato++;
                }
            }
        }
        if(totalTomato == ripeTomato) {
            System.out.println(0); return;
        }
        ripeTomato = 0;

        while(!q.isEmpty()){
            Index index = q.poll();
            if(isVisited[index.x][index.y]) continue;
            if(index.time > MIN_TIME) MIN_TIME = index.time;
            map[index.x][index.y] = 1;
            isVisited[index.x][index.y] = true;
            ripeTomato++;

            if(index.x +1 <N && map[index.x+1][index.y] ==0 && !isVisited[index.x+1][index.y]){
                q.add(new Index(index.x+1, index.y, index.time +1));
            }
            if(index.y +1 <M && map[index.x][index.y+1] ==0 && !isVisited[index.x][index.y+1]){
                q.add(new Index(index.x, index.y+1, index.time +1));
            }
            if(index.x -1 >=0 && map[index.x-1][index.y] ==0 && !isVisited[index.x-1][index.y]){
                q.add(new Index(index.x-1, index.y, index.time +1));
            }
            if(index.y -1 >=0&& map[index.x][index.y-1] ==0 && !isVisited[index.x][index.y-1]){
                q.add(new Index(index.x, index.y-1, index.time +1));
            }
        }
        if(totalTomato != ripeTomato) {
            System.out.println(-1);
        }else{
            System.out.println(MIN_TIME);
        }
    }

}
