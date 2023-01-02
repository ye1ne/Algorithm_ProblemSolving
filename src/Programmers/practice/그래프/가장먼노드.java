package Programmers.practice.그래프;

import java.util.*;

public class 가장먼노드 {
    public static void main(String[] args) {

        System.out.println(solution(6, new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
    }

    public static int solution(int n, int[][] edge) {

        Graph graph = new Graph(n);

        for(int i=0; i<edge.length; i++)
            graph.addEdge(edge[i][0], edge[i][1]);

        graph.bfs(1);

        return graph.findMaxDistance();
    }

    static class Graph{
        private int vertexSize;
        private List[] adjList;
        private boolean isVisited[];
        private int[] distance;

        public Graph(int v){
            vertexSize = v + 1;
            isVisited = new boolean[vertexSize];
            adjList = new List[vertexSize];
            for(int i=0; i<vertexSize; i++) adjList[i] = new ArrayList();
            distance = new int[vertexSize];
        }

        public void addEdge(int from, int to){
            if(!adjList[from].contains(to)) adjList[from].add(to);
            if(!adjList[to].contains(from)) adjList[to].add(from);
        }

        public int findMaxDistance(){
            int max = distance[vertexSize-1];
            int count = 0;
            for(int i=vertexSize-1; i>0; i--){
                if(distance[i] == max) count++;

            }

            return count;
        }

        public void bfs(int start){
            Queue<Integer> queue = new LinkedList<>();
            distance = new int[vertexSize];
            isVisited = new boolean[vertexSize];


            distance[start] = 0;

            queue.add(start);
            isVisited[start] = true;

            while(!queue.isEmpty()){
                int current = queue.poll();
                for(int i=0; i<adjList[current].size(); i++){
                    int next = (int) adjList[current].get(i);
                    if(!isVisited[next]){
                        isVisited[next] = true;
                        distance[next] = distance[current] + 1;
                        queue.add(next);
                    }
                }
            }

            Arrays.sort(distance);
        }


    }
}
