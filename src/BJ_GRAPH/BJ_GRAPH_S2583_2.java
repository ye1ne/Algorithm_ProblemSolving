package BJ_GRAPH;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_GRAPH_S2583_2 {
    static int M,N,T;
    static boolean[][] visit;
    static int count;
    static int partitionNum;
    static int dfs(int x, int y){
        //범위 외의 좌표가 오면 스탑
        if(y > M || x > N || y < 1 || x < 1) {
            return 0;
        }
        //이미 방문했던 좌표일 경우 역시 스탑
        if(visit[y][x]){
           return 0;
        }
        visit[y][x] = true;
        count++;
        //현재 좌표의 위쪽 좌표
        if(y!=M&&!visit[y+1][x]){;
            dfs(x,y+1);
        }
        //현재 좌표의 오른쪽 좌표
        if(x!=N&&!visit[y][x+1]){
            dfs(x+1,y);
        }
        //현재 좌표의 아래쪽 좌표
        if(y!=1&&!visit[y-1][x]){
            dfs(x,y-1);
        }
        //현재 좌표의 왼쪽 좌표
        if(x!=1&&!visit[y][x-1]){
            dfs(x-1,y);
        }
        //정상탐색 후 종료
        return 1;
    }

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //M은 해당 행렬의 행으로 y좌표에 해당
        N = Integer.parseInt(st.nextToken()); //N은 해당 행렬의 열로 x좌표에 해당
        T = Integer.parseInt(st.nextToken());
        visit = new boolean[M+1][N+1];

        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            //입력받은 네모 범위내의 좌표는 방문한것으로 간주
            for (int i = x1+1; i <= x2; i++) {
                for (int j = y1+1; j <= y2; j++) {
                    visit[j][i] = true;
                }
            }
        }

        // 분리되는 영역의 갯수가 정해지지 않음
        // 필요시 add하여 사용하기위해 ArrayList를 사용
        ArrayList<Integer> result = new ArrayList<Integer> ();
        partitionNum = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                int temp = dfs(j,i);
                //만약에 1개라도 count되어 종료했다면
                if(temp==1){
                    result.add(count);
                    partitionNum++;
                    count =0;
                }
            }
        }

        //출력
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
