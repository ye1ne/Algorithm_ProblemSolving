package BJ_GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_GRAPH_S1260 {
    static int map[][];
    static boolean[] visit;
    static int n,m,v;

    public static void dfs(int v){
        visit[v]= true;
        System.out.print(v+" ");
        for(int i =1; i<=n;i++){
            if(map[v][i] == 1 && visit[i] == false){
                dfs(i);
            }
        }
    }
    public static void bfs(int i){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(i);
        visit[i] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp+" ");
            for(int k =1; k<=n; k++){
                if(map[temp][k]==1 && visit[k]==false){
                    q.offer(k);
                    visit[k] = true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        visit = new boolean[n+1];
        for(int j=0; j<n+1;j++){
            Arrays.fill(map[j], 0);
        }
        Arrays.fill(visit, false);

        출처: https://sundries-in-myidea.tistory.com/4 [얇고 넓은 개발 블로그]
        for(int i=0; i<m; i++){
            String edge = br.readLine();
            StringTokenizer st1 = new StringTokenizer(edge," ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            map[a][b]=1;
            map[b][a]=1;
        }
        dfs(v);
        System.out.println();
        Arrays.fill(visit, false);
        bfs(v);

    }
}
