package BJ_GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_GRAPH_S11724 {
    static int N;
    static int M;
    static boolean[][] map;
    static boolean[] visit;
    static int finish;
    static int count;
    static void dfs(int v){
        if(visit[v] == false) {
            visit[v] = true;
            finish++;
        }
        for(int i = 1; i<=N; i++){
            if( map[v][i] == true && visit[i] == false)
                dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N+1][N+1];
        visit = new boolean[N+1];
        for(int i = 0; i <M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            map[a1][a2] = true;
            map[a2][a1] = true;
        }
        finish = count = 0;
        while( finish != N ) {
            for (int i = 1; i <= N; i++) {
                if (visit[i] == false) {
                    count++;
                    dfs(i);
                }
            }
        }
        System.out.println(count);
    }
}
