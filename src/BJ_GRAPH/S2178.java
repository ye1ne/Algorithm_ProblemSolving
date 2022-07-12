package BJ_GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2178 {

    static class Info{
        int x, y, depth;
        public Info(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    static int N,M,result;
    static int[][] map;
    static boolean[][] isVisited;
    static boolean[][] hasInput;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        hasInput = new boolean[N][M];
        isVisited = new boolean[N][M];
        for(int i =0; i<N;i++){
            String str = br.readLine();
            for(int j = 0; j<M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
        System.out.print(result+1);
    }

    static void bfs(){

        Info start= new Info(0,0,0);

        Queue<Info> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            Info info = q.poll();
            int x = info.x;
            int y = info.y;
            int depth = info.depth;
            isVisited[x][y] = true;
            StringTokenizer stringTokenizer = new StringTokenizer("ds:ds",":");
            System.out.println(stringTokenizer.nextToken());

            if(x==N-1 && y==M-1){
                result = depth;
                return;
            }

            if(x+1<N && map[x+1][y] == 1 && !isVisited[x+1][y]){
                if(!hasInput[x+1][y]) {
                    Info tmp = new Info(x + 1, y, depth + 1);
                    q.add(tmp);
                    hasInput[x + 1][y] = true;
                }
            }
            if(y+1<M && map[x][y+1] == 1 && !isVisited[x][y+1]){
                if(!hasInput[x][y+1]) {
                    Info tmp = new Info(x , y+1, depth + 1);
                    q.add(tmp);
                    hasInput[x][y+1] = true;
                }
            }
            if(x-1>=0 && map[x-1][y] == 1 && !isVisited[x-1][y]){
                if(!hasInput[x-1][y]) {
                    Info tmp = new Info(x - 1, y, depth + 1);
                    q.add(tmp);
                    hasInput[x - 1][y] = true;
                }
            }
            if(y-1>=0 && map[x][y-1] == 1&& !isVisited[x][y-1]){
                if(!hasInput[x][y-1]) {
                    Info tmp = new Info(x , y-1, depth + 1);
                    q.add(tmp);
                    hasInput[x ][y-1] = true;
                }
            }
        }
        return;
    }
}
