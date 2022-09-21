package Programmers.KAKAO2022INTERN;

import java.util.*;

public class 등산코스정하기2 {
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
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] path: paths) {
            int start = path[0];
            int end = path[1];
            int weight = path[2];


            //게이트에서 시작해서 나가는거나, 다른곳에서 봉우리로 들어가는거거나나
            if(isGate(start,gates) || isSummits(end,summits)){
                graph.get(start).add(new Node(end,weight));
            }
            //게이트봉우리로 들어가는거거나나
            else if(isGate(end,gates) || isSummits(start,summits)){
                graph.get(end).add(new Node(start,weight));
            }else{
                //나머지는 무방향이고 맘껏할 수 있음
                graph.get(start).add(new Node(end,weight));
                graph.get(end).add(new Node(start,weight));
            }

        }
        return dijkstra(n,gates,summits);

    }

    static boolean isSummits(int num, int[] summits) {
        for(int summit : summits){
            if(summit == num) return true;
        }
        return false;
    }

    static boolean isGate(int num, int[] gates) {
        for(int gate : gates){
            if(gate == num) return true;
        }
        return false;
    }

    static int[] dijkstra(int n, int[] gates, int[] summits) {

        int[] intensity = new int[n+1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        Queue<Node> queue = new LinkedList<>();

        for(int gate: gates){
            queue.add(new Node(gate,0));
            intensity[gate] = 0;
        }


        while (!queue.isEmpty()){

            Node curNode = queue.poll();

            if(curNode.weight<intensity[curNode.num]) continue;

            for(int i=0; i<graph.get(curNode.num).size(); i++){
                Node nextNode = graph.get(curNode.num).get(i);

                int distence = Math.max(intensity[curNode.num],nextNode.weight );
                if(distence < intensity[nextNode.num]){
                    intensity[nextNode.num] = distence;
                    queue.add(new Node(nextNode.num,distence));
                }
            }
        }
        int summitNum = 0;
        int minIntensity = Integer.MAX_VALUE;
        int count =0;
        Arrays.sort(summits);
        for(int tmp : summits){
            if(minIntensity>intensity[tmp]){
                summitNum = tmp;
                minIntensity = intensity[tmp];
            }
            count++;
        }
        return new int[]{summitNum, minIntensity};

    }




}
