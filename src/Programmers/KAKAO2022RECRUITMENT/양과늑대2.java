package Programmers.KAKAO2022RECRUITMENT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 양과늑대2 {

    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}
                , {4, 3}, {6, 5}, {4, 6}, {8, 9}};

        System.out.println(solution(info,edges));
    }

    static List<Integer>[] list;
    static int[] infos;
    static boolean[][][] isVisited;

    static int MAX;
    static final int NodeNum =0, WolfNum=2, SheepNum =1;

    static public int solution(int[] info, int[][] edges) {

        list = new List[info.length];
        for(int i=0; i<info.length; i++)  list[i] = new ArrayList<>();
        for(int i=0; i<edges.length; i++){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }

        isVisited = new boolean[info.length][info.length+1][info.length+1];
        infos = info;
        dfs(0,0,0);
        return MAX;
    }

    static void dfs(int sheep, int wolf, int now){

        if(infos[now] == 0) sheep++;
        if(infos[now] == 1) wolf++;

        if(sheep<=wolf) {
            isVisited[now][sheep][wolf] = true;
            MAX = Math.max(sheep,MAX);
            return;
        }

        System.out.println(now+"다. 양" +sheep+",늑대"+wolf);
        for(int i=0; i<list[now].size(); i++){
            int tmp = infos[now];
            if(!isVisited[now][sheep][wolf]) {
                //해주는 이유는, 안해주면 이미 먹었던거 인데도 또 먹어질 수 있음
                infos[now] = -1;
                isVisited[now][sheep][wolf] = true;
                dfs(sheep, wolf, list[now].get(i));
                isVisited[now][sheep][wolf] = false;
                infos[now] = -1;
            }
        }

    }

}


