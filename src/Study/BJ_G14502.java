package Study;

import java.io.*;
import java.util.*;

public class BJ_G14502 {
    static final int VIRUS = 2;
    static final int EMPTY = 0;
    static final int WALL = 1;


    static class Info{
        int row,col;
        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static Queue<Info> q = new LinkedList<>();
    static List<Info> qlist = new ArrayList<>();
    static List<Info> list = new ArrayList<>();
    static int N, M, count;
    static int[][] map,tmpMap;
    static boolean[][] isVisit;

    static void dfs(){
        isVisit = new boolean[N][M];
        for(Info info: qlist){
            q.offer(new Info(info.row, info.col));
        }
        while (!q.isEmpty()){
            Info tmp =q.poll();
            int row = tmp.row;
            int col = tmp.col;

            if(isVisit[row][col]){continue;}
            isVisit[row][col] = true;
            count++;

            if(row+1<N && map[row+1][col] == EMPTY) q.offer(new Info(row+1,col));
            if(row-1>=0 && map[row-1][col] == EMPTY) q.offer(new Info(row-1,col));
            if(col+1<M && map[row][col+1] == EMPTY) q.offer(new Info(row,col+1));
            if(col-1>=0 && map[row][col-1] == EMPTY) q.offer(new Info(row,col-1));
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [N][M];

        tmpMap = new int [N][M];
        int VirusCount = 0; int CountWall = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                tmpMap[i][j] = Integer.parseInt(st.nextToken());
                if(tmpMap[i][j] == VIRUS) {qlist.add(new Info(i,j));VirusCount++;}
                if(tmpMap[i][j] == EMPTY) list.add(new Info(i,j));
                if(tmpMap[i][j] == WALL) CountWall++;
            }
        }

        int min = N*M;
        for(int i=0;i<list.size();i++){
            for(int j=i+1; j< list.size(); j++){
                for(int k = j+1; k < list.size(); k++){
                    count = 0;
                    for(int l = 0; l<N;l++){map[l] = tmpMap[l].clone();}
                    Info tmp1 = list.get(i);
                    Info tmp2 = list.get(j);
                    Info tmp3 = list.get(k);
                    map[tmp1.row][tmp1.col] = WALL;
                    map[tmp2.row][tmp2.col] = WALL;
                    map[tmp3.row][tmp3.col] = WALL;
                    dfs();
                    if(count<min) min = count;
                }
            }
        }
        System.out.println(N*M-min-CountWall-3);

    }
}
