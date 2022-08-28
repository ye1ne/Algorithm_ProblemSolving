package BOJ_Study.BJ_GRAPH;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_GRAPH_S2583 {
    static int M,N,T;
    static boolean[][] graph;
    static boolean[][] visit;
    static int count;
    static int partitionNum;
    static int dfs(int x, int y){
        if(y > M || x > N || y < 1 || x < 1) {
            return 0;
        }
        if(visit[y][x]){
           return 0;
        }
        visit[y][x] = true;
        count++;
        if(y!=M&&!graph[y+1][x]&&!visit[y+1][x]){;
            dfs(x,y+1);
        }
        if(x!=N&&!graph[y][x+1]&&!visit[y][x+1]){
            dfs(x+1,y);
        }
        if(y!=1&&!graph[y-1][x]&&!visit[y-1][x]){
            dfs(x,y-1);
        }
        if(x!=1&&!graph[y][x-1]&&!visit[y][x-1]){
            dfs(x-1,y);
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        graph = new boolean[M+1][N+1];
        visit = new boolean[M+1][N+1];
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int i = x1+1; i <= x2; i++) {
                for (int j = y1+1; j <= y2; j++) {
                    graph[j][i] = true;
                    visit[j][i] = true;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer> ();
        partitionNum = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                int temp = dfs(j,i);
                if(temp==1){
                    result.add(count);
                    partitionNum++;
                    count =0;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Collections.sort(result);
        bw.write(partitionNum+"\n");
        for(int number : result) {
            bw.write(number + " ");
        }
        bw.flush();
        bw.close();
    }

}
