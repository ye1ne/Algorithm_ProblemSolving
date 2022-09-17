package leetcode.ch4_비선형자료구조;

import java.util.Arrays;
import java.util.PriorityQueue;

public class A40_743_네트워크딜레이타임 {
    static boolean[] isVisited;
    static int[] distance;
    static int[][] graph;
    static int N;
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;

        graph = new int[n+1][n+1];
        N = n;
        distance = new int[n+1];
        isVisited = new boolean[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=1; i<=n; i++) Arrays.fill(graph[i],Integer.MAX_VALUE);

        for(int i=0; i<times.length; i++){
            graph[times[i][0]][times[i][1]] = times[i][2];
        }
        dijkstra(k);

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            if(distance[i] == Integer.MAX_VALUE) return;
            max = Math.max(distance[i],max );
        }
        System.out.println(max);

    }
    static void dijkstra(int number){
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[0]-b[0]);

        distance[number] = 0;

        priorityQueue.add(new int[]{0,number});

        while(!priorityQueue.isEmpty()){
            int[] curr = priorityQueue.poll();
            int u = curr[1];
            if(isVisited[u]) continue;
            isVisited[u] = true;
            for(int v=1; v<=N; v++){
                if(graph[u][v] == Integer.MAX_VALUE) continue;
                if(distance[v] >distance[u]+graph[u][v]){
                    distance[v] = distance[u]+graph[u][v];
                    priorityQueue.add(new int[]{distance[v],v});
                }
            }
        }
    }
}
