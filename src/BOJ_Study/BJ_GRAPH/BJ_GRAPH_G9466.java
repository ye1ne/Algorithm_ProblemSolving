package BOJ_Study.BJ_GRAPH;

import java.io.*;
import java.util.*;

public class BJ_GRAPH_G9466 {
    static int n;
    static int[] student;
    static boolean[] visit;
    static boolean[] isTeam;
    static int hasTeamNum;

    static int dfs(int v){
        if(visit[v]) return v;

        int tmp =v;
        visit[v] = true;

        if(!visit[student[v]]){
            tmp = dfs(student[v]);
        }else if(visit[student[v]]){
            if(!isTeam[student[v]]){
                hasTeamNum++;
                for(int i=student[v]; i!=v; i=student[i]){
                    hasTeamNum++;
                }
            }
        }
        isTeam[v] = true;
        return tmp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            n = Integer.parseInt(br.readLine());
            student = new int[n + 1];
            visit = new boolean[n + 1];
            isTeam = new boolean[n + 1];
            hasTeamNum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                student[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<=n;i++){
                dfs(i);
            }

            bw.write((n-hasTeamNum)+"\n");

        }
        bw.flush();
        bw.close();
    }

}
