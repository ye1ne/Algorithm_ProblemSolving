package Programmers.practice.DFSBFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class 게임맵최단거리 {

    public static void main(String[] args) {

        int[][] map = {{1, 0, 1, 1, 1},{1, 0, 1, 0, 1},{1, 0, 1, 1, 1},{1, 1, 1, 0, 0},{0, 0, 0, 0, 1}};
        System.out.println(solution(map));

    }
    public static class Node{
        int x;
        int y;
        int cnt;


        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static int solution(int[][] maps) {


        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(new Node(0,0,0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.x == maps.length-1 && node.y == maps[0].length-1){
                return node.cnt+1;
            }

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] == 1 && !isVisited[nx][ny]){
                    isVisited[nx][ny] = true;
                    queue.add(new Node(nx, ny, node.cnt+1));
                }
            }


        }

        return -1;
    }


}
