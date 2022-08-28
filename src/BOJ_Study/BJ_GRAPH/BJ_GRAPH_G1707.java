package BOJ_Study.BJ_GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_GRAPH_G1707 {
    static boolean isBG;

    static int K,V,E;
    static int[] color;
    static LinkedList<Integer>[] adjList;

    private static boolean dfs(int curr, int col){
        color[curr] = col;
        int nextCol = -1*col;

        boolean result = true;
        for(int i : adjList[curr]){

            if(color[i] == 0){
                result = dfs(i, nextCol);
            } else {
                if(color[i] == color[curr]) return false;
            }

            if(!result) return result;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase<K; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            adjList = new LinkedList[V+1];
            color = new int[V + 1];
            for (int i = 0; i <= V; i++) {
                adjList[i] = new LinkedList<Integer>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a1 = Integer.parseInt(st.nextToken());
                int a2 = Integer.parseInt(st.nextToken());
                adjList[a1].add(a2);
                adjList[a2].add(a1);
            }
            for(int i=1; i<=V; i++){
                Collections.sort(adjList[i]);
            }
            isBG = true;
            for(int i =1; i<= V; i++){
                if(color[i]!=0) continue;
                isBG = dfs(i,1);
                if(!isBG) break;
            }

            System.out.println(isBG?"YES":"NO");
           }
    }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static boolean red = true;
    static boolean black = false;
    static boolean preColor;
    static String isBG;

    static int K,V,E;
    static boolean[] visit;
    static boolean[] color;
    static LinkedList<Integer>[] adjList;

    static void dfs(int v){
        visit[v] = true;
        if(preColor == black){
            color[v] = red;
        }else{
            color[v] = black;
        }
        Iterator<Integer> iter = adjList[v].listIterator();
        while (iter.hasNext()){
            preColor = color[v];
            int w = iter.next();
            if(visit[w] == false){
                dfs(w);
            }else if(visit[w] == true){
                if (color[w] == color[v]){
                    isBG = "NO";
                }else if(color[w] != color[v]){
                    isBG = "YES";
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase<K; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            adjList = new LinkedList[V+1];
            visit = new boolean[V + 1];
            color = new boolean[V + 1];
            for (int i = 0; i <= V; i++) {
                adjList[i] = new LinkedList<Integer>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a1 = Integer.parseInt(st.nextToken());
                int a2 = Integer.parseInt(st.nextToken());
                adjList[a1].add(a2);
                adjList[a2].add(a1);
            }
            for(int i=1; i<=V; i++){
                Collections.sort(adjList[i]);
            }

            preColor = black;
            isBG = "none";

            for(int i=1; i<=V; i++){
               if(visit[i] == false) {
                    dfs(i);
               }
            }

            System.out.println(isBG);
           }
    }
}

 */