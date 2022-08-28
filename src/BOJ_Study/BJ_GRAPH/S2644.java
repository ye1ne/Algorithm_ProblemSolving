package BOJ_Study.BJ_GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2644 {
    static int n,p1,p2,r,r1,r2, result;
    static List<Integer>[] graph;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new LinkedList[n+1];
        isVisited = new boolean[n+1];
        for(int i =1;i<=n;i++){ graph[i] = new LinkedList<>();}

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        r = Integer.parseInt(br.readLine());

        while(r-->0){
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            graph[r1].add(r2);
            graph[r2].add(r1);
        }

        dfs(p1,0);
        if(result == 0){
            System.out.println(-1);
        }else
            System.out.println(result);

    }
    static void dfs(int v,int depth){
        if(v == p2) {
            result = depth;
            return;
        }
        isVisited[v] = true;
        for(int i =0; i< graph[v].size();i++){
            int child = graph[v].get(i);
            if(!isVisited[child]){
                dfs(child,depth+1);
            }
        }

    }
}

