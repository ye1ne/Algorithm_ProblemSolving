package Programmers.KAKAO2022INTERN;

import java.util.*;

public class 등산코스정하기 {
    public static void main(String[] args) {
        int n =6;
        int[][] paths = {{1,2,3},{2,3,5},{2,4,2},{2,5,4},{3,4,4},{4,5,3},{4,6,1},{5,6,1}};
        int[] gates = {1,3};
        int[] summits = {5};
        System.out.println(solution(n,paths,gates,summits));
    }

    static List<List<Node>> graph;

    private static class Node{
        int num, weight;

        Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }

    static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        graph = new ArrayList<>();
        for(int i=0; i<paths.length; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] path: paths){
            int start = path[0];
            int end = path[1];
            int weight = path[2];

            //출입구일 경우 다른곳으로 가는 단방향,
            //산봉오리면 출입구로 돌아가는 단반향
            if(isGate(start,gates) || isSummit(end,summits)){
                graph.get(start).add(new Node(end,weight));
            }else if(isGate(end,gates) || isSummit(start,summits)){
                graph.get(end).add(new Node(start,weight));
            }else{
                graph.get(start).add(new Node(end,weight));
                graph.get(end).add(new Node(start,weight));
            }

        }
        return dijkstra(n,gates,summits);

    }

    static int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<Node> queue = new LinkedList<>();
        int[] intensity = new int[n+1];

        Arrays.fill(intensity, Integer.MAX_VALUE);
        //출입구들 큐에 다 넣고
        for(int gate: gates){
            queue.add(new Node(gate,0));
            intensity[gate] =0;
        }

        while(!queue.isEmpty()){
            Node curNode = queue.poll();

            //만약 현재노드의 가중치가, 구해놓은 가중치 보다 작으면 그냥 다음껄로 넘어감
            if(curNode.weight <intensity[curNode.num]) continue;

            //이제 연결된 모든 노드들에 대해서
            for(int i = 0; i<graph.get(curNode.num).size(); i++){
                Node newNode = graph.get(curNode.num).get(i);

                //길이는 새노드의 가중치(거리)랑, 현재노드의 가중치랑 더 큰거를 선택해서
                int distance = Math.max(intensity[curNode.num], newNode.weight );
                //만약 새노드의 현재 intensity가 더크면 바꿔끼고 넣기
                if(intensity[newNode.num] > distance){
                    intensity[newNode.num] = distance;
                    queue.add(new Node(newNode.num, distance));
                }
                /***
                 * 일반적인 다익스트라 코드는 담와같음
                 * if dist[to] > dist[from] + weight then
                 * dist[to] = dist[from] + weight
                 */
            }
        }
        //산봉오리 번호랑 최솟값
        int mn = Integer.MAX_VALUE;
        int mw = Integer.MAX_VALUE;

        Arrays.sort(summits);

        for(int summit : summits ){
            if(intensity[summit] <mw){
                mn = summit;
                mw = intensity[summit];
            }
        }

        return new int[] {mn,mw};
    }

    static  boolean isSummit(int num, int[] summits) {
        for (int summit : summits) {
            if (num == summit) return true;
        }
        return false;
    }

    static boolean isGate(int num, int[] gates) {
        for (int gate : gates) {
            if (num == gate) return true;
        }
        return false;
    }


}
