import java.io.*;
import java.util.*;

public class Main{
    static int n,m,v;
    static int[][] map;
    static boolean[] visit;

    static void dfs(int ver){
        visit[ver] = true;
        System.out.print(ver+" ");
        for(int i=1;i<=n;i++){
            if(map[ver][i] == 1 & visit[i] == false)
                dfs(i);
        }
    }
    static void bfs(int ver){

        visit[ver] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(ver);
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp+" ");
            for(int i=1; i<=n; i++){
                if(map[temp][i]==1 && visit[i] == false){
                    q.offer(i);
                    visit[i] = true;
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

        for(int i=0; i<m; i++){
            String edge = br.readLine();
            StringTokenizer st1 = new StringTokenizer(edge," ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            map[a][b]=1;
            map[b][a]=1;
        }
        dfs(v);
    }
}
