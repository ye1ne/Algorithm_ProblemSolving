package Programmers.KAKAO2022RECRUITMENT;

import Study.BJ_G22856;
import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class 양과늑대 {

    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}
                , {4, 3}, {6, 5}, {4, 6}, {8, 9}};

        System.out.println(solution(info,edges));
    }

    static List<Integer>[] list;
    static boolean[][][] isVisited;
    static int[] infos;
    static int MAX;

    static public int solution(int[] info, int[][] edges) {

        list = new List[info.length];
        for(int i=0; i<info.length; i++)  list[i] = new ArrayList<>();
        for(int i=0; i<edges.length; i++){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        isVisited = new boolean[info.length][info.length+1][info.length+1];
        infos = new int[info.length];
        infos = info;

        dfs(0,0,0);
        return MAX;
    }

    //방문했던 곳 또 갈 수 있는 dfs라고 생각하면된다.
    //종료조건은 더이상없거나, 또는 이미 방문했던 곳을 방문했거나, 또는 갯수가 다를때 이다
    static void dfs(int sheep, int wolf, int now){
        if(infos[now] == 0) sheep++;
        else if(infos[now] ==1 ) wolf++;

        if(wolf>= sheep) return;
        MAX = Math.max(MAX,sheep);
        for(int i=0; i<list[now].size(); i++){
            int next = list[now].get(i);
            int tmp = infos[now];
            if(!isVisited[next][sheep][wolf]){
                infos[now] = -1;
                isVisited[now][sheep][wolf] = true;
                System.out.println("now:"+now+" sheep:"+sheep+" wolf:"+wolf +" next:"+next+" MAX:"+MAX);
                System.out.println(Arrays.toString(infos));
                if(now == 1 && next ==4)
                    System.out.println();
                dfs(sheep, wolf, next);
                infos[now] = tmp;
                isVisited[now][sheep][wolf] = false;
            }
        }
    }

}


