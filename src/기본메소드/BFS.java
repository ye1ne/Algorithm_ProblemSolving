package 기본메소드;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {


        isVisted = new boolean[7];
        n = 7;



        //인접행렬 쓰려면 일단 이거 해줘야함
        V = n;
        adj = new LinkedList[n];
        // v개의 LinkedList 선언 및 생성
        for (int i = 0; i < n; ++i) {
            adj[i] = new LinkedList();
        }
    }

    static boolean[] isVisted;
    static int[][] map;
    static int n;
    //map 사용
    static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while(!q.isEmpty()) {
            isVisted[i] = true;
            int temp = q.poll();
            System.out.print(temp + " ");
            for(int j=1; j<n+1; j++) {
                if(map[temp][j] == 1 && isVisted[j] == false)
                    q.offer(j);

            }
        }
    }


    //인접행렬 사용
    //벌택스 갯수
    static int V;

    //기본 map대신 연결ㄹ리스트
    static LinkedList<Integer> adj[];
    // constructor

    static void addEdge (int v, int w) { // v번째 LinkedList 에 w를 삽입
        adj[v].add(w);
    }
    // BFS 함수
    static void BFS(int s) {
        boolean visited[] = new boolean[V]; // 각 노드이 방문 여부를 저장하기 위해
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // 방문한 노드를 큐에서 추출하고 값을 출력
            s = queue.poll();
            System.out.println(s + " ");

            // 방문한 노드와 인접한 모든 노드를 가져온다.
            Iterator<Integer> iter = adj[s].listIterator();
            while(iter.hasNext()){
                int n = iter.next();
                // 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}

