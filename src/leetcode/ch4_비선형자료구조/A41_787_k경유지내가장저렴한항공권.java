package leetcode.ch4_비선형자료구조;

import java.util.Arrays;

public class A41_787_k경유지내가장저렴한항공권 {

    static int[] distances;

    public static void main(String[] args) {
        int n = 5;
//        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
//        int[][] flights = {{0,1,100},{1,2,200},{2,0,100},{1,3,600},{2,3,200}};
//        int src = 0;
//        int dst = 3;
//        int k = 1;
        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int src = 0;
        int dst = 2;
        int K = 2;



        distances = new int[n];
        Arrays.fill(distances,Integer.MAX_VALUE);

        distances[src] = 0;
        for(int i=0; i<=K; i++){
            int[] temp = Arrays.copyOf(distances,n);
            for(int[] flight: flights){
                int cur = flight[0];
                int next = flight[1];
                int distance = flight[2];
                if(distances[cur] == Integer.MAX_VALUE) continue;
                temp[next] = Math.min(temp[next],distances[cur]+distance);
            }
            distances = temp;
        }

        System.out.println(distances[dst]);


    }

}
