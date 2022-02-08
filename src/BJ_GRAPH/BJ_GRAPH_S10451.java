package BJ_GRAPH;

import java.io.*;
import java.util.*;

public class BJ_GRAPH_S10451 {
    static int N;
    static LinkedList<Integer>[] graph;
    static boolean[] visit;
    static boolean dfs(int v){
        visit[v]= true;
        for(int i: graph[v]){
            if(visit[i] == false){
                dfs(i);
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- >0){
            N = Integer.parseInt(br.readLine());
            graph = new LinkedList[N + 1];
            visit = new boolean[N + 1];
            for (int i = 1; i < N + 1; i++) {
                graph[i] = new LinkedList<Integer>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i < N + 1; i++) {
                int input = Integer.parseInt(st.nextToken());
                graph[i].add(input);
            }
            for (int i = 1; i < N + 1; i++) {
                Collections.sort(graph[i]);
            }
            int count = 0;
            for (int i = 1; i < N + 1; i++) {
                if (visit[i] == false) {
                    dfs(i);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
