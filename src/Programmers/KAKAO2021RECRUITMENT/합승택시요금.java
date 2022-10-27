package Programmers.KAKAO2021RECRUITMENT;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 합승택시요금 {
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 5;
        int b = 6;
        int[][] fares = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};

        System.out.println(solution(n,s,a,b,fares));
    }

    static public int solution(int n, int s, int a, int b, int[][] fares) {

        isVisited = new boolean[n+1];
        graph = new int[n+1][n+1];
        distance = new int[3][n+1];
        for(int i=1; i<=n; i++) Arrays.fill(graph[i],Integer.MAX_VALUE);

        for(int i=0; i<3; i++) Arrays.fill(distance[i],Integer.MAX_VALUE);
        N = n;

        for(int[] fare: fares){
            graph[fare[0]][fare[1]] = fare[2];
            graph[fare[1]][fare[0]] = fare[2];
        }
        dijkstra(a,0);
        isVisited = new boolean[n+1];
        dijkstra(b,1);
        isVisited = new boolean[n+1];
        dijkstra(s,2);

        int MIN = distance[MUZI][s]+distance[APPEAH][s];
        for(int i=1; i<=n; i++){
//            if(i == a || i==b|| i ==s) continue;
            MIN = Math.min(distance[MUZI][i] + distance[APPEAH][i]+distance[COMPANY][i],MIN);
        }
        return MIN;
    }

    static final int MUZI = 0, APPEAH = 1, COMPANY =2;
    static int N;
    static void dijkstra(int number, int person) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        distance[person][number] = 0;

        priorityQueue.add(new int[]{0, number});

        while (!priorityQueue.isEmpty()) {
            int[] curr = priorityQueue.poll();
            int u = curr[1];
            if (isVisited[u]) continue;
            isVisited[u] = true;
            for (int v = 1; v <= N; v++) {
                if (graph[u][v] == Integer.MAX_VALUE) continue;
                if (distance[person][v] > distance[person][u] + graph[u][v]) {
                    distance[person][v] = distance[person][u] + graph[u][v];
                    priorityQueue.add(new int[]{distance[person][v], v});
                }
            }
        }
    }

    static boolean[] isVisited;
    static int[][] distance;
    static int[][] graph;
}
