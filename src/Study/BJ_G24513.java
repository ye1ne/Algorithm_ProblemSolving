package Study;

import java.io.*;
import java.util.*;

import java.util.StringTokenizer;

public class BJ_G24513 {
    final static int Max = 1_000_000; //최대로 가질 수 있는 시간
    static int N,M;
    static int[] result;
    static int[][] map; //맵의 경우 기본적으로 건들지 않음, 안바뀐다.
    static int[][][] countTime;
    static Queue<Location> q;

    static class Location{
            int row,col,virus,time;
            public Location(int row, int col, int virus,int time){
                this.row = row;
                this.col = col;
                this.virus = virus;
                this.time = time;
            }
    }

    static void check(int row, int col, int virus, int time){
        if(row<0 || col<0 || row >=N || col>=M){
            return;
        }
        if(map[row][col]==0){
            // 다른바이러스 인경우(3-virus)면, 카운트된 시간이 time보다는 커야하고,
            // 같은 바이러스 인 경우(virus)면, 카운트 된 시간이 time+1보다는 커야한다. 같아도 상관없음
            if(countTime[row][col][3-virus]> time && countTime[row][col][virus]> time+1){
                countTime[row][col][virus] = time + 1;
                if (countTime[row][col][3 - virus] == Max)
                    q.offer(new Location(row, col, virus, time + 1));
            }
        }

    }
    static void bfs(){
        while(!q.isEmpty()){
            Location tmp = q.poll();
            int row = tmp.row;
            int col = tmp.col;
            int virus = tmp.virus;
            int time = tmp.time;
            int virus1 = countTime[row][col][1] == Max ? 0:1;
            int virus2 = countTime[row][col][2] == Max ? 0:2;
            map[row][col] = virus1+virus2;
            result[virus1+virus2]++;
            if(virus1+ virus2 == 3) continue;
            check(row+1,col,virus,time);
            check(row,col+1,virus,time);
            check(row-1,col,virus,time);
            check(row,col-1,virus,time);

        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        countTime = new int[N][M][3];
        result = new int[4];
        q = new LinkedList<>();
        for(int i =0; i<N; i++){
            for(int j=0; j<M; j++){
                for (int k=0; k<3;k++){
                    countTime[i][j][k] = Max;
                }
            }
        }

        for(int i=0;i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
                if(0<map[i][j]&& map[i][j]<3){
                    q.offer(new Location(i,j,map[i][j],0));
                    countTime[i][j][map[i][j]] = 0;
                }
            }
        }
        bfs();
        System.out.println(result[1]+" "+result[2]+" "+result[3]);
    }
}
